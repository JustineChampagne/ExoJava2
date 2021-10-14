package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

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
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Query requete = em.createQuery("from Personne p",Personne.class);
		List<Personne> personnes = requete.getResultList();
		em.close();
		return personnes;
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
		
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		
		Query requeteConnect = em.createQuery("Select p from Personne p where p.login=:login and p.password=:password",Personne.class);
		requeteConnect.setParameter("login", login);
		requeteConnect.setParameter("password", password);
		Personne connected=null;
		
		try {
			connected =  (Personne) requeteConnect.getSingleResult();
		}
		catch(Exception e) {e.printStackTrace();System.out.println("Identifiants invalides");}

		//System.out.println(connected);
		return connected;
		
		
	}

}
