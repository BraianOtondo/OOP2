package dao;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import datos.Cliente;
public class ClienteDao {
	private static Session session;
	private Transaction tx;
	//Abre acceso a la bdd mysql
	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	//Lo que sea que hizo previamente da un paso atras, Rollback. Como si no hubiera pasado nada. Las transacciiones se cancelan
	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}

	public int agregar(Cliente objeto) {
		int id = 0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(objeto).toString());
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
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
			throw he;
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
			throw he;
		} finally {
			session.close();
		}
	}
	//Usando get de Hibernate, solo con clave primaria funciona
	public Cliente traer(long idCliente) throws HibernateException {
		Cliente objeto = null;
		try {
			iniciaOperacion();
			objeto = (Cliente) session.get(Cliente.class, idCliente);
		} finally {
			session.close();
		}
		return objeto;
	}
	//Usando HQL que trae cualquier valor especifico y directamente

	public Cliente traer(int dni) {
		Cliente cliente = null;
		try {
		iniciaOperacion();
		cliente = (Cliente) session.createQuery("from Cliente c where c.dni= :dni").setParameter("dni", dni).uniqueResult();
		// En este caso :dni es un marcador de posición para el parámetro.
		// Al utilizar el método setParameter para asignar el valor del
		//parámetro dni esto ayuda a prevenir la inyección de SQL.
		} finally {
		session.close();
		}
		return cliente;
		}
	//trae la lista solamente de ese cliente especifico
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
		//trae cliente junto a la lista directamente con una consulta hql, para que se pueda usar esa lista
	public Cliente traerClienteYContacto(long idCliente) throws HibernateException {
		Cliente objeto = null;
		try {
		iniciaOperacion();
		String hql = "from Cliente c inner join fetch c.contacto where c.idCliente = :idCliente";
		objeto = (Cliente) session.createQuery(hql).setParameter("idCliente",idCliente).uniqueResult();
		} finally {
		session.close();
		}
		return objeto;
		}
}
