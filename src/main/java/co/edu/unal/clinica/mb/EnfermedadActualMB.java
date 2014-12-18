package co.edu.unal.clinica.mb;

import java.sql.Timestamp;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.hibernate.Session;

import co.edu.unal.clinica.daos.EnfermedadActualDAO;
import co.edu.unal.clinica.hibernate.data.Enfermedad_Actual;
import co.edu.unal.clinica.utils.HibernateUtil;

@ManagedBean(name="enfermedadActualMB")
@SessionScoped
public class EnfermedadActualMB {
	
	private long fkConsulta;
	private long cedula;
	private String consolidado;
	private String enfermedadActual;
	private Timestamp fechaCreacion;
	
	private List<Enfermedad_Actual> listEnf;
	private EnfermedadActualDAO enfDao = new EnfermedadActualDAO();
	private static Enfermedad_Actual enf = new Enfermedad_Actual();
	
	public void guardarEnfermedadActual() {
		try{
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			consolidado = "No";
			Enfermedad_Actual ant = new Enfermedad_Actual(PacienteMB.cedulaConsulta, enfermedadActual, consolidado);
			long id = (long) session.save(ant);
			enf.setId(id);
			session.getTransaction().commit();
			session.close();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro ha sido creado correctamente","Puede seguir registrando o volver"));
		}
		catch(Exception ex){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Esto es vergonzoso","Ha ocurrido un error al intentar hacer el registro"));
		}
	}
	
	public void consolidarEnfermedadActual(){
		try{
			System.out.println("++++++++++++++++++++++ ENTRA AL METODO DE CONSOLIDAR Enfermedad Actual" );
			Enfermedad_Actual objetoConsolidado = enfDao.BuscarPorId(enf.getId());
			System.out.println("++++++++++++++++++++++ ID de Objeto Recuperado " +objetoConsolidado.getId());
			objetoConsolidado.setConsolidado("Si");
			enfDao.ConsolidarConsulta(objetoConsolidado);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro ha sido consolidado correctamente","Puede seguir registrando o volver"));
		}catch(Exception ex){
			System.out.println(ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Esto es vergonzoso","Ha ocurrido un error al intentar hacer la consolidacion"));
		}
	}
	
	public void consolidarEnfermedadActual(long idConsulta){
		try{
			System.out.println("++++++++++++++++++++++ ENTRA AL METODO DE CONSOLIDAR Enfermedad Actual" );
			Enfermedad_Actual objetoConsolidado = enfDao.BuscarPorId(enf.getId());
			System.out.println("++++++++++++++++++++++ ID de Objeto Recuperado " +objetoConsolidado.getId());
			objetoConsolidado.setConsolidado("Si");
			objetoConsolidado.setFkConsulta(idConsulta);
			enfDao.ConsolidarConsulta(objetoConsolidado);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro ha sido consolidado correctamente","Puede seguir registrando o volver"));
		}catch(Exception ex){
			System.out.println(ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Esto es vergonzoso","Ha ocurrido un error al intentar hacer la consolidacion"));
		}
	}
	
	public String modificar() {
		try{
		enfDao.Modificar(enf);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro ha sido modificado correctamente","Puede seguir modificando o volver"));
		}catch(Exception ex){
			System.out.println(ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Esto es vergonzoso","Ha ocurrido un error al intentar modificar la informacion"));
		}
		return "adminEnfermedadActual";
	}
	
	public void listar() throws Exception {
		this.listEnf = enfDao.Buscar(PacienteMB.cedulaConsulta);
	}
	
	public String leer(Enfermedad_Actual emp) {
		enf = emp;
		return "editarEnfermedadActual";
	}
	
	public long getCedula() {
		return cedula;
	}
	public void setCedula(long cedula) {
		this.cedula = cedula;
	}
	public String getEnfermedadActual() {
		return enfermedadActual;
	}
	public void setEnfermedadActual(String enfermedadActual) {
		this.enfermedadActual = enfermedadActual;
	}
	public Timestamp getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public List<Enfermedad_Actual> getListEnf() {
		return listEnf;
	}
	public void setListEnf(List<Enfermedad_Actual> listEnf) {
		this.listEnf = listEnf;
	}
	public EnfermedadActualDAO getEnfDao() {
		return enfDao;
	}
	public void setEnfDao(EnfermedadActualDAO enfDao) {
		this.enfDao = enfDao;
	}
	public Enfermedad_Actual getEnf() {
		return enf;
	}
	public String getConsolidado() {
		return consolidado;
	}
	public void setConsolidado(String consolidado) {
		this.consolidado = consolidado;
	}

	public long getFkConsulta() {
		return fkConsulta;
	}

	public void setFkConsulta(long fkConsulta) {
		this.fkConsulta = fkConsulta;
	}
}
