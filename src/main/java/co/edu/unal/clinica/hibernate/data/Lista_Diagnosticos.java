package co.edu.unal.clinica.hibernate.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Lista_Diagnosticos {
	
	@GeneratedValue
	@Id
	private long id;
	private String codigo;
	private String diagnostico;
	private String descripcion;
	
	public Lista_Diagnosticos (){
		
	}
	
	public Lista_Diagnosticos (String codigo, String diagnostico, String descripcion){
		this.codigo = codigo;
		this.diagnostico = diagnostico;
		this.descripcion = descripcion;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
