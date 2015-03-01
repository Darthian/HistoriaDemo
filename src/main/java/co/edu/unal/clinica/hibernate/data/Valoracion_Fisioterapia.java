package co.edu.unal.clinica.hibernate.data;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Valoracion_Fisioterapia {
	
	@GeneratedValue
	@Id
	private long id;
	private long fk_consulta;
	private long cedula;
	private String consolidado;
	private Timestamp fecha_Creacion;
	private String valoracion;
	private String observaciones;
	
	public Valoracion_Fisioterapia(){
		
	}
	
	public Valoracion_Fisioterapia(long fk_consulta, long cedula, String consolidado, String valoracion, String observaciones) {
		this.fk_consulta = fk_consulta;
		this.cedula = cedula;
		this.consolidado = consolidado;
		this.fecha_Creacion = new Timestamp(System.currentTimeMillis());
		this.valoracion = valoracion;
		this.observaciones = observaciones;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getFkConsulta() {
		return fk_consulta;
	}

	public void setFkConsulta(long fk_consulta) {
		this.fk_consulta = fk_consulta;
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

	public Timestamp getFechaCreacion() {
		return fecha_Creacion;
	}

	public void setFechaCreacion(Timestamp fecha_Creacion) {
		this.fecha_Creacion = fecha_Creacion;
	}

	public String getValoracion() {
		return valoracion;
	}

	public void setValoracion(String valoracion) {
		this.valoracion = valoracion;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
}
