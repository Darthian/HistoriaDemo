package co.edu.unal.clinica.hibernate.data;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Examen_Fisico {
	
	@GeneratedValue
	@Id
	private long id;
	private long fk_consulta;
	private long cedula;
	private String consolidado;
	private String estado_general;
	private String cabeza;
	private String ojos;
	private String nariz;
	private String boca;
	private String orejas;
	private String cuello;
	private String cardiaco;
	private String pulmonar;
	private String abdomen;
	private String extremidades;
	private String neurologico;
	private long temperatura;
	private long frecuencia_cardiaca;
	private long frecuencia_respiratoria;
	private String presion_arterial;
	private float peso;
	private float talla;
	private float perimetro_abdominal;
	private float masa_corporal;
	private Timestamp fecha_creacion;
	
	public Examen_Fisico(){
		
	}
	
	public Examen_Fisico(long cedula, String estado_general, String cabeza, String ojos, String nariz, String boca, 
			String orejas, String cuello, String cardiaco, String pulmonar, String abdomen, String extremidades, 
			String neurologico, long temperatura, long frecuencia_cardiaca, long frecuencia_pulmonar, String presion_arterial,
			float peso, float talla, float perimetro_abdominal, float masa_corporal, String consolidado){
		this.cedula = cedula;
		this.consolidado = consolidado;
		this.estado_general = estado_general;
		this.cabeza = cabeza;
		this.ojos = ojos;
		this.nariz = nariz;
		this.boca = boca;
		this.orejas = orejas;
		this.cuello = cuello;
		this.cardiaco = cardiaco;
		this.pulmonar = pulmonar;
		this.abdomen = abdomen;
		this.extremidades = extremidades;
		this.neurologico = neurologico;
		this.temperatura = temperatura;
		this.frecuencia_cardiaca = frecuencia_cardiaca;
		this.frecuencia_respiratoria = frecuencia_pulmonar;
		this.presion_arterial = presion_arterial;
		this.peso = peso;
		this.talla = talla;
		this.perimetro_abdominal = perimetro_abdominal;
		this.masa_corporal = masa_corporal;
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

	public String getCabeza() {
		return cabeza;
	}

	public void setCabeza(String cabeza) {
		this.cabeza = cabeza;
	}

	public String getOjos() {
		return ojos;
	}

	public void setOjos(String ojos) {
		this.ojos = ojos;
	}

	public String getNariz() {
		return nariz;
	}

	public void setNariz(String nariz) {
		this.nariz = nariz;
	}

	public String getBoca() {
		return boca;
	}

	public void setBoca(String boca) {
		this.boca = boca;
	}

	public String getOrejas() {
		return orejas;
	}

	public void setOrejas(String orejas) {
		this.orejas = orejas;
	}

	public String getCuello() {
		return cuello;
	}

	public void setCuello(String cuello) {
		this.cuello = cuello;
	}

	public String getCardiaco() {
		return cardiaco;
	}

	public void setCardiaco(String cardiaco) {
		this.cardiaco = cardiaco;
	}

	public String getPulmonar() {
		return pulmonar;
	}

	public void setPulmonar(String pulmonar) {
		this.pulmonar = pulmonar;
	}

	public String getAbdomen() {
		return abdomen;
	}

	public void setAbdomen(String abdomen) {
		this.abdomen = abdomen;
	}

	public String getExtremidades() {
		return extremidades;
	}

	public void setExtremidades(String extremidades) {
		this.extremidades = extremidades;
	}

	public String getNeurologico() {
		return neurologico;
	}

	public void setNeurologico(String neurologico) {
		this.neurologico = neurologico;
	}

	public Timestamp getFechaCreacion() {
		return fecha_creacion;
	}

	public void setFechaCreacion(Timestamp fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public long getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(long temperatura) {
		this.temperatura = temperatura;
	}

	public long getFrecuenciaCardiaca() {
		return frecuencia_cardiaca;
	}

	public void setFrecuenciaCardiaca(long frecuenciaCardiaca) {
		this.frecuencia_cardiaca = frecuenciaCardiaca;
	}

	public long getFrecuenciaRespiratoria() {
		return frecuencia_respiratoria;
	}

	public void setFrecuenciaRespiratoria(long frecuenciaRespiratoria) {
		this.frecuencia_respiratoria = frecuenciaRespiratoria;
	}

	public String getPresionArterial() {
		return presion_arterial;
	}

	public void setPresionArterial(String presionArterial) {
		this.presion_arterial = presionArterial;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public float getTalla() {
		return talla;
	}

	public void setTalla(float talla) {
		this.talla = talla;
	}

	public float getPerimetroAbdominal() {
		return perimetro_abdominal;
	}

	public void setPerimetroAbdominal(float perimetro_abdominal) {
		this.perimetro_abdominal = perimetro_abdominal;
	}

	public float getMasaCorporal() {
		return masa_corporal;
	}

	public void setMasaCorporal(float masa_corporal) {
		this.masa_corporal = masa_corporal;
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
