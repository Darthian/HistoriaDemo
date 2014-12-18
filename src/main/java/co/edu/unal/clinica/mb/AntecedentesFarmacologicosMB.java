package co.edu.unal.clinica.mb;

import java.sql.Timestamp;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.hibernate.Session;

import co.edu.unal.clinica.daos.AntecedentesFarmacologicosDAO;
import co.edu.unal.clinica.hibernate.data.Antecedentes_Farmacologicos;
import co.edu.unal.clinica.utils.HibernateUtil;

@ManagedBean(name="antecedentesFarmacologicosMB")
@SessionScoped
public class AntecedentesFarmacologicosMB {
	
	private long fkConsulta;
	private long cedula;
	private String consolidado;
	private String tratamientoActual;
	private String dieta;
	private String hipoglucemiantesOrales;
	private String insulina;
	private String otrosMedicamentos;
	private Timestamp fechaCreacion;
	
	private List<Antecedentes_Farmacologicos> listFarma;
	private AntecedentesFarmacologicosDAO farmaDao = new AntecedentesFarmacologicosDAO();
	private static Antecedentes_Farmacologicos farma = new Antecedentes_Farmacologicos();
	
	public void guardarAntecedenteFarmacologico() {
		try{
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			consolidado = "No";
			Antecedentes_Farmacologicos ant = new Antecedentes_Farmacologicos(PacienteMB.cedulaConsulta, tratamientoActual, dieta,hipoglucemiantesOrales, insulina, otrosMedicamentos, consolidado);
			long id = (long) session.save(ant);
			farma.setId(id);
			session.getTransaction().commit();
			session.close();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro ha sido creado correctamente","Puede seguir registrando o volver"));
		}
		catch(Exception ex){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Esto es vergonzoso","Ha ocurrido un error al intentar hacer el registro"));
		}
	}	
	
	public void consolidarAntecedenteFarmacologico(){
		try{
			System.out.println("++++++++++++++++++++++ ENTRA AL METODO DE CONSOLIDAR ANTECEDENTES Farmacologicos" );
			Antecedentes_Farmacologicos objetoConsolidado = farmaDao.BuscarPorId(farma.getId());
			System.out.println("++++++++++++++++++++++ ID de Objeto Recuperado " +objetoConsolidado.getId());
			objetoConsolidado.setConsolidado("Si");
			farmaDao.ConsolidarConsulta(objetoConsolidado);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro ha sido consolidado correctamente","Puede seguir registrando o volver"));
		}catch(Exception ex){
			System.out.println(ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Esto es vergonzoso","Ha ocurrido un error al intentar hacer la consolidacion"));
		}
	}
	
	public void consolidarAntecedenteFarmacologico(long idConsulta){
		try{
			System.out.println("++++++++++++++++++++++ ENTRA AL METODO DE CONSOLIDAR ANTECEDENTES Farmacologicos" );
			Antecedentes_Farmacologicos objetoConsolidado = farmaDao.BuscarPorId(farma.getId());
			System.out.println("++++++++++++++++++++++ ID de Objeto Recuperado " +objetoConsolidado.getId());
			objetoConsolidado.setConsolidado("Si");
			objetoConsolidado.setFkConsulta(idConsulta);
			farmaDao.ConsolidarConsulta(objetoConsolidado);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro ha sido consolidado correctamente","Puede seguir registrando o volver"));
		}catch(Exception ex){
			System.out.println(ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Esto es vergonzoso","Ha ocurrido un error al intentar hacer la consolidacion"));
		}
	}
	
	public String modificar() {
		try{
		farmaDao.Modificar(farma);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro ha sido modificado correctamente","Puede seguir modificando o volver"));
		}catch(Exception ex){
			System.out.println(ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Esto es vergonzoso","Ha ocurrido un error al intentar modificar la informacion"));
		}
		return "adminAntecedentesFarmacologicos";
	}
		
	public void listar() throws Exception {
		this.listFarma = farmaDao.Buscar(PacienteMB.cedulaConsulta);
	}
	
	public String leer(Antecedentes_Farmacologicos emp) {
		farma = emp;
		return "editarAntecedentesFarmacologicos";
	}
	
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
