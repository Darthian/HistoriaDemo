package co.edu.unal.clinica.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import co.edu.unal.clinica.hibernate.data.Diagnosticos;
import co.edu.unal.clinica.utils.HibernateUtil;

public class DiagnosticosDAO {
	
	private Session session;
	private List<Diagnosticos> listDiag;
	
	public List<Diagnosticos> Listar() throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Criteria cri = session.createCriteria(Diagnosticos.class);
			cri.addOrder(Order.asc("cedula"));
			listDiag = cri.list();
		} catch (Exception ex) {
			throw ex;
		}
		return listDiag;
	}
	
	public List<Diagnosticos> Buscar(long cedula) throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			String hql = "FROM Diagnosticos WHERE cedula = " + cedula ;
			Query query = session.createQuery(hql);

			if (!query.list().isEmpty()) {
				listDiag = (List<Diagnosticos>) query.list();
			}
			else{
				listDiag = null;
			}
		} catch (Exception ex) {
			throw ex;
		}
		return listDiag;
	}

}
