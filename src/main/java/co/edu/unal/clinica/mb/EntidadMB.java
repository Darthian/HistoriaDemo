package co.edu.unal.clinica.mb;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.hibernate.Session;

import co.edu.unal.clinica.daos.EntidadDAO;
import co.edu.unal.clinica.hibernate.data.Entidad;
import co.edu.unal.clinica.utils.HibernateUtil;

@ManagedBean(name = "entidadMB")
@SessionScoped
public class EntidadMB {
	
	private String nombre;
	private String descripcion;
	
	private List<Entidad> listEntidades;
	private EntidadDAO entidadDao = new EntidadDAO();
	private Entidad entidad = new Entidad();
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public List<Entidad> getListEntidades() {
		return listEntidades;
	}
	public void setListEntidades(List<Entidad> listEntidades) {
		this.listEntidades = listEntidades;
	}
	public EntidadDAO getEntidadDao() {
		return entidadDao;
	}
	public void setEntidadDao(EntidadDAO entidadDao) {
		this.entidadDao = entidadDao;
	}
	public Entidad getEntidad() {
		return entidad;
	}
	public void setEntidad(Entidad entidad) {
		this.entidad = entidad;
	}
	
	public void guardarEntidad() {
		try{
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Entidad ant = new Entidad(nombre, descripcion);
			session.save(ant);
			session.getTransaction().commit();
			session.close();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro ha sido creado correctamente","Puede seguir registrando o volver"));
		}catch(Exception ex){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Esto es vergonzoso","Ha ocurrido un error al intentar hacer el registro"));
		}
	}

	public void listar() throws Exception {
		this.listEntidades = entidadDao.Listar();
	}

	public String leer(Entidad emp) {
		this.entidad = emp;
		return "editarEntidad";
	}

	public String modificar() throws Exception {
		entidadDao.Modificar(this.entidad);
		return "adminEntidades";
	}

	public List<SelectItem> getListaEntidades() throws Exception {
		List<SelectItem> items = new ArrayList<SelectItem>();
		List<Entidad> listaEntidades = entidadDao.Listar();
		for (Entidad entidad : listaEntidades) {
			items.add(new SelectItem(entidad.getNombre(), entidad.getNombre()));
		}
		return items;
	}
}