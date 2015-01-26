package co.edu.unal.clinica.mb;

import java.sql.Timestamp;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.hibernate.Session;

import co.edu.unal.clinica.daos.ConsultaDAO;
import co.edu.unal.clinica.hibernate.data.Consulta;
import co.edu.unal.clinica.utils.HibernateUtil;

@ManagedBean(name="consultaMB")
@SessionScoped
public class ConsultaMB {
	
	private long id;
	private long cedula;
	private String tipoConsulta;
	private Timestamp fechaCreacion;
	
	private List<Consulta> listaConsultas;
	private List<Consulta> listaConsultasFiltradas;
	
	private ConsultaDAO consultaDao = new ConsultaDAO();
	
	public static long cedulaPaciente;
	public static long idConsultaConstante;
	
	private static Consulta consu = new Consulta();
	
	public void guardarConsulta(String tipoConsultaNueva) {
		try{
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Consulta obj = new Consulta(PacienteMB.cedulaConsulta);
			obj.setTipoConsulta(tipoConsultaNueva);
			long id = (long) session.save(obj);
			consu.setId(id); 
			session.getTransaction().commit();
			session.close();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro ha sido creado correctamente","Puede seguir registrando o volver"));
		}
		catch(Exception ex){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Esto es vergonzoso","Ha ocurrido un error al intentar hacer el registro"));
		}
	}	
	
	public void listar() throws Exception{
		cedulaPaciente = PacienteMB.cedulaConsulta;
		System.out.println("Cedula de las consultas:"+PacienteMB.cedulaConsulta);
		System.out.println("+++++++++ LLEGA AL METODO LISTAR CONSULTAS");
		this.listaConsultas = consultaDao.Buscar(PacienteMB.cedulaConsulta);
		System.out.println("+++++++++lista de consultas: "+this.listaConsultas);
	}
	
	public String leerDetalle(long idConsultaDetalle){
		idConsultaConstante = idConsultaDetalle;
		System.out.println("+++++++ID DE CONSULTA: "+idConsultaConstante);
		return "adminHistoriaClinicaDetalle";
	}
	
	public long getCedula() {
		return cedula;
	}
	public void setCedula(long cedula) {
		this.cedula = cedula;
	}
	public Timestamp getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public Consulta getConsu() {
		return consu;
	}
	public String getTipoConsulta() {
		return tipoConsulta;
	}

	public void setTipoConsulta(String tipoConsulta) {
		this.tipoConsulta = tipoConsulta;
	}

	public List<Consulta> getListaConsultas() {
		return listaConsultas;
	}

	public void setListaConsultas(List<Consulta> listaConsultas) {
		this.listaConsultas = listaConsultas;
	}

	public List<Consulta> getListaConsultasFiltradas() {
		return listaConsultasFiltradas;
	}

	public void setListaConsultasFiltradas(List<Consulta> listaConsultasFiltradas) {
		this.listaConsultasFiltradas = listaConsultasFiltradas;
	}

	public ConsultaDAO getConsultaDao() {
		return consultaDao;
	}

	public void setConsultaDao(ConsultaDAO consultaDao) {
		this.consultaDao = consultaDao;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public static long getIdConsultaConstante() {
		return idConsultaConstante;
	}

	public static void setIdConsultaConstante(long idConsultaConstante) {
		ConsultaMB.idConsultaConstante = idConsultaConstante;
	}
}
