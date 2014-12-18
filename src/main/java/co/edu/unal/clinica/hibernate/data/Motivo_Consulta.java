package co.edu.unal.clinica.hibernate.data;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Motivo_Consulta {
	
	@GeneratedValue
	@Id
	private long id;
	private long fk_consulta;
	private long cedula;
	private String consolidado;
	private String motivo_Consulta;
	private Timestamp fecha_Creacion;
	
	public Motivo_Consulta(){
		
	}
	
	public Motivo_Consulta(long cedula, String motivo_Consulta, String consolidado){
		this.cedula = cedula;
		this.consolidado = consolidado;
		this.motivo_Consulta = motivo_Consulta;
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

	public String getMotivoConsulta() {
		return motivo_Consulta;
	}

	public void setMotivoConsulta(String motivo_Consulta) {
		this.motivo_Consulta = motivo_Consulta;
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

	public long getFkConsulta() {
		return fk_consulta;
	}

	public void setFkConsulta(long fk_consulta) {
		this.fk_consulta = fk_consulta;
	}
}
