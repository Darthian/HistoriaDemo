package co.edu.unal.clinica.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import co.edu.unal.clinica.hibernate.data.Revision_Sistema;
import co.edu.unal.clinica.utils.HibernateUtil;

public class RevisionSistemaDAO {
	
	private Session session;
	private List<Revision_Sistema> listRevi;
	
	public List<Revision_Sistema> Listar() throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Criteria cri = session.createCriteria(Revision_Sistema.class);
			cri.addOrder(Order.asc("cedula"));
			listRevi = cri.list();
		} catch (Exception ex) {
			throw ex;
		}
		return listRevi;
	}
	
	public List<Revision_Sistema> Buscar(long cedula) throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			String hql = "FROM Revision_Sistema WHERE cedula = " + cedula ;
			Query query = session.createQuery(hql);

			if (!query.list().isEmpty()) {
				listRevi = (List<Revision_Sistema>) query.list();
			}
			else{
				listRevi = null;
			}
		} catch (Exception ex) {
			throw ex;
		}
		return listRevi;
	}

}
