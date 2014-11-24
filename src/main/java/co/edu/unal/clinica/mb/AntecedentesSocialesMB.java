package co.edu.unal.clinica.mb;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.hibernate.Session;

import co.edu.unal.clinica.daos.AntecedentesSocialesDAO;
import co.edu.unal.clinica.hibernate.data.Antecedentes_Sociales;
import co.edu.unal.clinica.utils.HibernateUtil;

@ManagedBean(name="antecedentesSocialesMB")
@SessionScoped
public class AntecedentesSocialesMB {
	
	private long cedula;
	private String consolidado;
	private String antecedente;
	
	private List<Antecedentes_Sociales> listaAnt;
	private AntecedentesSocialesDAO antDAO = new AntecedentesSocialesDAO();
	private static Antecedentes_Sociales ant = new Antecedentes_Sociales();

	public static long cedulaPaciente;
	
	public void guardarAntecedenteSocial() {
		try{
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			consolidado = "No";
			Antecedentes_Sociales antF = new Antecedentes_Sociales(PacienteMB.cedulaConsulta, consolidado, antecedente);
			long id = (long) session.save(antF);
			ant.setId(id); 
			session.getTransaction().commit();
			session.close();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro ha sido creado correctamente","Puede seguir registrando o volver"));
		}
		catch(Exception ex){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Esto es vergonzoso","Ha ocurrido un error al intentar hacer el registro"));
		}
	}	
	
	public void consolidarConsulta(){
		try{
			System.out.println("++++++++++++++++++++++ ENTRA AL METODO DE CONSOLIDAR ANTECEDENTES FAMILIARES" );
			Antecedentes_Sociales objetoConsolidado = antDAO.BuscarPorId(ant.getId());
			System.out.println("++++++++++++++++++++++ ID de Objeto Recuperado " +objetoConsolidado.getId());
			objetoConsolidado.setConsolidado("Si");
			antDAO.ConsolidarConsulta(objetoConsolidado);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro ha sido consolidado correctamente","Puede seguir registrando o volver"));
		}catch(Exception ex){
			System.out.println(ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Esto es vergonzoso","Ha ocurrido un error al intentar hacer la consolidacion"));
		}
	}
	
	public String modificar() {
		try{
			antDAO.Modificar(ant);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro ha sido modificado correctamente","Puede seguir modificando o volver"));
		}catch(Exception ex){
			System.out.println(ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Esto es vergonzoso","Ha ocurrido un error al intentar modificar la informacion"));
		}
		return "adminAntecedentesSociales";
	}
	
	public void listar() throws Exception {
		cedulaPaciente = PacienteMB.cedulaConsulta;
		System.out.println("Cedula de la historia:"+PacienteMB.cedulaConsulta);
		this.listaAnt = antDAO.Buscar(PacienteMB.cedulaConsulta);
	}
	
	public String leer(Antecedentes_Sociales emp) {
		ant = emp;
		return "editarAntecedentesSociales";
	}

	public long getCedula() {
		return cedula;
	}

	public void setCedula(long cedula) {
		this.cedula = cedula;
	}

	public String getConsolidado() {
		return consolidado;
	}

	public void setConsolidado(String consolidado) {
		this.consolidado = consolidado;
	}

	public String getAntecedente() {
		return antecedente;
	}

	public void setAntecedente(String antecedente) {
		this.antecedente = antecedente;
	}

	public List<Antecedentes_Sociales> getListaAnt() {
		return listaAnt;
	}

	public void setListaAnt(List<Antecedentes_Sociales> listaAnt) {
		this.listaAnt = listaAnt;
	}

	public AntecedentesSocialesDAO getAntDAO() {
		return antDAO;
	}

	public void setAntDAO(AntecedentesSocialesDAO antDAO) {
		this.antDAO = antDAO;
	}

	public Antecedentes_Sociales getAnt() {
		return ant;
	}

	public static void setAnt(Antecedentes_Sociales ant) {
		AntecedentesSocialesMB.ant = ant;
	}

	public static long getCedulaPaciente() {
		return cedulaPaciente;
	}

	public static void setCedulaPaciente(long cedulaPaciente) {
		AntecedentesSocialesMB.cedulaPaciente = cedulaPaciente;
	}

}
