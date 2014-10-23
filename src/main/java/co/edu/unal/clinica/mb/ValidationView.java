package co.edu.unal.clinica.mb;

import java.sql.Timestamp;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="validationView")
public class ValidationView {
	
	private String text;	
	private int edad;
	private Timestamp fechaNacimiento;
	private long cedula;
	private String procedencia;
	private String genero;
	private String eps;
	private String estadoFinanciero;
	private String ocupacion;
	private String estadoCivil;
	private String escolaridad;
	private String telefono;
	

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Timestamp getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Timestamp fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
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

	public String getEps() {
		return eps;
	}

	public void setEps(String eps) {
		this.eps = eps;
	}

	public String getEstadoFinanciero() {
		return estadoFinanciero;
	}

	public void setEstadoFinanciero(String estado_Financiero) {
		this.estadoFinanciero = estado_Financiero;
	}

	public String getOcupacion() {
		return ocupacion;
	}

	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estado_Civil) {
		this.estadoCivil = estado_Civil;
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
	
	
	

}
