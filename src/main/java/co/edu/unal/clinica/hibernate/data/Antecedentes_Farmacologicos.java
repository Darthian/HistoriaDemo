package co.edu.unal.clinica.hibernate.data;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Antecedentes_Farmacologicos {

	@GeneratedValue
	@Id
	private long id;
	private long cedula;
	private String tratamiento_actual;
	private String dieta;
	private String hipoglucemiantes_orales;
	private String insulina;
	private String otros_medicamentos;
	private Timestamp fecha_creacion;
	
	public Antecedentes_Farmacologicos(){
		
	}
	
	public Antecedentes_Farmacologicos(long cedula, String tratamiento_actual, String dieta, String hipoglucemiantes_orales, String insulina, String otros_medicamentos){
		this.cedula = cedula;
		this.tratamiento_actual = tratamiento_actual;
		this.dieta = dieta;
		this.hipoglucemiantes_orales = hipoglucemiantes_orales;
		this.insulina = insulina;
		this.otros_medicamentos = otros_medicamentos;
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
	public String getTratamientoActual() {
		return tratamiento_actual;
	}
	public void setTratamientoActual(String tratamiento_actual) {
		this.tratamiento_actual = tratamiento_actual;
	}
	public String getDieta() {
		return dieta;
	}
	public void setDieta(String dieta) {
		this.dieta = dieta;
	}
	public String getHipoglucemiantesOrales() {
		return hipoglucemiantes_orales;
	}
	public void setHipoglucemiantesOrales(String hipoglucemiantes_orales) {
		this.hipoglucemiantes_orales = hipoglucemiantes_orales;
	}
	public String getInsulina() {
		return insulina;
	}
	public void setInsulina(String insulina) {
		this.insulina = insulina;
	}
	public String getOtrosMedicamentos() {
		return otros_medicamentos;
	}
	public void setOtrosMedicamentos(String otros_medicamentos) {
		this.otros_medicamentos = otros_medicamentos;
	}
	public Timestamp getFechaCreacion() {
		return fecha_creacion;
	}
	public void setFecha_creacion(Timestamp fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}
}
