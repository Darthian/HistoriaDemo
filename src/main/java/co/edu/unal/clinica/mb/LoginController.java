package co.edu.unal.clinica.mb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import co.edu.unal.clinica.daos.UsuarioDAO;
import co.edu.unal.clinica.hibernate.data.Usuario;

@ManagedBean(name="loginController")
@SessionScoped
public class LoginController {
	
	private String nickName;
	private String password;
	
	private UsuarioDAO usuarioDAO = new UsuarioDAO();

	private Usuario usuario = new Usuario();
	
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

	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public String verificarDatos() throws Exception {
		UsuarioDAO usuDAO = new UsuarioDAO();
		Usuario us;
		String resultado;

		try {
			this.usuario.setNickName(nickName);
			this.usuario.setPassword(password);

			us = usuDAO.verificarDatos(this.usuario);
			if (us != null) {

				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", us);
				this.usuario.setRol(us.getRol());
				resultado = "index"; // recalcar que el
											// faces-redirect=true,
											// olvida la peticion anterior y se
											// dirige a la vista
				// this.usuario = us;
			} else {
				resultado = "error";
			}
		} catch (Exception e) {
			throw e;
		}

		return resultado;
	}
	
	public boolean verificarSesion() {
		boolean estado;

		if (FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario") == null) {
			estado = false;
		} else {
			estado = true;
		}

		return estado;
	}
	
	public String cerrarSesion() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "login?faces-redirect=true";
	}
}