package co.edu.unal.clinica.mb;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.*;
import javax.servlet.http.*;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import co.edu.unal.clinica.daos.PacienteDAO;
import co.edu.unal.clinica.daos.VistaHistoriaClinicaDAO;
import co.edu.unal.clinica.hibernate.data.Paciente;
import co.edu.unal.clinica.hibernate.data.Vista_total_historia;

@ManagedBean(name="jasperController")
@SessionScoped
public class JasperController {
	
	private PacienteDAO pacienteDAO = new PacienteDAO();
	private List<Paciente> listaPaciente;
	
	private VistaHistoriaClinicaDAO vistaHistoriaDao = new VistaHistoriaClinicaDAO();
	
	private List<Vista_total_historia> listaVistaHistoriaPrimeraVez;
	
	private JasperPrint jasperPrint;

	public List<Paciente> getListaPaciente() throws Exception {
		this.listaPaciente = pacienteDAO.Listar();
		return listaPaciente;
	}
	
	public void init() throws JRException{
		try{
			this.listaPaciente = pacienteDAO.Listar();
			System.out.println("Se cargo la lista"+this.listaPaciente);
		}catch(Exception e){
			System.out.println("Ha fallado el llamado al reporte");
			e.printStackTrace();
		}
		JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(this.listaPaciente);
		String reportPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("reports/report.jasper");
		jasperPrint = JasperFillManager.fillReport(reportPath, new HashMap(), beanCollectionDataSource);
	}
	
	public void initHistoria(long idConsulta) throws JRException{
		try{
			this.listaVistaHistoriaPrimeraVez = vistaHistoriaDao.BuscarIdConsulta(idConsulta);
			System.out.println("Se cargo la lista "+this.listaVistaHistoriaPrimeraVez+" de la consulta con id "+idConsulta);
		}catch(Exception e){
			System.out.println("Ha fallado el llamado al reporte");
			e.printStackTrace();
		}
		JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(this.listaVistaHistoriaPrimeraVez);
		String reportPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("reports/HistoriaClinica.jasper");
		jasperPrint = JasperFillManager.fillReport(reportPath, new HashMap(), beanCollectionDataSource);
	}
	
	public void PDF() throws JRException, IOException{
		init();
		HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
		httpServletResponse.addHeader("Content-disposition", "attachment; filename=report.pdf");
		ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
		JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
		FacesContext.getCurrentInstance().responseComplete();
	}
	
	public void vistaHistoriaPDF(long idConsulta) throws JRException, IOException{
		initHistoria(idConsulta);
		HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
		httpServletResponse.addHeader("Content-disposition", "attachment; filename=HistoriaClinica.pdf");
		ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
		JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
		FacesContext.getCurrentInstance().responseComplete();
	}

}
