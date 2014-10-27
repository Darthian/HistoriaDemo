package co.edu.unal.clinica.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import co.edu.unal.clinica.hibernate.data.Usuario;
import co.edu.unal.clinica.utils.HibernateUtil;

public class UsuarioDAO {

	private Session session;
	private Transaction trans;
	private List<Usuario> lstUsuarios;	

	public Usuario verificarDatos(Usuario usuario) throws Exception {
		Usuario us = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			String hql = "FROM Usuario WHERE nickname = '"
					+ usuario.getNickName() + "' and password = '"
					+ usuario.getPassword() + "'";
			Query query = session.createQuery(hql);

			if (!query.list().isEmpty()) {
				us = (Usuario) query.list().get(0);
			}

		} catch (Exception e) {
			throw e;
		}

		return us;
	}
	
	public boolean nickNameExiste(Usuario usuario) throws Exception{
		boolean existe = false;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			String hql = "FROM Usuario WHERE nickname = '"
					+ usuario.getNickName() + "'";
			Query query = session.createQuery(hql);

			if (query.list().isEmpty()) {
				existe = false;
			}
			else {
				existe = true;
			}

		} catch (Exception e) {
			throw e;
		}

		return existe;

	}

	public void Eliminar(Usuario emp) throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			trans = session.beginTransaction();
			session.delete(emp);
			trans.commit();
		} catch (Exception ex) {
			trans.rollback();
			throw ex;
		} finally {
			session.close();
		}
	}

	public void Modificar(Usuario emp) throws Exception {
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

	public List<Usuario> Listar() throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Criteria cri = session.createCriteria(Usuario.class);
			cri.addOrder(Order.asc("nickName"));
			lstUsuarios = cri.list();
		} catch (Exception ex) {
			throw ex;
		}
		return lstUsuarios;
	}

}
