package co.edu.unal.clinica.mb;

import java.sql.Timestamp;
import java.util.*;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.hibernate.Session;

import co.edu.unal.clinica.daos.DiagnosticosDAO;
import co.edu.unal.clinica.hibernate.data.Diagnosticos;
import co.edu.unal.clinica.utils.HibernateUtil;

@ManagedBean(name="diagnosticosMB")
@SessionScoped
public class DiagnosticosMB {
	
	private long cedula;
	private String consolidado;
	private String analisis;
	private String diagnostico;
	private String plan;
	private Timestamp fechaCreacion;
	
	private List<Diagnosticos> listDiag;
	private DiagnosticosDAO diagnosticosDao = new DiagnosticosDAO();
	private static Diagnosticos diag = new Diagnosticos();
	
	public void guardarDiagnosticos() {
		try{
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			consolidado = "No";
			Diagnosticos ant = new Diagnosticos(PacienteMB.cedulaConsulta, analisis, diagnostico, plan, consolidado);
			long id = (long) session.save(ant);
			diag.setId(id);
			session.getTransaction().commit();
			session.close();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro ha sido creado correctamente","Puede seguir registrando o volver"));
		}catch(Exception ex){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Esto es vergonzoso","Ha ocurrido un error al intentar hacer el registro"));
		}
	}	
	
	public void consolidarConsulta(){
		try{
			System.out.println("++++++++++++++++++++++ ENTRA AL METODO DE CONSOLIDAR Diagnosticos" );
			Diagnosticos objetoConsolidado = diagnosticosDao.BuscarPorId(diag.getId());
			System.out.println("++++++++++++++++++++++ ID de Objeto Recuperado " +objetoConsolidado.getId());
			objetoConsolidado.setConsolidado("Si");
			diagnosticosDao.ConsolidarConsulta(objetoConsolidado);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro ha sido consolidado correctamente","Puede seguir registrando o volver"));
		}catch(Exception ex){
			System.out.println(ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Esto es vergonzoso","Ha ocurrido un error al intentar hacer la consolidacion"));
		}
	}
	
	public String modificar() throws Exception {
		diagnosticosDao.Modificar(diag);
		return "adminDiagnosticos";
	}
	
	public void listar() throws Exception {
		this.listDiag = diagnosticosDao.Buscar(PacienteMB.cedulaConsulta);
	}
	
	public String leer(Diagnosticos emp) {
		diag = emp;
		return "editarDiagnosticos";
	}
	
	public long getCedula() {
		return cedula;
	}
	public void setCedula(long cedula) {
		this.cedula = cedula;
	}
	public String getAnalisis() {
		return analisis;
	}
	public void setAnalisis(String analisis) {
		this.analisis = analisis;
	}
	public String getDiagnostico() {
		return diagnostico;
	}
	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}
	public String getPlan() {
		return plan;
	}
	public void setPlan(String plan) {
		this.plan = plan;
	}
	public Timestamp getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Timestamp fecha_creacion) {
		this.fechaCreacion = fecha_creacion;
	}
	public List<Diagnosticos> getListDiag() {
		return listDiag;
	}
	public void setListDiag(List<Diagnosticos> listDiag) {
		this.listDiag = listDiag;
	}
	public DiagnosticosDAO getDiagnosticosDao() {
		return diagnosticosDao;
	}
	public void setDiagnosticosDao(DiagnosticosDAO diagnosticosDao) {
		this.diagnosticosDao = diagnosticosDao;
	}
	public Diagnosticos getDiag() {
		return diag;
	}
	public String getConsolidado() {
		return consolidado;
	}
	public void setConsolidado(String consolidado) {
		this.consolidado = consolidado;
	}
}
