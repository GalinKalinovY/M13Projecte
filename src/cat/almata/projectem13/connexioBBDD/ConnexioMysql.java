package cat.almata.projectem13.connexioBBDD;

import java.sql.*;
import java.util.List;

import cat.almata.projectem13.classes.Podcast;

public class ConnexioMysql {
	public List<Podcast> consultaPodcasts(Connection con) throws SQLException {
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM BOOK LIMIT 6");

		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			System.out.println("IDBN: " + rs.getString("ISBN"));
			System.out.println("BookName: " + rs.getString("BOOK_NAME"));
			System.out.println("Publisher Code: " + rs.getString("PUBLISHER_CODE"));
			System.out.println("Publisher Date: " + rs.getDate("PUBLISH_DATE"));
			System.out.println("Price: " + rs.getInt("PRICE"));
			System.out.println();
		}
		rs.close();
		stmt.close();
		
		//List<Podcast> pod = 
		
		return null;
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