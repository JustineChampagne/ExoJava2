package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

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
		// TODO Auto-generated method stub
		return null;
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
