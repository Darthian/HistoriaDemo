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
	private long fk_consulta;
	private long cedula;
	private String consolidado;
	private String fumador;
	private String fumador_texto;
	private String exfumador;
	private String exfumador_texto;
	private String consumidor_alcohol;
	private String alcohol_texto;
	private String ejercicio;
	private String ejercicio_texto;
	private String dificultad_ejercicio;
	private String dificultad_texto;
	private Timestamp fecha_creacion;
	
	public Habitos(){
		
	}
	
	public Habitos(long cedula, String fumador, String exfumador, String consumidor_alcohol, String ejercicio, String fumador_texto, String exfumador_texto,
			String alcohol_texto, String ejercicio_texto, String dificultad_ejercicio, String dificultad_texto, String consolidado){
		this.cedula = cedula;
		this.consolidado = consolidado;
		this.fumador = fumador;
		this.exfumador = exfumador;
		this.consumidor_alcohol = consumidor_alcohol;
		this.ejercicio = ejercicio;
		this.fumador_texto = fumador_texto;
		this.exfumador_texto = exfumador_texto;
		this.alcohol_texto = alcohol_texto;
		this.ejercicio_texto = ejercicio_texto;
		this.dificultad_ejercicio = dificultad_ejercicio;
		this.dificultad_texto = dificultad_texto;
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

	public String getFumadorTexto() {
		return fumador_texto;
	}

	public void setFumadorTexto(String fumador_texto) {
		this.fumador_texto = fumador_texto;
	}

	public String getExfumadorTexto() {
		return exfumador_texto;
	}

	public void setExfumadorTexto(String exfumador_texto) {
		this.exfumador_texto = exfumador_texto;
	}

	public String getAlcoholTexto() {
		return alcohol_texto;
	}

	public void setAlcoholTexto(String alcohol_texto) {
		this.alcohol_texto = alcohol_texto;
	}

	public String getEjercicioTexto() {
		return ejercicio_texto;
	}

	public void setEjercicioTexto(String ejercicio_texto) {
		this.ejercicio_texto = ejercicio_texto;
	}

	public String getDificultadEjercicio() {
		return dificultad_ejercicio;
	}

	public void setDificultadEjercicio(String dificultad_ejercicio) {
		this.dificultad_ejercicio = dificultad_ejercicio;
	}

	public String getDificultadTexto() {
		return dificultad_texto;
	}

	public void setDificultadTexto(String dificultad_texto) {
		this.dificultad_texto = dificultad_texto;
	}

	public String getConsolidado() {
		return consolidado;
	}

	public void setConsolidado(String consolidado) {
		this.consolidado = consolidado;
	}

	public long getFkConsulta() {
		return fk_consulta;
	}

	public void setFkConsulta(long fk_consulta) {
		this.fk_consulta = fk_consulta;
	}
}
