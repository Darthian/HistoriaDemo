package co.edu.unal.clinica.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import co.edu.unal.clinica.hibernate.data.Entidad;
import co.edu.unal.clinica.utils.HibernateUtil;

public class EntidadDAO {
	
	private Session session;
	private Transaction trans;
	private List<Entidad> listEntidades;
	
	public List<Entidad> Listar() throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Criteria cri = session.createCriteria(Entidad.class);
//			cri.addOrder(Order.asc("nombre"));
			listEntidades = cri.list();
		} catch (Exception ex) {
			throw ex;
		}
		return listEntidades;
	}
	
	public List<Entidad> Buscar(long id) throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			String hql = "FROM Entidad WHERE id = " + id ;
			Query query = session.createQuery(hql);

			if (!query.list().isEmpty()) {
				listEntidades = (List<Entidad>) query.list();
			}
			else{
				listEntidades = null;
			}
		} catch (Exception ex) {
			throw ex;
		}
		return listEntidades;
	}
	
	public void Modificar(Entidad emp) throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			trans = session.beginTransaction();
			session.update(emp);
			trans.commit();
		} catch (Exception ex) {
			trans.rollback();
			throw ex;
		} finally {
			session.close();
		}
	}
}
