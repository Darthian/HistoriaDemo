package co.edu.unal.clinica.mb;

import java.sql.Timestamp;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.hibernate.Session;

import co.edu.unal.clinica.daos.OtrosAntecedentesDAO;
import co.edu.unal.clinica.hibernate.data.Otros_Antecedentes;
import co.edu.unal.clinica.utils.HibernateUtil;

@ManagedBean(name="otrosAntecedentesMB")
@SessionScoped
public class OtrosAntecedentesMB {
	
	private long cedula;
	private String antecedente;
	private String observaciones;
	private Timestamp fechaCreacion;
	
	private List<Otros_Antecedentes> listaOAnt;
	private OtrosAntecedentesDAO oantDAO = new OtrosAntecedentesDAO();
	private Otros_Antecedentes oant = new Otros_Antecedentes();
	
	public static long cedulaPaciente;
	
	public long getCedula() {
		return cedula;
	}
	public void setCedula(long cedula) {
		this.cedula = cedula;
	}
	public String getAntecedente() {
		return antecedente;
	}
	public void setAntecedente(String antecedente) {
		this.antecedente = antecedente;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public Timestamp getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Timestamp fecha_Creacion) {
		this.fechaCreacion = fecha_Creacion;
	}
	
	public List<Otros_Antecedentes> getListaOAnt() {
		return listaOAnt;
	}
	public void setListaOAnt(List<Otros_Antecedentes> listaOAnt) {
		this.listaOAnt = listaOAnt;
	}
	public OtrosAntecedentesDAO getOantDAO() {
		return oantDAO;
	}
	public void setOantDAO(OtrosAntecedentesDAO oantDAO) {
		this.oantDAO = oantDAO;
	}
	public Otros_Antecedentes getOant() {
		return oant;
	}
	public void setOant(Otros_Antecedentes oant) {
		this.oant = oant;
	}
	public static long getCedulaPaciente() {
		return cedulaPaciente;
	}
	public static void setCedulaPaciente(long cedulaPaciente) {
		OtrosAntecedentesMB.cedulaPaciente = cedulaPaciente;
	}
	
	public void guardarOtrosAntecedentes() {
		try{
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Otros_Antecedentes ant = new Otros_Antecedentes(PacienteMB.cedulaConsulta, antecedente, observaciones);
			session.save(ant);
			session.getTransaction().commit();
			session.close();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro ha sido creado correctamente","Puede seguir registrando o volver"));
		}
		catch(Exception ex){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Esto es vergonzoso","Ha ocurrido un error al intentar hacer el registro"));
		}
	}	
	
	public void listar() throws Exception {
		cedulaPaciente = PacienteMB.cedulaConsulta;
		System.out.println("Cedula de la historia:"+PacienteMB.cedulaConsulta);
		this.listaOAnt = oantDAO.Buscar(PacienteMB.cedulaConsulta);
	}
}
