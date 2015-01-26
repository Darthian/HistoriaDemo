package co.edu.unal.clinica.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import co.edu.unal.clinica.hibernate.data.Antecedentes_Quirurgicos;
import co.edu.unal.clinica.utils.HibernateUtil;

public class AntecedentesQuirurgicosDAO {
	
	private Session session;
	private Transaction trans;
	private List<Antecedentes_Quirurgicos> lstAnt;
	private Antecedentes_Quirurgicos obj;
	
	public Antecedentes_Quirurgicos verificarDatos(Antecedentes_Quirurgicos ant) throws Exception {
		Antecedentes_Quirurgicos us = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			String hql = "FROM Antecedentes_Quirurgicos WHERE cedula = " + ant.getCedula() ;
			Query query = session.createQuery(hql);

			if (!query.list().isEmpty()) {
				us = (Antecedentes_Quirurgicos) query.list().get(0);
			}

		} catch (Exception e) {
			throw e;
		}
		return us;
	}
	
	public List<Antecedentes_Quirurgicos> Listar() throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Criteria cri = session.createCriteria(Antecedentes_Quirurgicos.class);
			cri.addOrder(Order.asc("cedula"));
			lstAnt = cri.list();
		} catch (Exception ex) {
			throw ex;
		}
		return lstAnt;
	}
	
	public List<Antecedentes_Quirurgicos> Buscar(long cedula) throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			String hql = "FROM Antecedentes_Quirurgicos WHERE cedula = " + cedula ;
			Query query = session.createQuery(hql);

			if (!query.list().isEmpty()) {
				lstAnt = (List<Antecedentes_Quirurgicos>) query.list();
			}
			else{
				lstAnt = null;
			}
		} catch (Exception ex) {
			throw ex;
		}
		return lstAnt;
	}
	
	public List<Antecedentes_Quirurgicos> BuscarPorConsulta(long idConsulta) throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			String hql = "FROM Antecedentes_Quirurgicos WHERE FK_CONSULTA = " + idConsulta;
			Query query = session.createQuery(hql);

			if (!query.list().isEmpty()) {
				lstAnt = (List<Antecedentes_Quirurgicos>) query.list();
			}
			else{
				lstAnt = null;
			}
		} catch (Exception ex) {
			throw ex;
		}
		return lstAnt;
	}
	
	public Antecedentes_Quirurgicos BuscarPorId(long id) throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			String hql = "FROM Antecedentes_Quirurgicos WHERE id = " + id ;
			Query query = session.createQuery(hql);

			if (!query.list().isEmpty()) {
				obj = (Antecedentes_Quirurgicos) query.list().get(0);
			}
			else{
				obj = null;
			}
		} catch (Exception ex) {
			throw ex;
		}
		return obj;
	}
	
	public List<Antecedentes_Quirurgicos> BuscarNoConsolidados() throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			String hql = "FROM Antecedentes_Quirurgicos WHERE CONSOLIDADO = 'No'";
			Query query = session.createQuery(hql);

			if (!query.list().isEmpty()) {
				lstAnt = (List<Antecedentes_Quirurgicos>) query.list();
			}
			else{
				lstAnt = null;
			}
		} catch (Exception ex) {
			throw ex;
		}
		return lstAnt;
	}
	
	public void ConsolidarConsulta(List<Antecedentes_Quirurgicos> list) throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			trans = session.beginTransaction();
			for(Antecedentes_Quirurgicos iterator: list){
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
	
	public void ConsolidarConsulta(Antecedentes_Quirurgicos mot) throws Exception {
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
	
	public void Modificar(Antecedentes_Quirurgicos emp) throws Exception {
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
