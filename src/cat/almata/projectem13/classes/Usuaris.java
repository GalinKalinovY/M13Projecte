package cat.almata.projectem13.classes;

import java.io.Serializable;
import java.util.Date;

public class Usuaris implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idUsuari;
	private String nomUsuari;
	private String cognomsUsuari;
	private String contrasenyaUsuari;
	private String contrasenyaUsuari2;
	private String nif;
	private int telefon;
	private Date anyNaixement;
	private String adreca;
	private String infoAdicional;
	
	
	public Usuaris() {
		super();
	}


	public Usuaris(int idUsuari, String nomUsuari, String cognomsUsuari, String contrasenyaUsuari, String contrasenyaUsuari2,String nif,
			int telefon, Date anyNaixement, String adreca, String infoAdicional) {
		super();
		this.idUsuari = idUsuari;
		this.nomUsuari = nomUsuari;
		this.cognomsUsuari = cognomsUsuari;
		this.contrasenyaUsuari = contrasenyaUsuari;
		this.contrasenyaUsuari2 = contrasenyaUsuari2;
		this.nif = nif;
		this.telefon = telefon;
		this.anyNaixement = anyNaixement;
		this.adreca = adreca;
		this.infoAdicional = infoAdicional;
	}
	
	
	public int getIdUsuari() {
		return idUsuari;
	}
	public void setIdUsuari(int idUsuari) {
		this.idUsuari = idUsuari;
	}
	public String getNomUsuari() {
		return nomUsuari;
	}
	public void setNomUsuari(String nomUsuari) {
		this.nomUsuari = nomUsuari;
	}
	public String getCognomsUsuari() {
		return cognomsUsuari;
	}
	public void setCognomsUsuari(String cognomsUsuari) {
		this.cognomsUsuari = cognomsUsuari;
	}
	public String getContrasenyaUsuari() {
		return contrasenyaUsuari;
	}
	public void setContrasenyaUsuari(String contrasenyaUsuari) {
		this.contrasenyaUsuari = contrasenyaUsuari;
	}
	public String getContrasenyaUsuari2() {
		return contrasenyaUsuari2;
	}
	public void setContrasenyaUsuari2(String contrasenyaUsuari2) {
		this.contrasenyaUsuari2 = contrasenyaUsuari2;
	}
	public String getNIF() {
		return nif;
	}
	public void setNIF(String nIF) {
		nif = nIF;
	}
	public int getTelefon() {
		return telefon;
	}
	public void setTelefon(int telefon) {
		this.telefon = telefon;
	}
	public Date getAnyNaixement() {
		return anyNaixement;
	}
	public void setAnyNaixement(Date anyNaixement) {
		this.anyNaixement = anyNaixement;
	}
	public String getAdreca() {
		return adreca;
	}
	public void setAdreca(String adreca) {
		this.adreca = adreca;
	}
	public String getInfoAdicional() {
		return infoAdicional;
	}
	public void setInfoAdicional(String infoAdicional) {
		this.infoAdicional = infoAdicional;
	}
	
	
	
	
	
}
