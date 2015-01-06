package co.edu.unal.clinica.hibernate.data;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Antecedentes_Transfusionales {
	
	@GeneratedValue
	@Id
	private long id;
	private long fk_consulta;
	private long cedula;
	private String consolidado;
	private String antecedente;
	private Timestamp fecha_Creacion;
	
	public Antecedentes_Transfusionales(){
		
	}
	
	public Antecedentes_Transfusionales(long cedula, String consolidado, String antecedente){
		this.cedula = cedula;
		this.consolidado = consolidado;
		this.antecedente = antecedente;
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
	public String getConsolidado() {
		return consolidado;
	}
	public void setConsolidado(String consolidado) {
		this.consolidado = consolidado;
	}
	public String getAntecedente() {
		return antecedente;
	}
	public void setAntecedente(String antecedente) {
		this.antecedente = antecedente;
	}
	public Timestamp getFechaCreacion() {
		return fecha_Creacion;
	}
	public void setFechaCreacion(Timestamp fecha_Creacion) {
		this.fecha_Creacion = fecha_Creacion;
	}

	public long getFkConsulta() {
		return fk_consulta;
	}

	public void setFkConsulta(long fk_consulta) {
		this.fk_consulta = fk_consulta;
	}

}