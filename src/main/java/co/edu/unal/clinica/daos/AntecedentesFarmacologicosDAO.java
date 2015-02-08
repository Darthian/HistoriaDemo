package co.edu.unal.clinica.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import co.edu.unal.clinica.hibernate.data.Antecedentes_Farmacologicos;
import co.edu.unal.clinica.utils.HibernateUtil;

public class AntecedentesFarmacologicosDAO {
	
	private Session session;
	private Transaction trans;
	private Antecedentes_Farmacologicos objetoRetornado;
	private List<Antecedentes_Farmacologicos> listFarma;

	public List<Antecedentes_Farmacologicos> Listar() throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Criteria cri = session.createCriteria(Antecedentes_Farmacologicos.class);
			cri.addOrder(Order.asc("cedula"));
			listFarma = cri.list();
		} catch (Exception ex) {
			throw ex;
		} finally {
			session.close();
		}
		return listFarma;
	}
	
	public List<Antecedentes_Farmacologicos> Buscar(long cedula) throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			String hql = "FROM Antecedentes_Farmacologicos WHERE cedula = " + cedula ;
			Query query = session.createQuery(hql);

			if (!query.list().isEmpty()) {
				listFarma = (List<Antecedentes_Farmacologicos>) query.list();
			}
			else{
				listFarma = null;
			}
		} catch (Exception ex) {
			throw ex;
		} finally {
			session.close();
		}
		return listFarma;
	}
	
	public List<Antecedentes_Farmacologicos> BuscarPorConsulta(long idConsulta) throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			String hql = "FROM Antecedentes_Farmacologicos WHERE FK_CONSULTA = " + idConsulta;
			Query query = session.createQuery(hql);

			if (!query.list().isEmpty()) {
				listFarma = (List<Antecedentes_Farmacologicos>) query.list();
			}
			else{
				listFarma = null;
			}
		} catch (Exception ex) {
			throw ex;
		} finally {
			session.close();
		}
		return listFarma;
	}
	
	public Antecedentes_Farmacologicos BuscarPorId(long id) throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			String hql = "FROM Antecedentes_Farmacologicos WHERE id = " + id ;
			Query query = session.createQuery(hql);

			if (!query.list().isEmpty()) {
				objetoRetornado = (Antecedentes_Farmacologicos) query.list().get(0);
			}
			else{
				objetoRetornado = null;
			}
		} catch (Exception ex) {
			throw ex;
		} finally {
			session.close();
		}
		return objetoRetornado;
	}
	
	public List<Antecedentes_Farmacologicos> BuscarNoConsolidados() throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			String hql = "FROM Antecedentes_Farmacologicos WHERE CONSOLIDADO = 'No'";
			Query query = session.createQuery(hql);

			if (!query.list().isEmpty()) {
				listFarma = (List<Antecedentes_Farmacologicos>) query.list();
			}
			else{
				listFarma = null;
			}
		} catch (Exception ex) {
			throw ex;
		} finally {
			session.close();
		}
		return listFarma;
	}
	
	public void ConsolidarConsulta(List<Antecedentes_Farmacologicos> list) throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			trans = session.beginTransaction();
			for(Antecedentes_Farmacologicos iterator: list){
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
	
	public void ConsolidarConsulta(Antecedentes_Farmacologicos mot) throws Exception {
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
	public void Modificar(Antecedentes_Farmacologicos emp) throws Exception {
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
