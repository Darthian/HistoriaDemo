package co.edu.unal.clinica.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import co.edu.unal.clinica.hibernate.data.Antecedentes_Patologicos;
import co.edu.unal.clinica.utils.HibernateUtil;

public class AntecedentesPatologicosDAO {
	
	private Session session;
	private Transaction trans;
	private Antecedentes_Patologicos objetoRetornado; 
	private List<Antecedentes_Patologicos> listPato;
	
	public List<Antecedentes_Patologicos> Listar() throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Criteria cri = session.createCriteria(Antecedentes_Patologicos.class);
			cri.addOrder(Order.asc("cedula"));
			listPato = cri.list();
		} catch (Exception ex) {
			throw ex;
		} finally {
			session.close();
		}
		return listPato;
	}
	
	public List<Antecedentes_Patologicos> Buscar(long cedula) throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			String hql = "FROM Antecedentes_Patologicos WHERE cedula = " + cedula ;
			Query query = session.createQuery(hql);

			if (!query.list().isEmpty()) {
				listPato = (List<Antecedentes_Patologicos>) query.list();
			}
			else{
				listPato = null;
			}
		} catch (Exception ex) {
			throw ex;
		} finally {
			session.close();
		}
		return listPato;
	}
	
	public List<Antecedentes_Patologicos> BuscarPorConsulta(long idConsulta) throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			String hql = "FROM Antecedentes_Patologicos WHERE FK_CONSULTA = " + idConsulta ;
			Query query = session.createQuery(hql);

			if (!query.list().isEmpty()) {
				listPato = (List<Antecedentes_Patologicos>) query.list();
			}
			else{
				listPato = null;
			}
		} catch (Exception ex) {
			throw ex;
		} finally {
			session.close();
		}
		return listPato;
	}
	
	public Antecedentes_Patologicos BuscarPorId(long id) throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			String hql = "FROM Antecedentes_Patologicos WHERE id = " + id ;
			Query query = session.createQuery(hql);

			if (!query.list().isEmpty()) {
				objetoRetornado = (Antecedentes_Patologicos) query.list().get(0);
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
	
	public List<Antecedentes_Patologicos> BuscarNoConsolidados() throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			String hql = "FROM Antecedentes_Patologicos WHERE CONSOLIDADO = 'No'";
			Query query = session.createQuery(hql);

			if (!query.list().isEmpty()) {
				listPato = (List<Antecedentes_Patologicos>) query.list();
			}
			else{
				listPato = null;
			}
		} catch (Exception ex) {
			throw ex;
		} finally {
			session.close();
		}
		return listPato;
	}
	
	public void ConsolidarConsulta(List<Antecedentes_Patologicos> list) throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			trans = session.beginTransaction();
			for(Antecedentes_Patologicos iterator: list){
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
	
	public void ConsolidarConsulta(Antecedentes_Patologicos objetoActualizado) throws Exception {
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
	
	public void Modificar(Antecedentes_Patologicos emp) throws Exception {
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
