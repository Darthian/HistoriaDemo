package co.edu.unal.clinica.hibernate.data;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Paciente {

	@GeneratedValue
	@Id
	private long id_Paciente;
	private String nombre_Paciente;
	private int edad;
	private Timestamp fecha_Nacimiento;
	
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
	
	public Paciente(){
		
	}
	
	public Paciente(String nombrePaciente, int edad, Timestamp fecha_Nacimiento, long cedula, String procedencia, String genero, String eps, String estadoFinanciero, String ocupacion, String estadoCivil, String escolaridad,String telefono){
		this.nombre_Paciente = nombrePaciente;
		this.edad = edad;
		this.fecha_Nacimiento = fecha_Nacimiento;
		this.cedula = cedula;
		this.procedencia = procedencia;
		this.genero = genero;
		this.eps = eps;
		this.estado_Financiero = estadoFinanciero;
		this.ocupacion = ocupacion;
		this.estado_Civil = estadoCivil;
		this.escolaridad = escolaridad;
		this.telefono = telefono;	
		this.fecha_creacion = new Timestamp(System.currentTimeMillis());
	}

	public long getId_Paciente() {
		return id_Paciente;
	}

	public void setId_Paciente(long id_Paciente) {
		this.id_Paciente = id_Paciente;
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

	public Timestamp getFecha_Nacimiento() {
		return fecha_Nacimiento;
	}

	public void setFecha_Nacimiento(Timestamp fecha_Nacimiento) {
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
}
