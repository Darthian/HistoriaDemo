package co.edu.unal.clinica.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import co.edu.unal.clinica.hibernate.data.Habitos;
import co.edu.unal.clinica.utils.HibernateUtil;

public class HabitosDAO {
	
	private Session session;
	private List<Habitos> listHab;
	
	public List<Habitos> Listar() throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Criteria cri = session.createCriteria(Habitos.class);
			cri.addOrder(Order.asc("cedula"));
			listHab = cri.list();
		} catch (Exception ex) {
			throw ex;
		}
		return listHab;
	}
	
	public List<Habitos> Buscar(long cedula) throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			String hql = "FROM Habitos WHERE cedula = " + cedula ;
			Query query = session.createQuery(hql);

			if (!query.list().isEmpty()) {
				listHab = (List<Habitos>) query.list();
			}
			else{
				listHab = null;
			}
		} catch (Exception ex) {
			throw ex;
		}
		return listHab;
	}

}
