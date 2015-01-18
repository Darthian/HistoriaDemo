package co.edu.unal.clinica.hibernate.data;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Consulta {
	
	@GeneratedValue
	@Id
	private long id;
	private long cedula;
	private String tipo_consulta;
	private Timestamp fecha_Creacion;
	
	public Consulta(){}
	
	public Consulta(long cedula){
		this.cedula = cedula;
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
	public Timestamp getFechaCreacion() {
		return fecha_Creacion;
	}
	public void setFechaCreacion(Timestamp fecha_Creacion) {
		this.fecha_Creacion = fecha_Creacion;
	}

	public String getTipoConsulta() {
		return tipo_consulta;
	}

	public void setTipoConsulta(String tipo_consulta) {
		this.tipo_consulta = tipo_consulta;
	}

}
