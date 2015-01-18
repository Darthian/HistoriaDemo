package co.edu.unal.clinica.mb;

import java.sql.Timestamp;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.hibernate.Session;

import co.edu.unal.clinica.daos.OtrosAntecedentesDAO;
import co.edu.unal.clinica.hibernate.data.Otros_Antecedentes;
import co.edu.unal.clinica.utils.HibernateUtil;

@ManagedBean(name="otrosAntecedentesMB")
@SessionScoped
public class OtrosAntecedentesMB {
	
	private long fkConsulta;
	private long cedula;
	private String consolidado;
	private String antecedente;
	private String observaciones;
	private Timestamp fechaCreacion;
	
	private List<Otros_Antecedentes> listaOAnt;
	private OtrosAntecedentesDAO oantDAO = new OtrosAntecedentesDAO();
	private static Otros_Antecedentes oant = new Otros_Antecedentes();
	
	public static long cedulaPaciente;
	
	public void guardarOtrosAntecedentes() {
		try{
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			consolidado = "No";
			Otros_Antecedentes ant = new Otros_Antecedentes(PacienteMB.cedulaConsulta, antecedente, observaciones, consolidado);
			long id = (long) session.save(ant);
			oant.setId(id);
			session.getTransaction().commit();
			session.close();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro ha sido creado correctamente","Puede seguir registrando o volver"));
		}
		catch(Exception ex){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Esto es vergonzoso","Ha ocurrido un error al intentar hacer el registro"));
		}
	}
	
//	public void consolidarOtrosAntecedentes(){
//		try{
//			System.out.println("++++++++++++++++++++++ ENTRA AL METODO DE CONSOLIDAR Otros Antecedentes" );
//			Otros_Antecedentes objetoConsolidado = oantDAO.BuscarPorId(oant.getId());
//			System.out.println("++++++++++++++++++++++ ID de Objeto Recuperado " +objetoConsolidado.getId());
//			objetoConsolidado.setConsolidado("Si");
//			oantDAO.ConsolidarConsulta(objetoConsolidado);
//			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro ha sido consolidado correctamente","Puede seguir registrando o volver"));
//		}catch(Exception ex){
//			System.out.println(ex);
//			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Esto es vergonzoso","Ha ocurrido un error al intentar hacer la consolidacion"));
//		}
//	}
	
	public void consolidarOtrosAntecedentes(long idConsulta){
		try{
			System.out.println("++++++++++++++++++++++ ENTRA AL METODO DE CONSOLIDAR Otros Antecedentes" );
			List<Otros_Antecedentes> listobjetoConsolidado = oantDAO.BuscarNoConsolidados();
			if(listobjetoConsolidado!= null && listobjetoConsolidado.size() > 0){
				for(Otros_Antecedentes iterator : listobjetoConsolidado){
					System.out.println("++++++++++++++++++++++ ID de Objeto Recuperado " +iterator.getId());
					iterator.setConsolidado("Si");
					iterator.setFkConsulta(idConsulta);
				}
				oantDAO.ConsolidarConsulta(listobjetoConsolidado);
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
		oantDAO.Modificar(oant);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro ha sido modificado correctamente","Puede seguir modificando o volver"));
		}catch(Exception ex){
			System.out.println(ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Esto es vergonzoso","Ha ocurrido un error al intentar modificar la informacion"));
		}
		return "adminOtrosAntecedentes";
	}
	
	public void listar() throws Exception {
		cedulaPaciente = PacienteMB.cedulaConsulta;
		System.out.println("Cedula de la historia:"+PacienteMB.cedulaConsulta);
		this.listaOAnt = oantDAO.Buscar(PacienteMB.cedulaConsulta);
	}
	
	public String leer(Otros_Antecedentes emp) {
		oant = emp;
		return "editarOtrosAntecedentes";
	}
	
	public long getCedula() {
		return cedula;
	}
	public void setCedula(long cedula) {
		this.cedula = cedula;
	}
	public String getAntecedente() {
		return antecedente;
	}
	public void setAntecedente(String antecedente) {
		this.antecedente = antecedente;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public Timestamp getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Timestamp fecha_Creacion) {
		this.fechaCreacion = fecha_Creacion;
	}
	
	public List<Otros_Antecedentes> getListaOAnt() {
		return listaOAnt;
	}
	public void setListaOAnt(List<Otros_Antecedentes> listaOAnt) {
		this.listaOAnt = listaOAnt;
	}
	public OtrosAntecedentesDAO getOantDAO() {
		return oantDAO;
	}
	public void setOantDAO(OtrosAntecedentesDAO oantDAO) {
		this.oantDAO = oantDAO;
	}
	public Otros_Antecedentes getOant() {
		return oant;
	}
	public static long getCedulaPaciente() {
		return cedulaPaciente;
	}
	public static void setCedulaPaciente(long cedulaPaciente) {
		OtrosAntecedentesMB.cedulaPaciente = cedulaPaciente;
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
