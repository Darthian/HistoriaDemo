package co.edu.unal.clinica.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import co.edu.unal.clinica.hibernate.data.Enfermedad_Actual;
import co.edu.unal.clinica.utils.HibernateUtil;

public class EnfermedadActualDAO {
	
	private Session session;
	private List<Enfermedad_Actual> listEnf;
	
	public List<Enfermedad_Actual> Listar() throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Criteria cri = session.createCriteria(Enfermedad_Actual.class);
			cri.addOrder(Order.asc("cedula"));
			listEnf = cri.list();
		} catch (Exception ex) {
			throw ex;
		}
		return listEnf;
	}
	
	public List<Enfermedad_Actual> Buscar(long cedula) throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			String hql = "FROM Enfermedad_Actual WHERE cedula = " + cedula ;
			Query query = session.createQuery(hql);

			if (!query.list().isEmpty()) {
				listEnf = (List<Enfermedad_Actual>) query.list();
			}
			else{
				listEnf = null;
			}
		} catch (Exception ex) {
			throw ex;
		}
		return listEnf;
	}
}
