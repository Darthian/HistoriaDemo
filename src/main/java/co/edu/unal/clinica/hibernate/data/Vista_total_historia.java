package co.edu.unal.clinica.hibernate.data;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Vista_total_historia {
	
	@Id
	private	long CEDULA;
	private String NOMBRE_PACIENTE;		
	private	int EDAD;			
	private	String GENERO;		
	private	String OCUPACION;	
	private	String DIAGNOSTICO;	
	private	String COMPLICACIONES_DIABETES;	
	private	String NEFROPATIA_DIABETICA;		
	private int	ESTADO_NEFROPATIA;				
	private	String PRESION_ARTERIAL;		
	private int FRECUENCIA_CARDIACA;			
	private int FRECUENCIA_RESPIRATORIA;		
	private int	TEMPERATURA;			
	private float PESO;				
	private float TALLA;				
	private float MASA_CORPORAL;		
	private float PERIMETRO_ABDOMINAL;	
	private	String cardiopulmunar;	
	private	String ABDOMEN;		
	private	String EXTREMIDADES;	
	private	String NEUROLOGICO;		
	private	String PIE_DIABETICO;		
	private float BUN;				
	private float CREATININA;		
	private float GLICEMIA_AYUNAS;	
	private float GLICEMIA_POST_PRANDIAL;		
	private float HDL;		
	private float HEMOGLOBINA_GLICOSILADA;	
	private float LDL;				
	private	String PARCIAL_ORINA;	
	private float TRIGLICERIDOS;			
	private float VLDL;			
	private	String OTROS_PARACLINICOS;	
	private	String ANALISIS;		
	private	String PLAN;	
	private Timestamp FECHA_CREACION;
	
	public Vista_total_historia(){}

	public String getNOMBRE_PACIENTE() {
		return NOMBRE_PACIENTE;
	}

	public void setNOMBRE_PACIENTE(String nOMBRE_PACIENTE) {
		NOMBRE_PACIENTE = nOMBRE_PACIENTE;
	}

	public long getCEDULA() {
		return CEDULA;
	}

	public void setCEDULA(long cEDULA) {
		CEDULA = cEDULA;
	}

	public int getEDAD() {
		return EDAD;
	}

	public void setEDAD(int eDAD) {
		EDAD = eDAD;
	}

	public String getGENERO() {
		return GENERO;
	}

	public void setGENERO(String gENERO) {
		GENERO = gENERO;
	}

	public String getOCUPACION() {
		return OCUPACION;
	}

	public void setOCUPACION(String oCUPACION) {
		OCUPACION = oCUPACION;
	}

	public String getDIAGNOSTICO() {
		return DIAGNOSTICO;
	}

	public void setDIAGNOSTICO(String dIAGNOSTICO) {
		DIAGNOSTICO = dIAGNOSTICO;
	}

	public String getCOMPLICACIONES_DIABETES() {
		return COMPLICACIONES_DIABETES;
	}

	public void setCOMPLICACIONES_DIABETES(String cOMPLICACIONES_DIABETES) {
		COMPLICACIONES_DIABETES = cOMPLICACIONES_DIABETES;
	}

	public String getNEFROPATIA_DIABETICA() {
		return NEFROPATIA_DIABETICA;
	}

	public void setNEFROPATIA_DIABETICA(String nEFROPATIA_DIABETICA) {
		NEFROPATIA_DIABETICA = nEFROPATIA_DIABETICA;
	}

	public int getESTADO_NEFROPATIA() {
		return ESTADO_NEFROPATIA;
	}

	public void setESTADO_NEFROPATIA(int eSTADO_NEFROPATIA) {
		ESTADO_NEFROPATIA = eSTADO_NEFROPATIA;
	}

	public String getPRESION_ARTERIAL() {
		return PRESION_ARTERIAL;
	}

	public void setPRESION_ARTERIAL(String pRESION_ARTERIAL) {
		PRESION_ARTERIAL = pRESION_ARTERIAL;
	}

	public int getFRECUENCIA_CARDIACA() {
		return FRECUENCIA_CARDIACA;
	}

	public void setFRECUENCIA_CARDIACA(int fRECUENCIA_CARDIACA) {
		FRECUENCIA_CARDIACA = fRECUENCIA_CARDIACA;
	}

	public int getFRECUENCIA_RESPIRATORIA() {
		return FRECUENCIA_RESPIRATORIA;
	}

	public void setFRECUENCIA_RESPIRATORIA(int fRECUENCIA_RESPIRATORIA) {
		FRECUENCIA_RESPIRATORIA = fRECUENCIA_RESPIRATORIA;
	}

	public int getTEMPERATURA() {
		return TEMPERATURA;
	}

	public void setTEMPERATURA(int tEMPERATURA) {
		TEMPERATURA = tEMPERATURA;
	}

	public float getPESO() {
		return PESO;
	}

	public void setPESO(float pESO) {
		PESO = pESO;
	}

	public float getTALLA() {
		return TALLA;
	}

	public void setTALLA(float tALLA) {
		TALLA = tALLA;
	}

	public float getMASA_CORPORAL() {
		return MASA_CORPORAL;
	}

	public void setMASA_CORPORAL(float mASA_CORPORAL) {
		MASA_CORPORAL = mASA_CORPORAL;
	}

	public float getPERIMETRO_ABDOMINAL() {
		return PERIMETRO_ABDOMINAL;
	}

	public void setPERIMETRO_ABDOMINAL(float pERIMETRO_ABDOMINAL) {
		PERIMETRO_ABDOMINAL = pERIMETRO_ABDOMINAL;
	}

	public String getCardiopulmunar() {
		return cardiopulmunar;
	}

	public void setCardiopulmunar(String cardiopulmunar) {
		this.cardiopulmunar = cardiopulmunar;
	}

	public String getABDOMEN() {
		return ABDOMEN;
	}

	public void setABDOMEN(String aBDOMEN) {
		ABDOMEN = aBDOMEN;
	}

	public String getEXTREMIDADES() {
		return EXTREMIDADES;
	}

	public void setEXTREMIDADES(String eXTREMIDADES) {
		EXTREMIDADES = eXTREMIDADES;
	}

	public String getNEUROLOGICO() {
		return NEUROLOGICO;
	}

	public void setNEUROLOGICO(String nEUROLOGICO) {
		NEUROLOGICO = nEUROLOGICO;
	}

	public String getPIE_DIABETICO() {
		return PIE_DIABETICO;
	}

	public void setPIE_DIABETICO(String pIE_DIABETICO) {
		PIE_DIABETICO = pIE_DIABETICO;
	}

	public float getBUN() {
		return BUN;
	}

	public void setBUN(float bUN) {
		BUN = bUN;
	}

	public float getCREATININA() {
		return CREATININA;
	}

	public void setCREATININA(float cREATININA) {
		CREATININA = cREATININA;
	}

	public float getGLICEMIA_AYUNAS() {
		return GLICEMIA_AYUNAS;
	}

	public void setGLICEMIA_AYUNAS(float gLICEMIA_AYUNAS) {
		GLICEMIA_AYUNAS = gLICEMIA_AYUNAS;
	}

	public float getGLICEMIA_POST_PRANDIAL() {
		return GLICEMIA_POST_PRANDIAL;
	}

	public void setGLICEMIA_POST_PRANDIAL(float gLICEMIA_POST_PRANDIAL) {
		GLICEMIA_POST_PRANDIAL = gLICEMIA_POST_PRANDIAL;
	}

	public float getHDL() {
		return HDL;
	}

	public void setHDL(float hDL) {
		HDL = hDL;
	}

	public float getHEMOGLOBINA_GLICOSILADA() {
		return HEMOGLOBINA_GLICOSILADA;
	}

	public void setHEMOGLOBINA_GLICOSILADA(float hEMOGLOBINA_GLICOSILADA) {
		HEMOGLOBINA_GLICOSILADA = hEMOGLOBINA_GLICOSILADA;
	}

	public float getLDL() {
		return LDL;
	}

	public void setLDL(float lDL) {
		LDL = lDL;
	}

	public String getPARCIAL_ORINA() {
		return PARCIAL_ORINA;
	}

	public void setPARCIAL_ORINA(String pARCIAL_ORINA) {
		PARCIAL_ORINA = pARCIAL_ORINA;
	}

	public float getTRIGLICERIDOS() {
		return TRIGLICERIDOS;
	}

	public void setTRIGLICERIDOS(float tRIGLICERIDOS) {
		TRIGLICERIDOS = tRIGLICERIDOS;
	}

	public float getVLDL() {
		return VLDL;
	}

	public void setVLDL(float vLDL) {
		VLDL = vLDL;
	}

	public String getOTROS_PARACLINICOS() {
		return OTROS_PARACLINICOS;
	}

	public void setOTROS_PARACLINICOS(String oTROS_PARACLINICOS) {
		OTROS_PARACLINICOS = oTROS_PARACLINICOS;
	}

	public String getANALISIS() {
		return ANALISIS;
	}

	public void setANALISIS(String aNALISIS) {
		ANALISIS = aNALISIS;
	}

	public String getPLAN() {
		return PLAN;
	}

	public void setPLAN(String pLAN) {
		PLAN = pLAN;
	}

	public Timestamp getFECHA_CREACION() {
		return FECHA_CREACION;
	}

	public void setFECHA_CREACION(Timestamp fECHA_CREACION) {
		FECHA_CREACION = fECHA_CREACION;
	}
}
