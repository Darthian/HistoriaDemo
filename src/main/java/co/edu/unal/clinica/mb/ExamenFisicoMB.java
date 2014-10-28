package co.edu.unal.clinica.mb;

import java.sql.Timestamp;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.hibernate.Session;

import co.edu.unal.clinica.daos.ExamenFisicoDAO;
import co.edu.unal.clinica.hibernate.data.Examen_Fisico;
import co.edu.unal.clinica.utils.HibernateUtil;

@ManagedBean(name="examenFisicoMB")
@SessionScoped
public class ExamenFisicoMB {
	
	private long cedula;
	private String estadoGeneral;
	private String cabeza;
	private String ojos;
	private String nariz;
	private String boca;
	private String orejas;
	private String cuello;
	private String cardiaco;
	private String pulmonar;
	private String abdomen;
	private String extremidades;
	private String neurologico;
	private Timestamp fechaCreacion;
	
	private List<Examen_Fisico> listExam;
	private ExamenFisicoDAO examDao = new ExamenFisicoDAO();
	private Examen_Fisico exam = new Examen_Fisico();
	public long getCedula() {
		return cedula;
	}
	public void setCedula(long cedula) {
		this.cedula = cedula;
	}
	public String getEstadoGeneral() {
		return estadoGeneral;
	}
	public void setEstadoGeneral(String estado_general) {
		this.estadoGeneral = estado_general;
	}
	public String getCabeza() {
		return cabeza;
	}
	public void setCabeza(String cabeza) {
		this.cabeza = cabeza;
	}
	public String getOjos() {
		return ojos;
	}
	public void setOjos(String ojos) {
		this.ojos = ojos;
	}
	public String getNariz() {
		return nariz;
	}
	public void setNariz(String nariz) {
		this.nariz = nariz;
	}
	public String getBoca() {
		return boca;
	}
	public void setBoca(String boca) {
		this.boca = boca;
	}
	public String getOrejas() {
		return orejas;
	}
	public void setOrejas(String orejas) {
		this.orejas = orejas;
	}
	public String getCuello() {
		return cuello;
	}
	public void setCuello(String cuello) {
		this.cuello = cuello;
	}
	public String getCardiaco() {
		return cardiaco;
	}
	public void setCardiaco(String cardiaco) {
		this.cardiaco = cardiaco;
	}
	public String getPulmonar() {
		return pulmonar;
	}
	public void setPulmonar(String pulmonar) {
		this.pulmonar = pulmonar;
	}
	public String getAbdomen() {
		return abdomen;
	}
	public void setAbdomen(String abdomen) {
		this.abdomen = abdomen;
	}
	public String getExtremidades() {
		return extremidades;
	}
	public void setExtremidades(String extremidades) {
		this.extremidades = extremidades;
	}
	public String getNeurologico() {
		return neurologico;
	}
	public void setNeurologico(String neurologico) {
		this.neurologico = neurologico;
	}
	public Timestamp getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Timestamp fecha_creacion) {
		this.fechaCreacion = fecha_creacion;
	}
	public List<Examen_Fisico> getListExam() {
		return listExam;
	}
	public void setListExam(List<Examen_Fisico> listExam) {
		this.listExam = listExam;
	}
	public ExamenFisicoDAO getExamDao() {
		return examDao;
	}
	public void setExamDao(ExamenFisicoDAO examDao) {
		this.examDao = examDao;
	}
	public Examen_Fisico getExam() {
		return exam;
	}
	public void setExam(Examen_Fisico exam) {
		this.exam = exam;
	}
	
	public void guardarExamenFisico() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Examen_Fisico ant = new Examen_Fisico(PacienteMB.cedulaConsulta,estadoGeneral,cabeza,ojos,nariz,boca,orejas,cuello,cardiaco,pulmonar,abdomen,extremidades,neurologico);
		session.save(ant);
		session.getTransaction().commit();
		session.close();
	}	
	
	public void listar() throws Exception {
		this.listExam = examDao.Buscar(PacienteMB.cedulaConsulta);
	}
}
