package co.edu.unal.clinica.mb;

import java.sql.Timestamp;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.hibernate.Session;

import co.edu.unal.clinica.daos.MotivoConsultaDAO;
import co.edu.unal.clinica.hibernate.data.Motivo_Consulta;
import co.edu.unal.clinica.utils.HibernateUtil;

@ManagedBean(name="motivoConsultaMB")
@SessionScoped
public class MotivoConsultaMB {
	
	private long cedula;
	private String motivoConsulta;
	private Timestamp fechaCreacion;
	
	private List<Motivo_Consulta> listMot;
	private MotivoConsultaDAO motDao = new MotivoConsultaDAO();
	private Motivo_Consulta mot = new Motivo_Consulta();
	
	public long getCedula() {
		return cedula;
	}
	public void setCedula(long cedula) {
		this.cedula = cedula;
	}
	public String getMotivoConsulta() {
		return motivoConsulta;
	}
	public void setMotivoConsulta(String motivoConsulta) {
		this.motivoConsulta = motivoConsulta;
	}
	public Timestamp getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public List<Motivo_Consulta> getListMot() {
		return listMot;
	}
	public void setListMot(List<Motivo_Consulta> listMot) {
		this.listMot = listMot;
	}
	public MotivoConsultaDAO getMotDao() {
		return motDao;
	}
	public void setMotDao(MotivoConsultaDAO motDao) {
		this.motDao = motDao;
	}
	public Motivo_Consulta getMot() {
		return mot;
	}
	public void setMot(Motivo_Consulta mot) {
		this.mot = mot;
	}
	
	public void guardarMotivoConsulta() {
		try{
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Motivo_Consulta ant = new Motivo_Consulta(PacienteMB.cedulaConsulta, motivoConsulta);
			session.save(ant);
			session.getTransaction().commit();
			session.close();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro ha sido creado correctamente","Puede seguir registrando o volver"));
		}catch(Exception ex){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Esto es vergonzoso","Ha ocurrido un error al intentar hacer el registro"));
		}
	}	
	
	public void listar() throws Exception {
		this.listMot = motDao.Buscar(PacienteMB.cedulaConsulta);
	}
}
