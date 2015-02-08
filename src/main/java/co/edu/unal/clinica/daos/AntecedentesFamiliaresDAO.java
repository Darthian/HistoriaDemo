package co.edu.unal.clinica.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.Transaction;

import co.edu.unal.clinica.hibernate.data.Antecedentes_Familiares;
import co.edu.unal.clinica.utils.HibernateUtil;


public class AntecedentesFamiliaresDAO {
	
	private Session session;
	private Transaction trans;
	private List<Antecedentes_Familiares> lstAnt;
	private Antecedentes_Familiares obj;
	
	public Antecedentes_Familiares verificarDatos(Antecedentes_Familiares ant) throws Exception {
		Antecedentes_Familiares us = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			String hql = "FROM Antecedentes_Familiares WHERE cedula = " + ant.getCedula() ;
			Query query = session.createQuery(hql);

			if (!query.list().isEmpty()) {
				us = (Antecedentes_Familiares) query.list().get(0);
			}

		} catch (Exception e) {
			throw e;
		} finally {
			session.close();
		}
		return us;
	}
	
	public List<Antecedentes_Familiares> Listar() throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Criteria cri = session.createCriteria(Antecedentes_Familiares.class);
			cri.addOrder(Order.asc("cedula"));
			lstAnt = cri.list();
		} catch (Exception ex) {
			throw ex;
		} finally {
			session.close();
		}
		return lstAnt;
	}
	
	public List<Antecedentes_Familiares> Buscar(long cedula) throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			String hql = "FROM Antecedentes_Familiares WHERE cedula = " + cedula ;
			Query query = session.createQuery(hql);

			if (!query.list().isEmpty()) {
				lstAnt = (List<Antecedentes_Familiares>) query.list();
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
	
	public List<Antecedentes_Familiares> BuscarPorConsulta(long idConsulta) throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			String hql = "FROM Antecedentes_Familiares WHERE FK_CONSULTA = " + idConsulta;
			Query query = session.createQuery(hql);

			if (!query.list().isEmpty()) {
				lstAnt = (List<Antecedentes_Familiares>) query.list();
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
	
	public Antecedentes_Familiares BuscarPorId(long id) throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			String hql = "FROM Antecedentes_Familiares WHERE id = " + id ;
			Query query = session.createQuery(hql);

			if (!query.list().isEmpty()) {
				obj = (Antecedentes_Familiares) query.list().get(0);
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
	
	public List<Antecedentes_Familiares> BuscarNoConsolidados() throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			String hql = "FROM Antecedentes_Familiares WHERE CONSOLIDADO = 'No'";
			Query query = session.createQuery(hql);

			if (!query.list().isEmpty()) {
				lstAnt = (List<Antecedentes_Familiares>) query.list();
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
	
	public void ConsolidarConsulta(List<Antecedentes_Familiares> list) throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			trans = session.beginTransaction();
			for(Antecedentes_Familiares iterator: list){
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
	
	public void ConsolidarConsulta(Antecedentes_Familiares mot) throws Exception {
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
	
	public void Modificar(Antecedentes_Familiares emp) throws Exception {
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
