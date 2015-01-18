package co.edu.unal.clinica.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import co.edu.unal.clinica.hibernate.data.Enfermedad_Actual;
import co.edu.unal.clinica.utils.HibernateUtil;

public class EnfermedadActualDAO {
	
	private Session session;
	private Transaction trans;
	private Enfermedad_Actual objetoRetornado;
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
	
	public Enfermedad_Actual BuscarPorId(long id) throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			String hql = "FROM Enfermedad_Actual WHERE id = " + id ;
			Query query = session.createQuery(hql);

			if (!query.list().isEmpty()) {
				objetoRetornado = (Enfermedad_Actual) query.list().get(0);
			}
			else{
				objetoRetornado = null;
			}
		} catch (Exception ex) {
			throw ex;
		}
		return objetoRetornado;
	}
	
	public List<Enfermedad_Actual> BuscarNoConsolidados() throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			String hql = "FROM Enfermedad_Actual WHERE CONSOLIDADO = 'No'";
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
	
	public void ConsolidarConsulta(List<Enfermedad_Actual> list) throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			trans = session.beginTransaction();
			for(Enfermedad_Actual iterator: list){
				session.update(iterator);
			}
			trans.commit();
		} catch (Exception ex) {
			trans.rollback();
			throw ex;
		} finally {
			session.close();
		}
	}
	
	public void ConsolidarConsulta(Enfermedad_Actual objetoActualizado) throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			trans = session.beginTransaction();
			session.update(objetoActualizado);
			trans.commit();
		} catch (Exception ex) {
			trans.rollback();
			throw ex;
		} finally {
			session.close();
		}
	}
	public void Modificar(Enfermedad_Actual emp) throws Exception {
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
