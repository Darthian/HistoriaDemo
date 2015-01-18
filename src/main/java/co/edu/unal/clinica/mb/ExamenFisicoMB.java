package co.edu.unal.clinica.mb;

import java.sql.Timestamp;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.hibernate.Session;

import co.edu.unal.clinica.daos.ExamenFisicoDAO;
import co.edu.unal.clinica.hibernate.data.Examen_Fisico;
import co.edu.unal.clinica.utils.HibernateUtil;

@ManagedBean(name="examenFisicoMB")
@SessionScoped
public class ExamenFisicoMB {
	
	private long fkConsulta;
	private long cedula;
	private String consolidado;
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
	private long temperatura;
	private long frecuenciaCardiaca;
	private long frecuenciaRespiratoria;
	private String presionArterial;
	private float peso;
	private float talla;
	private float perimetroAbdominal;
	private float masaCorporal;
	private Timestamp fechaCreacion;
	
	private List<Examen_Fisico> listExam;
	private ExamenFisicoDAO examDao = new ExamenFisicoDAO();
	private static Examen_Fisico exam = new Examen_Fisico();
	
	public void guardarExamenFisico() {
		try{
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			consolidado = "No";
			Examen_Fisico ant = new Examen_Fisico(PacienteMB.cedulaConsulta,estadoGeneral,cabeza,ojos,nariz,boca,orejas,cuello,cardiaco,pulmonar,abdomen,extremidades,neurologico,
					temperatura, frecuenciaCardiaca, frecuenciaRespiratoria, presionArterial, peso, talla, perimetroAbdominal, masaCorporal, consolidado);
			long id = (long) session.save(ant);
			exam.setId(id);
			session.getTransaction().commit();
			session.close();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro ha sido creado correctamente","Puede seguir registrando o volver"));
		}catch(Exception ex){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Esto es vergonzoso","Ha ocurrido un error al intentar hacer el registro"));
		}
	}	
	
//	public void consolidarExamenFisico(){
//		try{
//			System.out.println("++++++++++++++++++++++ ENTRA AL METODO DE CONSOLIDAR Examen Fisico" );
//			Examen_Fisico objetoConsolidado = examDao.BuscarPorId(exam.getId());
//			System.out.println("++++++++++++++++++++++ ID de Objeto Recuperado " +objetoConsolidado.getId());
//			objetoConsolidado.setConsolidado("Si");
//			examDao.ConsolidarConsulta(objetoConsolidado);
//			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro ha sido consolidado correctamente","Puede seguir registrando o volver"));
//		}catch(Exception ex){
//			System.out.println(ex);
//			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Esto es vergonzoso","Ha ocurrido un error al intentar hacer la consolidacion"));
//		}
//	}
	
	public void consolidarExamenFisico(long idConsulta){
		try{
			System.out.println("++++++++++++++++++++++ ENTRA AL METODO DE CONSOLIDAR ANTECEDENTES Examen Fisico" );
			List<Examen_Fisico> listobjetoConsolidado = examDao.BuscarNoConsolidados();
			if(listobjetoConsolidado!= null && listobjetoConsolidado.size() > 0){
				for(Examen_Fisico iterator : listobjetoConsolidado){
					System.out.println("++++++++++++++++++++++ ID de Objeto Recuperado " +iterator.getId());
					iterator.setConsolidado("Si");
					iterator.setFkConsulta(idConsulta);
				}
				examDao.ConsolidarConsulta(listobjetoConsolidado);
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
		examDao.Modificar(exam);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro ha sido modificado correctamente","Puede seguir modificando o volver"));
		}catch(Exception ex){
			System.out.println(ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Esto es vergonzoso","Ha ocurrido un error al intentar modificar la informacion"));
		}
		return "adminExamenFisico";
	}
	
	public void listar() throws Exception {
		this.listExam = examDao.Buscar(PacienteMB.cedulaConsulta);
	}
	
	public String leer(Examen_Fisico emp) {
		exam = emp;
		return "editarExamenFisico";
	}
	
	public String leerExamenFiscoCabeza(){
		System.out.println("+++++++++++++++++++CEDULA CAPTURADA: ");
		return "adminExamenFisicoCabeza";
	}
	
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
	public long getTemperatura() {
		return temperatura;
	}
	public void setTemperatura(long temperatura) {
		this.temperatura = temperatura;
	}
	public long getFrecuenciaCardiaca() {
		return frecuenciaCardiaca;
	}
	public void setFrecuenciaCardiaca(long frecuenciaCardiaca) {
		this.frecuenciaCardiaca = frecuenciaCardiaca;
	}
	public long getFrecuenciaRespiratoria() {
		return frecuenciaRespiratoria;
	}
	public void setFrecuenciaRespiratoria(long frecuenciaPulmonar) {
		this.frecuenciaRespiratoria = frecuenciaPulmonar;
	}
	public String getPresionArterial() {
		return presionArterial;
	}
	public void setPresionArterial(String presionArterial) {
		this.presionArterial = presionArterial;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public float getTalla() {
		return talla;
	}

	public void setTalla(float talla) {
		this.talla = talla;
	}

	public float getPerimetroAbdominal() {
		return perimetroAbdominal;
	}

	public void setPerimetroAbdominal(float perimetroAbdominal) {
		this.perimetroAbdominal = perimetroAbdominal;
	}

	public float getMasaCorporal() {
		return masaCorporal;
	}

	public void setMasaCorporal(float masaCorporal) {
		this.masaCorporal = masaCorporal;
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
}
