package cat.almata.projectem13.connexioBBDD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import cat.almata.projectem13.classes.LlistaPodcasts;
import cat.almata.projectem13.classes.Podcast;
import cat.almata.projectem13.classes.Usuaris;

public class ConnexioMysql {
	public Podcast consultaPodcast(Connection con, String idPodcast) throws SQLException {
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM Podcast where id=?");
		stmt.setInt(1, Integer.parseInt(idPodcast));

		Podcast podcast = null;

		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			podcast = new Podcast();
			podcast.setId(rs.getInt("ID"));
			podcast.setFormat(rs.getString("format"));
			podcast.setNom(rs.getString("nomProducte"));
			podcast.setDescripcio(rs.getString("descripcio"));
			podcast.setPreu(rs.getFloat("preu"));
			podcast.setImatge(rs.getString("imatgeProducte"));

			System.out.println("ID: " + rs.getInt("ID"));
			System.out.println("format: " + rs.getString("format"));
			System.out.println("nomProducte: " + rs.getString("nomProducte"));
			System.out.println("descripcio: " + rs.getString("descripcio"));
			System.out.println("preu: " + rs.getFloat("preu"));
			System.out.println("imatgeProducte: " + rs.getString("imatgeProducte"));
			System.out.println();

		}
		rs.close();
		stmt.close();

