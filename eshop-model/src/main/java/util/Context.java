package util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.IDAOAchat;
import dao.IDAOClient;
import dao.IDAOFournisseur;
import dao.IDAOPersonne;
import dao.IDAOProduit;
import dao.jpa.DAOAchat;
import dao.jpa.DAOClient;
import dao.jpa.DAOFournisseur;
import dao.jpa.DAOPersonne;
import dao.jpa.DAOProduit;


public class Context {



	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("eshop-modelJPA");
	private IDAOPersonne daoPersonne= new DAOPersonne();
	private IDAOClient daoClient = new DAOClient();
	private IDAOFournisseur daoFournisseur = new DAOFournisseur();
	private IDAOAchat daoAchat = new DAOAchat();
	private IDAOProduit daoProduit = new DAOProduit();
	
	

	//SINGLETON
	private static Context _instance;
	
	
	private Context() {}
	
	
	
	public static Context getInstance() 
	{
		if(_instance==null)
		{_instance=new Context();}
		
		return _instance;
	}
	//FIN SINGLETON



	public EntityManagerFactory getEmf() {
		return emf;
	}

	


	public IDAOPersonne getDaoPersonne() {
		return daoPersonne;
	}



	public IDAOClient getDaoClient() {
		return daoClient;
	}



	public IDAOFournisseur getDaoFournisseur() {
		return daoFournisseur;
	}



	public IDAOAchat getDaoAchat() {
		return daoAchat;
	}



	public IDAOProduit getDaoProduit() {
		return daoProduit;
	}



	public void closeEmf() 
	{
		this.emf.close();
	}

	
	
	
	
}