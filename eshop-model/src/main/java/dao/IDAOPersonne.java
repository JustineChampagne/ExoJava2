package dao;

import model.Personne;

public interface IDAOPersonne extends IDAO<Personne,Integer> {

	public Personne connect(String login,String password);
}