		return podcast;
	}

	public Podcast elsMeusPodcasts(Connection con, String nomUsuari) throws SQLException {

		String idUsu = null;

		PreparedStatement stmt = con.prepareStatement("SELECT * FROM Usuaris where nomUsuari=? ");
		stmt.setString(1, nomUsuari);

		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			idUsu = rs.getString(1);
		}
		stmt.close();
		
		
		Podcast podcast = null;
		if (idUsu != null) {
			PreparedStatement stmt2 = con.prepareStatement("SELECT * FROM podcastPersonal where idUsuari=?");
			stmt2.setString(1, idUsu);


			ResultSet rs2 = stmt2.executeQuery();
			while (rs2.next()) {
				podcast = new Podcast();
				podcast.setId(rs2.getInt("ID"));
				podcast.setFormat(rs2.getString("format"));
				podcast.setNom(rs2.getString("nomProducte"));
				podcast.setDescripcio(rs2.getString("descripcio"));
				podcast.setPreu(rs2.getFloat("preu"));
				podcast.setImatge(rs2.getString("imatgeProducte"));

				System.out.println("ID: " + rs2.getInt("ID"));
				System.out.println("format: " + rs2.getString("format"));
				System.out.println("nomProducte: " + rs2.getString("nomProducte"));
				System.out.println("descripcio: " + rs2.getString("descripcio"));
				System.out.println("preu: " + rs2.getFloat("preu"));
				System.out.println("imatgeProducte: " + rs2.getString("imatgeProducte"));
				System.out.println();

			}
			rs.close();
			stmt.close();
		}

		return podcast;
	}

	public List<LlistaPodcasts> consultaPodcasts(Connection con) throws SQLException {
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM LListaPodcasts LIMIT 8");

		List<LlistaPodcasts> llistaPodcasts = new ArrayList<LlistaPodcasts>();

		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			LlistaPodcasts pod = new LlistaPodcasts();
			pod.setId(rs.getInt("ID"));
			pod.setNom(rs.getString("nomProducte"));
			pod.setPreu(rs.getFloat("preu"));
			pod.setImatge(rs.getString("imatgePodcast"));
			pod.setTemaPodcast(rs.getString("temaPodcast"));

			System.out.println(
					"-------------------------------------------------------------------------------------------");
			System.out.println("ID: " + rs.getInt("ID"));
			System.out.println("nomProducte: " + rs.getString("nomProducte"));
			System.out.println("preu: " + rs.getFloat("preu"));
			System.out.println("imatgePodcast: " + rs.getString("imatgePodcast"));
			System.out.println("temaPodcast: " + rs.getString("temaPodcast"));
			System.out.println(
					"-------------------------------------------------------------------------------------------");

			llistaPodcasts.add(pod);
		}
		rs.close();
		stmt.close();

		return llistaPodcasts;
	}

	public String registreUsuari(Usuaris usuari, Connection con) throws SQLException {

		String existeixNom = null;

		PreparedStatement stmt = con
				.prepareStatement("SELECT * FROM Usuaris where nomUsuari=? AND contrasenyaUsuari=?");
		stmt.setString(1, usuari.getNomUsuari());
		stmt.setString(2, usuari.getContrasenyaUsuari());

		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			existeixNom = rs.getString(2);
		}
		stmt.close();

		if (existeixNom == null) {
			PreparedStatement stmt2 = con.prepareStatement("INSERT INTO Usuaris "
					+ "(nomUsuari,cognomsUsuari,contrasenyaUsuari,NIF,telefon,anyNaixement,adreca,infoAdicional) "
					+ "VALUES (?,?,?,?,?,?,?,?);");

			java.sql.Date dataNaix = new java.sql.Date(usuari.getAnyNaixement().getTime());

			stmt2.setString(1, usuari.getNomUsuari());
			stmt2.setString(2, usuari.getCognomsUsuari());
			stmt2.setString(3, usuari.getContrasenyaUsuari());
			stmt2.setString(4, usuari.getNIF());
			stmt2.setInt(5, usuari.getTelefon());
			stmt2.setDate(6, dataNaix);
			stmt2.setString(7, usuari.getAdreca());
			stmt2.setString(8, usuari.getInfoAdicional());

			stmt2.executeUpdate();
			stmt2.close();
			System.out.println("Usuari inscrit!.");
			return "inscrit";
		} else if (existeixNom.equals(usuari.getNomUsuari())) {
			System.out.println("Usuari existeix");
			return "Existeix";
		} else {
			System.out.println("Usuari no existeix");
			return "noExisteix";
		}

	}

	public String afegirPodcastPersonal(String nomUsu, Podcast pod, Connection con) throws SQLException {

		String existeixNom = null;

		PreparedStatement stmt = con.prepareStatement("SELECT * FROM Usuaris where nomUsuari=?");
		stmt.setString(1, nomUsu);

		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			existeixNom = rs.getString(1);
		}
		stmt.close();

		if (existeixNom != null) {
			PreparedStatement stmt2 = con.prepareStatement("INSERT INTO podcastPersonal "
					+ "(idUsuari,format,nomProducte,descripcio,preu,imatgeProducte) " + "VALUES (?,?,?,?,?,?);");

			stmt2.setString(1, existeixNom);
			stmt2.setString(2, pod.getFormat());
			stmt2.setString(3, pod.getNom());
			stmt2.setString(4, pod.getDescripcio());
			stmt2.setFloat(5, pod.getPreu());
			stmt2.setString(6, pod.getImatge());

			stmt2.executeUpdate();
			stmt2.close();
			System.out.println("Podcast afegit");
			return "afegit";
		} else {
			System.out.println("No pots afegir com a guest");
			return "noExisteix";
		}

	}

	public String autenticacioUsuari(String nom, String contra, Connection con) throws SQLException {

		String nomUsuari = null;

		PreparedStatement stmt = con
				.prepareStatement("SELECT * FROM Usuaris where nomUsuari=? AND contrasenyaUsuari=?");
		stmt.setString(1, nom);
		stmt.setString(2, contra);

		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			nomUsuari = rs.getString(2);
		}

		stmt.close();

		return nomUsuari;

	}
	
	public void eliminaPodcastPersonal(String nom, Connection con) throws SQLException {

		String existeixNom = null;

		PreparedStatement stmt = con.prepareStatement("SELECT * FROM Usuaris where nomUsuari=?");
		stmt.setString(1, nom);

		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			existeixNom = rs.getString(1);
		}
		stmt.close();

		if (existeixNom != null) {
			PreparedStatement stmt2 = con.prepareStatement("DELETE FROM podcastPersonal WHERE idUsuari=?");

			stmt2.setString(1, existeixNom);

			stmt2.execute();
		}
	}

}
