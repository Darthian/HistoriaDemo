package co.edu.unal.clinica.hibernate.data;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Paraclinicos {
	
	@GeneratedValue
	@Id
	private long id;
	private long fk_consulta;
	private long cedula;
	private String consolidado;
	private float glicemia_ayunas;
	private float glicemia_post_prandial;
	private float hemoglobina_glicosilada;
	private float trigliceridos;
	private float hdl;
	private float ldl;
	private float vldl;
	private float creatinina;
	private float bun;
	private String parcial_orina;
	private String otros_paraclinicos;
	private Timestamp fecha_creacion;
	
	public Paraclinicos(){
		
	}
	
	public Paraclinicos(long cedula, float glicemia_ayunas, float glicemia_post_prandial, float hemoglobina_glicosilada, float trigliceridos, float hdl, float ldl, float vldl, 
			float creatinina, float bun, String parcial_orina, String otros_paraclinicos, String consolidado){
		this.cedula = cedula;
		this.consolidado = consolidado;
		this.glicemia_ayunas = glicemia_ayunas;
		this.glicemia_post_prandial = glicemia_post_prandial;
		this.hemoglobina_glicosilada = hemoglobina_glicosilada;
		this.trigliceridos = trigliceridos;
		this.hdl = hdl;
		this.ldl = ldl;
		this.vldl = vldl;
		this.creatinina = creatinina;
		this.bun = bun;
		this.parcial_orina = parcial_orina;
		this.otros_paraclinicos = otros_paraclinicos;
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

	public float getGlicemiaAyunas() {
		return glicemia_ayunas;
	}

	public void setGlicemiaAyunas(float glicemia_ayunas) {
		this.glicemia_ayunas = glicemia_ayunas;
	}

	public float getGlicemiaPostPrandial() {
		return glicemia_post_prandial;
	}

	public void setGlicemiaPostPrandial(float glicemia_post_prandial) {
		this.glicemia_post_prandial = glicemia_post_prandial;
	}

	public float getHemoglobinaGlicosilada() {
		return hemoglobina_glicosilada;
	}

	public void setHemoglobinaGlicosilada(float hemoglobina_glicosilada) {
		this.hemoglobina_glicosilada = hemoglobina_glicosilada;
	}

	public float getTrigliceridos() {
		return trigliceridos;
	}

	public void setTrigliceridos(float trigliceridos) {
		this.trigliceridos = trigliceridos;
	}

	public float getHdl() {
		return hdl;
	}

	public void setHdl(float hdl) {
		this.hdl = hdl;
	}

	public float getLdl() {
		return ldl;
	}

	public void setLdl(float ldl) {
		this.ldl = ldl;
	}

	public float getVldl() {
		return vldl;
	}

	public void setVldl(float vldl) {
		this.vldl = vldl;
	}

	public float getCreatinina() {
		return creatinina;
	}

	public void setCreatinina(float creatinina) {
		this.creatinina = creatinina;
	}

	public float getBun() {
		return bun;
	}

	public void setBun(float bun) {
		this.bun = bun;
	}

	public String getOtrosParaclinicos() {
		return otros_paraclinicos;
	}

	public void setOtrosParaclinicos(String otros_paraclinicos) {
		this.otros_paraclinicos = otros_paraclinicos;
	}

	public Timestamp getFechaCreacion() {
		return fecha_creacion;
	}

	public void setFechaCreacion(Timestamp fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public String getParcialOrina() {
		return parcial_orina;
	}

	public void setParcialOrina(String parcialOrina) {
		this.parcial_orina = parcialOrina;
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
