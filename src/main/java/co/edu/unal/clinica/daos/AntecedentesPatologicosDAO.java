package co.edu.unal.clinica.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import co.edu.unal.clinica.hibernate.data.Antecedentes_Patologicos;
import co.edu.unal.clinica.utils.HibernateUtil;

public class AntecedentesPatologicosDAO {
	
	private Session session;
	private List<Antecedentes_Patologicos> listPato;
	
	public List<Antecedentes_Patologicos> Listar() throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Criteria cri = session.createCriteria(Antecedentes_Patologicos.class);
			cri.addOrder(Order.asc("cedula"));
			listPato = cri.list();
		} catch (Exception ex) {
			throw ex;
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
		}
		return listPato;
	}

}
