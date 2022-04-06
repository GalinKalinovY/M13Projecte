package cat.almata.projectem13.classes;

import java.io.Serializable;

public class LlistaPodcasts implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String nom;
	private float preu;
	private String imatge;
	private String temaPodcast;
	

	public LlistaPodcasts() {
		super();
	}

	public LlistaPodcasts(int id, String nom, float preu, String imatge, String temaPodcast) {
		super();
		this.id = id;
		this.nom = nom;
		this.preu = preu;
		this.imatge = imatge;
		this.temaPodcast = temaPodcast;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public float getPreu() {
		return preu;
	}
	public void setPreu(float preu) {
		this.preu = preu;
	}
	public String getImatge() {
		return imatge;
	}
	public void setImatge(String imatge) {
		this.imatge = imatge;
	}
	public String getTemaPodcast() {
		return temaPodcast;
	}
	public void setTemaPodcast(String temaPodcast) {
		this.temaPodcast = temaPodcast;
	}
	
	
	
}
