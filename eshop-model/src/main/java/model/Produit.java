package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@NamedQueries({ 
	@NamedQuery( 
			name="Produit.findByLibelle", 
			query="select p from Produit p where p.libelle = :lelibelle") 
			}) 

@Entity
public class Produit {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String libelle;
	private double prix;
	
	
	@OneToMany(mappedBy = "produit")
	private List<Achat> acheteurs;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Fournisseur fournisseur;
	
	
	public Produit() {
	}


	public Produit(String libelle, double prix, Fournisseur fournisseur) {
		this.libelle = libelle;
		this.prix = prix;
		this.fournisseur = fournisseur;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getLibelle() {
		return libelle;
	}


	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}


	public double getPrix() {
		return prix;
	}


	public void setPrix(double prix) {
		this.prix = prix;
	}


	public Fournisseur getFournisseur() {
		return fournisseur;
	}


	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}

	

	public List<Achat> getAcheteurs() {
		return acheteurs;
	}


	public void setAcheteurs(List<Achat> acheteurs) {
		this.acheteurs = acheteurs;
	}


	@Override
	public String toString() {
		return "Produit [id=" + id + ", libelle=" + libelle + ", prix=" + prix + ", fournisseur=" + fournisseur + "]";
	}
	
	
	
}
