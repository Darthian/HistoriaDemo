package co.edu.unal.clinica.hibernate.data;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Vista_total_historia {
	
	@Id
	private long ID_CONSULTA;
	private String TIPO_CONSULTA;
	private String NOMBRE_PACIENTE;
	private	long CEDULA;
	private	Integer EDAD;			
	private	String GENERO;		
	private	String OCUPACION;
	private String ENFERMEDAD_ACTUAL;
	private String EJERCICIO_TEXTO;
	private	String DIAGNOSTICO;	
	private	String COMPLICACIONES_DIABETES;	
	private	String NEFROPATIA_DIABETICA;		
	private Integer	ESTADO_NEFROPATIA;				
	private	String PRESION_ARTERIAL;		
	private Integer FRECUENCIA_CARDIACA;			
	private Integer FRECUENCIA_RESPIRATORIA;		
	private Integer	TEMPERATURA;			
	private Float PESO;				
	private Float TALLA;				
	private Float MASA_CORPORAL;		
	private Float PERIMETRO_ABDOMINAL;	
	private	String CARDIOPULMONAR;	
	private	String ABDOMEN;		
	private	String EXTREMIDADES;	
	private	String NEUROLOGICO;		
	private	String PIE_DIABETICO;		
	private Float BUN;				
	private Float CREATININA;		
	private Float GLICEMIA_AYUNAS;	
	private Float GLICEMIA_POST_PRANDIAL;		
	private Float HDL;		
	private Float HEMOGLOBINA_GLICOSILADA;	
	private Float LDL;				
	private	String PARCIAL_ORINA;	
	private Float TRIGLICERIDOS;			
	private Float VLDL;			
	private	String OTROS_PARACLINICOS;	
	private	String ANALISIS;		
	private	String PLAN;	
	private String TRATAMIENTO_ACTUAL;
	private String DESCRIPCION_DIAGNOSTICO;
	private Timestamp FECHA_CREACION;
	
	public Vista_total_historia(){}

	public long getID_CONSULTA() {
		return ID_CONSULTA;
	}

	public void setID_CONSULTA(long iD_CONSULTA) {
		ID_CONSULTA = iD_CONSULTA;
	}

	public String getTIPO_CONSULTA() {
		return TIPO_CONSULTA;
	}

	public void setTIPO_CONSULTA(String tIPO_CONSULTA) {
		TIPO_CONSULTA = tIPO_CONSULTA;
	}

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

	public Integer getEDAD() {
		return EDAD;
	}

	public void setEDAD(Integer eDAD) {
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

	public String getENFERMEDAD_ACTUAL() {
		return ENFERMEDAD_ACTUAL;
	}

	public void setENFERMEDAD_ACTUAL(String eNFERMEDAD_ACTUAL) {
		ENFERMEDAD_ACTUAL = eNFERMEDAD_ACTUAL;
	}

	public String getEJERCICIO_TEXTO() {
		return EJERCICIO_TEXTO;
	}

	public void setEJERCICIO_TEXTO(String eJERCICIO_TEXTO) {
		EJERCICIO_TEXTO = eJERCICIO_TEXTO;
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

	public Integer getESTADO_NEFROPATIA() {
		return ESTADO_NEFROPATIA;
	}

	public void setESTADO_NEFROPATIA(Integer eSTADO_NEFROPATIA) {
		ESTADO_NEFROPATIA = eSTADO_NEFROPATIA;
	}

	public String getPRESION_ARTERIAL() {
		return PRESION_ARTERIAL;
	}

	public void setPRESION_ARTERIAL(String pRESION_ARTERIAL) {
		PRESION_ARTERIAL = pRESION_ARTERIAL;
	}

	public Integer getFRECUENCIA_CARDIACA() {
		return FRECUENCIA_CARDIACA;
	}

	public void setFRECUENCIA_CARDIACA(Integer fRECUENCIA_CARDIACA) {
		FRECUENCIA_CARDIACA = fRECUENCIA_CARDIACA;
	}

	public Integer getFRECUENCIA_RESPIRATORIA() {
		return FRECUENCIA_RESPIRATORIA;
	}

	public void setFRECUENCIA_RESPIRATORIA(Integer fRECUENCIA_RESPIRATORIA) {
		FRECUENCIA_RESPIRATORIA = fRECUENCIA_RESPIRATORIA;
	}

	public Integer getTEMPERATURA() {
		return TEMPERATURA;
	}

	public void setTEMPERATURA(Integer tEMPERATURA) {
		TEMPERATURA = tEMPERATURA;
	}

	public Float getPESO() {
		return PESO;
	}

	public void setPESO(Float pESO) {
		PESO = pESO;
	}

	public Float getTALLA() {
		return TALLA;
	}

	public void setTALLA(Float tALLA) {
		TALLA = tALLA;
	}

	public Float getMASA_CORPORAL() {
		return MASA_CORPORAL;
	}

	public void setMASA_CORPORAL(Float mASA_CORPORAL) {
		MASA_CORPORAL = mASA_CORPORAL;
	}

	public Float getPERIMETRO_ABDOMINAL() {
		return PERIMETRO_ABDOMINAL;
	}

	public void setPERIMETRO_ABDOMINAL(Float pERIMETRO_ABDOMINAL) {
		PERIMETRO_ABDOMINAL = pERIMETRO_ABDOMINAL;
	}

	public String getCARDIOPULMONAR() {
		return CARDIOPULMONAR;
	}

	public void setCARDIOPULMONAR(String cARDIOPULMONAR) {
		CARDIOPULMONAR = cARDIOPULMONAR;
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

	public Float getBUN() {
		return BUN;
	}

	public void setBUN(Float bUN) {
		BUN = bUN;
	}

	public Float getCREATININA() {
		return CREATININA;
	}

	public void setCREATININA(Float cREATININA) {
		CREATININA = cREATININA;
	}

	public Float getGLICEMIA_AYUNAS() {
		return GLICEMIA_AYUNAS;
	}

	public void setGLICEMIA_AYUNAS(Float gLICEMIA_AYUNAS) {
		GLICEMIA_AYUNAS = gLICEMIA_AYUNAS;
	}

	public Float getGLICEMIA_POST_PRANDIAL() {
		return GLICEMIA_POST_PRANDIAL;
	}

	public void setGLICEMIA_POST_PRANDIAL(Float gLICEMIA_POST_PRANDIAL) {
		GLICEMIA_POST_PRANDIAL = gLICEMIA_POST_PRANDIAL;
	}

	public Float getHDL() {
		return HDL;
	}

	public void setHDL(Float hDL) {
		HDL = hDL;
	}

	public Float getHEMOGLOBINA_GLICOSILADA() {
		return HEMOGLOBINA_GLICOSILADA;
	}

	public void setHEMOGLOBINA_GLICOSILADA(Float hEMOGLOBINA_GLICOSILADA) {
		HEMOGLOBINA_GLICOSILADA = hEMOGLOBINA_GLICOSILADA;
	}

	public Float getLDL() {
		return LDL;
	}

	public void setLDL(Float lDL) {
		LDL = lDL;
	}

	public String getPARCIAL_ORINA() {
		return PARCIAL_ORINA;
	}

	public void setPARCIAL_ORINA(String pARCIAL_ORINA) {
		PARCIAL_ORINA = pARCIAL_ORINA;
	}

	public Float getTRIGLICERIDOS() {
		return TRIGLICERIDOS;
	}

	public void setTRIGLICERIDOS(Float tRIGLICERIDOS) {
		TRIGLICERIDOS = tRIGLICERIDOS;
	}

	public Float getVLDL() {
		return VLDL;
	}

	public void setVLDL(Float vLDL) {
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

	public String getTRATAMIENTO_ACTUAL() {
		return TRATAMIENTO_ACTUAL;
	}

	public void setTRATAMIENTO_ACTUAL(String tRATAMIENTO_ACTUAL) {
		TRATAMIENTO_ACTUAL = tRATAMIENTO_ACTUAL;
	}

	public String getDESCRIPCION_DIAGNOSTICO() {
		return DESCRIPCION_DIAGNOSTICO;
	}

	public void setDESCRIPCION_DIAGNOSTICO(String dESCRIPCION_DIAGNOSTICO) {
		DESCRIPCION_DIAGNOSTICO = dESCRIPCION_DIAGNOSTICO;
	}

	public Timestamp getFECHA_CREACION() {
		return FECHA_CREACION;
	}

	public void setFECHA_CREACION(Timestamp fECHA_CREACION) {
		FECHA_CREACION = fECHA_CREACION;
	}

	
}