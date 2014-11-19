package co.edu.unal.clinica.mb;

import java.sql.Timestamp;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.hibernate.Session;

import co.edu.unal.clinica.daos.MotivoConsultaDAO;
import co.edu.unal.clinica.hibernate.data.Motivo_Consulta;
import co.edu.unal.clinica.utils.HibernateUtil;

@ManagedBean(name="motivoConsultaMB")
@SessionScoped
public class MotivoConsultaMB {
	
	private long cedula;
	private String consolidado;
	private String motivoConsulta;
	private Timestamp fechaCreacion;
	
	private List<Motivo_Consulta> listMot;
	private MotivoConsultaDAO motDao = new MotivoConsultaDAO();
	private static Motivo_Consulta mot = new Motivo_Consulta();
	
	public void guardarMotivoConsulta() {
		try{
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			consolidado = "No";
			Motivo_Consulta ant = new Motivo_Consulta(PacienteMB.cedulaConsulta, motivoConsulta, consolidado);
			System.out.println("++++++++++++++++++++++ Se instancia el objeto a guardar, aun no se guarda " +mot.getId());
			long id = (long) session.save(ant);
			mot.setId(id); 
			System.out.println("++++++++++++++++++++++ Se guarda el objeto instanciado ID GUARDADO: " +mot.getId());
			session.getTransaction().commit();
			session.close();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro ha sido creado correctamente","Puede seguir registrando o volver"));
		}catch(Exception ex){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Esto es vergonzoso","Ha ocurrido un error al intentar hacer el registro"));
		}
	}	
	
	public void consolidarConsulta(){
		try{
			System.out.println("++++++++++++++++++++++ ENTRA AL METODO DE CONSOLIDAR MOTIVO CONSULTA " );
			Motivo_Consulta motConsolidado = motDao.BuscarPorId(mot.getId());
			System.out.println("++++++++++++++++++++++ ID de Objeto Recuperado " +motConsolidado.getId());
			motConsolidado.setConsolidado("Si");
			motDao.ConsolidarConsulta(motConsolidado);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro ha sido consolidado correctamente","Puede seguir registrando o volver"));
		}catch(Exception ex){
			System.out.println(ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Esto es vergonzoso","Ha ocurrido un error al intentar hacer la consolidacion"));
		}
	}
	
	public String modificar() throws Exception {
		motDao.Modificar(mot);
		return "adminMotivoConsulta";
	}
	
	public void listar() throws Exception {
		this.listMot = motDao.Buscar(PacienteMB.cedulaConsulta);
	}
	
	public String leer(Motivo_Consulta emp) {
		mot = emp;
		return "editarMotivo";
	}
	
	public long getCedula() {
		return cedula;
	}
	public void setCedula(long cedula) {
		this.cedula = cedula;
	}
	public String getMotivoConsulta() {
		return motivoConsulta;
	}
	public void setMotivoConsulta(String motivoConsulta) {
		this.motivoConsulta = motivoConsulta;
	}
	public Timestamp getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public List<Motivo_Consulta> getListMot() {
		return listMot;
	}
	public void setListMot(List<Motivo_Consulta> listMot) {
		this.listMot = listMot;
	}
	public MotivoConsultaDAO getMotDao() {
		return motDao;
	}
	public void setMotDao(MotivoConsultaDAO motDao) {
		this.motDao = motDao;
	}
	public Motivo_Consulta getMot() {
		return mot;
	}
	public String getConsolidado() {
		return consolidado;
	}
	public void setConsolidado(String consolidado) {
		this.consolidado = consolidado;
	}
}
