package co.edu.unal.clinica.mb;

import java.sql.Timestamp;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.hibernate.Session;

import co.edu.unal.clinica.daos.ValoracionFisioterapiaDAO;
import co.edu.unal.clinica.hibernate.data.Valoracion_Fisioterapia;
import co.edu.unal.clinica.utils.HibernateUtil;

@ManagedBean(name="valoracionFisioterapiaMB")
@SessionScoped
public class ValoracionFisioterapiaMB {
	
	private long fkConsulta;
	private long cedula;
	private String consolidado;
	private Timestamp fecha_Creacion;
	private String valoracion;
	private String observaciones;
	
	private List<Valoracion_Fisioterapia> listaVal;
	private List<Valoracion_Fisioterapia> listaValHC;
	private ValoracionFisioterapiaDAO valDAO = new ValoracionFisioterapiaDAO();
	private static Valoracion_Fisioterapia val = new Valoracion_Fisioterapia();

	public static long cedulaPaciente;
	
	public void guardarValoracionFisioterapia() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try{
			session.beginTransaction();
			consolidado = "No";
			Valoracion_Fisioterapia valN = new Valoracion_Fisioterapia(fkConsulta, PacienteMB.cedulaConsulta, consolidado, valoracion, observaciones);
			long id = (long) session.save(valN);
			val.setId(id); 
			session.getTransaction().commit();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro ha sido creado correctamente","Puede seguir registrando o volver"));
		}
		catch(Exception ex){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Esto es vergonzoso","Ha ocurrido un error al intentar hacer el registro"));
		}
		finally{
			session.close();
		}
	}
	
	public void consolidarValoracionFisioterapia(long idConsulta){
		try{
			System.out.println("++++++++++++++++++++++ ENTRA AL METODO DE CONSOLIDAR VALORACION FISIOTERAPIA" );
			List<Valoracion_Fisioterapia> listobjetoConsolidado = valDAO.BuscarNoConsolidados();
			if(listobjetoConsolidado!= null && listobjetoConsolidado.size() > 0){
				for(Valoracion_Fisioterapia iterator : listobjetoConsolidado){
					System.out.println("++++++++++++++++++++++ ID de Objeto Recuperado " +iterator.getId());
					iterator.setConsolidado("Si");
					iterator.setFkConsulta(idConsulta);
				}
				valDAO.ConsolidarConsulta(listobjetoConsolidado);
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
			valDAO.Modificar(val);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro ha sido modificado correctamente","Puede seguir modificando o volver"));
		}catch(Exception ex){
			System.out.println(ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Esto es vergonzoso","Ha ocurrido un error al intentar modificar la informacion"));
		}
		return "adminValoracionFisioterapia";
	}
	
	public void listar(){
		cedulaPaciente = PacienteMB.cedulaConsulta;
		System.out.println("Cedula de la historia:"+PacienteMB.cedulaConsulta);
		try{
			this.listaVal = valDAO.Buscar(PacienteMB.cedulaConsulta);
		}catch(Exception ex){
			System.out.println(ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Esto es vergonzoso","Ha ocurrido un error al intentar consultar la informacion"));
		}
	}
	
	public void listarHC() throws Exception {
		this.listaValHC = valDAO.BuscarPorConsulta(ConsultaMB.idConsultaConstante);
	}
	
	public String leer(Valoracion_Fisioterapia emp) {
		val = emp;
		return "editarValoracionFisioterapia";
	}

	public long getFkConsulta() {
		return fkConsulta;
	}

	public void setFkConsulta(long fkConsulta) {
		this.fkConsulta = fkConsulta;
	}

	public long getCedula() {
		return cedula;
	}

	public void setCedula(long cedula) {
		this.cedula = cedula;
	}

	public String getConsolidado() {
		return consolidado;
	}

	public void setConsolidado(String consolidado) {
		this.consolidado = consolidado;
	}

	public Timestamp getFechaCreacion() {
		return fecha_Creacion;
	}

	public void setFechaCreacion(Timestamp fecha_Creacion) {
		this.fecha_Creacion = fecha_Creacion;
	}

	public String getValoracion() {
		return valoracion;
	}

	public void setValoracion(String valoracion) {
		this.valoracion = valoracion;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public List<Valoracion_Fisioterapia> getListaVal() {
		return listaVal;
	}

	public void setListaVal(List<Valoracion_Fisioterapia> listaVal) {
		this.listaVal = listaVal;
	}

	public List<Valoracion_Fisioterapia> getListaValHC() {
		return listaValHC;
	}

	public void setListaValHC(List<Valoracion_Fisioterapia> listaValHC) {
		this.listaValHC = listaValHC;
	}

	public ValoracionFisioterapiaDAO getValDAO() {
		return valDAO;
	}

	public void setValDAO(ValoracionFisioterapiaDAO valDAO) {
		this.valDAO = valDAO;
	}

	public Valoracion_Fisioterapia getVal() {
		return val;
	}

	public void setVal(Valoracion_Fisioterapia val) {
		ValoracionFisioterapiaMB.val = val;
	}

	public static long getCedulaPaciente() {
		return cedulaPaciente;
	}

	public static void setCedulaPaciente(long cedulaPaciente) {
		ValoracionFisioterapiaMB.cedulaPaciente = cedulaPaciente;
	}

}
