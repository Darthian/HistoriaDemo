package co.edu.unal.clinica.mb;

import java.sql.Timestamp;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.hibernate.Session;

import co.edu.unal.clinica.daos.ValoracionNutricionalDAO;
import co.edu.unal.clinica.hibernate.data.Valoracion_Nutricional;
import co.edu.unal.clinica.utils.HibernateUtil;

@ManagedBean(name="valoracionNutricionalMB")
@SessionScoped
public class ValoracionNutricionalMB {

	private long fkConsulta;
	private long cedula;
	private String consolidado;
	private Timestamp fechaCreacion;
	private float proteinaGrDia;
	private float proteinaGrKg;
	private float proteinaVct;
	private float grasaGrDia;
	private float grasaGrKg;
	private float grasaVct;
	private float choGrDia;
	private float choGrKg;
	private float choVct;
	private float grasaSatGrDia;
	private float grasaSatGrKg;
	private float grasaSatVct;
	private float grasaMonoGrDia;
	private float grasaMonoGrKg;
	private float grasaMonoVct;
	private float grasaPoliGrDia;
	private float grasaPoliGrKg;
	private float grasaPoliVct;
	private String basales;
	private String factor;
	private float cal_kg;
	private float cal_totales;
	private String prescripcion;
	private String metas;
	private String observaciones;
	
	private List<Valoracion_Nutricional> listaVal;
	private List<Valoracion_Nutricional> listaValHC;
	private ValoracionNutricionalDAO valDAO = new ValoracionNutricionalDAO();
	private static Valoracion_Nutricional val = new Valoracion_Nutricional();

	public static long cedulaPaciente;
	
