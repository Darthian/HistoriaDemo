package co.edu.unal.clinica.mb;

import java.sql.Timestamp;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.hibernate.Session;

import co.edu.unal.clinica.daos.HabitosDAO;
import co.edu.unal.clinica.hibernate.data.Habitos;
import co.edu.unal.clinica.utils.HibernateUtil;

@ManagedBean(name="habitosMB")
@SessionScoped
public class HabitosMB {
	
	private long cedula;
	private String fumador;
	private String exfumador;
	private String consumidorAlcohol;
	private String ejercicio;
	private Timestamp fechaCreacion;
	
	private List<Habitos> listHab;
	private HabitosDAO habDao = new HabitosDAO();
	private Habitos hab = new Habitos();
	
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
	
	public void guardarHabitos() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Habitos ant = new Habitos(PacienteMB.cedulaConsulta, fumador, exfumador,consumidorAlcohol, ejercicio);
		session.save(ant);
		session.getTransaction().commit();
		session.close();
	}	
	
	public void listar() throws Exception {
		this.listHab = habDao.Buscar(PacienteMB.cedulaConsulta);
	}
}
