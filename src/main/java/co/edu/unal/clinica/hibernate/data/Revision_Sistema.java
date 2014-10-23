package co.edu.unal.clinica.hibernate.data;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Revision_Sistema {

	@GeneratedValue
	@Id
	private long id;
	private long cedula;
	private String estado_general;
	private String cardio_vascular;
	private String respiratorio;
	private String gastrointestinal;
	private String musculo_esqueletico;
	private Timestamp fecha_creacion;

	public Revision_Sistema() {

	}

	public Revision_Sistema(long cedula, String estado_general, String cardio_vascular, String respiratorio, String gastrointestinal, String musculo_esqueletico) {
		this.cedula = cedula;
		this.estado_general = estado_general;
		this.cardio_vascular = cardio_vascular;
		this.respiratorio = respiratorio;
		this.gastrointestinal = gastrointestinal;
		this.musculo_esqueletico = musculo_esqueletico;
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

	public String getEstadoGeneral() {
		return estado_general;
	}

	public void setEstadoGeneral(String estado_general) {
		this.estado_general = estado_general;
	}

	public String getCardioVascular() {
		return cardio_vascular;
	}

	public void setCardioVascular(String cardio_vascular) {
		this.cardio_vascular = cardio_vascular;
	}

	public String getRespiratorio() {
		return respiratorio;
	}

	public void setRespiratorio(String respiratorio) {
		this.respiratorio = respiratorio;
	}

	public String getGastrointestinal() {
		return gastrointestinal;
	}

	public void setGastrointestinal(String gastrointestinal) {
		this.gastrointestinal = gastrointestinal;
	}

	public String getMusculoEsqueletico() {
		return musculo_esqueletico;
	}

	public void setMusculoEsqueletico(String musculo_esqueletico) {
		this.musculo_esqueletico = musculo_esqueletico;
	}

	public Timestamp getFechaCreacion() {
		return fecha_creacion;
	}

	public void setFechaCreacion(Timestamp fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

}
