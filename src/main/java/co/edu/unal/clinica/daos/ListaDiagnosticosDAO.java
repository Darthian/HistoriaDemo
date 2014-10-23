package co.edu.unal.clinica.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import co.edu.unal.clinica.hibernate.data.Lista_Diagnosticos;
import co.edu.unal.clinica.hibernate.data.Usuario;
import co.edu.unal.clinica.utils.HibernateUtil;

public class ListaDiagnosticosDAO {
	
	private Session session;
	private Transaction trans;
	private List<Lista_Diagnosticos> listEnf;
	
	public List<Lista_Diagnosticos> Listar() throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Criteria cri = session.createCriteria(Lista_Diagnosticos.class);
			cri.addOrder(Order.asc("codigo"));
			listEnf = cri.list();
		} catch (Exception ex) {
			throw ex;
		}
		return listEnf;
	}
	
	public List<Lista_Diagnosticos> Buscar(long codigo) throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			String hql = "FROM Lista_Diagnosticos WHERE codigo = " + codigo ;
			Query query = session.createQuery(hql);

			if (!query.list().isEmpty()) {
				listEnf = (List<Lista_Diagnosticos>) query.list();
			}
			else{
				listEnf = null;
			}
		} catch (Exception ex) {
			throw ex;
		}
		return listEnf;
	}
	
	public void Modificar(Lista_Diagnosticos emp) throws Exception {
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