	public void guardarValoracionNutricional() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try{
			session.beginTransaction();
			consolidado = "No";
			Valoracion_Nutricional valN = new Valoracion_Nutricional(fkConsulta, PacienteMB.cedulaConsulta, consolidado, proteinaGrDia, proteinaGrKg, proteinaVct,
			grasaGrDia, grasaGrKg, grasaVct, choGrDia, choGrKg, choVct, grasaSatGrDia, grasaSatGrKg, grasaSatVct, grasaMonoGrDia, grasaMonoGrKg,
			grasaMonoVct, grasaPoliGrDia, grasaPoliGrKg, grasaPoliVct,basales, factor, cal_kg, cal_totales, prescripcion, metas, observaciones);
			long id = (long) session.save(valN);
			val.setId(id); 
			session.getTransaction().commit();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro ha sido creado correctamente","Puede seguir registrando o volver"));
		}
		catch(Exception ex){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Esto es vergonzoso","Ha ocurrido un error al intentar hacer el registro"));
		}
		finally{
			session.close();
		}
	}
	
	public void consolidarValoracionNutricional(long idConsulta){
		try{
			System.out.println("++++++++++++++++++++++ ENTRA AL METODO DE CONSOLIDAR VALORACION NUTRICIONAL" );
			List<Valoracion_Nutricional> listobjetoConsolidado = valDAO.BuscarNoConsolidados();
			if(listobjetoConsolidado!= null && listobjetoConsolidado.size() > 0){
				for(Valoracion_Nutricional iterator : listobjetoConsolidado){
					System.out.println("++++++++++++++++++++++ ID de Objeto Recuperado " +iterator.getId());
					iterator.setConsolidado("Si");
					iterator.setFkConsulta(idConsulta);
				}
				valDAO.ConsolidarConsulta(listobjetoConsolidado);
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro ha sido consolidado correctamente","Puede seguir registrando o volver"));
			}else{
				System.out.println("++++++++++++++++++++++ No hay regitros sin consolidar");
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "No hay regitros sin consolidar","No hay motivos de consulta sin guardar definitivamente"));
			}
		}catch(Exception ex){
			System.out.println(ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Esto es vergonzoso","Ha ocurrido un error al intentar hacer la consolidacion"));
		}
	}
	
	public String modificar() {
		try{
			valDAO.Modificar(val);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro ha sido modificado correctamente","Puede seguir modificando o volver"));
		}catch(Exception ex){
			System.out.println(ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Esto es vergonzoso","Ha ocurrido un error al intentar modificar la informacion"));
		}
		return "adminValoracionNutricional";
	}
	
	public void listar(){
		cedulaPaciente = PacienteMB.cedulaConsulta;
		System.out.println("Cedula de la historia:"+PacienteMB.cedulaConsulta);
		try{
			this.listaVal = valDAO.Buscar(PacienteMB.cedulaConsulta);
		}catch(Exception ex){
			System.out.println(ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Esto es vergonzoso","Ha ocurrido un error al intentar consultar la informacion"));
		}
	}
	
	public void listarHC() throws Exception {
		this.listaValHC = valDAO.BuscarPorConsulta(ConsultaMB.idConsultaConstante);
	}
	
	public String leer(Valoracion_Nutricional emp) {
		val = emp;
		return "editarValoracionNutricional";
	}
	
	public long getFkConsulta() {
		return fkConsulta;
	}
	public void setFkConsulta(long fkConsulta) {
		this.fkConsulta = fkConsulta;
	}
	public long getCedula() {
		return cedula;
	}
	public void setCedula(long cedula) {
		this.cedula = cedula;
	}
	public String getConsolidado() {
		return consolidado;
	}
	public void setConsolidado(String consolidado) {
		this.consolidado = consolidado;
	}
	public Timestamp getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public float getProteinaGrDia() {
		return proteinaGrDia;
	}
	public void setProteinaGrDia(float proteinaGrDia) {
		this.proteinaGrDia = proteinaGrDia;
	}
	public float getProteinaGrKg() {
		return proteinaGrKg;
	}
	public void setProteinaGrKg(float proteinaGrKg) {
		this.proteinaGrKg = proteinaGrKg;
	}
	public float getProteinaVct() {
		return proteinaVct;
	}
	public void setProteinaVct(float proteinaVct) {
		this.proteinaVct = proteinaVct;
	}
	public float getGrasaGrDia() {
		return grasaGrDia;
	}
	public void setGrasaGrDia(float grasaGrDia) {
		this.grasaGrDia = grasaGrDia;
	}
	public float getGrasaGrKg() {
		return grasaGrKg;
	}
	public void setGrasaGrKg(float grasaGrKg) {
		this.grasaGrKg = grasaGrKg;
	}
	public float getGrasaVct() {
		return grasaVct;
	}
	public void setGrasaVct(float grasaVct) {
		this.grasaVct = grasaVct;
	}
	public float getChoGrDia() {
		return choGrDia;
	}
	public void setChoGrDia(float choGrDia) {
		this.choGrDia = choGrDia;
	}
	public float getChoGrKg() {
		return choGrKg;
	}
	public void setChoGrKg(float choGrKg) {
		this.choGrKg = choGrKg;
	}
	public float getChoVct() {
		return choVct;
	}
	public void setChoVct(float choVct) {
		this.choVct = choVct;
	}
	public float getGrasaSatGrDia() {
		return grasaSatGrDia;
	}
	public void setGrasaSatGrDia(float grasaSatGrDia) {
		this.grasaSatGrDia = grasaSatGrDia;
	}
	public float getGrasaSatGrKg() {
		return grasaSatGrKg;
	}
	public void setGrasaSatGrKg(float grasaSatGrKg) {
		this.grasaSatGrKg = grasaSatGrKg;
	}
	public float getGrasaSatVct() {
		return grasaSatVct;
	}
	public void setGrasaSatVct(float grasaSatVct) {
		this.grasaSatVct = grasaSatVct;
	}
	public float getGrasaMonoGrDia() {
		return grasaMonoGrDia;
	}
	public void setGrasaMonoGrDia(float grasaMonoGrDia) {
		this.grasaMonoGrDia = grasaMonoGrDia;
	}
	public float getGrasaMonoGrKg() {
		return grasaMonoGrKg;
	}
	public void setGrasaMonoGrKg(float grasaMonoGrKg) {
		this.grasaMonoGrKg = grasaMonoGrKg;
	}
	public float getGrasaMonoVct() {
		return grasaMonoVct;
	}
	public void setGrasaMonoVct(float grasaMonoVct) {
		this.grasaMonoVct = grasaMonoVct;
	}
	public float getGrasaPoliGrDia() {
		return grasaPoliGrDia;
	}
	public void setGrasaPoliGrDia(float grasaPoliGrDia) {
		this.grasaPoliGrDia = grasaPoliGrDia;
	}
	public float getGrasaPoliGrKg() {
		return grasaPoliGrKg;
	}
	public void setGrasaPoliGrKg(float grasaPoliGrKg) {
		this.grasaPoliGrKg = grasaPoliGrKg;
	}
	public float getGrasaPoliVct() {
		return grasaPoliVct;
	}
	public void setGrasaPoliVct(float grasaPoliVct) {
		this.grasaPoliVct = grasaPoliVct;
	}

	public List<Valoracion_Nutricional> getListaVal() {
		return listaVal;
	}

	public void setListaVal(List<Valoracion_Nutricional> listaVal) {
		this.listaVal = listaVal;
	}

	public List<Valoracion_Nutricional> getListaValHC() {
		return listaValHC;
	}

	public void setListaValHC(List<Valoracion_Nutricional> listaValHC) {
		this.listaValHC = listaValHC;
	}

	public ValoracionNutricionalDAO getValDAO() {
		return valDAO;
	}

	public void setValDAO(ValoracionNutricionalDAO valDAO) {
		this.valDAO = valDAO;
	}

	public Valoracion_Nutricional getVal() {
		return val;
	}

	public void setVal(Valoracion_Nutricional val) {
		ValoracionNutricionalMB.val = val;
	}

	public String getBasales() {
		return basales;
	}

	public void setBasales(String basales) {
		this.basales = basales;
	}

	public String getFactor() {
		return factor;
	}

	public void setFactor(String factor) {
		this.factor = factor;
	}

	public float getCal_kg() {
		return cal_kg;
	}

	public void setCal_kg(float cal_kg) {
		this.cal_kg = cal_kg;
	}

	public float getCal_totales() {
		return cal_totales;
	}

	public void setCal_totales(float cal_totales) {
		this.cal_totales = cal_totales;
	}

	public String getPrescripcion() {
		return prescripcion;
	}

	public void setPrescripcion(String prescripcion) {
		this.prescripcion = prescripcion;
	}

	public String getMetas() {
		return metas;
	}

	public void setMetas(String metas) {
		this.metas = metas;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
	
}
