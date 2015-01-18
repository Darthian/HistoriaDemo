package co.edu.unal.clinica.mb;

import java.sql.Timestamp;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.hibernate.Session;

import co.edu.unal.clinica.daos.RevisionSistemaDAO;
import co.edu.unal.clinica.hibernate.data.Revision_Sistema;
import co.edu.unal.clinica.utils.HibernateUtil;

@ManagedBean(name="revisionSistemaMB")
@SessionScoped
public class RevisionSistemaMB {
	
	private long fkConsulta;
	private long cedula;
	private String consolidado;
	private String estadoGeneral;
	private String cardioVascular;
	private String respiratorio;
	private String gastrointestinal;
	private String musculoEsqueletico;
	private String cabeza;
	private String cuello;
	private String cardiopulmunar;
	private String digestivo;
	private String genitourinario;
	private String extremidades;
	private String psicomotor;
	private String nervioso;
	private String endocrino;
	private Timestamp fechaCreacion;
	
	private List<Revision_Sistema> listRevi;
	private RevisionSistemaDAO reviDao = new RevisionSistemaDAO();
	private static Revision_Sistema revi = new Revision_Sistema();
	
	public void guardarRevision() {
		try{
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			consolidado = "No";
			Revision_Sistema ant = new Revision_Sistema(PacienteMB.cedulaConsulta, estadoGeneral, cardioVascular,respiratorio, gastrointestinal,musculoEsqueletico,
					cabeza, cuello, cardiopulmunar, digestivo, genitourinario, extremidades, psicomotor, nervioso, endocrino, consolidado);
			long id = (long) session.save(ant);
			revi.setId(id);
			session.getTransaction().commit();
			session.close();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro ha sido creado correctamente","Puede seguir registrando o volver"));
		}catch(Exception ex){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Esto es vergonzoso","Ha ocurrido un error al intentar hacer el registro"));
		}
	}	
	
//	public void consolidarRevision(){
//		try{
//			System.out.println("++++++++++++++++++++++ ENTRA AL METODO DE CONSOLIDAR Revision Sistema" );
//			Revision_Sistema objetoConsolidado = reviDao.BuscarPorId(revi.getId());
//			System.out.println("++++++++++++++++++++++ ID de Objeto Recuperado " +objetoConsolidado.getId());
//			objetoConsolidado.setConsolidado("Si");
//			reviDao.ConsolidarConsulta(objetoConsolidado);
//			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro ha sido consolidado correctamente","Puede seguir registrando o volver"));
//		}catch(Exception ex){
//			System.out.println(ex);
//			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Esto es vergonzoso","Ha ocurrido un error al intentar hacer la consolidacion"));
//		}
//	}
	
	public void consolidarRevision(long idConsulta){
		try{
			System.out.println("++++++++++++++++++++++ ENTRA AL METODO DE CONSOLIDAR Revision Sistema" );
			List<Revision_Sistema> listobjetoConsolidado = reviDao.BuscarNoConsolidados();
			if(listobjetoConsolidado!= null && listobjetoConsolidado.size() > 0){
				for(Revision_Sistema iterator : listobjetoConsolidado){
					System.out.println("++++++++++++++++++++++ ID de Objeto Recuperado " +iterator.getId());
					iterator.setConsolidado("Si");
					iterator.setFkConsulta(idConsulta);
				}
				reviDao.ConsolidarConsulta(listobjetoConsolidado);
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
	
	public String modificar(){
		try{
		reviDao.Modificar(revi);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro ha sido modificado correctamente","Puede seguir modificando o volver"));
		}catch(Exception ex){
			System.out.println(ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Esto es vergonzoso","Ha ocurrido un error al intentar modificar la informacion"));
		}
		return "adminRevisionSistema";
	}
	
	public void listar() throws Exception {
		this.listRevi = reviDao.Buscar(PacienteMB.cedulaConsulta);
	}
	
	public String leer(Revision_Sistema emp) {
		revi = emp;
		return "editarRevisionSistema";
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
	public String getCabeza() {
		return cabeza;
	}

	public void setCabeza(String cabeza) {
		this.cabeza = cabeza;
	}

	public String getCuello() {
		return cuello;
	}

	public void setCuello(String cuello) {
		this.cuello = cuello;
	}

	public String getCardiopulmunar() {
		return cardiopulmunar;
	}

	public void setCardiopulmunar(String cardiopulmunar) {
		this.cardiopulmunar = cardiopulmunar;
	}

	public String getDigestivo() {
		return digestivo;
	}

	public void setDigestivo(String digestivo) {
		this.digestivo = digestivo;
	}

	public String getGenitourinario() {
		return genitourinario;
	}

	public void setGenitourinario(String genitourinario) {
		this.genitourinario = genitourinario;
	}

	public String getExtremidades() {
		return extremidades;
	}

	public void setExtremidades(String extremidades) {
		this.extremidades = extremidades;
	}

	public String getPsicomotor() {
		return psicomotor;
	}

	public void setPsicomotor(String psicomotor) {
		this.psicomotor = psicomotor;
	}

	public String getNervioso() {
		return nervioso;
	}

	public void setNervioso(String nervioso) {
		this.nervioso = nervioso;
	}

	public String getEndocrino() {
		return endocrino;
	}

	public void setEndocrino(String endocrino) {
		this.endocrino = endocrino;
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
