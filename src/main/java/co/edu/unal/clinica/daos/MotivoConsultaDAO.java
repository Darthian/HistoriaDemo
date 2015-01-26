package co.edu.unal.clinica.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import co.edu.unal.clinica.hibernate.data.Motivo_Consulta;
import co.edu.unal.clinica.utils.HibernateUtil;

public class MotivoConsultaDAO {
	
	private Session session;
	private Transaction trans;
	private List<Motivo_Consulta> listMot;
	private Motivo_Consulta mot;
	
	public List<Motivo_Consulta> Listar() throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Criteria cri = session.createCriteria(Motivo_Consulta.class);
			cri.addOrder(Order.asc("cedula"));
			listMot = cri.list();
		} catch (Exception ex) {
			throw ex;
		}
		return listMot;
	}
	
	public List<Motivo_Consulta> Buscar(long cedula) throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			String hql = "FROM Motivo_Consulta WHERE cedula = " + cedula ;
			Query query = session.createQuery(hql);

			if (!query.list().isEmpty()) {
				listMot = (List<Motivo_Consulta>) query.list();
			}
			else{
				listMot = null;
			}
		} catch (Exception ex) {
			throw ex;
		}
		return listMot;
	}
	
	public List<Motivo_Consulta> BuscarPorConsulta(long idConsulta) throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			String hql = "FROM Motivo_Consulta WHERE FK_CONSULTA = " + idConsulta ;
			Query query = session.createQuery(hql);

			if (!query.list().isEmpty()) {
				listMot = (List<Motivo_Consulta>) query.list();
			}
			else{
				listMot = null;
			}
		} catch (Exception ex) {
			throw ex;
		}
		return listMot;
	}
	
	public List<Motivo_Consulta> BuscarNoConsolidados() throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			String hql = "FROM Motivo_Consulta WHERE CONSOLIDADO = 'No'";
			Query query = session.createQuery(hql);

			if (!query.list().isEmpty()) {
				listMot = (List<Motivo_Consulta>) query.list();
			}
			else{
				listMot = null;
			}
		} catch (Exception ex) {
			throw ex;
		}
		return listMot;
	}
	
	public Motivo_Consulta BuscarPorId(long id) throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			String hql = "FROM Motivo_Consulta WHERE id = " + id ;
			Query query = session.createQuery(hql);

			if (!query.list().isEmpty()) {
				mot = (Motivo_Consulta) query.list().get(0);
			}
			else{
				mot = null;
			}
		} catch (Exception ex) {
			throw ex;
		}
		return mot;
	}
	
	public void ConsolidarConsulta(Motivo_Consulta mot) throws Exception {
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
	
	public void ConsolidarConsulta(List<Motivo_Consulta> listMot) throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			trans = session.beginTransaction();
			for(Motivo_Consulta iterator: listMot){
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
	
	public void Modificar(Motivo_Consulta emp) throws Exception {
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
