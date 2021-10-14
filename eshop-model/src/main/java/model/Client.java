package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("customer")
public class Client extends Personne {
	
	private int age;
	@Column(name="birthdate")
	private LocalDate dateNaissance;
	
	@OneToMany(mappedBy = "client")
	private List<Achat> achats;
	
	
	
	public Client() {}
	
	public Client(String nom, String prenom, int age, LocalDate dateNaissance) {
		super(nom, prenom);
		this.age = age;
		this.dateNaissance = dateNaissance;
	}

	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public LocalDate getDateNaissance() {
		return dateNaissance;
	}


	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	

	public List<Achat> getAchats() {
		return achats;
	}

	public void setAchats(List<Achat> achats) {
		this.achats = achats;
	}

	@Override
	public String toString() {
		return "Client [age=" + age + ", dateNaissance=" + dateNaissance + ", id=" + id
				+ ", nom=" + nom + ", prenom=" + prenom + "]";
	}

	
	
	
	

}
