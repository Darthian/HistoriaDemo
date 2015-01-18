package co.edu.unal.clinica.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import co.edu.unal.clinica.hibernate.data.Diagnosticos;
import co.edu.unal.clinica.utils.HibernateUtil;

public class DiagnosticosDAO {
	
	private Session session;
	private Transaction trans;
	private Diagnosticos objetoRetornado;
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
	
	public Diagnosticos BuscarPorId(long id) throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			String hql = "FROM Diagnosticos WHERE id = " + id ;
			Query query = session.createQuery(hql);

			if (!query.list().isEmpty()) {
				objetoRetornado = (Diagnosticos) query.list().get(0);
			}
			else{
				objetoRetornado = null;
			}
		} catch (Exception ex) {
			throw ex;
		}
		return objetoRetornado;
	}
	
	public List<Diagnosticos> BuscarNoConsolidados() throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			String hql = "FROM Diagnosticos WHERE CONSOLIDADO = 'No'";
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
	
	public void ConsolidarConsulta(List<Diagnosticos> list) throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			trans = session.beginTransaction();
			for(Diagnosticos iterator: list){
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
	
	public void ConsolidarConsulta(Diagnosticos objetoActualizado) throws Exception {
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
	public void Modificar(Diagnosticos emp) throws Exception {
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
