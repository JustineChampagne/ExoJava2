package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import dao.IDAOFournisseur;
import model.Fournisseur;
import util.Context;

public class DAOFournisseur implements IDAOFournisseur{

	@Override
	public Fournisseur findById(Integer id) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Fournisseur objet = em.find(Fournisseur.class, id);
		em.close();
		return objet;
	}

	@Override
	public List<Fournisseur> findAll() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Fournisseur save(Fournisseur o) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		o=em.merge(o);
		em.getTransaction().commit();
		em.close();
		return o;
	}

	@Override
	public void delete(Fournisseur o) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		o=em.merge(o);
		em.remove(o);
		em.getTransaction().commit();
		em.close();
	}

}
