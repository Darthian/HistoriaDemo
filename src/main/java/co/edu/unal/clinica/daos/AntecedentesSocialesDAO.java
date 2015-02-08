package co.edu.unal.clinica.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import co.edu.unal.clinica.hibernate.data.Antecedentes_Sociales;
import co.edu.unal.clinica.utils.HibernateUtil;

public class AntecedentesSocialesDAO {
	
	private Session session;
	private Transaction trans;
	private List<Antecedentes_Sociales> lstSoc;
	private Antecedentes_Sociales obj;
	
	public Antecedentes_Sociales verificarDatos(Antecedentes_Sociales ant) throws Exception {
		Antecedentes_Sociales us = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			String hql = "FROM Antecedentes_Sociales WHERE cedula = " + ant.getCedula() ;
			Query query = session.createQuery(hql);

			if (!query.list().isEmpty()) {
				us = (Antecedentes_Sociales) query.list().get(0);
			}

		} catch (Exception e) {
			throw e;
		} finally {
			session.close();
		}
		return us;
	}
	
	public List<Antecedentes_Sociales> Listar() throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Criteria cri = session.createCriteria(Antecedentes_Sociales.class);
			cri.addOrder(Order.asc("cedula"));
			lstSoc = cri.list();
		} catch (Exception ex) {
			throw ex;
		} finally {
			session.close();
		}
		return lstSoc;
	}
	
	public List<Antecedentes_Sociales> Buscar(long cedula) throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			String hql = "FROM Antecedentes_Sociales WHERE cedula = " + cedula ;
			Query query = session.createQuery(hql);

			if (!query.list().isEmpty()) {
				lstSoc = (List<Antecedentes_Sociales>) query.list();
			}
			else{
				lstSoc = null;
			}
		} catch (Exception ex) {
			throw ex;
		} finally {
			session.close();
		}
		return lstSoc;
	}
	
	public List<Antecedentes_Sociales> BuscarPorConsulta(long idConsulta) throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			String hql = "FROM Antecedentes_Sociales WHERE FK_CONSULTA = " + idConsulta;
			Query query = session.createQuery(hql);

			if (!query.list().isEmpty()) {
				lstSoc = (List<Antecedentes_Sociales>) query.list();
			}
			else{
				lstSoc = null;
			}
		} catch (Exception ex) {
			throw ex;
		} finally {
			session.close();
		}
		return lstSoc;
	}
	
	public Antecedentes_Sociales BuscarPorId(long id) throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			String hql = "FROM Antecedentes_Sociales WHERE id = " + id ;
			Query query = session.createQuery(hql);

			if (!query.list().isEmpty()) {
				obj = (Antecedentes_Sociales) query.list().get(0);
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
	
	public List<Antecedentes_Sociales> BuscarNoConsolidados() throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			String hql = "FROM Antecedentes_Sociales WHERE CONSOLIDADO = 'No'";
			Query query = session.createQuery(hql);

			if (!query.list().isEmpty()) {
				lstSoc = (List<Antecedentes_Sociales>) query.list();
			}
			else{
				lstSoc = null;
			}
		} catch (Exception ex) {
			throw ex;
		} finally {
			session.close();
		}
		return lstSoc;
	}
	
	public void ConsolidarConsulta(List<Antecedentes_Sociales> list) throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			trans = session.beginTransaction();
			for(Antecedentes_Sociales iterator: list){
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
	
	public void ConsolidarConsulta(Antecedentes_Sociales mot) throws Exception {
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
	
	public void Modificar(Antecedentes_Sociales emp) throws Exception {
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
