package co.edu.unal.clinica.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import co.edu.unal.clinica.hibernate.data.Antecedentes_Alergicos;
import co.edu.unal.clinica.utils.HibernateUtil;

public class AntecedentesAlergicosDAO {
	
	private Session session;
	private Transaction trans;
	private List<Antecedentes_Alergicos> lstAnt;
	private Antecedentes_Alergicos obj;
	
	public Antecedentes_Alergicos verificarDatos(Antecedentes_Alergicos ant) throws Exception {
		Antecedentes_Alergicos us = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			String hql = "FROM Antecedentes_Alergicos WHERE cedula = " + ant.getCedula() ;
			Query query = session.createQuery(hql);

			if (!query.list().isEmpty()) {
				us = (Antecedentes_Alergicos) query.list().get(0);
			}

		} catch (Exception e) {
			throw e;
		} finally {
			session.close();
		}
		return us;
	}
	
	public List<Antecedentes_Alergicos> Listar() throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Criteria cri = session.createCriteria(Antecedentes_Alergicos.class);
			cri.addOrder(Order.asc("cedula"));
			lstAnt = cri.list();
		} catch (Exception ex) {
			throw ex;
		} finally {
			session.close();
		}
		return lstAnt;
	}
	
	public List<Antecedentes_Alergicos> Buscar(long cedula) throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			String hql = "FROM Antecedentes_Alergicos WHERE cedula = " + cedula ;
			Query query = session.createQuery(hql);

			if (!query.list().isEmpty()) {
				lstAnt = (List<Antecedentes_Alergicos>) query.list();
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
	
	public List<Antecedentes_Alergicos> BuscarPorConsulta(long idConsulta) throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			String hql = "FROM Antecedentes_Alergicos WHERE FK_CONSULTA = " + idConsulta ;
			Query query = session.createQuery(hql);

			if (!query.list().isEmpty()) {
				lstAnt = (List<Antecedentes_Alergicos>) query.list();
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
	
	public Antecedentes_Alergicos BuscarPorId(long id) throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			String hql = "FROM Antecedentes_Alergicos WHERE id = " + id ;
			Query query = session.createQuery(hql);

			if (!query.list().isEmpty()) {
				obj = (Antecedentes_Alergicos) query.list().get(0);
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
	
	public List<Antecedentes_Alergicos> BuscarNoConsolidados() throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			String hql = "FROM Antecedentes_Alergicos WHERE CONSOLIDADO = 'No'";
			Query query = session.createQuery(hql);

			if (!query.list().isEmpty()) {
				lstAnt = (List<Antecedentes_Alergicos>) query.list();
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
	
	public void ConsolidarConsulta(List<Antecedentes_Alergicos> list) throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			trans = session.beginTransaction();
			for(Antecedentes_Alergicos iterator: list){
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
	
	public void ConsolidarConsulta(Antecedentes_Alergicos mot) throws Exception {
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
	
	public void Modificar(Antecedentes_Alergicos emp) throws Exception {
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
