package co.edu.unal.clinica.daos;

import java.sql.Timestamp;
import java.util.List;

import javax.xml.bind.ParseConversionEvent;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import antlr.Parser;
import co.edu.unal.clinica.hibernate.data.Paciente;
import co.edu.unal.clinica.utils.HibernateUtil;

public class PacienteDAO {
	
	private Session session;
	private Transaction trans;
	private List<Paciente> lstPacientes;	

	public Paciente verificarDatos(Paciente paciente) throws Exception {
		Paciente us = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			String hql = "FROM Paciente WHERE cedula = "
					+ paciente.getCedula() ;
			Query query = session.createQuery(hql);

			if (!query.list().isEmpty()) {
				us = (Paciente) query.list().get(0);
			}

		} catch (Exception e) {
			throw e;
		}

		return us;
	}

	public void Eliminar(Paciente paciente) throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			trans = session.beginTransaction();
			session.delete(paciente);
			trans.commit();
		} catch (Exception ex) {
			trans.rollback();
			throw ex;
		} finally {
			session.close();
		}
	}

	public void Modificar(Paciente paciente) throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			trans = session.beginTransaction();
//			System.out.println(paciente.getFecha_Nacimiento()+"FECHA ANTES");
//			paciente.setFecha_Nacimiento(new Timestamp(paciente.getFecha_Nacimiento().getTime())); 
//			System.out.println(paciente.getFecha_Nacimiento()+"FECHA DESPUES ");
			session.update(paciente);
			trans.commit();
		} catch (Exception ex) {
			trans.rollback();
			throw ex;
		} finally {
			session.close();
		}
	}

	public List<Paciente> Listar() throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Criteria cri = session.createCriteria(Paciente.class);
			//cri.addOrder(Order.asc("nombre_Paciente"));
			lstPacientes = cri.list();
		} catch (Exception ex) {
			throw ex;
		}
		return lstPacientes;
	}
	
//	public List<Paciente> Filtrar(long cedula) throws Exception {
//		try {
//			session = HibernateUtil.getSessionFactory().openSession();
//			String hql = "FROM Paciente WHERE cedula = " + cedula;
//			Query query = session.createQuery(hql);
//
//			if (!query.list().isEmpty()) {
//				lstPacientes = (List<Paciente>) query.list();
//			}
//			else{
//				lstPacientes = null;
//			}
//		} catch (Exception ex) {
//			throw ex;
//		}
//		return lstPacientes;
//	}

}
