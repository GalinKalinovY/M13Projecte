package projecteM13AppEscriptori;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import cat.almata.projectem13.classes.Podcast;
import cat.almata.projectem13.connexioBBDD.ConnexioMysql;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.Icon;
import javax.swing.JTextArea;

public class PaginaPodcastInfo {

	private JFrame frame;
	private JLabel lblCosPagina_1;
	private static String idPodcast;
	private static String nomUsuariLogin;
	Podcast podcastTriat;

	/**
	 * Launch the application.
	 */
	public void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					if (args.length != 0) {
						PaginaPodcastInfo window = new PaginaPodcastInfo(args[0], args[1]);
						window.frame.setVisible(true);
						idPodcast = args[0];
					} else {
						PaginaPodcastInfo window = new PaginaPodcastInfo(null, null);
						window.frame.setVisible(true);
						idPodcast = args[0];
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @param string
	 * 
	 * @throws ClassNotFoundException
	 */
	public PaginaPodcastInfo(String stringId, String stringNom) throws ClassNotFoundException {
		idPodcast = stringId;
		nomUsuariLogin = stringNom;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws ClassNotFoundException
	 */
	private void initialize() throws ClassNotFoundException {

		podcastTriat = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/M13Projecte",
					"root", "galinkalinov99");
			System.out.println("Conectant...");

			ConnexioMysql conMysql = new ConnexioMysql();
			if (idPodcast != null) {
				podcastTriat = conMysql.consultaPodcast(connection, idPodcast);
			}

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}

		frame = new JFrame();
		BorderLayout borderLayout = (BorderLayout) frame.getContentPane().getLayout();

		// menu de la pàgina
		JPanel panelMenu = new JPanel();
		panelMenu.setBackground(Color.DARK_GRAY);
		FlowLayout fl_panelMenu = (FlowLayout) panelMenu.getLayout();
		// fl_panelMenu.setVgap(30);
		frame.getContentPane().add(panelMenu, BorderLayout.NORTH);
		// lblIconaMenu.setIcon(new
		// ImageIcon(MenuPpal.class.getResource("/imatgesPerPantalles/imatgesApp/podcastNeonIcona.jpeg")));

		ImageIcon imageIcon = new ImageIcon(
				new ImageIcon(MenuPpal.class.getResource("/imatgesPerPantalles/imatgesApp/podcastNeonIcona.jpeg"))
						.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));

		JLabel lblNomLoginUsuari = new JLabel("Benvingut,");
		lblNomLoginUsuari.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		lblNomLoginUsuari.setForeground(new Color(255, 255, 255));
		panelMenu.add(lblNomLoginUsuari);

		if (nomUsuariLogin != null)
			lblNomLoginUsuari.setText("Benvingut, " + nomUsuariLogin);

		JLabel lblSpacer = new JLabel("               ");
		panelMenu.add(lblSpacer);

