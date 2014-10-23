package co.edu.unal.clinica.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import co.edu.unal.clinica.hibernate.data.Examen_Fisico;
import co.edu.unal.clinica.utils.HibernateUtil;

public class ExamenFisicoDAO {
	
	private Session session;
	private List<Examen_Fisico> listExa;
	
	public List<Examen_Fisico> Listar() throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Criteria cri = session.createCriteria(Examen_Fisico.class);
			cri.addOrder(Order.asc("cedula"));
			listExa = cri.list();
		} catch (Exception ex) {
			throw ex;
		}
		return listExa;
	}
	
	public List<Examen_Fisico> Buscar(long cedula) throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			String hql = "FROM Examen_Fisico WHERE cedula = " + cedula ;
			Query query = session.createQuery(hql);

			if (!query.list().isEmpty()) {
				listExa = (List<Examen_Fisico>) query.list();
			}
			else{
				listExa = null;
			}
		} catch (Exception ex) {
			throw ex;
		}
		return listExa;
	}

}
