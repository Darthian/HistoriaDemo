package co.edu.unal.clinica.daos;

import java.util.HashMap;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
			String hql = "FROM Paciente WHERE cedula = " + paciente.getCedula() ;
			Query query = session.createQuery(hql);

			if (!query.list().isEmpty()) {
				us = (Paciente) query.list().get(0);
			}

		} catch (Exception e) {
			throw e;
		} finally {
			session.close();
		}
		return us;
	}

	public void Eliminar(Paciente paciente) throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			trans = session.beginTransaction();
			session.delete(paciente);
			trans.commit();
			session.close();
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
		} finally {
			session.close();
		}
		return lstPacientes;
	}
	
	public List<Paciente> BuscarPaciente(long cedula) throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			String hql = "FROM Paciente WHERE cedula = " + cedula;
			Query query = session.createQuery(hql);

			if (!query.list().isEmpty()) {
				lstPacientes = (List<Paciente>) query.list();
			}
			else{
				lstPacientes = null;
			}
		} catch (Exception ex) {
			throw ex;
		} finally {
			session.close();
		}
		return lstPacientes;
	}
	
	public List<Paciente> BuscarPorFiltro(String tablaFiltro, String campoFiltro, String valorFiltro) throws Exception {
		System.out.println("LLEGA A CREAR EL QUERY");
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			String hql = "FROM PACIENTE paciente INNER JOIN " + tablaFiltro + " filtro WHERE paciente.cedula = filtro.CEDULA AND filtro." + campoFiltro + " = '"+valorFiltro+"'";
			System.out.println("++++++++++++++++++++++"+hql);
			HashMap<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("campoFiltro", campoFiltro);
			Query query = session.createFilter(parametros, hql);
			System.out.println("++++++++++++++++++++++"+hql);
			System.out.println("++++++++++++++++++++++"+query);
			
			if (!query.list().isEmpty()) {
				lstPacientes = (List<Paciente>) query.list();
				System.out.println("++++++++++++++++++++++"+lstPacientes);
			}
			else{
				lstPacientes = null;
			}
		} catch (Exception ex) {
			throw ex;
		} finally {
			session.close();
		}
		return lstPacientes;
	}
}
