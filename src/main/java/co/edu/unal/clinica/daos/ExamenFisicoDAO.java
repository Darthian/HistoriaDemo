package co.edu.unal.clinica.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import co.edu.unal.clinica.hibernate.data.Examen_Fisico;
import co.edu.unal.clinica.utils.HibernateUtil;

public class ExamenFisicoDAO {
	
	private Session session;
	private Transaction trans;
	private Examen_Fisico objetoRetornado;
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
	
	public Examen_Fisico BuscarPorId(long id) throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			String hql = "FROM Examen_Fisico WHERE id = " + id ;
			Query query = session.createQuery(hql);

			if (!query.list().isEmpty()) {
				objetoRetornado = (Examen_Fisico) query.list().get(0);
			}
			else{
				objetoRetornado = null;
			}
		} catch (Exception ex) {
			throw ex;
		}
		return objetoRetornado;
	}
	
	public void ConsolidarConsulta(Examen_Fisico objetoActualizado) throws Exception {
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
	public void Modificar(Examen_Fisico emp) throws Exception {
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
