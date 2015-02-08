package co.edu.unal.clinica.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import co.edu.unal.clinica.hibernate.data.Antecedentes_Transfusionales;
import co.edu.unal.clinica.utils.HibernateUtil;

public class AntecedentesTransfusionalesDAO {
	
	private Session session;
	private Transaction trans;
	private List<Antecedentes_Transfusionales> lstAnt;
	private Antecedentes_Transfusionales obj;
	
	public Antecedentes_Transfusionales verificarDatos(Antecedentes_Transfusionales ant) throws Exception {
		Antecedentes_Transfusionales us = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			String hql = "FROM Antecedentes_Transfusionales WHERE cedula = " + ant.getCedula() ;
			Query query = session.createQuery(hql);

			if (!query.list().isEmpty()) {
				us = (Antecedentes_Transfusionales) query.list().get(0);
			}

		} catch (Exception e) {
			throw e;
		} finally {
			session.close();
		}
		return us;
	}
	
	public List<Antecedentes_Transfusionales> Listar() throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Criteria cri = session.createCriteria(Antecedentes_Transfusionales.class);
			cri.addOrder(Order.asc("cedula"));
			lstAnt = cri.list();
		} catch (Exception ex) {
			throw ex;
		} finally {
			session.close();
		}
		return lstAnt;
	}
	
	public List<Antecedentes_Transfusionales> Buscar(long cedula) throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			String hql = "FROM Antecedentes_Transfusionales WHERE cedula = " + cedula ;
			Query query = session.createQuery(hql);

			if (!query.list().isEmpty()) {
				lstAnt = (List<Antecedentes_Transfusionales>) query.list();
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
	
	public List<Antecedentes_Transfusionales> BuscarPorConsulta(long idConsulta) throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			String hql = "FROM Antecedentes_Transfusionales WHERE FK_CONSULTA = " + idConsulta;
			Query query = session.createQuery(hql);

			if (!query.list().isEmpty()) {
				lstAnt = (List<Antecedentes_Transfusionales>) query.list();
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
	
	public Antecedentes_Transfusionales BuscarPorId(long id) throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			String hql = "FROM Antecedentes_Transfusionales WHERE id = " + id ;
			Query query = session.createQuery(hql);

			if (!query.list().isEmpty()) {
				obj = (Antecedentes_Transfusionales) query.list().get(0);
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
	
	public List<Antecedentes_Transfusionales> BuscarNoConsolidados() throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			String hql = "FROM Antecedentes_Transfusionales WHERE CONSOLIDADO = 'No'";
			Query query = session.createQuery(hql);

			if (!query.list().isEmpty()) {
				lstAnt = (List<Antecedentes_Transfusionales>) query.list();
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
	
	public void ConsolidarConsulta(List<Antecedentes_Transfusionales> list) throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			trans = session.beginTransaction();
			for(Antecedentes_Transfusionales iterator: list){
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
	
	public void ConsolidarConsulta(Antecedentes_Transfusionales mot) throws Exception {
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
	
	public void Modificar(Antecedentes_Transfusionales emp) throws Exception {
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