		JLabel lblIconaMenu = new JLabel("");
		lblIconaMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuPpal menuPpal = null;
				if (nomUsuariLogin != null) {
					menuPpal = new MenuPpal(nomUsuariLogin);
					String[] s = new String[] { nomUsuariLogin };
					menuPpal.main(s);
					frame.dispose();
				} else {
					menuPpal = new MenuPpal("");
					String[] s = new String[] { "" };
					menuPpal.main(s);
					frame.dispose();
				}

			}
		});
		lblIconaMenu.setIcon(imageIcon);
		panelMenu.add(lblIconaMenu);

		JLabel lblLlistaPodcasts = new JLabel(" Llista Podcasts ");
		lblLlistaPodcasts.setForeground(Color.CYAN);
		panelMenu.add(lblLlistaPodcasts);
		lblLlistaPodcasts.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				LlistaPodcasts llistaPodcasts = null;
				try {
					llistaPodcasts = new LlistaPodcasts(nomUsuariLogin);
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
				String[] s = new String[] { nomUsuariLogin };
				llistaPodcasts.main(s);
				frame.dispose();
			}
		});

		JLabel lblElsMeusPodcasts = new JLabel(" Els meus podcasts ");
		lblElsMeusPodcasts.setForeground(Color.CYAN);
		panelMenu.add(lblElsMeusPodcasts);
		lblElsMeusPodcasts.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				ElsMeusPodcasts elsmeusPodcasts = null;
				if (nomUsuariLogin != null) {
					try {
						elsmeusPodcasts = new ElsMeusPodcasts(nomUsuariLogin);
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					}
					String[] s = new String[] { nomUsuariLogin };
					elsmeusPodcasts.main(s);
					frame.dispose();
				} else {
					try {
						elsmeusPodcasts = new ElsMeusPodcasts("");
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					}
					String[] s = new String[] { "" };
					elsmeusPodcasts.main(s);
					frame.dispose();
				}

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
				frame.dispose();
			}
		});

		JButton btnEntra_Registrat = new JButton("Entra/Registrat");
		btnEntra_Registrat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// quant cliquem sobre el boto ens redireccionarà en la paina del formulari.
				PaginaRegistre paginaRegistre = null;
				try {
					paginaRegistre = new PaginaRegistre();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				String[] s = new String[] { "0" };
				paginaRegistre.main(s);
				frame.dispose();
			}
		});
		btnEntra_Registrat.setForeground(Color.CYAN);
		btnEntra_Registrat.setBackground(Color.MAGENTA);
		panelMenu.add(btnEntra_Registrat);
		JPanel panelCos = new JPanel();
		panelCos.setLayout(null);
		panelCos.setBackground(Color.DARK_GRAY);

		frame.getContentPane().add(panelCos, BorderLayout.CENTER);

		JLabel lblNewLabel_3 = new JLabel("No pots afegir el podcast si no estas logeijat");
		lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_3.setVisible(false);
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(206, 35, 437, 43);
		panelCos.add(lblNewLabel_3);

		JLabel lblCosPagina = new JLabel("");

		JLabel lblLlista = new JLabel("", new ImageIcon(MenuPpal.class.getResource(podcastTriat.getImatge())),
				SwingConstants.CENTER);
		lblLlista.setBounds(1135, 198, 572, 455);
		panelCos.add(lblLlista);
		lblLlista.setBackground(new Color(0, 204, 204));

		JLabel lblNewLabel_1 = new JLabel(podcastTriat.getNom());
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel_1.setForeground(new Color(204, 51, 255));
		lblNewLabel_1.setBounds(206, 149, 261, 84);
		panelCos.add(lblNewLabel_1);

		JButton btnNewButton = new JButton("Escolta");
		btnNewButton.setBounds(206, 628, 117, 25);
		panelCos.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Afegir");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {

					Connection connection = null;
					Class.forName("com.mysql.cj.jdbc.Driver");
					connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/M13Projecte",
							"root", "galinkalinov99");
					System.out.println("Conectant...");

					ConnexioMysql cm = new ConnexioMysql();
					if (nomUsuariLogin != null && nomUsuariLogin != "") {
						String resultat = cm.afegirPodcastPersonal(nomUsuariLogin, podcastTriat, connection);

						if (resultat.equals("afegit")) {
							ElsMeusPodcasts elsmeusPodcasts = null;
							if (nomUsuariLogin != null) {
								try {
									elsmeusPodcasts = new ElsMeusPodcasts(nomUsuariLogin);
								} catch (ClassNotFoundException e1) {
									e1.printStackTrace();
								}
								String[] s = new String[] { nomUsuariLogin };
								elsmeusPodcasts.main(s);
								frame.dispose();
							} else {
								try {
									elsmeusPodcasts = new ElsMeusPodcasts("");
								} catch (ClassNotFoundException e1) {
									e1.printStackTrace();
								}
								String[] s = new String[] { "" };
								elsmeusPodcasts.main(s);
								frame.dispose();
							}
						}

						if (connection != null) {
							connection.close();
						}
					} else {
						lblNewLabel_3.setVisible(true);
						System.out.println("El usuari es guest i no pot afegir el podcast a la llista personal");
					}

				} catch (SQLException | ClassNotFoundException sqlException) {
					sqlException.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(350, 628, 117, 25);
		panelCos.add(btnNewButton_1);

		JTextArea textArea = new JTextArea(podcastTriat.getDescripcio());
		textArea.setFont(new Font("Dialog", Font.ITALIC, 18));
		textArea.setForeground(new Color(255, 255, 255));
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setOpaque(false);
		textArea.setBorder(BorderFactory.createEmptyBorder());
		textArea.setBounds(206, 258, 566, 268);
		panelCos.add(textArea);

		JLabel lblNewLabel_2 = new JLabel(String.valueOf(podcastTriat.getPreu()));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel_2.setBounds(618, 617, 147, 43);
		panelCos.add(lblNewLabel_2);

		JLabel lblNewLabel = new JLabel("Preu:");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(548, 628, 78, 25);
		panelCos.add(lblNewLabel);

		lblCosPagina = new JLabel("",
				new ImageIcon(MenuPpal.class.getResource("/imatgesPerPantalles/imatgesApp/BG_Llista_Podcasts.jpg")),
				SwingConstants.CENTER);
		lblCosPagina.setBackground(new Color(0, 204, 204));
		lblCosPagina.setBounds(-58, -268, 1953, 1108);
		panelCos.add(lblCosPagina);

		frame.setBounds(300, 100, 1920, 1080);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}
}
