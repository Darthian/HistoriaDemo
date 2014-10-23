package co.edu.unal.clinica.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import co.edu.unal.clinica.hibernate.data.Antecedentes_Farmacologicos;
import co.edu.unal.clinica.utils.HibernateUtil;

public class AntecedentesFarmacologicosDAO {
	
	private Session session;
	private List<Antecedentes_Farmacologicos> listFarma;

	public List<Antecedentes_Farmacologicos> Listar() throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Criteria cri = session.createCriteria(Antecedentes_Farmacologicos.class);
			cri.addOrder(Order.asc("cedula"));
			listFarma = cri.list();
		} catch (Exception ex) {
			throw ex;
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
		}
		return listFarma;
	}
}
