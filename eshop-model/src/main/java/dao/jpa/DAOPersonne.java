package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import dao.IDAOPersonne;
import model.Personne;
import util.Context;

public class DAOPersonne implements IDAOPersonne{

	@Override
	public Personne findById(Integer id) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Personne objet = em.find(Personne.class, id);
		em.close();
		return objet;
	}

	@Override
	public List<Personne> findAll() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Personne save(Personne o) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		o=em.merge(o);
		em.getTransaction().commit();
		em.close();
		return o;
	}

	@Override
	public void delete(Personne o) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		o=em.merge(o);
		em.remove(o);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public Personne connect(String login, String password) {
		return null;
	}

}
