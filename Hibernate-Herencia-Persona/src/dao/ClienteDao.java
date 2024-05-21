package dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Cliente;

public class ClienteDao {
	private static Session session;
	private Transaction tx;
	
	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}
	public int agregar(Cliente objeto) {
		int id = 0;
		// System.out.println(objeto);
		try {
			iniciaOperacion();
			id = (int) session.save(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
		return id;
	}

	public List<Cliente> traerClientes(LocalDate fechaNac) {
		List<Cliente> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from PersonaFisica pf", Cliente.class).list();
		} finally {
			session.close();
		}
		return lista;
	}
	public List<Cliente> traerClientes(LocalDate fechaDesde,LocalDate fechaHasta) {
		List<Cliente> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from PersonaFisica pf where pf.fechaNacimiento betweeen"
					+ ":fechaDesde AND :fechaHasta", Cliente.class).
					setParameter("fechaDesde", fechaDesde).setParameter("fechaHasta", fechaHasta).list();
		} finally {
			session.close();
		}
		return lista;
	}
	public List<Cliente> traer(LocalDate fechaDesde, LocalDate fechaHasta) {
		List<Cliente> lista = new ArrayList<Cliente>();
		try {
			iniciaOperacion();
			lista = session
					.createQuery("from Cliente c where c.fechaDeNacimiento between :fechaDesde and :fechaHasta",
							Cliente.class)
					.setParameter("fechaDesde", fechaDesde).setParameter("fechaHasta", fechaHasta).list();
		} finally {
			session.close();
		}
		return lista;
	}
}
