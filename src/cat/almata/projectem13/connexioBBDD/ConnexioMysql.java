package cat.almata.projectem13.connexioBBDD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import cat.almata.projectem13.classes.Podcast;

public class ConnexioMysql {
	public List<Podcast> consultaPodcasts(Connection con) throws SQLException {
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM Podcast LIMIT 6");

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