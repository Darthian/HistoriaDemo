package co.edu.unal.clinica.mb;

import java.sql.Timestamp;
import java.util.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.hibernate.Session;

import co.edu.unal.clinica.daos.AntecedentesPatologicosDAO;
import co.edu.unal.clinica.hibernate.data.Antecedentes_Patologicos;
import co.edu.unal.clinica.utils.HibernateUtil;

@ManagedBean(name="antecedentesPatologicosMB")
@SessionScoped
public class AntecedentesPatologicosMB {
	
	private long cedula;
	private String complicacionesDiabetes;
	private String retinopatiaDiabetica;
	private String nefropatiaDiabetica;
	private int estadoNefropatia;
	private String hipertension;
	private String dislipidemia;
	private String tipoDislipidemia;
	private String otros;
	private Timestamp fechaCreacion;
	
	private List<Antecedentes_Patologicos> listPato;
	private AntecedentesPatologicosDAO patoDao = new AntecedentesPatologicosDAO();
	private Antecedentes_Patologicos pato = new Antecedentes_Patologicos();
	
	public long getCedula() {
		return cedula;
	}
	public void setCedula(long cedula) {
		this.cedula = cedula;
	}
	public String getComplicacionesDiabetes() {
		return complicacionesDiabetes;
	}
	public void setComplicacionesDiabetes(String complicaciones_diabetes) {
		this.complicacionesDiabetes = complicaciones_diabetes;
	}
	public String getRetinopatiaDiabetica() {
		return retinopatiaDiabetica;
	}
	public void setRetinopatiaDiabetica(String retinopatia_diabetica) {
		this.retinopatiaDiabetica = retinopatia_diabetica;
	}
	public String getNefropatiaDiabetica() {
		return nefropatiaDiabetica;
	}
	public void setNefropatiaDiabetica(String nefropatia_diabetica) {
		this.nefropatiaDiabetica = nefropatia_diabetica;
	}
	public int getEstadoNefropatia() {
		return estadoNefropatia;
	}
	public void setEstadoNefropatia(int estado_nefropatia) {
		this.estadoNefropatia = estado_nefropatia;
	}
	public String getHipertension() {
		return hipertension;
	}
	public void setHipertension(String hipertension) {
		this.hipertension = hipertension;
	}
	public String getDislipidemia() {
		return dislipidemia;
	}
	public void setDislipidemia(String dislipidemia) {
		this.dislipidemia = dislipidemia;
	}
	public String getTipoDislipidemia() {
		return tipoDislipidemia;
	}
	public void setTipoDislipidemia(String tipo_dislipidemia) {
		this.tipoDislipidemia = tipo_dislipidemia;
	}
	public String getOtros() {
		return otros;
	}
	public void setOtros(String otros) {
		this.otros = otros;
	}
	public Timestamp getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Timestamp fecha_creacion) {
		this.fechaCreacion = fecha_creacion;
	}
	public List<Antecedentes_Patologicos> getListPato() {
		return listPato;
	}
	public void setListPato(List<Antecedentes_Patologicos> listPato) {
		this.listPato = listPato;
	}
	public AntecedentesPatologicosDAO getPatoDao() {
		return patoDao;
	}
	public void setPatoDao(AntecedentesPatologicosDAO patoDao) {
		this.patoDao = patoDao;
	}
	public Antecedentes_Patologicos getPato() {
		return pato;
	}
	public void setPato(Antecedentes_Patologicos pato) {
		this.pato = pato;
	}
	
	public void guardarAntecedentePatologico() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Antecedentes_Patologicos ant = new Antecedentes_Patologicos(PacienteMB.cedulaConsulta, complicacionesDiabetes, retinopatiaDiabetica,nefropatiaDiabetica, estadoNefropatia,hipertension,dislipidemia,tipoDislipidemia,otros);
		session.save(ant);
		session.getTransaction().commit();
		session.close();
	}	
	
	public void listar() throws Exception {
		this.listPato = patoDao.Buscar(PacienteMB.cedulaConsulta);
	}
}
