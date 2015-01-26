package co.edu.unal.clinica.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import co.edu.unal.clinica.hibernate.data.Habitos;
import co.edu.unal.clinica.utils.HibernateUtil;

public class HabitosDAO {
	
	private Session session;
	private Transaction trans;
	private Habitos objetoRetornado;
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
	
	public List<Habitos> BuscarPorConsulta(long idConsulta) throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			String hql = "FROM Habitos WHERE FK_CONSULTA = " + idConsulta ;
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
	
	public Habitos BuscarPorId(long id) throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			String hql = "FROM Habitos WHERE id = " + id ;
			Query query = session.createQuery(hql);

			if (!query.list().isEmpty()) {
				objetoRetornado = (Habitos) query.list().get(0);
			}
			else{
				objetoRetornado = null;
			}
		} catch (Exception ex) {
			throw ex;
		}
		return objetoRetornado;
	}
	
	public List<Habitos> BuscarNoConsolidados() throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			String hql = "FROM Habitos WHERE CONSOLIDADO = 'No'";
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
	
	public void ConsolidarConsulta(List<Habitos> list) throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			trans = session.beginTransaction();
			for(Habitos iterator: list){
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
	
	public void ConsolidarConsulta(Habitos objetoActualizado) throws Exception {
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
	public void Modificar(Habitos emp) throws Exception {
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
