package model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Achat {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Produit produit;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Client client;
	
	private LocalDateTime dateAchat;
	
	public Achat() {
	}

	public Achat(Produit produit, Client client) {
		this.produit = produit;
		this.client = client;
		this.dateAchat = LocalDateTime.now();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public LocalDateTime getDateAchat() {
		return dateAchat;
	}

	public void setDateAchat(LocalDateTime dateAchat) {
		this.dateAchat = dateAchat;
	}

	@Override
	public String toString() {
		return "Achat [id=" + id + ", produit=" + produit + ", client=" + client + ", dateAchat=" + dateAchat + "]";
	}
	
	

}
