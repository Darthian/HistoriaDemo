package co.edu.unal.clinica.mb;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

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
	private String mostrarBotonDescarga = "No";
	
	private String tablaFiltro;
	private String campoFiltro;
	private String valorFiltro;

	private List<Paciente> listaPaciente;
	private List<Paciente> listaPacienteSoloConsulta;
	private List<Paciente> listaPacienteHistoriaDetalle;
	private List<Paciente> listaPacienteFiltrado;
	
	private PacienteDAO pacienteDAO = new PacienteDAO();
	private Paciente paciente = new Paciente();
	
	private long cedulaBuscadaConsulta;
	
	public static long cedulaConsulta;
	public long idConsulta;
	public static Paciente pacienteHistoriaClinica;
	private static String consultaActiva;
	private static String tipoConsulta;
	
	@Inject
	private AntecedentesFamiliaresMB antecedentesFamiliares;
	@Inject
	private AntecedentesFarmacologicosMB antecedentesFarmacologicos;
	@Inject
	private AntecedentesPatologicosMB antecedentesPatologicos;
	@Inject
	private DiagnosticosMB diagnosticos;
	@Inject
	private EnfermedadActualMB enfermedadActual;
	@Inject
	private ExamenFisicoMB examenFisico;
	@Inject
	private HabitosMB habitos;
	@Inject
	private MotivoConsultaMB motivo;
	@Inject
	private OtrosAntecedentesMB otrosAntecedentes;
	@Inject
	private ParaclinicosMB paraclinicos;
	@Inject
	private RevisionSistemaMB revisionSistema;
	@Inject
	private AntecedentesAlergicosMB antecedentesAlergicos;
	@Inject
	private AntecedentesGinecobstetricosMB antecedentesGinecobstetricos;
	@Inject
	private AntecedentesQuirurgicosMB antecedentesQuirurgicos;
	@Inject
	private AntecedentesSocialesMB antecedentesSociales;
	@Inject
	private AntecedentesTransfusionalesMB antecedentesTransfusionales;
	@Inject
	private AntecedentesTraumatologicosMB antecedentesTraumatologicos;
	@Inject
	private ConsultaMB consulta;
	@Inject
	private ValoracionNutricionalMB valoracionNutricional;
	@Inject
	private ValoracionFisioterapiaMB valoracionFisioterapia;
	

	public void guardarPaciente() {
		try{
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			System.out.println("+++++++++++++++++++++++++++++Fecha de nacimiento Capturada:" + fecha_Nacimiento);
			Paciente paciente = new Paciente(nombre_Paciente, edad, new Timestamp(fecha_Nacimiento.getTime()), cedula, procedencia, genero, eps, estado_Financiero, ocupacion, estado_Civil, escolaridad, telefono);
			session.save(paciente);
			session.getTransaction().commit();
			session.close();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro ha sido creado correctamente","Puede seguir registrando o volver"));
		}catch(Exception ex){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Esto es vergonzoso","Ha ocurrido un error al intentar hacer el registro"));
		}
	}
	
	public void consolidarConsultaGeneral(){
		if(motivo.getMot().getId() != 0 && consulta.getConsu().getId() != 0){
			System.out.println("ID MOTIVO CONSULTA: "+motivo.getMot().getId());
			motivo.consolidarMotivoConsulta(consulta.getConsu().getId());
			idConsulta = consulta.getConsu().getId();
		}
		if(motivo.getMot().getId() != 0 && consulta.getConsu().getId() != 0){
			System.out.println("ID MOTIVO CONSULTA: "+motivo.getMot().getId());
			motivo.consolidarMotivoConsulta(consulta.getConsu().getId());
			idConsulta = consulta.getConsu().getId();
		}
		if(antecedentesFamiliares.getAnt().getId() != 0 && consulta.getConsu().getId() != 0){
			System.out.println("ID ANTECEDENTES FAMILIARES: "+antecedentesFamiliares.getAnt().getId());
			antecedentesFamiliares.consolidarAntecedenteFamiliar(consulta.getConsu().getId());
			idConsulta = consulta.getConsu().getId();
		}
		if(antecedentesFarmacologicos.getFarma().getId() != 0 && consulta.getConsu().getId() != 0){
			System.out.println("ID ANTECEDENTES farmacologicos: "+antecedentesFarmacologicos.getFarma().getId());
			antecedentesFarmacologicos.consolidarAntecedenteFarmacologico(consulta.getConsu().getId());
			idConsulta = consulta.getConsu().getId();
		}
		if(antecedentesPatologicos.getPato().getId() != 0 && consulta.getConsu().getId() != 0){
			System.out.println("ID ANTECEDENTES patologicos: "+antecedentesPatologicos.getPato().getId());
			antecedentesPatologicos.consolidarAntecedentePatologico(consulta.getConsu().getId());
			idConsulta = consulta.getConsu().getId();
		}
		if(diagnosticos.getDiag().getId() != 0 && consulta.getConsu().getId() != 0){
			System.out.println("ID Diagnosticos: "+diagnosticos.getDiag().getId());
			diagnosticos.consolidarDiagnostico(consulta.getConsu().getId());
			idConsulta = consulta.getConsu().getId();
		}
		if(enfermedadActual.getEnf().getId() != 0 && consulta.getConsu().getId() != 0){
			System.out.println("ID Enfermedad Actual: "+enfermedadActual.getEnf().getId());
			enfermedadActual.consolidarEnfermedadActual(consulta.getConsu().getId());
			idConsulta = consulta.getConsu().getId();
		}
		if(examenFisico.getExam().getId() != 0 && consulta.getConsu().getId() != 0){
			System.out.println("ID Examen Fisico: "+examenFisico.getExam().getId());
			examenFisico.consolidarExamenFisico(consulta.getConsu().getId());
			idConsulta = consulta.getConsu().getId();
		}
		if(habitos.getHab().getId() != 0 && consulta.getConsu().getId() != 0){
			System.out.println("ID Habitos: "+habitos.getHab().getId());
			habitos.consolidarHabitos(consulta.getConsu().getId());
			idConsulta = consulta.getConsu().getId();
		}
		if(otrosAntecedentes.getOant().getId() != 0 && consulta.getConsu().getId() != 0){
			System.out.println("ID Otros Antecedentes: "+otrosAntecedentes.getOant().getId());
			otrosAntecedentes.consolidarOtrosAntecedentes(consulta.getConsu().getId());
			idConsulta = consulta.getConsu().getId();
		}
		if(paraclinicos.getPara().getId() != 0 && consulta.getConsu().getId() != 0){
			System.out.println("ID Paraclinicos: "+paraclinicos.getPara().getId());
			paraclinicos.consolidarParaClinicos(consulta.getConsu().getId());
			idConsulta = consulta.getConsu().getId();
		}
		if(revisionSistema.getRevi().getId() != 0 && consulta.getConsu().getId() != 0){
			System.out.println("ID Revision Sistema: "+revisionSistema.getRevi().getId());
			revisionSistema.consolidarRevision(consulta.getConsu().getId());
			idConsulta = consulta.getConsu().getId();
		}
		if(antecedentesAlergicos.getAnt().getId() != 0 && consulta.getConsu().getId() != 0){
			System.out.println("ID Antecedente Alergico: "+antecedentesAlergicos.getAnt().getId());
			antecedentesAlergicos.consolidarAntecedenteAlergico(consulta.getConsu().getId());
			idConsulta = consulta.getConsu().getId();
		}
		if(antecedentesGinecobstetricos.getAnt().getId() != 0 && consulta.getConsu().getId() != 0){
			System.out.println("ID Antecedente Gineco: "+antecedentesGinecobstetricos.getAnt().getId());
			antecedentesGinecobstetricos.consolidarAntecedenteGinecobstetrico(consulta.getConsu().getId());
			idConsulta = consulta.getConsu().getId();
		}
		if(antecedentesQuirurgicos.getAnt().getId() != 0 && consulta.getConsu().getId() != 0){
			System.out.println("ID Antecedente Quiru: "+antecedentesQuirurgicos.getAnt().getId());
			antecedentesQuirurgicos.consolidarAntecedenteQuirurgico(consulta.getConsu().getId());
			idConsulta = consulta.getConsu().getId();
		}
		if(antecedentesSociales.getAnt().getId() != 0 && consulta.getConsu().getId() != 0){
			System.out.println("ID Antecedente Sociales: "+antecedentesSociales.getAnt().getId());
			antecedentesSociales.consolidarAntecedenteSocial(consulta.getConsu().getId());
			idConsulta = consulta.getConsu().getId();
		}
		if(antecedentesTransfusionales.getAnt().getId() != 0 && consulta.getConsu().getId() != 0){
			System.out.println("ID Antecedente Trans: "+antecedentesTransfusionales.getAnt().getId());
			antecedentesTransfusionales.consolidarAntecedenteTransfusional(consulta.getConsu().getId());
			idConsulta = consulta.getConsu().getId();
		}
		if(antecedentesTraumatologicos.getAnt().getId() != 0 && consulta.getConsu().getId() != 0){
			System.out.println("ID Antecedente Trau: "+antecedentesTraumatologicos.getAnt().getId());
			antecedentesTraumatologicos.consolidarAntecedenteTraumatologico(consulta.getConsu().getId());
			idConsulta = consulta.getConsu().getId();
		}
		if(valoracionNutricional.getVal().getId() != 0 && consulta.getConsu().getId() != 0){
			System.out.println("ID Antecedente Trau: "+valoracionNutricional.getVal().getId());
			valoracionNutricional.consolidarValoracionNutricional(consulta.getConsu().getId());
			idConsulta = consulta.getConsu().getId();
		}
		if(valoracionFisioterapia.getVal().getId() != 0 && consulta.getConsu().getId() != 0){
			System.out.println("ID Antecedente Trau: "+valoracionFisioterapia.getVal().getId());
			valoracionFisioterapia.consolidarValoracionFisioterapia(consulta.getConsu().getId());
			idConsulta = consulta.getConsu().getId();
		}
	}

	public void guardarDefinitivamente(String tipoConsultaNueva){
		if(cedulaBuscadaConsulta != 0){
			consulta.guardarConsulta(tipoConsultaNueva);
			consolidarConsultaGeneral();
			mostrarBotonDescarga = "Si";
			System.out.println("++++++++++" + mostrarBotonDescarga);
		}
	}
	
	public void eliminar(Paciente emp) throws Exception {
		pacienteDAO.Eliminar(emp);
		this.listar();
	}
	
	public void buscarPacientesFiltro(){
		try{
			this.listaPaciente = pacienteDAO.BuscarPorFiltro(tablaFiltro, campoFiltro, valorFiltro);
			if(this.listaPaciente != null && this.listaPaciente.size() > 0){
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Se ha efectuado la busqueda","Puede ver los resultados a continuacion"));
			}else{
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "La busqueda no genero resultados","Revise los parametros de la busqueda"));
			}
		}catch(Exception ex){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Esto es vergonzoso","Ha ocurrido un error al intentar hacer la busqueda"));
		}
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
	
	public void buscarPacienteEvolucion() throws Exception {
		System.out.println("+++++++++++++++++++++++++++++CEDULA PACIENTE CONSULTA: " + cedulaBuscadaConsulta);
		this.listaPacienteSoloConsulta = pacienteDAO.BuscarPaciente(cedulaBuscadaConsulta);
		consultaActiva = "ACTIVA";
		tipoConsulta = "EVOLUCION";
		cedulaConsulta=cedulaBuscadaConsulta;
	}
	
	public void buscarPacientePrimera() throws Exception {
		System.out.println("+++++++++++++++++++++++++++++CEDULA PACIENTE CONSULTA: " + cedulaBuscadaConsulta);
		this.listaPacienteSoloConsulta = pacienteDAO.BuscarPaciente(cedulaBuscadaConsulta);
		consultaActiva = "ACTIVA";
		tipoConsulta = "PRIMERA";
		cedulaConsulta=cedulaBuscadaConsulta;
	}
	
	public void buscarPacienteHistoriaDetalle() throws Exception {
		System.out.println("+++++++++++++++++++++++++++++CEDULA PACIENTE CONSULTA: " + cedulaConsulta);
		this.listaPacienteHistoriaDetalle = pacienteDAO.BuscarPaciente(cedulaConsulta);
	}
	
	public String terminarConsulta(String tipoConsultaNueva) {
		//consulta.guardarConsulta(tipoConsultaNueva);
		//consolidarConsultaGeneral();
		consultaActiva = "INACTIVA";
		cedulaBuscadaConsulta = 0;
		cedulaConsulta = 0;
		this.listaPacienteSoloConsulta = null;
		mostrarBotonDescarga = "No";
		System.out.println("+++++++++++++++++++++++++++++CEDULA PACIENTE CONSULTA AL TERMINAR: " + cedulaBuscadaConsulta);
		return "index";
	}
	
	public String leerHistoriaClinica(Paciente pac){
		pacienteHistoriaClinica = pac;
		cedulaConsulta = pac.getCedula();
		this.paciente = pac;
		System.out.println("+++++++++++++++++++CEDULA CAPTURADA: " + pacienteHistoriaClinica.getCedula());
		return "adminHistoriaClinica";
	}
	
	public String leerAntecedentesFamiliares(Paciente pac) throws Exception{
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
	
	public String leerAntecedentesAlergicos(Paciente pac){
		cedulaConsulta = pac.getCedula();
		this.paciente = pac;
		System.out.println("+++++++++++++++++++CEDULA CAPTURADA: " + cedulaConsulta);
		return "adminAntecedentesAlergicos";
	}
	public String leerAntecedentesGinecobstetricos(Paciente pac){
		cedulaConsulta = pac.getCedula();
		this.paciente = pac;
		System.out.println("+++++++++++++++++++CEDULA CAPTURADA: " + cedulaConsulta);
		return "adminAntecedentesGinecobstetricos";
	}
	public String leerAntecedentesQuirurgicos(Paciente pac){
		cedulaConsulta = pac.getCedula();
		this.paciente = pac;
		System.out.println("+++++++++++++++++++CEDULA CAPTURADA: " + cedulaConsulta);
		return "adminAntecedentesQuirurgicos";
	}
	public String leerAntecedentesTraumatologicos(Paciente pac){
		cedulaConsulta = pac.getCedula();
		this.paciente = pac;
		System.out.println("+++++++++++++++++++CEDULA CAPTURADA: " + cedulaConsulta);
		return "adminAntecedentesTraumatologicos";
	}
	public String leerAntecedentesTransfusionales(Paciente pac){
		cedulaConsulta = pac.getCedula();
		this.paciente = pac;
		System.out.println("+++++++++++++++++++CEDULA CAPTURADA: " + cedulaConsulta);
		return "adminAntecedentesTransfusionales";
	}
	public String leerAntecedentesSociales(Paciente pac){
		cedulaConsulta = pac.getCedula();
		this.paciente = pac;
		System.out.println("+++++++++++++++++++CEDULA CAPTURADA: " + cedulaConsulta);
		return "adminAntecedentesSociales";
	}
	
	public String leerAntecedentesClinicos(Paciente pac){
		cedulaConsulta = pac.getCedula();
		this.paciente = pac;
		System.out.println("+++++++++++++++++++CEDULA CAPTURADA ANTECEDENTES CLINICOS: " + cedulaConsulta);
		return "adminAntecedentesClinicos";
	}
	
	public String leerDiagnosticos(Paciente pac){
		cedulaConsulta = pac.getCedula();
		this.paciente = pac;
		System.out.println("+++++++++++++++++++CEDULA CAPTURADA: " + cedulaConsulta);
		return "adminDiagnosticos";
	}
	
	public String leerExamenFisico(Paciente pac){
		cedulaConsulta = pac.getCedula();
		this.paciente = pac;
		System.out.println("+++++++++++++++++++CEDULA CAPTURADA EXAMEN FISICO: " + cedulaConsulta);
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
	
	public String leerValoracionNutricional(Paciente pac){
		cedulaConsulta = pac.getCedula();
		this.paciente = pac;
		System.out.println("+++++++++++++++++++CEDULA CAPTURADA: " + cedulaConsulta);
		return "adminValoracionNutricional";
	}
	
	public String leerValoracionFisioterapia(Paciente pac){
		cedulaConsulta = pac.getCedula();
		this.paciente = pac;
		System.out.println("+++++++++++++++++++FISIOTERAPIA CEDULA CAPTURADA: " + cedulaConsulta);
		return "adminValoracionFisioterapia";
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
	
	public String leerOtrosAntecedentes(Paciente pac){
		cedulaConsulta = pac.getCedula();
		this.paciente = pac;
		System.out.println("+++++++++++++++++++CEDULA CAPTURADA: " + cedulaConsulta);
		return "adminOtrosAntecedentes";
	}
	
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

	public static long getCedulaConsulta() {
		return cedulaConsulta;
	}

	public static void setCedulaConsulta(long cedulaConsulta) {
		PacienteMB.cedulaConsulta = cedulaConsulta;
	}
	
	public long getIdConsulta() {
		return idConsulta;
	}

	public void setIdConsulta(long id) {
		this.idConsulta = id;
	}
	
	public static Paciente getPacienteHistoriaClinica(){
		return pacienteHistoriaClinica;
	}
	public static void setPacienteHistoriaClinica(Paciente pac){
		PacienteMB.pacienteHistoriaClinica = pac;
	}
	
	public long getCedulaBuscadaConsulta() {
		return cedulaBuscadaConsulta;
	}

	public void setCedulaBuscadaConsulta(long cedulaBuscadaConsulta) {
		this.cedulaBuscadaConsulta = cedulaBuscadaConsulta;
	}
	
	public List<Paciente> getListaPacienteSoloConsulta() {
		return listaPacienteSoloConsulta;
	}
	
	public void setListaPacienteSoloConsulta(
			List<Paciente> listaPacienteSoloConsulta) {
		this.listaPacienteSoloConsulta = listaPacienteSoloConsulta;
	}

	public String getMostrarBotonDescarga() {
		return mostrarBotonDescarga;
	}

	public void setMostrarBotonDescarga(String mostrarBotonDescarga) {
		this.mostrarBotonDescarga = mostrarBotonDescarga;
	}

	public List<Paciente> getListaPacienteHistoriaDetalle() {
		return listaPacienteHistoriaDetalle;
	}

	public void setListaPacienteHistoriaDetalle(
			List<Paciente> listaPacienteHistoriaDetalle) {
		this.listaPacienteHistoriaDetalle = listaPacienteHistoriaDetalle;
	}

	public String getConsultaActiva() {
		return consultaActiva;
	}

	public void setConsultaActiva(String consultaActiva) {
		PacienteMB.consultaActiva = consultaActiva;
	}
	
	public String getTipoConsulta() {
		return tipoConsulta;
	}

	public void setTipoConsulta(String tipoConsulta) {
		PacienteMB.tipoConsulta = tipoConsulta;
	}

	public String getTablaFiltro() {
		return tablaFiltro;
	}

	public void setTablaFiltro(String tablaFiltro) {
		this.tablaFiltro = tablaFiltro;
	}

	public String getCampoFiltro() {
		return campoFiltro;
	}

	public void setCampoFiltro(String campoFiltro) {
		this.campoFiltro = campoFiltro;
	}

	public String getValorFiltro() {
		return valorFiltro;
	}

	public void setValorFiltro(String valorFiltro) {
		this.valorFiltro = valorFiltro;
	}
}
