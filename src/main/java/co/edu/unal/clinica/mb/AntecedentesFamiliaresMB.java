package co.edu.unal.clinica.mb;

import java.sql.Timestamp;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.hibernate.Session;

import co.edu.unal.clinica.daos.AntecedentesFamiliaresDAO;
import co.edu.unal.clinica.hibernate.data.Antecedentes_Familiares;
import co.edu.unal.clinica.utils.HibernateUtil;

@ManagedBean(name="antecedentesFamiliaresMB")
@SessionScoped
public class AntecedentesFamiliaresMB {
	
	private long cedula;
	private String historiaFamiliarDiabetes;
	private String historiaFamiliarInfarto;
	private String historiaFamiliarDislipidemia;
	private String otros;
	private Timestamp fechaCreacion;
	
	private List<Antecedentes_Familiares> listaAnt;
	private AntecedentesFamiliaresDAO antDAO = new AntecedentesFamiliaresDAO();
	private Antecedentes_Familiares ant = new Antecedentes_Familiares();

	public static long cedulaPaciente;
	
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
	public void setAnt(Antecedentes_Familiares ant) {
		this.ant = ant;
	}
	
	public void guardarAntecedenteFamiliar() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Antecedentes_Familiares ant = new Antecedentes_Familiares(PacienteMB.cedulaConsulta, historiaFamiliarDiabetes, historiaFamiliarInfarto,historiaFamiliarDislipidemia, otros);
		session.save(ant);
		session.getTransaction().commit();
		session.close();
	}	
	
	public void listar() throws Exception {
		cedulaPaciente = PacienteMB.cedulaConsulta;
		System.out.println("Cedula de la historia:"+PacienteMB.cedulaConsulta);
		this.listaAnt = antDAO.Buscar(PacienteMB.cedulaConsulta);
	}
	
//	public String leer(Antecedentes_Familiares emp) {
//		this.ant = emp;
//		return "editarPacientes";
//	}

}
