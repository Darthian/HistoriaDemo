package co.edu.unal.clinica.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import co.edu.unal.clinica.hibernate.data.Paraclinicos;
import co.edu.unal.clinica.utils.HibernateUtil;

public class ParaclinicosDAO {
	
	private Session session;
	private List<Paraclinicos> listPara;
	
	public List<Paraclinicos> Listar() throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Criteria cri = session.createCriteria(Paraclinicos.class);
			cri.addOrder(Order.asc("cedula"));
			listPara = cri.list();
		} catch (Exception ex) {
			throw ex;
		}
		return listPara;
	}
	
	public List<Paraclinicos> Buscar(long cedula) throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			String hql = "FROM Paraclinicos WHERE cedula = " + cedula ;
			Query query = session.createQuery(hql);

			if (!query.list().isEmpty()) {
				listPara = (List<Paraclinicos>) query.list();
			}
			else{
				listPara = null;
			}
		} catch (Exception ex) {
			throw ex;
		}
		return listPara;
	}

}
