package co.edu.unal.clinica.mb;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.hibernate.Session;

import co.edu.unal.clinica.daos.PacienteDAO;
import co.edu.unal.clinica.hibernate.data.Paciente;
import co.edu.unal.clinica.utils.HibernateUtil;


@ManagedBean(name="pacienteMB")
@SessionScoped
public class PacienteMB {

	private String nombre_Paciente;
	private int edad;
	private java.util.Date fecha_Nacimiento;
	private long cedula;
	private String procedencia;
	private String genero;
	private String eps;
	private String estado_Financiero;
	private String ocupacion;
	private String estado_Civil;
	private String escolaridad;
	private String telefono;
	private Timestamp fecha_creacion;

	private List<Paciente> listaPaciente;
	private List<Paciente> listaPacienteFiltrado;
	private PacienteDAO pacienteDAO = new PacienteDAO();
	private Paciente paciente = new Paciente();
	
	public static long cedulaConsulta; 

	public long getCedula() {
		return cedula;
	}

	public void setCedula(long cedula) {
		this.cedula = cedula;
	}

	public String getProcedencia() {
		return procedencia;
	}

	public void setProcedencia(String procedencia) {
		this.procedencia = procedencia;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getEPS() {
		return eps;
	}

	public void setEPS(String ePS) {
		this.eps = ePS;
	}

	public String getOcupacion() {
		return ocupacion;
	}

	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}

	public String getEscolaridad() {
		return escolaridad;
	}

	public void setEscolaridad(String escolaridad) {
		this.escolaridad = escolaridad;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public PacienteDAO getPacienteDAO() {
		return pacienteDAO;
	}

	public void setPacienteDAO(PacienteDAO pacienteDAO) {
		this.pacienteDAO = pacienteDAO;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	public List<Paciente> getListaPaciente() {
		return listaPaciente;
	}

	public void setListaPaciente(List<Paciente> listaPaciente) {
		this.listaPaciente = listaPaciente;
	}

	public String getNombre_Paciente() {
		return nombre_Paciente;
	}

	public void setNombre_Paciente(String nombre_Paciente) {
		this.nombre_Paciente = nombre_Paciente;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public Date getFecha_Nacimiento() {
		return fecha_Nacimiento;
	}

	public void setFecha_Nacimiento(Date fecha_Nacimiento) {
		this.fecha_Nacimiento = fecha_Nacimiento;
	}

	public String getEps() {
		return eps;
	}

	public void setEps(String eps) {
		this.eps = eps;
	}

	public String getEstado_Financiero() {
		return estado_Financiero;
	}

	public void setEstado_Financiero(String estado_Financiero) {
		this.estado_Financiero = estado_Financiero;
	}

	public String getEstado_Civil() {
		return estado_Civil;
	}

	public void setEstado_Civil(String estado_Civil) {
		this.estado_Civil = estado_Civil;
	}

	public Timestamp getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(Timestamp fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}
	
	public List<Paciente> getListaPacienteFiltrado() {
		return listaPacienteFiltrado;
	}

	public void setListaPacienteFiltrado(List<Paciente> listaPacienteFiltrado) {
		this.listaPacienteFiltrado = listaPacienteFiltrado;
	}
	
	public void guardarPaciente() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		System.out.println("+++++++++++++++++++++++++++++Fecha de nacimiento Capturada:" + fecha_Nacimiento);
		Paciente paciente = new Paciente(nombre_Paciente, edad, new Timestamp(fecha_Nacimiento.getTime()), cedula, procedencia, genero, eps, estado_Financiero, ocupacion, estado_Civil, escolaridad, telefono);
		session.save(paciente);
		session.getTransaction().commit();
		session.close();
		
		GrowlView.mensajePacienteRegistrado();
	}

	public void eliminar(Paciente emp) throws Exception {
		pacienteDAO.Eliminar(emp);
		this.listar();
	}

	public String leer(Paciente emp) {
		this.paciente = emp;
		return "editarPacientes";
	}
	
	public String modificar() throws Exception {
		pacienteDAO.Modificar(this.paciente);
		return "adminPacientes";
	}

	public void listar() throws Exception {
		this.listaPaciente = pacienteDAO.Listar();
	}
	
//	public void filtrarLista(long pac) throws Exception {
//		this.listaPacienteFiltrado = pacienteDAO.Filtrar(pac);
//	}
	
	public String leerAntecedentesFamiliares(Paciente pac){
		cedulaConsulta = pac.getCedula();
		this.paciente = pac;
		System.out.println("+++++++++++++++++++CEDULA CAPTURADA: " + cedulaConsulta);
		return "adminAntecedentesFamiliares";
	}
	
	public String leerAntecedentesFarmacologicos(Paciente pac){
		cedulaConsulta = pac.getCedula();
		this.paciente = pac;
		System.out.println("+++++++++++++++++++CEDULA CAPTURADA: " + cedulaConsulta);
		return "adminAntecedentesFarmacologicos";
	}
	
	public String leerAntecedentesPatologicos(Paciente pac){
		cedulaConsulta = pac.getCedula();
		this.paciente = pac;
		System.out.println("+++++++++++++++++++CEDULA CAPTURADA: " + cedulaConsulta);
		return "adminAntecedentesPatologicos";
	}
	
	public String leerDiagnosticos(Paciente pac){
		cedulaConsulta = pac.getCedula();
		this.paciente = pac;
		System.out.println("+++++++++++++++++++CEDULA CAPTURADA: " + cedulaConsulta);
		return "adminDiagnosticos";
	}
	
	public String leerExamenFisco(Paciente pac){
		cedulaConsulta = pac.getCedula();
		this.paciente = pac;
		System.out.println("+++++++++++++++++++CEDULA CAPTURADA: " + cedulaConsulta);
		return "adminExamenFisico";
	}
	
	public String leerHabitos(Paciente pac){
		cedulaConsulta = pac.getCedula();
		this.paciente = pac;
		System.out.println("+++++++++++++++++++CEDULA CAPTURADA: " + cedulaConsulta);
		return "adminHabitos";		
	}
	
	public String leerParaclinicos(Paciente pac){
		cedulaConsulta = pac.getCedula();
		this.paciente = pac;
		System.out.println("+++++++++++++++++++CEDULA CAPTURADA: " + cedulaConsulta);
		return "adminParaclinicos";		
	}
	
	public String leerRevisionSistema(Paciente pac){
		cedulaConsulta = pac.getCedula();
		this.paciente = pac;
		System.out.println("+++++++++++++++++++CEDULA CAPTURADA: " + cedulaConsulta);
		return "adminRevisionSistema";
	}
	
	public String leerMotivoConsulta(Paciente pac){
		cedulaConsulta = pac.getCedula();
		this.paciente = pac;
		System.out.println("+++++++++++++++++++CEDULA CAPTURADA: " + cedulaConsulta);
		return "adminMotivoConsulta";
	}
	
	public String leerEnfermedadActual(Paciente pac){
		cedulaConsulta = pac.getCedula();
		this.paciente = pac;
		System.out.println("+++++++++++++++++++CEDULA CAPTURADA: " + cedulaConsulta);
		return "adminEnfermedadActual";
	}	
}
