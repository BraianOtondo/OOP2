package dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

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

	public int agregar(Cliente objeto) throws HibernateException {
		int id = 0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(objeto).toString());
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
		} finally {
			session.close();
		}
		return id;
	}

	public void actualizar(Cliente objeto) throws HibernateException {
		try {
			iniciaOperacion();
			session.update(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
		} finally {
			session.close();
		}
	}

	public void eliminar(Cliente objeto) throws HibernateException {
		try {
			iniciaOperacion();
			session.delete(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
		} finally {
			session.close();
		}
	}

	public Cliente traer(long idCliente) {
		Cliente objeto = null;
		try {
			iniciaOperacion();
			objeto = (Cliente) session.get(Cliente.class, idCliente);
		} finally {
			session.close();
		}
		return objeto;
	}

	public Cliente traer(int dni) {
		// int dni=(int) dniNegocio;
		Cliente objeto = null;
		try {
			iniciaOperacion();
			objeto = (Cliente) session.createQuery("from Cliente c where c.dni=" + dni).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}

	// devuelve todos los clientes
	public List<Cliente> traer() {
		List<Cliente> lista = new ArrayList<Cliente>();
		try {
			iniciaOperacion();
			Query<Cliente> query = session.createQuery("from Cliente c order by c.idCliente ASC", Cliente.class);
			lista = query.getResultList();
		} finally {
			session.close();
		}
		return lista;
	}

	public List<Cliente> traerFechaDePrestamo(LocalDate fecha) {
		List<Cliente> lista = new ArrayList<Cliente>();
		try {
			iniciaOperacion();
			lista = session.createQuery(
					"select distinct c from Cliente c inner join fetch c.prestamos p where p.fecha = :fecha",
					Cliente.class).setParameter("fecha", fecha).list();
		} finally {
			// TODO: handle finally clause
			session.close();

		}
		return lista;
	}

	// Devuelve literal 1 CLiente pero con listas de prestamos
	public Cliente traerClienteYPrestamos(long idCliente) {
		Cliente objeto = null;
		try {
			iniciaOperacion();
			String hql = "from Cliente c where c.idCliente=:idCliente";
			objeto = (Cliente) session.createQuery(hql).setParameter("idCliente", idCliente).uniqueResult();
			Hibernate.initialize(objeto.getPrestamos());
		} finally {
			session.close();
		}
		return objeto;
	}

	public Cliente traerClienteYPrestamos(int dni) {
		Cliente objeto = null;
		try {
			iniciaOperacion();
			String hql = "from Cliente c where c.dni=:dni";
			objeto = (Cliente) session.createQuery(hql).setParameter("dni", dni).uniqueResult();
			Hibernate.initialize(objeto.getPrestamos());
		} finally {
			session.close();
		}
		return objeto;

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
	
	public List<Cliente>traerClientesFisicosConApellido(LocalDate desde, LocalDate hasta, String apellido){
		List<Cliente> clientes= new ArrayList<Cliente>();
		for(Cliente c:dao.traer(desde, hasta)) {
			if((PersonaFisica) c).getApellido().equalsIgnoreCase(apellido)){
				clientes.add(c);
			}
		}
		return clientes;
	}

	public List<Cliente> traer(String apellido) {
		List<Cliente> lista = new ArrayList<Cliente>();
		try {
			iniciaOperacion();
			lista = session.createQuery("from Cliente c where c.apellido=:apellido", Cliente.class)
					.setParameter("apellido", apellido).list();
		} finally {
			session.close();
		}
		return lista;
	}

	public List<Cliente> traerFechaAbierto(LocalDate fechaDesde, LocalDate fechaHasta) {
		List<Cliente> lista = new ArrayList<Cliente>();
		try {
			iniciaOperacion();
			lista = session.createQuery(
					"from Cliente c where c.fechaDeNacimiento > :fechaDesde and c.fechaDeNacimiento < :fechaHasta",
					Cliente.class).setParameter("fechaDesde", fechaDesde).setParameter("fechaHasta", fechaHasta).list();

		} finally {
			session.close();
		}
		return lista;
	}

}