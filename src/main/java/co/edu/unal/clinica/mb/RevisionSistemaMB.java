package co.edu.unal.clinica.mb;

import java.sql.Timestamp;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.hibernate.Session;

import co.edu.unal.clinica.daos.RevisionSistemaDAO;
import co.edu.unal.clinica.hibernate.data.Revision_Sistema;
import co.edu.unal.clinica.utils.HibernateUtil;

@ManagedBean(name="revisionSistemaMB")
@SessionScoped
public class RevisionSistemaMB {
	
	private long cedula;
	private String estadoGeneral;
	private String cardioVascular;
	private String respiratorio;
	private String gastrointestinal;
	private String musculoEsqueletico;
	private Timestamp fechaCreacion;
	
	private List<Revision_Sistema> listRevi;
	private RevisionSistemaDAO reviDao = new RevisionSistemaDAO();
	private Revision_Sistema revi = new Revision_Sistema();
	
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
	public String getCardioVascular() {
		return cardioVascular;
	}
	public void setCardioVascular(String cardio_vascular) {
		this.cardioVascular = cardio_vascular;
	}
	public String getRespiratorio() {
		return respiratorio;
	}
	public void setRespiratorio(String respiratorio) {
		this.respiratorio = respiratorio;
	}
	public String getGastrointestinal() {
		return gastrointestinal;
	}
	public void setGastrointestinal(String gastrointestinal) {
		this.gastrointestinal = gastrointestinal;
	}
	public String getMusculoEsqueletico() {
		return musculoEsqueletico;
	}
	public void setMusculoEsqueletico(String musculo_esqueletico) {
		this.musculoEsqueletico = musculo_esqueletico;
	}
	public Timestamp getFecha_creacion() {
		return fechaCreacion;
	}
	public void setFecha_creacion(Timestamp fecha_creacion) {
		this.fechaCreacion = fecha_creacion;
	}
	public List<Revision_Sistema> getListRevi() {
		return listRevi;
	}
	public void setListRevi(List<Revision_Sistema> listRevi) {
		this.listRevi = listRevi;
	}
	public RevisionSistemaDAO getReviDao() {
		return reviDao;
	}
	public void setReviDao(RevisionSistemaDAO reviDao) {
		this.reviDao = reviDao;
	}
	public Revision_Sistema getRevi() {
		return revi;
	}
	public void setRevi(Revision_Sistema revi) {
		this.revi = revi;
	}
	
	public void guardarRevision() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Revision_Sistema ant = new Revision_Sistema(PacienteMB.cedulaConsulta, estadoGeneral, cardioVascular,respiratorio, gastrointestinal,musculoEsqueletico);
		session.save(ant);
		session.getTransaction().commit();
		session.close();
	}	
	
	public void listar() throws Exception {
		this.listRevi = reviDao.Buscar(PacienteMB.cedulaConsulta);
	}
}
