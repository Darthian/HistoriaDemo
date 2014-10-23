package co.edu.unal.clinica.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import co.edu.unal.clinica.hibernate.data.Antecedentes_Familiares;
import co.edu.unal.clinica.utils.HibernateUtil;

public class AntecedentesFamiliaresDAO {
	
	private Session session;
	private List<Antecedentes_Familiares> lstAnt;
	
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
		}
		return lstAnt;
	}
}
