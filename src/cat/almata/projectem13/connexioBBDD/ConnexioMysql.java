package cat.almata.projectem13.connexioBBDD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import cat.almata.projectem13.classes.LlistaPodcasts;
import cat.almata.projectem13.classes.Podcast;
import cat.almata.projectem13.classes.Usuaris;

public class ConnexioMysql {
	public List<Podcast> consultaPodcast(Connection con) throws SQLException {
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM Podcast where id=?");

		List<Podcast> llistaPodcasts = new ArrayList<Podcast>();

		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			Podcast pod  =  new Podcast();
			pod.setId(rs.getInt("ID"));
			pod.setFormat(rs.getString("format"));
			pod.setNom(rs.getString("nomProducte"));
			pod.setDescripcio(rs.getString("descripcio"));
			pod.setPreu(rs.getFloat("preu"));
			pod.setImatge(rs.getString("imatgeProducte"));
			
			System.out.println("ID: " + rs.getInt("ID"));
			System.out.println("format: " + rs.getString("format"));
			System.out.println("nomProducte: " + rs.getString("nomProducte"));
			System.out.println("descripcio: " + rs.getString("descripcio"));
			System.out.println("preu: " + rs.getFloat("preu"));
			System.out.println("imatgeProducte: " + rs.getString("imatgeProducte"));
			System.out.println();
			
			llistaPodcasts.add(pod);
		}
		rs.close();
		stmt.close();
		
		
		
		return llistaPodcasts;
	}
	public List<LlistaPodcasts> consultaPodcasts(Connection con) throws SQLException {
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM LListaPodcasts LIMIT 8");

		List<LlistaPodcasts> llistaPodcasts = new ArrayList<LlistaPodcasts>();

		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			LlistaPodcasts pod  =  new LlistaPodcasts();
			pod.setId(rs.getInt("ID"));
			pod.setNom(rs.getString("nomProducte"));
			pod.setPreu(rs.getFloat("preu"));
			pod.setImatge(rs.getString("imatgePodcast"));
			pod.setTemaPodcast(rs.getString("temaPodcast"));
			
			System.out.println("-------------------------------------------------------------------------------------------");
			System.out.println("ID: " + rs.getInt("ID"));
			System.out.println("nomProducte: " + rs.getString("nomProducte"));
			System.out.println("preu: " + rs.getFloat("preu"));
			System.out.println("imatgePodcast: " + rs.getString("imatgePodcast"));
			System.out.println("temaPodcast: " + rs.getString("temaPodcast"));
			System.out.println("-------------------------------------------------------------------------------------------");
			
			llistaPodcasts.add(pod);
		}
		rs.close();
		stmt.close();
		
		
		
		return llistaPodcasts;
	}
	
	public void registreUsuari(Usuaris usuari,Connection con) throws SQLException {
		PreparedStatement stmt = con.prepareStatement("INSERT INTO Usuaris "
				+ "(nomUsuari,cognomsUsuari,contrasenyaUsuari,NIF,telefon,anyNaixement,adreca,infoAdicional) "
				+ "VALUES (?,?,?,?,?,?,?,?);");
		
		java.sql.Date dataNaix = new java.sql.Date(usuari.getAnyNaixement().getTime());
		
		stmt.setString(1,usuari.getNomUsuari());
		stmt.setString(2,usuari.getCognomsUsuari());
		stmt.setString(3,usuari.getContrasenyaUsuari());
		stmt.setString(4,usuari.getNIF());
		stmt.setInt(5,usuari.getTelefon());
		stmt.setDate(6,dataNaix);
		stmt.setString(7,usuari.getAdreca());
		stmt.setString(8,usuari.getInfoAdicional());
		
		stmt.execute();
		stmt.close();
		System.out.println("Usuari inscrit!.");
		
	}
}
//prova connexió a bbdd a dins de la classe java que te la pantalla.
/*btnNewButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        String firstName = firstname.getText();
        String lastName = lastname.getText();
        String emailId = email.getText();
        String userName = username.getText();
        String mobileNumber = mob.getText();
        int len = mobileNumber.length();
        String password = passwordField.getText();

        String msg = "" + firstName;
        msg += " \n";
        if (len != 10) {
            JOptionPane.showMessageDialog(btnNewButton, "Enter a valid mobile number");
        }

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/swing_demo", "root", "root");

            String query = "INSERT INTO account values('" + firstName + "','" + lastName + "','" + userName + "','" +
                password + "','" + emailId + "','" + mobileNumber + "')";

            Statement sta = connection.createStatement();
            int x = sta.executeUpdate(query);
            if (x == 0) {
                JOptionPane.showMessageDialog(btnNewButton, "This is alredy exist");
            } else {
                JOptionPane.showMessageDialog(btnNewButton,
                    "Welcome, " + msg + "Your account is sucessfully created");
            }
            connection.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
});*/