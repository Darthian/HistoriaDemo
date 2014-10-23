package co.edu.unal.clinica.mb;

import java.sql.Timestamp;
import java.util.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.hibernate.Session;

import co.edu.unal.clinica.daos.DiagnosticosDAO;
import co.edu.unal.clinica.hibernate.data.Diagnosticos;
import co.edu.unal.clinica.utils.HibernateUtil;

@ManagedBean(name="diagnosticosMB")
@SessionScoped
public class DiagnosticosMB {
	
	private long cedula;
	private String analisis;
	private String diagnostico;
	private String plan;
	private Timestamp fechaCreacion;
	
	private List<Diagnosticos> listDiag;
	private DiagnosticosDAO diagnosticosDao = new DiagnosticosDAO();
	private Diagnosticos diag = new Diagnosticos();
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
	public void setDiag(Diagnosticos diag) {
		this.diag = diag;
	}
	
	public void guardarDiagnosticos() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Diagnosticos ant = new Diagnosticos(PacienteMB.cedulaConsulta, analisis, diagnostico,plan);
		session.save(ant);
		session.getTransaction().commit();
		session.close();
	}	
	
	public void listar() throws Exception {
		this.listDiag = diagnosticosDao.Buscar(PacienteMB.cedulaConsulta);
	}
}
