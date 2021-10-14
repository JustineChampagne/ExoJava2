package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.IDAOAchat;
import model.Achat;
import util.Context;

public class DAOAchat implements IDAOAchat{

	@Override
	public Achat findById(Integer id) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Achat objet = em.find(Achat.class, id);
		em.close();
		return objet;
	}

	@Override
	public List<Achat> findAll() {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Query requete = em.createQuery("from Achat a",Achat.class);
		List<Achat> achats = requete.getResultList();
		em.close();
		return achats;
	}


	@Override
	public Achat save(Achat o) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		o=em.merge(o);
		em.getTransaction().commit();
		em.close();
		return o;
	}

	@Override
	public void delete(Achat o) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		o=em.merge(o);
		em.remove(o);
		em.getTransaction().commit();
		em.close();
	}

}
