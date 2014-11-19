package co.edu.unal.clinica.hibernate.data;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Enfermedad_Actual {
	
	@GeneratedValue
	@Id
	private long id;
	private long cedula;
	private String consolidado;
	@Column(name = "enfermedad_Actual", nullable = true)
	private String enfermedad_Actual;
	private Timestamp fecha_Creacion;
	
	public Enfermedad_Actual(){
		
	}
	
	public Enfermedad_Actual(long cedula, String enfermedad_Actual, String consolidado){
		this.cedula = cedula;
		this.consolidado = consolidado;
		this.enfermedad_Actual = enfermedad_Actual;
		this.fecha_Creacion = new Timestamp(System.currentTimeMillis());
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getCedula() {
		return cedula;
	}

	public void setCedula(long cedula) {
		this.cedula = cedula;
	}

	public String getEnfermedadActual() {
		return enfermedad_Actual;
	}

	public void setEnfermedadActual(String enfermedad_Actual) {
		this.enfermedad_Actual = enfermedad_Actual;
	}

	public Timestamp getFechaCreacion() {
		return fecha_Creacion;
	}

	public void setFechaCreacion(Timestamp fecha_Creacion) {
		this.fecha_Creacion = fecha_Creacion;
	}

	public String getConsolidado() {
		return consolidado;
	}

	public void setConsolidado(String consolidado) {
		this.consolidado = consolidado;
	}
}
