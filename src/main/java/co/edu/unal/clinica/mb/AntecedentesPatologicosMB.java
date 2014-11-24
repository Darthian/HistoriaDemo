package co.edu.unal.clinica.mb;

import java.sql.Timestamp;
import java.util.*;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.hibernate.Session;

import co.edu.unal.clinica.daos.AntecedentesPatologicosDAO;
import co.edu.unal.clinica.hibernate.data.Antecedentes_Patologicos;
import co.edu.unal.clinica.utils.HibernateUtil;

@ManagedBean(name="antecedentesPatologicosMB")
@SessionScoped
public class AntecedentesPatologicosMB {
	
	private long cedula;
	private String consolidado;
	private String complicacionesDiabetes;
	private String compCardiovasculares;
	private String complicacionCardiovascular;
	private String retinopatiaDiabetica;
	private String nefropatiaDiabetica;
	private int estadoNefropatia;
	private String hipertension;
	private String dislipidemia;
	private String tipoDislipidemia;
	private String filtracionGlomerular;
	private String pieDiabetico;
	private String otros;
	private Timestamp fechaCreacion;
	
	private List<Antecedentes_Patologicos> listPato;
	private AntecedentesPatologicosDAO patoDao = new AntecedentesPatologicosDAO();
	private static Antecedentes_Patologicos pato = new Antecedentes_Patologicos();
	
	public void guardarAntecedentePatologico() {
		try{
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			consolidado = "No";
			Antecedentes_Patologicos ant = new Antecedentes_Patologicos(PacienteMB.cedulaConsulta, complicacionesDiabetes, retinopatiaDiabetica,nefropatiaDiabetica, estadoNefropatia,hipertension,dislipidemia,tipoDislipidemia,otros,
					compCardiovasculares, complicacionCardiovascular, filtracionGlomerular,pieDiabetico, consolidado);
			long id = (long) session.save(ant);
			pato.setId(id);
			session.getTransaction().commit();
			session.close();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro ha sido creado correctamente","Puede seguir registrando o volver"));
		}
		catch(Exception ex){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Esto es vergonzoso","Ha ocurrido un error al intentar hacer el registro"));
		}
	}	
	
	public void consolidarConsulta(){
		try{
			System.out.println("++++++++++++++++++++++ ENTRA AL METODO DE CONSOLIDAR ANTECEDENTES Patologicos" );
			Antecedentes_Patologicos objetoConsolidado = patoDao.BuscarPorId(pato.getId());
			System.out.println("++++++++++++++++++++++ ID de Objeto Recuperado " +objetoConsolidado.getId());
			objetoConsolidado.setConsolidado("Si");
			patoDao.ConsolidarConsulta(objetoConsolidado);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro ha sido consolidado correctamente","Puede seguir registrando o volver"));
		}catch(Exception ex){
			System.out.println(ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Esto es vergonzoso","Ha ocurrido un error al intentar hacer la consolidacion"));
		}
	}
	
	public String modificar() {
		try{
		patoDao.Modificar(pato);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro ha sido modificado correctamente","Puede seguir modificando o volver"));
		}catch(Exception ex){
			System.out.println(ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Esto es vergonzoso","Ha ocurrido un error al intentar modificar la informacion"));
		}
		
		return "adminAntecedentesPatologicos";
	}
	
	public void listar() throws Exception {
		this.listPato = patoDao.Buscar(PacienteMB.cedulaConsulta);
	}
	
	public String leer(Antecedentes_Patologicos emp) {
		pato = emp;
		return "editarAntecedentesPatologicos";
	}
	
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
	public String getCompCardiovasculares() {
		return compCardiovasculares;
	}
	public void setCompCardiovasculares(String compCardiovasculares) {
		this.compCardiovasculares = compCardiovasculares;
	}
	public String getComplicacionCardiovascular() {
		return complicacionCardiovascular;
	}
	public void setComplicacionCardiovascular(String complicacionCardiovascular) {
		this.complicacionCardiovascular = complicacionCardiovascular;
	}

	public String getFiltracionGlomerular() {
		return filtracionGlomerular;
	}

	public void setFiltracionGlomerular(String filtracionGlomerular) {
		this.filtracionGlomerular = filtracionGlomerular;
	}

	public String getPieDiabetico() {
		return pieDiabetico;
	}

	public void setPieDiabetico(String pieDiabetico) {
		this.pieDiabetico = pieDiabetico;
	}

	public String getConsolidado() {
		return consolidado;
	}

	public void setConsolidado(String consolidado) {
		this.consolidado = consolidado;
	}
}
