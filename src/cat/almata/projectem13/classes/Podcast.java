package cat.almata.projectem13.classes;

import java.io.Serializable;

public class Podcast implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String format;
	private String nom;
	private String descripcio;
	private float preu;
	private String imatge;
	

	public Podcast() {
		super();
	}

	public Podcast(int id, String format, String nom, String descripcio, float preu, String imatge) {
		super();
		this.id = id;
		this.format = format;
		this.nom = nom;
		this.descripcio = descripcio;
		this.preu = preu;
		this.imatge = imatge;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescripcio() {
		return descripcio;
	}
	public void setDescripcio(String descripcio) {
		this.descripcio = descripcio;
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
	
	public void transmetreEnViu() {
		
	}

	@Override
	public String toString() {
		return "Podcast [id=" + id + ", format=" + format + ", nom=" + nom + ", descripcio=" + descripcio + ", preu="
				+ preu + ", imatge=" + imatge + "]";
	}
	
	
	
	
}
