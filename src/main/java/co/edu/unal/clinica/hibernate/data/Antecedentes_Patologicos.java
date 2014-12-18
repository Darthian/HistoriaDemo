package co.edu.unal.clinica.hibernate.data;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Antecedentes_Patologicos {
	
	@GeneratedValue
	@Id
	private long id;
	private long fk_consulta;
	private long cedula;
	private String consolidado;
	private String complicaciones_diabetes;
	private String comp_cardiovasculares;
	private String complicacion_cardiovascular;
	private String retinopatia_diabetica;
	private String nefropatia_diabetica;
	private int estado_nefropatia;
	private String hipertension;
	private String dislipidemia;
	private String tipo_dislipidemia;
	private String filtracion_glomerular;
	private String pie_diabetico;
	private String otros;
	private Timestamp fecha_creacion;
	
	public Antecedentes_Patologicos(){
		
	}
	
	public Antecedentes_Patologicos(long cedula, String complicaciones_diabetes, String retinopatia_diabetica, String nefropatia_diabetica, int estado_nefropatia, String hipertension, String dislipidemia, String tipo_dislipidemia, String otros, 
			String comp_cardiovasculares, String complicacion_cardiovascular, String filtracion_glomerular, String pie_diabetico, String consolidado){
		this.cedula = cedula;
		this.consolidado = consolidado;
		this.complicaciones_diabetes = complicaciones_diabetes;
		this.comp_cardiovasculares = comp_cardiovasculares;
		this.complicacion_cardiovascular = complicacion_cardiovascular;
		this.retinopatia_diabetica = retinopatia_diabetica;
		this.nefropatia_diabetica = nefropatia_diabetica;
		this.estado_nefropatia = estado_nefropatia;
		this.hipertension = hipertension;
		this.dislipidemia = dislipidemia;
		this.tipo_dislipidemia = tipo_dislipidemia;
		this.filtracion_glomerular = filtracion_glomerular;
		this.pie_diabetico = pie_diabetico;
		this.otros = otros;
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
	public String getComplicacionesDiabetes() {
		return complicaciones_diabetes;
	}
	public void setComplicacionesDiabetes(String complicaciones_diabetes) {
		this.complicaciones_diabetes = complicaciones_diabetes;
	}
	public String getRetinopatiaDiabetica() {
		return retinopatia_diabetica;
	}
	public void setRetinopatiaDiabetica(String retinopatia_diabetica) {
		this.retinopatia_diabetica = retinopatia_diabetica;
	}
	public String getNefropatiaDiabetica() {
		return nefropatia_diabetica;
	}
	public void setNefropatiaDiabetica(String nefropatia_diabetica) {
		this.nefropatia_diabetica = nefropatia_diabetica;
	}
	public int getEstadoNefropatia() {
		return estado_nefropatia;
	}
	public void setEstadoNefropatia(int estado_nefropatia) {
		this.estado_nefropatia = estado_nefropatia;
	}
	public String getHipertension() {
		return hipertension;
	}
	public void setHipertension(String hipertension) {
		this.hipertension = hipertension;
	}
	public String getDislipidemia() {
		return dislipidemia;
	}
	public void setDislipidemia(String dislipidemia) {
		this.dislipidemia = dislipidemia;
	}
	public String getTipoDislipidemia() {
		return tipo_dislipidemia;
	}
	public void setTipoDislipidemia(String tipo_dislipidemia) {
		this.tipo_dislipidemia = tipo_dislipidemia;
	}
	public String getOtros() {
		return otros;
	}
	public void setOtros(String otros) {
		this.otros = otros;
	}
	public Timestamp getFechaCreacion() {
		return fecha_creacion;
	}
	public void setFechaCreacion(Timestamp fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public String getCompCardiovasculares() {
		return comp_cardiovasculares;
	}

	public void setCompCardiovasculares(String comp_cardiovasculares) {
		this.comp_cardiovasculares = comp_cardiovasculares;
	}

	public String getComplicacionCardiovascular() {
		return complicacion_cardiovascular;
	}

	public void setComplicacionCardiovascular(String complicacion_cardiovascular) {
		this.complicacion_cardiovascular = complicacion_cardiovascular;
	}

	public String getFiltracionGlomerular() {
		return filtracion_glomerular;
	}

	public void setFiltracionGlomerular(String filtracion_glomerular) {
		this.filtracion_glomerular = filtracion_glomerular;
	}

	public String getPieDiabetico() {
		return pie_diabetico;
	}

	public void setPieDiabetico(String pie_diabetico) {
		this.pie_diabetico = pie_diabetico;
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
