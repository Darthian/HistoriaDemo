package co.edu.unal.clinica.hibernate.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Usuario {
	
	@GeneratedValue
	@Id
	private long id_Usuario;
	private String nickName;
	private String password;
	private String rol;
	private String nombre;
	private String apellidos;

	public Usuario(){
		
	}
	
	public Usuario(String nickName,String password, String rol, String nombre, String apellidos){
		this.nickName = nickName;
		this.password = password;
		this.rol = rol;
		this.nombre = nombre;
		this.apellidos = apellidos;
	}
	
	public long getIdUsuario() {
		return id_Usuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.id_Usuario = idUsuario;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

}
