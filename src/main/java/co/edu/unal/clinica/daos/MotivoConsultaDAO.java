package co.edu.unal.clinica.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import co.edu.unal.clinica.hibernate.data.Motivo_Consulta;
import co.edu.unal.clinica.utils.HibernateUtil;

public class MotivoConsultaDAO {
	
	private Session session;
	private List<Motivo_Consulta> listMot;
	
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

}
