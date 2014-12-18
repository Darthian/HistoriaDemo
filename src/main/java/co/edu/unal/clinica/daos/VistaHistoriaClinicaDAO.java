package co.edu.unal.clinica.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

import co.edu.unal.clinica.hibernate.data.Vista_total_historia;
import co.edu.unal.clinica.utils.HibernateUtil;

public class VistaHistoriaClinicaDAO {
	
	private Session session;
	private List<Vista_total_historia> lstVistaTotalHistoria;
	
	public List<Vista_total_historia> Listar() throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Criteria cri = session.createCriteria(Vista_total_historia.class);
			//cri.addOrder(Order.asc("nombre_Paciente"));
			lstVistaTotalHistoria = cri.list();
		} catch (Exception ex) {
			throw ex;
		}
		return lstVistaTotalHistoria;
	}
	
	public List<Vista_total_historia> BuscarPorCedula(long cedula) throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			String hql = "FROM Vista_total_historia WHERE CEDULA = " + cedula;
			Query query = session.createQuery(hql);

			if (!query.list().isEmpty()) {
				lstVistaTotalHistoria = (List<Vista_total_historia>) query.list();
			}
			else{
				lstVistaTotalHistoria = null;
			}
		} catch (Exception ex) {
			throw ex;
		}
		return lstVistaTotalHistoria;
	}
}
