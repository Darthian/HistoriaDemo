package co.edu.unal.clinica.mb;

import java.sql.Timestamp;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.hibernate.Session;

import co.edu.unal.clinica.daos.AntecedentesFamiliaresDAO;
import co.edu.unal.clinica.hibernate.data.Antecedentes_Familiares;
import co.edu.unal.clinica.utils.HibernateUtil;

@ManagedBean(name="antecedentesFamiliaresMB")
@SessionScoped
public class AntecedentesFamiliaresMB {
	
	private long cedula;
	private String consolidado;
	private String historiaFamiliarDiabetes;
	private String historiaFamiliarInfarto;
	private String historiaFamiliarDislipidemia;
	private String otros;
	private Timestamp fechaCreacion;
	
	private List<Antecedentes_Familiares> listaAnt;
	private AntecedentesFamiliaresDAO antDAO = new AntecedentesFamiliaresDAO();
	private static Antecedentes_Familiares ant = new Antecedentes_Familiares();

	public static long cedulaPaciente;
	
	public void guardarAntecedenteFamiliar() {
		try{
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			consolidado = "No";
			Antecedentes_Familiares antF = new Antecedentes_Familiares(PacienteMB.cedulaConsulta, historiaFamiliarDiabetes, historiaFamiliarInfarto,historiaFamiliarDislipidemia, otros, consolidado);
			long id = (long) session.save(antF);
			ant.setId(id); 
			session.getTransaction().commit();
			session.close();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro ha sido creado correctamente","Puede seguir registrando o volver"));
		}
		catch(Exception ex){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Esto es vergonzoso","Ha ocurrido un error al intentar hacer el registro"));
		}
	}	
	
	public void consolidarConsulta(){
		try{
			System.out.println("++++++++++++++++++++++ ENTRA AL METODO DE CONSOLIDAR ANTECEDENTES FAMILIARES" );
			Antecedentes_Familiares objetoConsolidado = antDAO.BuscarPorId(ant.getId());
			System.out.println("++++++++++++++++++++++ ID de Objeto Recuperado " +objetoConsolidado.getId());
			objetoConsolidado.setConsolidado("Si");
			antDAO.ConsolidarConsulta(objetoConsolidado);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro ha sido consolidado correctamente","Puede seguir registrando o volver"));
		}catch(Exception ex){
			System.out.println(ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Esto es vergonzoso","Ha ocurrido un error al intentar hacer la consolidacion"));
		}
	}
	
	public String modificar() {
		try{
			antDAO.Modificar(ant);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro ha sido modificado correctamente","Puede seguir modificando o volver"));
		}catch(Exception ex){
			System.out.println(ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Esto es vergonzoso","Ha ocurrido un error al intentar modificar la informacion"));
		}
		return "adminAntecedentesFamiliares";
	}
	
	public void listar() throws Exception {
		cedulaPaciente = PacienteMB.cedulaConsulta;
		System.out.println("Cedula de la historia:"+PacienteMB.cedulaConsulta);
		this.listaAnt = antDAO.Buscar(PacienteMB.cedulaConsulta);
	}
	
	public String leer(Antecedentes_Familiares emp) {
		ant = emp;
		return "editarAntecedentesFamiliares";
	}
	
	public long getCedula() {
		return cedula;
	}
	public void setCedula(long cedula) {
		this.cedula = cedula;
	}
	public String getHistoriaFamiliarDiabetes() {
		return historiaFamiliarDiabetes;
	}
	public void setHistoriaFamiliarDiabetes(String historiaFamiliarDiabetes) {
		this.historiaFamiliarDiabetes = historiaFamiliarDiabetes;
	}
	public String getHistoriaFamiliarInfarto() {
		return historiaFamiliarInfarto;
	}
	public void setHistoriaFamiliarInfarto(String historiaFamiliarInfarto) {
		this.historiaFamiliarInfarto = historiaFamiliarInfarto;
	}
	public String getHistoriaFamiliarDislipidemia() {
		return historiaFamiliarDislipidemia;
	}
	public void setHistoriaFamiliarDislipidemia(String historiaFamiliarDislipidemia) {
		this.historiaFamiliarDislipidemia = historiaFamiliarDislipidemia;
	}
	public String getOtros() {
		return otros;
	}
	public void setOtros(String otros) {
		this.otros = otros;
	}
	public Timestamp getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public List<Antecedentes_Familiares> getListaAnt() {
		return listaAnt;
	}
	public void setListaAnt(List<Antecedentes_Familiares> listaAnt) {
		this.listaAnt = listaAnt;
	}
	public AntecedentesFamiliaresDAO getAntDAO() {
		return antDAO;
	}
	public void setAntDAO(AntecedentesFamiliaresDAO antDAO) {
		this.antDAO = antDAO;
	}
	public Antecedentes_Familiares getAnt() {
		return ant;
	}
	public String getConsolidado() {
		return consolidado;
	}
	public void setConsolidado(String consolidado) {
		this.consolidado = consolidado;
	}

}
