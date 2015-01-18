package co.edu.unal.clinica.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import co.edu.unal.clinica.hibernate.data.Otros_Antecedentes;
import co.edu.unal.clinica.hibernate.data.Paraclinicos;
import co.edu.unal.clinica.hibernate.data.Revision_Sistema;
import co.edu.unal.clinica.utils.HibernateUtil;

public class RevisionSistemaDAO {
	
	private Session session;
	private Transaction trans;
	private Revision_Sistema objetoRetornado;
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
	
	public Revision_Sistema BuscarPorId(long id) throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			String hql = "FROM Revision_Sistema WHERE id = " + id ;
			Query query = session.createQuery(hql);

			if (!query.list().isEmpty()) {
				objetoRetornado = (Revision_Sistema) query.list().get(0);
			}
			else{
				objetoRetornado = null;
			}
		} catch (Exception ex) {
			throw ex;
		}
		return objetoRetornado;
	}
	
	public List<Revision_Sistema> BuscarNoConsolidados() throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			String hql = "FROM Revision_Sistema WHERE CONSOLIDADO = 'No'";
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
	
	public void ConsolidarConsulta(List<Revision_Sistema> list) throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			trans = session.beginTransaction();
			for(Revision_Sistema iterator: list){
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
	
	public void ConsolidarConsulta(Revision_Sistema objetoActualizado) throws Exception {
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
	public void Modificar(Revision_Sistema emp) throws Exception {
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
