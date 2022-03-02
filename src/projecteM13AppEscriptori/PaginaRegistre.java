package projecteM13AppEscriptori;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;

import cat.almata.projectem13.classes.Podcast;
import cat.almata.projectem13.classes.Usuaris;
import cat.almata.projectem13.connexioBBDD.ConnexioMysql;

public class PaginaRegistre {

	private JFrame frame;
	private JTextField txbNom;
	private JTextField txtContrassenya;
	private JTextField txtRepetirContrassenya;
	private JTextField txtAnyNaixement;
	private JTextField txtAdrea;
	private JTextField txtCognoms;
	private JTextField txtDniniecif;
	private JTextField txtTelefon;
	private JTextField txtInfoAdicional;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaginaRegistre window = new PaginaRegistre();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @throws SQLException
	 */
	public PaginaRegistre() throws SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws SQLException
	 */
	private void initialize() throws SQLException {

		Usuaris usuaris = new Usuaris();
		final boolean usuariComplet = false;

		frame = new JFrame();

		BorderLayout borderLayout = (BorderLayout) frame.getContentPane().getLayout();

		// menu de la pàgina
		JPanel panelMenu = new JPanel();
		panelMenu.setBackground(Color.DARK_GRAY);
		FlowLayout fl_panelMenu = (FlowLayout) panelMenu.getLayout();
		// fl_panelMenu.setVgap(30);
		frame.getContentPane().add(panelMenu, BorderLayout.NORTH);

		JLabel lblIconaMenu = new JLabel("");
		// lblIconaMenu.setIcon(new
		// ImageIcon(MenuPpal.class.getResource("/imatgesPerPantalles/imatgesApp/podcastNeonIcona.jpeg")));

		ImageIcon imageIcon = new ImageIcon(
				new ImageIcon(MenuPpal.class.getResource("/imatgesPerPantalles/imatgesApp/podcastNeonIcona.jpeg"))
						.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		lblIconaMenu.setIcon(imageIcon);
		panelMenu.add(lblIconaMenu);

		JLabel lblSpacer = new JLabel("               ");
		panelMenu.add(lblSpacer);

		JLabel lblLlistaPodcasts = new JLabel(" Llista Podcasts ");
		lblLlistaPodcasts.setForeground(Color.CYAN);
		panelMenu.add(lblLlistaPodcasts);
		lblLlistaPodcasts.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// you can open a new frame here as
				// i have assumed you have declared "frame" as instance variable
				frame = new JFrame("LLista Podcasts");
				frame.setVisible(true);
				frame.setBounds(300, 100, 800, 800);

			}
		});

		JLabel lblElsMeusPodcasts = new JLabel(" Els meus podcasts ");
		lblElsMeusPodcasts.setForeground(Color.CYAN);
		panelMenu.add(lblElsMeusPodcasts);
		lblElsMeusPodcasts.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// you can open a new frame here as
				// i have assumed you have declared "frame" as instance variable
				frame = new JFrame("Els meus Podcasts");
				frame.setVisible(true);
				frame.setBounds(300, 100, 800, 800);

			}
		});

		JLabel lblRetransmissioPodcast = new JLabel(" Retransmissió Podcast ");
		lblRetransmissioPodcast.setForeground(Color.CYAN);
		panelMenu.add(lblRetransmissioPodcast);
		lblRetransmissioPodcast.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// you can open a new frame here as
				// i have assumed you have declared "frame" as instance variable
				frame = new JFrame("Retransmissió Podcast");
				frame.setVisible(true);
				frame.setBounds(300, 100, 800, 800);

			}
		});

		JButton btnEntra_Registrat = new JButton("Entra/Registrat");
		btnEntra_Registrat.setForeground(Color.CYAN);
		btnEntra_Registrat.setBackground(Color.MAGENTA);
		panelMenu.add(btnEntra_Registrat);

		/************************
		 * 
		 * * cos de la pàgina*
		 * 
		 *********************/
		JPanel panelCos = new JPanel();
		panelCos.setLayout(null);
		panelCos.setBackground(Color.DARK_GRAY);

		frame.getContentPane().add(panelCos, BorderLayout.CENTER);

		JLabel lblMissatge = new JLabel("lblmissatge");
		lblMissatge.setForeground(Color.WHITE);
		lblMissatge.setBounds(820, 237, 239, 15);
		panelCos.add(lblMissatge);
		lblMissatge.setVisible(false);

		txbNom = new JTextField();
		txbNom.setText("Nom");
		txbNom.setToolTipText("Nom");
		txbNom.setBounds(537, 277, 200, 39);
		panelCos.add(txbNom);
		txbNom.setColumns(10);

		txtContrassenya = new JTextField();
		txtContrassenya.setToolTipText("contrea");
		txtContrassenya.setColumns(10);
		txtContrassenya.setBounds(537, 350, 200, 39);
		panelCos.add(txtContrassenya);

		txtRepetirContrassenya = new JTextField();
		txtRepetirContrassenya.setText("Repetir contrassenya");
		txtRepetirContrassenya.setToolTipText("Nom");
		txtRepetirContrassenya.setColumns(10);
		txtRepetirContrassenya.setBounds(537, 423, 200, 39);
		panelCos.add(txtRepetirContrassenya);

		txtAnyNaixement = new JTextField();
		txtAnyNaixement.setText("00/00/000");
		txtAnyNaixement.setToolTipText("any naix");
		txtAnyNaixement.setColumns(10);
		txtAnyNaixement.setBounds(537, 501, 200, 39);
		panelCos.add(txtAnyNaixement);

		txtAdrea = new JTextField();
		txtAdrea.setText("Adreça");
		txtAdrea.setToolTipText("Nom");
		txtAdrea.setColumns(10);
		txtAdrea.setBounds(537, 581, 200, 39);
		panelCos.add(txtAdrea);


		txtCognoms = new JTextField();
		txtCognoms.setText("Cognoms");
		txtCognoms.setToolTipText("Nom");
		txtCognoms.setColumns(10);
		txtCognoms.setBounds(1058, 277, 200, 39);
		panelCos.add(txtCognoms);

		txtDniniecif = new JTextField();
		txtDniniecif.setText("12345678Z");
		txtDniniecif.setToolTipText("Nom");
		txtDniniecif.setColumns(10);
		txtDniniecif.setBounds(1058, 350, 200, 39);
		panelCos.add(txtDniniecif);

		txtTelefon = new JTextField();
		txtTelefon.setText("000000000");
		txtTelefon.setToolTipText("telefon");
		txtTelefon.setColumns(10);
		txtTelefon.setBounds(1058, 423, 200, 39);
		panelCos.add(txtTelefon);

		txtInfoAdicional = new JTextField();
		txtInfoAdicional.setText("Info adicional");
		txtInfoAdicional.setToolTipText("info");
		txtInfoAdicional.setColumns(10);
		txtInfoAdicional.setBounds(1058, 501, 200, 119);
		panelCos.add(txtInfoAdicional);


		JButton btnRegistre = new JButton("Registre");
		btnRegistre.setForeground(Color.CYAN);
		btnRegistre.setBorder(new LineBorder(Color.CYAN, 1, true));
		btnRegistre.setBackground(Color.MAGENTA);
		btnRegistre.setBounds(820, 670, 158, 43);
		panelCos.add(btnRegistre);

		btnRegistre.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// cridem la validació del usuari per a que pugui fer la consulta sql si esta
				// validat.
				String valid = validarUsuari(usuaris, usuariComplet, lblMissatge);
				try {
					if (usuaris != null && valid == "usuariValid") {
						Connection connection = null;
						Class.forName("com.mysql.cj.jdbc.Driver");
						connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/M13Projecte",
								"root", "galin");
						System.out.println("Conectant...");

						ConnexioMysql cm = new ConnexioMysql();
						cm.registreUsuari(usuaris, connection);

						lblMissatge.setText("Usuari insertat!");
						lblMissatge.setVisible(true);

						if (connection != null) {
							connection.close();
						}
					} else {
						System.out.println("No hi ha cap dada de l'usuari per poder ser inserit.");
					}

				} catch (SQLException | ClassNotFoundException sqlException) {
					sqlException.printStackTrace();
				}

			}

		});

		JLabel lblCosPagina = new JLabel("");
		lblCosPagina = new JLabel("",
				new ImageIcon(MenuPpal.class.getResource("/imatgesPerPantalles/imatgesApp/paginaRegiste.jpg")),
				SwingConstants.CENTER);
		lblCosPagina.setBackground(new Color(0, 204, 204));
		lblCosPagina.setBounds(0, -52, 1920, 1080);
		panelCos.add(lblCosPagina);

		frame.setBounds(300, 100, 1920, 1080);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public String validarUsuari(Usuaris usuari, boolean usuariComplet, JLabel lblMissatge) {

		/*
		 * if (isNullEmpty(usuari.getNomUsuari()) !=null &&
		 * isNullEmpty(usuari.getCognomsUsuari()) != null &&
		 * isNullEmpty(usuari.getContrasenyaUsuari2()) != null &&
		 * isNullEmpty(usuari.getAdreca()) != null && usuari.getAnyNaixement() != null
		 * && isNullEmpty(usuari.getInfoAdicional()) != null &&
		 * isNullEmpty(usuari.getNIF()) != null && usuari.getTelefon() != 0) {
		 */

		// comprovació per el nom
		if (txbNom.getText() != null && txbNom.getText().trim().isEmpty()) {
			usuari.setNomUsuari(txbNom.getText());
			usuariComplet = true;
		} else {
			lblMissatge.setText("Error al insertar l'usuari");
			lblMissatge.setVisible(true);
		}

		// comprovació per la contrassenya
		if (txtContrassenya.getText() != null && !txtContrassenya.getText().trim().isEmpty()
				&& txtContrassenya.getText().length() < 8) {
			usuari.setContrasenyaUsuari(txtContrassenya.getText());
			usuariComplet = true;
			return "usuariValid";
		} else {
			lblMissatge.setText("Error al insertar l'usuari, revisa la contrassenya");
			lblMissatge.setVisible(true);
			return null;
		}
//		// agafem el text del formulari
//		if (txtRepetirContrassenya.getText() != null || txtRepetirContrassenya.getText() != "") {
//			usuaris.setContrasenyaUsuari2(txtRepetirContrassenya.getText());
//			usuariComplet = true;
//		} else {
//			lblMissatge.setText("Error al insertar l'usuari");
//			lblMissatge.setVisible(true);
//		}
//		// agafem el text del formulari
//		try {
//			if (txtAnyNaixement.getText() != null || txtAnyNaixement.getText() != "") {
//				Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(txtAnyNaixement.getText());
//				usuaris.setAnyNaixement(date1);
//				usuariComplet = true;
//			} else {
//				lblMissatge.setText("Error al insertar l'usuari");
//				lblMissatge.setVisible(true);
//			}
//		} catch (ParseException e1) {
//			e1.printStackTrace();
//		}
		// agafem el text del formulari
//		if (txtAdrea.getText() != null || txtAdrea.getText() != "") {
//			usuaris.setAdreca(txtAdrea.getText());
//			usuariComplet = true;
//		} else {
//			lblMissatge.setText("Error al insertar l'usuari");
//			lblMissatge.setVisible(true);
//		}
		// agafem el text del formulari
//		if (txtCognoms.getText() != null || txtCognoms.getText() != "") {
//			usuaris.setCognomsUsuari(txtCognoms.getText());
//			usuariComplet = true;
//		} else {
//			lblMissatge.setText("Error al insertar l'usuari");
//			lblMissatge.setVisible(true);
//		}
		// agafem el text del formulari
//		if (txtDniniecif.getText() != null || txtDniniecif.getText() != "") {
//			usuaris.setNIF(txtDniniecif.getText());
//			usuariComplet = true;
//		} else {
//			lblMissatge.setText("Error al insertar l'usuari");
//			lblMissatge.setVisible(true);
//		}
		// agafem el text del formulari
//		if (txtTelefon.getText() != null || txtTelefon.getText() != "") {
//			int telefon = Integer.parseInt(txtTelefon.getText());
//			usuaris.setTelefon(telefon);
//			usuariComplet = true;
//		} else {
//			lblMissatge.setText("Error al insertar l'usuari");
//			lblMissatge.setVisible(true);
//		}
		// agafem el text del formulari
//		if (txtInfoAdicional.getText() != null || txtInfoAdicional.getText() != "") {
//			usuaris.setInfoAdicional(txtInfoAdicional.getText());
//			usuariComplet = true;
//		} else {
//			lblMissatge.setText("Error al insertar l'usuari");
//			lblMissatge.setVisible(true);
//		}

	}

	// method check if string is null or empty
	public static String isNullEmpty(String str) {

		if (str == null || str.isEmpty() || str.trim().isEmpty()) {
			System.out.println("El valor es null, buit o en blanc.");
			return null;
		} else {
			System.out.println("El valor no es null, buit o en blanc");
			return str;
		}
	}
}
