package br.com.testeback2017.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.testeback2017.config.JPAUtil;
import br.com.testeback2017.modelo.Cliente;

public class ClienteDao {

	EntityManager em = new JPAUtil().createEntityManager();

	public void persisteUmCliente(Cliente cliente) {

		em.getTransaction().begin();
		em.persist(cliente);
		em.getTransaction().commit();
	}

	public double buscaMediaVlTotal() {
		// String query = "select AVG(c.vl_total) from Cliente c where
		// c.vl_total >= 560 and c.id_customer between 1500 and 2700 ";
		String query = "select AVG(c.vl_total) from Cliente c where c.vl_total >= 300 and c.id_customer between 1 and 200 ";

		double singleResult = (double) em.createQuery(query).getSingleResult();
		return singleResult;
	}

	public List<Cliente> buscaClientes() {
		// String query = "select c from Cliente c where c.vl_total >= 560 and
		// c.id_customer between 1500 and 2700 ";
		String query = "from Cliente c where c.vl_total >= 300 and c.id_customer between 1 and 200 order by c.vl_total";
		return em.createQuery(query, Cliente.class).getResultList();
	}

}
