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
	
	private long cedula;
	private String enfermedadActual;
	private Timestamp fechaCreacion;
	
	private List<Enfermedad_Actual> listEnf;
	private EnfermedadActualDAO enfDao = new EnfermedadActualDAO();
	private Enfermedad_Actual enf = new Enfermedad_Actual();
	
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
	public void setEnf(Enfermedad_Actual enf) {
		this.enf = enf;
	}
	
	public void guardarEnfermedadActual() {
		try{
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Enfermedad_Actual ant = new Enfermedad_Actual(PacienteMB.cedulaConsulta, enfermedadActual);
			session.save(ant);
			session.getTransaction().commit();
			session.close();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro ha sido creado correctamente","Puede seguir registrando o volver"));
		}
		catch(Exception ex){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Esto es vergonzoso","Ha ocurrido un error al intentar hacer el registro"));
		}
	}	
	
	public void listar() throws Exception {
		this.listEnf = enfDao.Buscar(PacienteMB.cedulaConsulta);
	}
}
