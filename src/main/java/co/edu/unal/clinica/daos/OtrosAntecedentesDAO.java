package co.edu.unal.clinica.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import co.edu.unal.clinica.hibernate.data.Otros_Antecedentes;
import co.edu.unal.clinica.utils.HibernateUtil;

public class OtrosAntecedentesDAO {
	
	private Session session;
	private Transaction trans;
	private Otros_Antecedentes objetoRetornado;
	private List<Otros_Antecedentes> lstOAnt;
	
	public Otros_Antecedentes verificarDatos(Otros_Antecedentes oant) throws Exception {
		Otros_Antecedentes us = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			String hql = "FROM Otros_Antecedentes WHERE cedula = " + oant.getCedula() ;
			Query query = session.createQuery(hql);

			if (!query.list().isEmpty()) {
				us = (Otros_Antecedentes) query.list().get(0);
			}

		} catch (Exception e) {
			throw e;
		}
		return us;
	}
	
	public List<Otros_Antecedentes> Listar() throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Criteria cri = session.createCriteria(Otros_Antecedentes.class);
			cri.addOrder(Order.asc("cedula"));
			lstOAnt = cri.list();
		} catch (Exception ex) {
			throw ex;
		}
		return lstOAnt;
	}
	
	public List<Otros_Antecedentes> Buscar(long cedula) throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			String hql = "FROM Otros_Antecedentes WHERE cedula = " + cedula ;
			Query query = session.createQuery(hql);

			if (!query.list().isEmpty()) {
				lstOAnt = (List<Otros_Antecedentes>) query.list();
			}
			else{
				lstOAnt = null;
			}
		} catch (Exception ex) {
			throw ex;
		}
		return lstOAnt;
	}
	
	public Otros_Antecedentes BuscarPorId(long id) throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			String hql = "FROM Otros_Antecedentes WHERE id = " + id ;
			Query query = session.createQuery(hql);

			if (!query.list().isEmpty()) {
				objetoRetornado = (Otros_Antecedentes) query.list().get(0);
			}
			else{
				objetoRetornado = null;
			}
		} catch (Exception ex) {
			throw ex;
		}
		return objetoRetornado;
	}
	
	public List<Otros_Antecedentes> BuscarNoConsolidados() throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			String hql = "FROM Otros_Antecedentes WHERE CONSOLIDADO = 'No'";
			Query query = session.createQuery(hql);

			if (!query.list().isEmpty()) {
				lstOAnt = (List<Otros_Antecedentes>) query.list();
			}
			else{
				lstOAnt = null;
			}
		} catch (Exception ex) {
			throw ex;
		}
		return lstOAnt;
	}
	
	public void ConsolidarConsulta(List<Otros_Antecedentes> list) throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			trans = session.beginTransaction();
			for(Otros_Antecedentes iterator: list){
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
	
	public void ConsolidarConsulta(Otros_Antecedentes objetoActualizado) throws Exception {
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
	public void Modificar(Otros_Antecedentes emp) throws Exception {
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
