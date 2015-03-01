package co.edu.unal.clinica.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import co.edu.unal.clinica.hibernate.data.Valoracion_Fisioterapia;
import co.edu.unal.clinica.utils.HibernateUtil;

public class ValoracionFisioterapiaDAO {
	
	private Session session;
	private Transaction trans;
	private List<Valoracion_Fisioterapia> lstAnt;
	private Valoracion_Fisioterapia obj;
	
	public Valoracion_Fisioterapia verificarDatos(Valoracion_Fisioterapia ant) throws Exception {
		Valoracion_Fisioterapia us = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			String hql = "FROM Valoracion_Fisioterapia WHERE cedula = " + ant.getCedula() ;
			Query query = session.createQuery(hql);

			if (!query.list().isEmpty()) {
				us = (Valoracion_Fisioterapia) query.list().get(0);
			}

		} catch (Exception e) {
			throw e;
		} finally {
			session.close();
		}
		return us;
	}
	
	public List<Valoracion_Fisioterapia> Listar() throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Criteria cri = session.createCriteria(Valoracion_Fisioterapia.class);
			cri.addOrder(Order.asc("cedula"));
			lstAnt = cri.list();
		} catch (Exception ex) {
			throw ex;
		} finally {
			session.close();
		}
		return lstAnt;
	}
	
	public List<Valoracion_Fisioterapia> Buscar(long cedula) throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			String hql = "FROM Valoracion_Fisioterapia WHERE cedula = " + cedula ;
			Query query = session.createQuery(hql);

			if (!query.list().isEmpty()) {
				lstAnt = (List<Valoracion_Fisioterapia>) query.list();
			}
			else{
				lstAnt = null;
			}
		} catch (Exception ex) {
			throw ex;
		} finally {
			session.close();
		}
		return lstAnt;
	}
	
	public List<Valoracion_Fisioterapia> BuscarPorConsulta(long idConsulta) throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			String hql = "FROM Valoracion_Fisioterapia WHERE FK_CONSULTA = " + idConsulta;
			Query query = session.createQuery(hql);

			if (!query.list().isEmpty()) {
				lstAnt = (List<Valoracion_Fisioterapia>) query.list();
			}
			else{
				lstAnt = null;
			}
		} catch (Exception ex) {
			throw ex;
		} finally {
			session.close();
		}
		return lstAnt;
	}
	
	public Valoracion_Fisioterapia BuscarPorId(long id) throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			String hql = "FROM Valoracion_Fisioterapia WHERE id = " + id ;
			Query query = session.createQuery(hql);

			if (!query.list().isEmpty()) {
				obj = (Valoracion_Fisioterapia) query.list().get(0);
			}
			else{
				obj = null;
			}
		} catch (Exception ex) {
			throw ex;
		} finally {
			session.close();
		}
		return obj;
	}
	
	public List<Valoracion_Fisioterapia> BuscarNoConsolidados() throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			String hql = "FROM Valoracion_Fisioterapia WHERE CONSOLIDADO = 'No'";
			Query query = session.createQuery(hql);

			if (!query.list().isEmpty()) {
				lstAnt = (List<Valoracion_Fisioterapia>) query.list();
			}
			else{
				lstAnt = null;
			}
		} catch (Exception ex) {
			throw ex;
		} finally {
			session.close();
		}
		return lstAnt;
	}
	
	public void ConsolidarConsulta(List<Valoracion_Fisioterapia> list) throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			trans = session.beginTransaction();
			for(Valoracion_Fisioterapia iterator: list){
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
	
	public void ConsolidarConsulta(Valoracion_Fisioterapia mot) throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			trans = session.beginTransaction();
			session.update(mot);
			trans.commit();
		} catch (Exception ex) {
			trans.rollback();
			throw ex;
		} finally {
			session.close();
		}
	}
	
	public void Modificar(Valoracion_Fisioterapia emp) throws Exception {
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
