package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import dao.IDAOClient;
import model.Client;
import util.Context;

public class DAOClient implements IDAOClient{

	@Override
	public Client findById(Integer id) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Client objet = em.find(Client.class, id);
		em.close();
		return objet;
	}

	@Override
	public List<Client> findAll() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Client save(Client o) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		o=em.merge(o);
		em.getTransaction().commit();
		em.close();
		return o;
	}

	@Override
	public void delete(Client o) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		o=em.merge(o);
		em.remove(o);
		em.getTransaction().commit();
		em.close();
	}

}
