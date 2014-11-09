package co.edu.unal.clinica.mb;

import java.sql.Timestamp;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.hibernate.Session;

import co.edu.unal.clinica.daos.HabitosDAO;
import co.edu.unal.clinica.hibernate.data.Habitos;
import co.edu.unal.clinica.utils.HibernateUtil;

@ManagedBean(name="habitosMB")
@SessionScoped
public class HabitosMB {
	
	private long cedula;
	private String fumador;
	private String fumadorTexto;
	private String exfumador;
	private String exfumadorTexto;
	private String consumidorAlcohol;
	private String alcoholTexto;
	private String ejercicio;
	private String ejercicioTexto;
	private String dificultadEjercicio;
	private String dificultadTexto;
	private Timestamp fechaCreacion;
	
	private List<Habitos> listHab;
	private HabitosDAO habDao = new HabitosDAO();
	private Habitos hab = new Habitos();
	
	public void guardarHabitos() {
		try{
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Habitos ant = new Habitos(PacienteMB.cedulaConsulta, fumador, exfumador,consumidorAlcohol, ejercicio, fumadorTexto, exfumadorTexto,
					alcoholTexto, ejercicioTexto, dificultadEjercicio, dificultadTexto);
			session.save(ant);
			session.getTransaction().commit();
			session.close();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro ha sido creado correctamente","Puede seguir registrando o volver"));
		}catch(Exception ex){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Esto es vergonzoso","Ha ocurrido un error al intentar hacer el registro"));
		}
	}	
	
	public void listar() throws Exception {
		this.listHab = habDao.Buscar(PacienteMB.cedulaConsulta);
	}
	
	public long getCedula() {
		return cedula;
	}
	public void setCedula(long cedula) {
		this.cedula = cedula;
	}
	public String getFumador() {
		return fumador;
	}
	public void setFumador(String fumador) {
		this.fumador = fumador;
	}
	public String getExfumador() {
		return exfumador;
	}
	public void setExfumador(String exfumador) {
		this.exfumador = exfumador;
	}
	public String getConsumidorAlcohol() {
		return consumidorAlcohol;
	}
	public void setConsumidorAlcohol(String consumidor_alcohol) {
		this.consumidorAlcohol = consumidor_alcohol;
	}
	public String getEjercicio() {
		return ejercicio;
	}
	public void setEjercicio(String ejercicio) {
		this.ejercicio = ejercicio;
	}
	public Timestamp getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Timestamp fecha_creacion) {
		this.fechaCreacion = fecha_creacion;
	}
	public List<Habitos> getListHab() {
		return listHab;
	}
	public void setListHab(List<Habitos> listHab) {
		this.listHab = listHab;
	}
	public HabitosDAO getHabDao() {
		return habDao;
	}
	public void setHabDao(HabitosDAO habDao) {
		this.habDao = habDao;
	}
	public Habitos getHab() {
		return hab;
	}
	public void setHab(Habitos hab) {
		this.hab = hab;
	}

	public String getFumadorTexto() {
		return fumadorTexto;
	}

	public void setFumadorTexto(String fumadorTexto) {
		this.fumadorTexto = fumadorTexto;
	}

	public String getExfumadorTexto() {
		return exfumadorTexto;
	}

	public void setExfumadorTexto(String exfumadorTexto) {
		this.exfumadorTexto = exfumadorTexto;
	}

	public String getAlcoholTexto() {
		return alcoholTexto;
	}

	public void setAlcoholTexto(String alcoholTexto) {
		this.alcoholTexto = alcoholTexto;
	}

	public String getEjercicioTexto() {
		return ejercicioTexto;
	}

	public void setEjercicioTexto(String ejercicioTexto) {
		this.ejercicioTexto = ejercicioTexto;
	}

	public String getDificultadEjercicio() {
		return dificultadEjercicio;
	}

	public void setDificultadEjercicio(String dificultadEjercicio) {
		this.dificultadEjercicio = dificultadEjercicio;
	}

	public String getDificultadTexto() {
		return dificultadTexto;
	}

	public void setDificultadTexto(String dificultadTexto) {
		this.dificultadTexto = dificultadTexto;
	}
	
}
