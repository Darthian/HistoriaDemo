package co.edu.unal.clinica.mb;

import java.sql.Timestamp;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.hibernate.Session;

import co.edu.unal.clinica.daos.ParaclinicosDAO;
import co.edu.unal.clinica.hibernate.data.Paraclinicos;
import co.edu.unal.clinica.utils.HibernateUtil;

@ManagedBean(name="paraclinicosMB")
@SessionScoped
public class ParaclinicosMB {
	
	private long cedula;
	private float glicemiaAyunas;
	private float glicemiaPostPrandial;
	private float hemoglobinaGlicosilada;
	private float trigliceridos;
	private float hdl;
	private float ldl;
	private float vldl;
	private float creatinina;
	private float bun;
	private float otrosParaclinicos;
	private Timestamp fechaCreacion;
	
	private List<Paraclinicos> listPara;
	private ParaclinicosDAO paraDao = new ParaclinicosDAO();
	private Paraclinicos para = new Paraclinicos();
	public long getCedula() {
		return cedula;
	}
	public void setCedula(long cedula) {
		this.cedula = cedula;
	}
	public float getGlicemiaAyunas() {
		return glicemiaAyunas;
	}
	public void setGlicemiaAyunas(float glicemia_ayunas) {
		this.glicemiaAyunas = glicemia_ayunas;
	}
	public float getGlicemiaPostPrandial() {
		return glicemiaPostPrandial;
	}
	public void setGlicemiaPostPrandial(float glicemia_post_prandial) {
		this.glicemiaPostPrandial = glicemia_post_prandial;
	}
	public float getHemoglobinaGlicosilada() {
		return hemoglobinaGlicosilada;
	}
	public void setHemoglobinaGlicosilada(float hemoglobina_glicosilada) {
		this.hemoglobinaGlicosilada = hemoglobina_glicosilada;
	}
	public float getTrigliceridos() {
		return trigliceridos;
	}
	public void setTrigliceridos(float trigliceridos) {
		this.trigliceridos = trigliceridos;
	}
	public float getHdl() {
		return hdl;
	}
	public void setHdl(float hdl) {
		this.hdl = hdl;
	}
	public float getLdl() {
		return ldl;
	}
	public void setLdl(float ldl) {
		this.ldl = ldl;
	}
	public float getVldl() {
		return vldl;
	}
	public void setVldl(float vldl) {
		this.vldl = vldl;
	}
	public float getCreatinina() {
		return creatinina;
	}
	public void setCreatinina(float creatinina) {
		this.creatinina = creatinina;
	}
	public float getBun() {
		return bun;
	}
	public void setBun(float bun) {
		this.bun = bun;
	}
	public float getOtrosParaclinicos() {
		return otrosParaclinicos;
	}
	public void setOtrosParaclinicos(float otros_paraclinicos) {
		this.otrosParaclinicos = otros_paraclinicos;
	}	
	public Timestamp getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFecha_creacion(Timestamp fecha_creacion) {
		this.fechaCreacion = fecha_creacion;
	}
	public List<Paraclinicos> getListPara() {
		return listPara;
	}
	public void setListPara(List<Paraclinicos> listPara) {
		this.listPara = listPara;
	}
	public ParaclinicosDAO getParaDao() {
		return paraDao;
	}
	public void setParaDao(ParaclinicosDAO paraDao) {
		this.paraDao = paraDao;
	}
	public Paraclinicos getPara() {
		return para;
	}
	public void setPara(Paraclinicos para) {
		this.para = para;
	}
	public void guardarParaClinicos() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Paraclinicos ant = new Paraclinicos(PacienteMB.cedulaConsulta, glicemiaAyunas, glicemiaPostPrandial,hemoglobinaGlicosilada, trigliceridos,hdl,ldl,vldl,creatinina,bun,otrosParaclinicos);
		session.save(ant);
		session.getTransaction().commit();
		session.close();
	}	
	
	public void listar() throws Exception {
		this.listPara = paraDao.Buscar(PacienteMB.cedulaConsulta);
	}
}
