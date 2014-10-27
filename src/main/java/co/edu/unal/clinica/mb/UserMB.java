package co.edu.unal.clinica.mb;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import co.edu.unal.clinica.daos.UsuarioDAO;
import co.edu.unal.clinica.hibernate.data.Usuario;
import co.edu.unal.clinica.utils.HibernateUtil;

@ManagedBean(name="userMB")
@SessionScoped
public class UserMB {

	private String nickName;
	private String rol;
	private String password;
	private String nombre;
	private String apellidos;
	private List<Usuario> listaUsuarios;
	private UsuarioDAO usuarioDAO = new UsuarioDAO();

	private Usuario usuario = new Usuario();

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
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

	public String guardarUsuario() throws HibernateException, Exception {
		Usuario cliente = new Usuario(nickName, password, rol, nombre, apellidos);
		 
		if(usuarioDAO.nickNameExiste(cliente) == false){
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();		
			session.save(cliente);
			session.getTransaction().commit();
			session.close();
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El usuario ha sido creado correctamente","Puede seguir creando usuarios o volver"));
			return "adminUsuarios";
		}else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "El nombre de usuario "+nickName+" ya existe, ingrese uno diferente por favor","El nombre de usuario debe ser unico"));
			return "";
		}
	}

	public void eliminar(Usuario emp) throws Exception {
		usuarioDAO.Eliminar(emp);
		this.listar();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El usuario ha sido eliminado correctamente","Puede seguir administrando la informacion"));
	}

	public String leer(Usuario emp) {
		this.usuario = emp;
		return "editar";
	}
	
	public String modificar() throws Exception {
		usuarioDAO.Modificar(this.usuario);
		return "adminUsuarios";
	}

	public void listar() throws Exception {
		System.out.println("++++++++++++++++++++++Entro al listar de Usuarios!! no se que HPS PASA :'(");
		this.listaUsuarios = usuarioDAO.Listar();
	}

//	public String verificarDatos() throws Exception {
//		UsuarioDAO usuDAO = new UsuarioDAO();
//		Usuario us;
//		String resultado;
//
//		try {
//			this.usuario.setNickName(nickName);
//			this.usuario.setPassword(password);
//
//			us = usuDAO.verificarDatos(this.usuario);
//			if (us != null) {
//
//				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", us);
//				this.usuario.setRol(us.getRol());
//				resultado = "index"; // recalcar que el
//											// faces-redirect=true,
//											// olvida la peticion anterior y se
//											// dirige a la vista
//				// this.usuario = us;
//			} else {
//				resultado = "error";
//			}
//		} catch (Exception e) {
//			throw e;
//		}
//
//		return resultado;
//	}
//
//	public boolean verificarSesion() {
//		boolean estado;
//
//		if (FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario") == null) {
//			estado = false;
//		} else {
//			estado = true;
//		}
//
//		return estado;
//	}
//	
//	public String cerrarSesion() {
//		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
//		return "login?faces-redirect=true";
//	}
}
