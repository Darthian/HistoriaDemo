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
	
	private long fkConsulta;
	private long cedula;
	private String consolidado;
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
	private List<Habitos> listHabHC;
	private HabitosDAO habDao = new HabitosDAO();
	private static Habitos hab = new Habitos();
	
	public void guardarHabitos() {
		try{
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			consolidado = "No";
			Habitos ant = new Habitos(PacienteMB.cedulaConsulta, fumador, exfumador,consumidorAlcohol, ejercicio, fumadorTexto, exfumadorTexto,
					alcoholTexto, ejercicioTexto, dificultadEjercicio, dificultadTexto, consolidado);
			long id = (long) session.save(ant);
			hab.setId(id);
			session.getTransaction().commit();
			session.close();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro ha sido creado correctamente","Puede seguir registrando o volver"));
		}catch(Exception ex){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Esto es vergonzoso","Ha ocurrido un error al intentar hacer el registro"));
		}
	}	
	
//	public void consolidarHabitos(){
//		try{
//			System.out.println("++++++++++++++++++++++ ENTRA AL METODO DE CONSOLIDAR Habitos" );
//			Habitos objetoConsolidado = habDao.BuscarPorId(hab.getId());
//			System.out.println("++++++++++++++++++++++ ID de Objeto Recuperado " +objetoConsolidado.getId());
//			objetoConsolidado.setConsolidado("Si");
//			habDao.ConsolidarConsulta(objetoConsolidado);
//			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro ha sido consolidado correctamente","Puede seguir registrando o volver"));
//		}catch(Exception ex){
//			System.out.println(ex);
//			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Esto es vergonzoso","Ha ocurrido un error al intentar hacer la consolidacion"));
//		}
//	}
	
	public void consolidarHabitos(long idConsulta){
		try{
			System.out.println("++++++++++++++++++++++ ENTRA AL METODO DE CONSOLIDAR Habitos" );
			List<Habitos> listobjetoConsolidado = habDao.BuscarNoConsolidados();
			if(listobjetoConsolidado!= null && listobjetoConsolidado.size() > 0){
				for(Habitos iterator : listobjetoConsolidado){
					System.out.println("++++++++++++++++++++++ ID de Objeto Recuperado " +iterator.getId());
					iterator.setConsolidado("Si");
					iterator.setFkConsulta(idConsulta);
				}
				habDao.ConsolidarConsulta(listobjetoConsolidado);
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro ha sido consolidado correctamente","Puede seguir registrando o volver"));
			}else{
				System.out.println("++++++++++++++++++++++ No hay regitros sin consolidar");
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "No hay regitros sin consolidar","No hay motivos de consulta sin guardar definitivamente"));
			}
		}catch(Exception ex){
			System.out.println(ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Esto es vergonzoso","Ha ocurrido un error al intentar hacer la consolidacion"));
		}
	}
	
	public String modificar() {
		try{
		habDao.Modificar(hab);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro ha sido modificado correctamente","Puede seguir modificando o volver"));
		}catch(Exception ex){
			System.out.println(ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Esto es vergonzoso","Ha ocurrido un error al intentar modificar la informacion"));
		}
		return "adminHabitos";
	}
	
	public void listar() throws Exception {
		this.listHab = habDao.Buscar(PacienteMB.cedulaConsulta);
	}
	
	public void listarHC() throws Exception {
		System.out.println("+++++++ID CONSULTA EN MB HABITOS: "+ConsultaMB.idConsultaConstante);
		this.listHabHC = habDao.BuscarPorConsulta(ConsultaMB.idConsultaConstante);
	}
	
	public String leer(Habitos emp) {
		hab = emp;
		return "editarHabitos";
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

	public String getConsolidado() {
		return consolidado;
	}

	public void setConsolidado(String consolidado) {
		this.consolidado = consolidado;
	}

	public long getFkConsulta() {
		return fkConsulta;
	}

	public void setFkConsulta(long fkConsulta) {
		this.fkConsulta = fkConsulta;
	}

	public List<Habitos> getListHabHC() {
		return listHabHC;
	}

	public void setListHabHC(List<Habitos> listHabHC) {
		this.listHabHC = listHabHC;
	}
	
}
