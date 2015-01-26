package co.edu.unal.clinica.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

import co.edu.unal.clinica.hibernate.data.Consulta;
import co.edu.unal.clinica.utils.HibernateUtil;

public class ConsultaDAO {
	
	private Session session;
	private List<Consulta> lstAnt;
	private Consulta obj;
	
	public Consulta verificarDatos(Consulta ant) throws Exception {
		Consulta us = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			String hql = "FROM Consulta WHERE cedula = " + ant.getCedula() ;
			Query query = session.createQuery(hql);

			if (!query.list().isEmpty()) {
				us = (Consulta) query.list().get(0);
			}

		} catch (Exception e) {
			throw e;
		}
		return us;
	}
	
	public List<Consulta> Listar() throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Criteria cri = session.createCriteria(Consulta.class);
//			cri.addOrder(Order.asc("cedula"));
			lstAnt = cri.list();
		} catch (Exception ex) {
			throw ex;
		}
		return lstAnt;
	}
	
	public List<Consulta> Buscar(long cedula) throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			String hql = "FROM Consulta WHERE cedula = " + cedula ;
			Query query = session.createQuery(hql);

			if (!query.list().isEmpty()) {
				lstAnt = (List<Consulta>) query.list();
			}
			else{
				lstAnt = null;
			}
		} catch (Exception ex) {
			throw ex;
		}
		return lstAnt;
	}
	
	public List<Consulta> BuscarPorTipoConsulta(String tipoConsulta) throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			String hql = "FROM Consulta WHERE TIPO_CONSULTA = " + tipoConsulta;
			Query query = session.createQuery(hql);

			if (!query.list().isEmpty()) {
				lstAnt = (List<Consulta>) query.list();
			}
			else{
				lstAnt = null;
			}
		} catch (Exception ex) {
			throw ex;
		}
		return lstAnt;
	}
	
	public Consulta BuscarPorId(long id) throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			String hql = "FROM Consulta WHERE id = " + id ;
			Query query = session.createQuery(hql);

			if (!query.list().isEmpty()) {
				obj = (Consulta) query.list().get(0);
			}
			else{
				obj = null;
			}
		} catch (Exception ex) {
			throw ex;
		}
		return obj;
	}

}
