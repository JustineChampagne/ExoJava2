import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Client;
import model.Fournisseur;
import model.Personne;
import model.Produit;
import util.Context;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;






public class Test {
	
	public static void test(String[] args)
	
	{
		
		

		
		  
		  EntityManagerFactory emf =
		  Persistence.createEntityManagerFactory("eshop-modelJPA");
		  
		  EntityManager em = emf.createEntityManager();

		  Fournisseur f1 = new Fournisseur("nom", "prenom", "Societe");
		  Fournisseur f2 = new Fournisseur("nom", "prenom", "Societe2");
		  
		  Produit produit1= new Produit("lib1", 10.0, f1);
		  Produit produit2= new Produit("lib2",20.0, f2);
		  Produit produit3= new Produit("lib3", 30.0, f1);
		  Produit produit4= new Produit("lib4",40.0, f2);		  
		  
		  List<Produit> produitsA = new ArrayList();
		  produitsA.add(produit1);
		  produitsA.add(produit2);
		  
		  List<Produit> produitsB = new ArrayList();
		  produitsB.add(produit3);
		  produitsB.add(produit4);		  		  
		  //Client cA = new Client("nom", "prenom", 27,LocalDate.parse("1993-12-30"), produitsA ); 
		  //Client cB = new Client("nom", "prenom", 30,LocalDate.parse("1990-12-31"), produitsB ); 
		  
		  em.getTransaction().begin();
		  
		
		  em.persist(f1);
		  em.persist(f2);
		  em.persist(produit1);
		  em.persist(produit2);
		  em.persist(produit3);
		  em.persist(produit4);
		  
		  //em.persist(cA);
		  //em.persist(cB);		    
		    
		  em.getTransaction().commit();
		  
		  

		 
		  Client cBase = em.find(Client.class, 1); //SELECT dans la base la planete 1
	        System.out.println("voici notre client A :");
	       // System.out.println(cA);
		  em.close();
		  
		  emf.close();	        
	}
	
	public static void test2(String [] args)
	{

		  
		  EntityManagerFactory emf =
		  Persistence.createEntityManagerFactory("eshop-modelJPA");
		  
		  EntityManager em = emf.createEntityManager();

		  Fournisseur f1 = new Fournisseur("nom", "prenom", "Societe");
		  Fournisseur f2 = new Fournisseur("nom", "prenom", "Societe2");
		  
		  Produit produit1= new Produit("lib1", 10.0, f1);
		  Produit produit2= new Produit("lib2",20.0, f2);
		  Produit produit3= new Produit("lib3", 30.0, f1);
		  Produit produit4= new Produit("lib4",40.0, f2);		  
		  
		  List<Produit> produitsA = new ArrayList();
		  produitsA.add(produit1);
		  produitsA.add(produit2);
		  
		  List<Produit> produitsB = new ArrayList();
		  produitsB.add(produit3);
		  produitsB.add(produit4);		  		  
		  Client cA = new Client("nom", "prenom", 27,LocalDate.parse("1993-12-30") ); 
		  Client cB = new Client("nom", "prenom", 30,LocalDate.parse("1990-12-31") ); 
		  
		  Produit produitTEST= new Produit("nouveau",50.0, f2);
		  
		   em.getTransaction().begin();
		  
		  //Context.getInstance().getDaoProduit().insert(produitTEST);
		  
		  
		  
		  
		  
		  
		  
		  
		 
		  
		
		  em.persist(f1);
		  em.persist(f2);
		  em.persist(produit1);
		  em.persist(produit2);
		  em.persist(produit3);
		  em.persist(produit4);
		  
		  em.persist(cA);
		  em.persist(cB);		    
		    
		  em.getTransaction().commit();
		  
		  em.close();
		  
		  emf.close();	        
	        
	}
	
	public static void main(String[] args) {


		EntityManager em = Context.getInstance().getEmf().createEntityManager();

		Query requete = em.createQuery("from Produit p where p.libelle like :lib",Produit.class);
		requete.setParameter("lib", "%W%");
		
		List<Produit> produits = requete.getResultList();
		
	
		for(Produit p : produits) 
		{
			System.out.println(p);
		}
		
		
		
		Query requeteConnect = em.createQuery("Select p from Personne p where p.nom=:login and p.prenom=:password",Personne.class);
		requeteConnect.setParameter("login", "Abid");
		requeteConnect.setParameter("password", "Jordan");
		Personne connected=null;
		
		try {
			connected =  (Personne) requeteConnect.getSingleResult();
		}
		catch(Exception e) {e.printStackTrace();System.out.println("Identifiants invalides");}
		
	

		Query q = em.createNamedQuery("Produit.findByLibelle",Produit.class);
		q.setParameter("lelibelle","PS5");
		List<Produit> prods = q.getResultList();
		
		
		System.out.println(connected);
		em.close();
		
		Context.getInstance().closeEmf();
		
	} 
}
