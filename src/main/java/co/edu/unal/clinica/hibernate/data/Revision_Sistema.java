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
	private String consolidado;
	private String estado_general;
	private String cardio_vascular;
	private String respiratorio;
	private String gastrointestinal;
	private String musculo_esqueletico;
	private String cabeza;
	private String cuello;
	private String cardiopulmunar;
	private String digestivo;
	private String genitourinario;
	private String extremidades;
	private String psicomotor;
	private String nervioso;
	private String endocrino;
	private Timestamp fecha_creacion;
	
	public Revision_Sistema() {

	}

	public Revision_Sistema(long cedula, String estado_general, String cardio_vascular, String respiratorio, String gastrointestinal, String musculo_esqueletico,
			String cabeza, String cuello, String cardiopulmunar, String digestivo, String genitourinario, String extremidades, 
			String psicomotor, String nervioso, String endocrino, String consolidado) {
		this.cedula = cedula;
		this.consolidado = consolidado;
		this.estado_general = estado_general;
		this.cardio_vascular = cardio_vascular;
		this.respiratorio = respiratorio;
		this.gastrointestinal = gastrointestinal;
		this.musculo_esqueletico = musculo_esqueletico;
		this.cabeza = cabeza;
		this.cuello = cuello;
		this.cardiopulmunar = cardiopulmunar;
		this.digestivo = digestivo;
		this.genitourinario = genitourinario;
		this.extremidades = extremidades;
		this.psicomotor = psicomotor;
		this.nervioso = nervioso;
		this.endocrino =endocrino;
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

	public String getCabeza() {
		return cabeza;
	}

	public void setCabeza(String cabeza) {
		this.cabeza = cabeza;
	}

	public String getCuello() {
		return cuello;
	}

	public void setCuello(String cuello) {
		this.cuello = cuello;
	}

	public String getCardiopulmunar() {
		return cardiopulmunar;
	}

	public void setCardiopulmunar(String cardiopulmunar) {
		this.cardiopulmunar = cardiopulmunar;
	}

	public String getDigestivo() {
		return digestivo;
	}

	public void setDigestivo(String digestivo) {
		this.digestivo = digestivo;
	}

	public String getGenitourinario() {
		return genitourinario;
	}

	public void setGenitourinario(String genitourinario) {
		this.genitourinario = genitourinario;
	}

	public String getExtremidades() {
		return extremidades;
	}

	public void setExtremidades(String extremidades) {
		this.extremidades = extremidades;
	}

	public String getPsicomotor() {
		return psicomotor;
	}

	public void setPsicomotor(String psicomotor) {
		this.psicomotor = psicomotor;
	}

	public String getNervioso() {
		return nervioso;
	}

	public void setNervioso(String nervioso) {
		this.nervioso = nervioso;
	}

	public String getEndocrino() {
		return endocrino;
	}

	public void setEndocrino(String endocrino) {
		this.endocrino = endocrino;
	}

	public String getConsolidado() {
		return consolidado;
	}

	public void setConsolidado(String consolidado) {
		this.consolidado = consolidado;
	}

}
