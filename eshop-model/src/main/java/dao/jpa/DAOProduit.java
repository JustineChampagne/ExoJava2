package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.IDAOProduit;
import model.Produit;
import util.Context;

public class DAOProduit implements IDAOProduit{

	@Override
	public Produit findById(Integer id) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Produit objet = em.find(Produit.class, id);
		em.close();
		return objet;
	}

	@Override
	public List<Produit> findAll() {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Query requete = em.createQuery("from Produit p",Produit.class);
		List<Produit> produits = requete.getResultList();
		em.close();
		return produits;
	}


	@Override
	public Produit save(Produit o) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		o=em.merge(o);
		em.getTransaction().commit();
		em.close();
		return o;
	}

	@Override
	public void delete(Produit o) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		o=em.merge(o);
		em.remove(o);
		em.getTransaction().commit();
		em.close();
	}

}
