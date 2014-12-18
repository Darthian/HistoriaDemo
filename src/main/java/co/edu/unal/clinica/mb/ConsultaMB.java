package co.edu.unal.clinica.mb;

import java.sql.Timestamp;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.hibernate.Session;

import co.edu.unal.clinica.hibernate.data.Consulta;
import co.edu.unal.clinica.utils.HibernateUtil;

@ManagedBean(name="consultaMB")
@SessionScoped
public class ConsultaMB {
	
	private long cedula;
	private Timestamp fechaCreacion;
	
	private static Consulta consu = new Consulta();
	
	public void guardarConsulta() {
		try{
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Consulta obj = new Consulta(PacienteMB.cedulaConsulta);
			long id = (long) session.save(obj);
			consu.setId(id); 
			session.getTransaction().commit();
			session.close();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro ha sido creado correctamente","Puede seguir registrando o volver"));
		}
		catch(Exception ex){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Esto es vergonzoso","Ha ocurrido un error al intentar hacer el registro"));
		}
	}	
	
	public long getCedula() {
		return cedula;
	}
	public void setCedula(long cedula) {
		this.cedula = cedula;
	}
	public Timestamp getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Consulta getConsu() {
		return consu;
	}
}
