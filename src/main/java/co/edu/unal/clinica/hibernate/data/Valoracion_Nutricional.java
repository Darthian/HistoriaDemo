package co.edu.unal.clinica.hibernate.data;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Valoracion_Nutricional {
	
	@GeneratedValue
	@Id
	private long id;
	private long fk_consulta;
	private long cedula;
	private String consolidado;
	private Timestamp fecha_Creacion;
	private float proteina_gr_dia;
	private float proteina_gr_kg;
	private float proteina_vct;
	private float grasa_gr_dia;
	private float grasa_gr_kg;
	private float grasa_vct;
	private float cho_gr_dia;
	private float cho_gr_kg;
	private float cho_vct;
	private float grasa_sat_gr_dia;
	private float grasa_sat_gr_kg;
	private float grasa_sat_vct;
	private float grasa_mono_gr_dia;
	private float grasa_mono_gr_kg;
	private float grasa_mono_vct;
	private float grasa_poli_gr_dia;
	private float grasa_poli_gr_kg;
	private float grasa_poli_vct;
	private String basales;
	private String factor;
	private float cal_kg;
	private float cal_totales;
	private String prescripcion;
	private String metas;
	private String observaciones;
	
	public Valoracion_Nutricional(){
		
	}
	
	public Valoracion_Nutricional(long fk_consulta, long cedula, String consolidado, float proteina_gr_dia, float proteina_gr_kg, float proteina_vct,
			float grasa_gr_dia, float grasa_gr_kg, float grasa_vct, float cho_gr_dia, float cho_gr_kg, float cho_vct, float grasa_sat_gr_dia, float grasa_sat_gr_kg, float grasa_sat_vct,
			float grasa_mono_gr_dia, float grasa_mono_gr_kg, float grasa_mono_vct, float grasa_poli_gr_dia, float grasa_poli_gr_kg, float grasa_poli_vct,
			String basales, String factor, float cal_kg, float cal_totales, String prescripcion, String metas, String observaciones) {
		
		this.fk_consulta = fk_consulta;
		this.cedula = cedula;
		this.consolidado = consolidado;
		this.fecha_Creacion = new Timestamp(System.currentTimeMillis());
		this.proteina_gr_dia = proteina_gr_dia;
		this.proteina_gr_kg = proteina_gr_kg;
		this.proteina_vct = proteina_vct;
		this.grasa_gr_dia = grasa_gr_dia;
		this.grasa_gr_kg = grasa_gr_kg;
		this.grasa_vct = grasa_vct;
		this.cho_gr_dia = cho_gr_dia;
		this.cho_gr_kg = cho_gr_kg;
		this.cho_vct = cho_vct;
		this.grasa_sat_gr_dia = grasa_sat_gr_dia;
		this.grasa_sat_gr_kg = grasa_sat_gr_kg;
		this.grasa_sat_vct = grasa_sat_vct;
		this.grasa_mono_gr_dia = grasa_mono_gr_dia;
		this.grasa_mono_gr_kg = grasa_mono_gr_kg;
		this.grasa_mono_vct = grasa_mono_vct;
		this.grasa_poli_gr_dia = grasa_poli_gr_dia;
		this.grasa_poli_gr_kg = grasa_poli_gr_kg;
		this.grasa_poli_vct = grasa_poli_vct;
		this.basales = basales;
		this.factor = factor;
		this.cal_kg = cal_kg;
		this.cal_totales = cal_totales;
		this.prescripcion = prescripcion;
		this.metas = metas;
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
	public float getProteinaGrDia() {
		return proteina_gr_dia;
	}
	public void setProteinaGrDia(float proteina_gr_dia) {
		this.proteina_gr_dia = proteina_gr_dia;
	}
	public float getProteinaGrKg() {
		return proteina_gr_kg;
	}
	public void setProteinaGrKg(float proteina_gr_kg) {
		this.proteina_gr_kg = proteina_gr_kg;
	}
	public float getProteinaVct() {
		return proteina_vct;
	}
	public void setProteinaVct(float proteina_vct) {
		this.proteina_vct = proteina_vct;
	}
	public float getGrasaGrDia() {
		return grasa_gr_dia;
	}
	public void setGrasaGrDia(float grasa_gr_dia) {
		this.grasa_gr_dia = grasa_gr_dia;
	}
	public float getGrasaGrKg() {
		return grasa_gr_kg;
	}
	public void setGrasaGrKg(float grasa_gr_kg) {
		this.grasa_gr_kg = grasa_gr_kg;
	}
	public float getGrasaVct() {
		return grasa_vct;
	}
	public void setGrasaVct(float grasa_vct) {
		this.grasa_vct = grasa_vct;
	}
	public float getChoGrDia() {
		return cho_gr_dia;
	}
	public void setChoGrDia(float cho_gr_dia) {
		this.cho_gr_dia = cho_gr_dia;
	}
	public float getChoGrKg() {
		return cho_gr_kg;
	}
	public void setChoGrKg(float cho_gr_kg) {
		this.cho_gr_kg = cho_gr_kg;
	}
	public float getChoVct() {
		return cho_vct;
	}
	public void setChoVct(float cho_vct) {
		this.cho_vct = cho_vct;
	}
	public float getGrasaSatGrDia() {
		return grasa_sat_gr_dia;
	}
	public void setGrasaSatGrDia(float grasa_sat_gr_dia) {
		this.grasa_sat_gr_dia = grasa_sat_gr_dia;
	}
	public float getGrasaSatGrKg() {
		return grasa_sat_gr_kg;
	}
	public void setGrasaSatGrKg(float grasa_sat_gr_kg) {
		this.grasa_sat_gr_kg = grasa_sat_gr_kg;
	}
	public float getGrasaSatVct() {
		return grasa_sat_vct;
	}
	public void setGrasaSatVct(float grasa_sat_vct) {
		this.grasa_sat_vct = grasa_sat_vct;
	}
	public float getGrasaMonoGrDia() {
		return grasa_mono_gr_dia;
	}
	public void setGrasaMonoGrDia(float grasa_mono_gr_dia) {
		this.grasa_mono_gr_dia = grasa_mono_gr_dia;
	}
	public float getGrasaMonoGrKg() {
		return grasa_mono_gr_kg;
	}
	public void setGrasaMonoGrKg(float grasa_mono_gr_kg) {
		this.grasa_mono_gr_kg = grasa_mono_gr_kg;
	}
	public float getGrasaMonoVct() {
		return grasa_mono_vct;
	}
	public void setGrasaMonoVct(float grasa_mono_vct) {
		this.grasa_mono_vct = grasa_mono_vct;
	}
	public float getGrasaPoliGrDia() {
		return grasa_poli_gr_dia;
	}
	public void setGrasaPoliGrDia(float grasa_poli_gr_dia) {
		this.grasa_poli_gr_dia = grasa_poli_gr_dia;
	}
	public float getGrasaPoliGrKg() {
		return grasa_poli_gr_kg;
	}
	public void setGrasaPoliGrKg(float grasa_poli_gr_kg) {
		this.grasa_poli_gr_kg = grasa_poli_gr_kg;
	}
	public float getGrasaPoliVct() {
		return grasa_poli_vct;
	}
	public void setGrasaPoliVct(float grasa_poli_vct) {
		this.grasa_poli_vct = grasa_poli_vct;
	}

	public String getBasales() {
		return basales;
	}

	public void setBasales(String basales) {
		this.basales = basales;
	}

	public String getFactor() {
		return factor;
	}

	public void setFactor(String factor) {
		this.factor = factor;
	}

	public float getCal_kg() {
		return cal_kg;
	}

	public void setCal_kg(float cal_kg) {
		this.cal_kg = cal_kg;
	}

	public float getCal_totales() {
		return cal_totales;
	}

	public void setCal_totales(float cal_totales) {
		this.cal_totales = cal_totales;
	}

	public String getPrescripcion() {
		return prescripcion;
	}

	public void setPrescripcion(String prescripcion) {
		this.prescripcion = prescripcion;
	}

	public String getMetas() {
		return metas;
	}

	public void setMetas(String metas) {
		this.metas = metas;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
}
