package co.edu.unal.clinica.mb;

import java.sql.Timestamp;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.hibernate.Session;

import co.edu.unal.clinica.daos.AntecedentesGinecobstetricosDAO;
import co.edu.unal.clinica.hibernate.data.Antecedentes_Ginecobstetricos;
import co.edu.unal.clinica.utils.HibernateUtil;

@ManagedBean(name="antecedentesGinecobstetricosMB")
@SessionScoped
public class AntecedentesGinecobstetricosMB {
	
	private long fkConsulta;
	private long cedula;
	private String consolidado;
	private String antecedente;
	private Timestamp fechaCreacion;
	
	private List<Antecedentes_Ginecobstetricos> listaAnt;
	private List<Antecedentes_Ginecobstetricos> listaAntHC;
	private AntecedentesGinecobstetricosDAO antDAO = new AntecedentesGinecobstetricosDAO();
	private static Antecedentes_Ginecobstetricos ant = new Antecedentes_Ginecobstetricos();

	public static long cedulaPaciente;
	
	public void guardarAntecedenteGinecobstetrico() {
		try{
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			consolidado = "No";
			Antecedentes_Ginecobstetricos antF = new Antecedentes_Ginecobstetricos(PacienteMB.cedulaConsulta, consolidado, antecedente);
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
	
//	public void consolidarAntecedenteGinecobstetrico(){
//		try{
//			System.out.println("++++++++++++++++++++++ ENTRA AL METODO DE CONSOLIDAR ANTECEDENTES Ginecobstetrico" );
//			Antecedentes_Ginecobstetricos objetoConsolidado = antDAO.BuscarPorId(ant.getId());
//			System.out.println("++++++++++++++++++++++ ID de Objeto Recuperado " +objetoConsolidado.getId());
//			objetoConsolidado.setConsolidado("Si");
//			antDAO.ConsolidarConsulta(objetoConsolidado);
//			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro ha sido consolidado correctamente","Puede seguir registrando o volver"));
//		}catch(Exception ex){
//			System.out.println(ex);
//			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Esto es vergonzoso","Ha ocurrido un error al intentar hacer la consolidacion"));
//		}
//	}
	
	public void consolidarAntecedenteGinecobstetrico(long idConsulta){
		try{
			System.out.println("++++++++++++++++++++++ ENTRA AL METODO DE CONSOLIDAR ANTECEDENTES Ginecobstetrico" );
			List<Antecedentes_Ginecobstetricos> listobjetoConsolidado = antDAO.BuscarNoConsolidados();
			if(listobjetoConsolidado!= null && listobjetoConsolidado.size() > 0){
				for(Antecedentes_Ginecobstetricos iterator : listobjetoConsolidado){
					System.out.println("++++++++++++++++++++++ ID de Objeto Recuperado " +iterator.getId());
					iterator.setConsolidado("Si");
					iterator.setFkConsulta(idConsulta);
				}
				antDAO.ConsolidarConsulta(listobjetoConsolidado);
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro ha sido consolidado correctamente","Puede seguir registrando o volver"));
			}else{
				System.out.println("++++++++++++++++++++++ No hay regitros sin consolidar");
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "No hay regitros sin consolidar","No hay motivos de consulta sin guardar definitivamente"));
			}
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
		return "adminAntecedentesGinecobstetricos";
	}
	
	public void listar() throws Exception {
		cedulaPaciente = PacienteMB.cedulaConsulta;
		System.out.println("Cedula de la historia:"+PacienteMB.cedulaConsulta);
		this.listaAnt = antDAO.Buscar(PacienteMB.cedulaConsulta);
	}
	
	public void listarHC() throws Exception {
		this.listaAntHC = antDAO.BuscarPorConsulta(ConsultaMB.idConsultaConstante);
	}
	
	public String leer(Antecedentes_Ginecobstetricos emp) {
		ant = emp;
		return "editarAntecedentesGinecobstetricos";
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

	public Antecedentes_Ginecobstetricos getAnt() {
		return ant;
	}

	public static void setAnt(Antecedentes_Ginecobstetricos ant) {
		AntecedentesGinecobstetricosMB.ant = ant;
	}

	public static long getCedulaPaciente() {
		return cedulaPaciente;
	}

	public static void setCedulaPaciente(long cedulaPaciente) {
		AntecedentesGinecobstetricosMB.cedulaPaciente = cedulaPaciente;
	}

	public List<Antecedentes_Ginecobstetricos> getListaAnt() {
		return listaAnt;
	}

	public void setListaAnt(List<Antecedentes_Ginecobstetricos> listaAnt) {
		this.listaAnt = listaAnt;
	}

	public AntecedentesGinecobstetricosDAO getAntDAO() {
		return antDAO;
	}

	public void setAntDAO(AntecedentesGinecobstetricosDAO antDAO) {
		this.antDAO = antDAO;
	}

	public Timestamp getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public long getFkConsulta() {
		return fkConsulta;
	}

	public void setFkConsulta(long fkConsulta) {
		this.fkConsulta = fkConsulta;
	}

	public List<Antecedentes_Ginecobstetricos> getListaAntHC() {
		return listaAntHC;
	}

	public void setListaAntHC(List<Antecedentes_Ginecobstetricos> listaAntHC) {
		this.listaAntHC = listaAntHC;
	}

}
