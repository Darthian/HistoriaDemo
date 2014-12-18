package co.edu.unal.clinica.hibernate.data;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Diagnosticos {
	
	@GeneratedValue
	@Id
	private long id;
	private long fk_consulta;
	private long cedula;
	private String consolidado;
	private String analisis;
	private String diagnostico;
	private String plan;
	private Timestamp fecha_creacion;
	
	public Diagnosticos(){
		
	}
	
	public Diagnosticos(long cedula, String analisis, String diagnostico, String plan, String consolidado){
		this.cedula = cedula;
		this.consolidado = consolidado;
		this.analisis = analisis;
		this.diagnostico = diagnostico;
		this.plan = plan;
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
	public String getAnalisis() {
		return analisis;
	}
	public void setAnalisis(String analisis) {
		this.analisis = analisis;
	}
	public String getDiagnostico() {
		return diagnostico;
	}
	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}
	public String getPlan() {
		return plan;
	}
	public void setPlan(String plan) {
		this.plan = plan;
	}
	public Timestamp getFechaCreacion() {
		return fecha_creacion;
	}
	public void setFechaCreacion(Timestamp fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
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
