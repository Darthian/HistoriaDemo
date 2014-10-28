package co.edu.unal.clinica.hibernate.data;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Antecedentes_Familiares {
	
	@GeneratedValue
	@Id
	private long id;
	private long cedula;
	private String historia_Familiar_Diabetes;
	private String historia_Familiar_Infarto;
	private String historia_Familiar_Dislipidemia;
	private String otros;
	private Timestamp fecha_Creacion;
	
	public Antecedentes_Familiares(){
		
	}
	
	public Antecedentes_Familiares(long cedula, String historiaFamiliarDiabetes, String historiaFamiliarInarto, String historiaFamiliarDislipidemia, String otros){
		this.cedula = cedula;
		this.historia_Familiar_Diabetes = historiaFamiliarDiabetes;
		this.historia_Familiar_Dislipidemia = historiaFamiliarDislipidemia;
		this.historia_Familiar_Infarto = historiaFamiliarInarto;
		this.otros = otros;
//		Date date = new Date();
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
	public String getHistoriaFamiliarDiabetes() {
		return historia_Familiar_Diabetes;
	}
	public void setHistoriaFamiliarDiabetes(String historiaFamiliarDiabetes) {
		this.historia_Familiar_Diabetes = historiaFamiliarDiabetes;
	}
	public String getHistoriaFamiliarInfarto() {
		return historia_Familiar_Infarto;
	}
	public void setHistoriaFamiliarInfarto(String historiaFamiliarInfarto) {
		this.historia_Familiar_Infarto = historiaFamiliarInfarto;
	}
	public String getHistoriaFamiliarDislipidemia() {
		return historia_Familiar_Dislipidemia;
	}
	public void setHistoriaFamiliarDislipidemia(String historiaFamiliarDislipidemia) {
		this.historia_Familiar_Dislipidemia = historiaFamiliarDislipidemia;
	}
	public String getOtros() {
		return otros;
	}
	public void setOtros(String otros) {
		this.otros = otros;
	}
	public Timestamp getFechaCreacion() {
		return fecha_Creacion;
	}
	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fecha_Creacion = fechaCreacion;
	}
	
}
