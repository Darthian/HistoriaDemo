package co.edu.unal.clinica.mb;

import java.sql.Timestamp;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.hibernate.Session;

import co.edu.unal.clinica.daos.AntecedentesFarmacologicosDAO;
import co.edu.unal.clinica.hibernate.data.Antecedentes_Farmacologicos;
import co.edu.unal.clinica.utils.HibernateUtil;

@ManagedBean(name="antecedentesFarmacologicosMB")
@SessionScoped
public class AntecedentesFarmacologicosMB {
	
	private long cedula;
	private String tratamientoActual;
	private String dieta;
	private String hipoglucemiantesOrales;
	private String insulina;
	private String otrosMedicamentos;
	private Timestamp fechaCreacion;
	
	private List<Antecedentes_Farmacologicos> listFarma;
	private AntecedentesFarmacologicosDAO farmaDao = new AntecedentesFarmacologicosDAO();
	private Antecedentes_Farmacologicos farma = new Antecedentes_Farmacologicos();
	
	public long getCedula() {
		return cedula;
	}
	public void setCedula(long cedula) {
		this.cedula = cedula;
	}
	public String getTratamientoActual() {
		return tratamientoActual;
	}
	public void setTratamientoActual(String tratamiento_actual) {
		this.tratamientoActual = tratamiento_actual;
	}
	public String getDieta() {
		return dieta;
	}
	public void setDieta(String dieta) {
		this.dieta = dieta;
	}
	public String getHipoglucemiantesOrales() {
		return hipoglucemiantesOrales;
	}
	public void setHipoglucemiantesOrales(String hipoglucemiantes_orales) {
		this.hipoglucemiantesOrales = hipoglucemiantes_orales;
	}
	public String getInsulina() {
		return insulina;
	}
	public void setInsulina(String insulina) {
		this.insulina = insulina;
	}
	public String getOtrosMedicamentos() {
		return otrosMedicamentos;
	}
	public void setOtrosMedicamentos(String otros_medicamentos) {
		this.otrosMedicamentos = otros_medicamentos;
	}
	public Timestamp getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Timestamp fecha_creacion) {
		this.fechaCreacion = fecha_creacion;
	}
	public List<Antecedentes_Farmacologicos> getListFarma() {
		return listFarma;
	}
	public void setListFarma(List<Antecedentes_Farmacologicos> listFarma) {
		this.listFarma = listFarma;
	}
	public AntecedentesFarmacologicosDAO getFarmaDao() {
		return farmaDao;
	}
	public void setFarmaDao(AntecedentesFarmacologicosDAO farmaDao) {
		this.farmaDao = farmaDao;
	}
	public Antecedentes_Farmacologicos getFarma() {
		return farma;
	}
	public void setFarma(Antecedentes_Farmacologicos farma) {
		this.farma = farma;
	}
	
	public void guardarAntecedenteFarmacologico() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Antecedentes_Farmacologicos ant = new Antecedentes_Farmacologicos(PacienteMB.cedulaConsulta, tratamientoActual, dieta,hipoglucemiantesOrales, insulina, otrosMedicamentos);
		session.save(ant);
		session.getTransaction().commit();
		session.close();
	}	
	
	public void listar() throws Exception {
		this.listFarma = farmaDao.Buscar(PacienteMB.cedulaConsulta);
	}
}
