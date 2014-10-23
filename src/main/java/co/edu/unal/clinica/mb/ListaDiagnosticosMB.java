package co.edu.unal.clinica.mb;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import org.hibernate.Session;

import co.edu.unal.clinica.daos.ListaDiagnosticosDAO;
import co.edu.unal.clinica.hibernate.data.Lista_Diagnosticos;
import co.edu.unal.clinica.utils.HibernateUtil;

@ManagedBean(name = "listaDiagnosticosMB")
@SessionScoped
public class ListaDiagnosticosMB {

	private long codigo;
	private String diagnostico;
	private String descripcion;

	private List<Lista_Diagnosticos> listDiag;
	private ListaDiagnosticosDAO diagDao = new ListaDiagnosticosDAO();
	private Lista_Diagnosticos diag = new Lista_Diagnosticos();

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
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

	public List<Lista_Diagnosticos> getListDiag() {
		return listDiag;
	}

	public void setListDiag(List<Lista_Diagnosticos> listDiag) {
		this.listDiag = listDiag;
	}

	public ListaDiagnosticosDAO getEnfDao() {
		return diagDao;
	}

	public void setEnfDao(ListaDiagnosticosDAO enfDao) {
		this.diagDao = enfDao;
	}

	public Lista_Diagnosticos getDiag() {
		return diag;
	}

	public void setDiag(Lista_Diagnosticos enf) {
		this.diag = enf;
	}

	public void guardarListaDiagnosticos() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Lista_Diagnosticos ant = new Lista_Diagnosticos(codigo, diagnostico, descripcion);
		session.save(ant);
		session.getTransaction().commit();
		session.close();
	}

	public void listar() throws Exception {
		this.listDiag = diagDao.Listar();
	}

	public String leer(Lista_Diagnosticos emp) {
		this.diag = emp;
		return "editarListaDiagnosticos";
	}

	public String modificar() throws Exception {
		diagDao.Modificar(this.diag);
		return "adminListaDiagnosticos";
	}

	public List<SelectItem> getListaDiagnosticos() throws Exception {
		List<SelectItem> items = new ArrayList<SelectItem>();
		List<Lista_Diagnosticos> listaDiagnosticos = diagDao.Listar();
		for (Lista_Diagnosticos diag : listaDiagnosticos) {
			items.add(new SelectItem(diag.getCodigo(), diag.getDiagnostico()));
		}
		return items;
	}

}
