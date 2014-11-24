package co.edu.unal.clinica.mb;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.hibernate.Session;

import co.edu.unal.clinica.daos.AntecedentesAlergicosDAO;
import co.edu.unal.clinica.hibernate.data.Antecedentes_Alergicos;
import co.edu.unal.clinica.utils.HibernateUtil;

@ManagedBean(name="antecedentesAlergicosMB")
@SessionScoped
public class AntecedentesAlergicosMB {
	
	private long cedula;
	private String consolidado;
	private String antecedente;
	
	private List<Antecedentes_Alergicos> listaAnt;
	private AntecedentesAlergicosDAO antDAO = new AntecedentesAlergicosDAO();
	private static Antecedentes_Alergicos ant = new Antecedentes_Alergicos();

	public static long cedulaPaciente;
	
	public void guardarAntecedenteAlergico() {
		try{
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			consolidado = "No";
			Antecedentes_Alergicos antF = new Antecedentes_Alergicos(PacienteMB.cedulaConsulta, consolidado, antecedente);
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
			Antecedentes_Alergicos objetoConsolidado = antDAO.BuscarPorId(ant.getId());
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
		return "adminAntecedentesAlergicos";
	}
	
	public void listar() throws Exception {
		cedulaPaciente = PacienteMB.cedulaConsulta;
		System.out.println("Cedula de la historia:"+PacienteMB.cedulaConsulta);
		this.listaAnt = antDAO.Buscar(PacienteMB.cedulaConsulta);
	}
	
	public String leer(Antecedentes_Alergicos emp) {
		ant = emp;
		return "editarAntecedentesAlergicos";
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

	public List<Antecedentes_Alergicos> getListaAnt() {
		return listaAnt;
	}

	public void setListaAnt(List<Antecedentes_Alergicos> listaAnt) {
		this.listaAnt = listaAnt;
	}

	public AntecedentesAlergicosDAO getAntDAO() {
		return antDAO;
	}

	public void setAntDAO(AntecedentesAlergicosDAO antDAO) {
		this.antDAO = antDAO;
	}

	public Antecedentes_Alergicos getAnt() {
		return ant;
	}

	public static void setAnt(Antecedentes_Alergicos ant) {
		AntecedentesAlergicosMB.ant = ant;
	}

	public static long getCedulaPaciente() {
		return cedulaPaciente;
	}

	public static void setCedulaPaciente(long cedulaPaciente) {
		AntecedentesAlergicosMB.cedulaPaciente = cedulaPaciente;
	}
}
