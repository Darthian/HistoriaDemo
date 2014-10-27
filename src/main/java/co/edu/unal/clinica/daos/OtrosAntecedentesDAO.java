package co.edu.unal.clinica.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import co.edu.unal.clinica.hibernate.data.Otros_Antecedentes;
import co.edu.unal.clinica.utils.HibernateUtil;

public class OtrosAntecedentesDAO {
	
	private Session session;
	private List<Otros_Antecedentes> lstOAnt;
	
	public Otros_Antecedentes verificarDatos(Otros_Antecedentes oant) throws Exception {
		Otros_Antecedentes us = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			String hql = "FROM Otros_Antecedentes WHERE cedula = " + oant.getCedula() ;
			Query query = session.createQuery(hql);

			if (!query.list().isEmpty()) {
				us = (Otros_Antecedentes) query.list().get(0);
			}

		} catch (Exception e) {
			throw e;
		}
		return us;
	}
	
	public List<Otros_Antecedentes> Listar() throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Criteria cri = session.createCriteria(Otros_Antecedentes.class);
			cri.addOrder(Order.asc("cedula"));
			lstOAnt = cri.list();
		} catch (Exception ex) {
			throw ex;
		}
		return lstOAnt;
	}
	
	public List<Otros_Antecedentes> Buscar(long cedula) throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			String hql = "FROM Otros_Antecedentes WHERE cedula = " + cedula ;
			Query query = session.createQuery(hql);

			if (!query.list().isEmpty()) {
				lstOAnt = (List<Otros_Antecedentes>) query.list();
			}
			else{
				lstOAnt = null;
			}
		} catch (Exception ex) {
			throw ex;
		}
		return lstOAnt;
	}

}
