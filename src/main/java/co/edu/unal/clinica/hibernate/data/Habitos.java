package co.edu.unal.clinica.hibernate.data;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Habitos {
	
	@GeneratedValue
	@Id
	private long id;
	private long cedula;
	private String fumador;
	private String exfumador;
	private String consumidor_alcohol;
	private String ejercicio;
	private Timestamp fecha_creacion;
	
	public Habitos(){
		
	}
	
	public Habitos(long cedula, String fumador, String exfumador, String consumidor_alcohol, String ejercicio){
		this.cedula = cedula;
		this.fumador = fumador;
		this.exfumador = exfumador;
		this.consumidor_alcohol = consumidor_alcohol;
		this.ejercicio = ejercicio;
		this.fecha_creacion = new Timestamp(System.currentTimeMillis());		
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

	public String getFumador() {
		return fumador;
	}

	public void setFumador(String fumador) {
		this.fumador = fumador;
	}

	public String getExfumador() {
		return exfumador;
	}

	public void setExfumador(String exfumador) {
		this.exfumador = exfumador;
	}

	public String getConsumidorAlcohol() {
		return consumidor_alcohol;
	}

	public void setConsumidorAlcohol(String consumidor_alcohol) {
		this.consumidor_alcohol = consumidor_alcohol;
	}

	public String getEjercicio() {
		return ejercicio;
	}

	public void setEjercicio(String ejercicio) {
		this.ejercicio = ejercicio;
	}

	public Timestamp getFechaCreacion() {
		return fecha_creacion;
	}

	public void setFechaCreacion(Timestamp fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}
}
