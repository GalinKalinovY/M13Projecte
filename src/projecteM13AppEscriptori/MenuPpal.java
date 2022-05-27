package projecteM13AppEscriptori;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Icon;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import cat.almata.projectem13.connexioBBDD.ConnexioMysql;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JMenuBar;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuPpal {

	private JFrame frame;
	private static String nomUsuariLogin = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					if (args.length != 0) {
						MenuPpal window = new MenuPpal(args[0]);
						window.frame.setVisible(true);
						nomUsuariLogin=args[0];
					} else {
						MenuPpal window = new MenuPpal("");
						window.frame.setVisible(true);
						nomUsuariLogin ="";
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MenuPpal(String nomUsuari) {
		nomUsuariLogin=nomUsuari;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

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

		JLabel lblNomUsuari = new JLabel("Benvingut,");
		lblNomUsuari.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		lblNomUsuari.setForeground(new Color(255, 255, 255));
		panelMenu.add(lblNomUsuari);
		
		if(nomUsuariLogin !=null)lblNomUsuari.setText("Benvingut, "+nomUsuariLogin);

		JLabel lblSpacer = new JLabel("               ");
		panelMenu.add(lblSpacer);

		JLabel lblIconaMenu = new JLabel("");
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
					// TODO Auto-generated catch block
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
		btnEntra_Registrat.setForeground(Color.CYAN);
		btnEntra_Registrat.setBackground(Color.MAGENTA);
		panelMenu.add(btnEntra_Registrat);
		btnEntra_Registrat.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// quant cliquem sobre el boto ens redireccionarà en la paina del formulari.
				PaginaRegistre paginaRegistre = null;
				try {
					paginaRegistre = new PaginaRegistre();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				String[] s = new String[] { "" };
				paginaRegistre.main(s);
				frame.dispose();
			}
		});

		// cos de la pàgina
		JPanel panelCos = new JPanel();
		panelCos.setLayout(null);
		panelCos.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(panelCos, BorderLayout.CENTER);

		JLabel lblTitol = new JLabel("Milions de podcasts,\n des dels més coneguts fins als independents.");
		lblTitol.setBounds(262, 195, 1237, 50);
		lblTitol.setFont(new Font("Arial", Font.BOLD, 30));
		lblTitol.setPreferredSize(new Dimension(250, 100));
		panelCos.add(lblTitol);
		lblTitol.setForeground(new Color(204, 153, 255));

		JLabel lblDescripcio = new JLabel("Un catàleg que diu molt.");
		lblDescripcio.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescripcio.setBounds(262, 273, 223, 78);
		lblDescripcio.setFont(new Font("Dialog", Font.BOLD, 15));
		lblDescripcio.setPreferredSize(new Dimension(250, 100));
		panelCos.add(lblDescripcio);
		lblDescripcio.setForeground(Color.WHITE);

		JButton btnLlistaPodcasts = new JButton("Llista Podcasts");
		btnLlistaPodcasts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
		btnLlistaPodcasts.setBackground(new Color(0, 204, 204));
		btnLlistaPodcasts.setBounds(372, 512, 158, 43);
		btnLlistaPodcasts.setBorder(new LineBorder(new Color(255, 0, 153), 1, true));
		panelCos.add(btnLlistaPodcasts);
		// funcionalitat del boto de llista Podcasts
		btnLlistaPodcasts.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				LlistaPodcasts llistaPodcasts = null;
				try {
					llistaPodcasts = new LlistaPodcasts("");
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
				String[] s = new String[] { "" };
				llistaPodcasts.main(s);
				frame.dispose();
			}
		});

		JLabel lblLaColleccis = new JLabel(
				"La col·lecció és enorme i la varietat, infinita. Des de presentadors de renom internacional fins als creadors més alternatius,");
		lblLaColleccis.setPreferredSize(new Dimension(250, 100));
		lblLaColleccis.setHorizontalAlignment(SwingConstants.LEFT);
		lblLaColleccis.setForeground(Color.WHITE);
		lblLaColleccis.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblLaColleccis.setBounds(272, 363, 1080, 57);
		panelCos.add(lblLaColleccis);

		JLabel lblAquestProgramaDe = new JLabel(
				"Aquest programa de què tothom parla? El tens a la app Podcasts. Aquesta joia que només tu coneixes? També.");
		lblAquestProgramaDe.setPreferredSize(new Dimension(250, 100));
		lblAquestProgramaDe.setHorizontalAlignment(SwingConstants.LEFT);
		lblAquestProgramaDe.setForeground(Color.WHITE);
		lblAquestProgramaDe.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblAquestProgramaDe.setBounds(272, 330, 956, 57);
		panelCos.add(lblAquestProgramaDe);

		JLabel lblAquCapVeu = new JLabel("aquí cap veu se sent més alta que una altra.");
		lblAquCapVeu.setPreferredSize(new Dimension(250, 100));
		lblAquCapVeu.setHorizontalAlignment(SwingConstants.LEFT);
		lblAquCapVeu.setForeground(Color.WHITE);
		lblAquCapVeu.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblAquCapVeu.setBounds(272, 399, 1080, 57);
		panelCos.add(lblAquCapVeu);

		JButton btnRetransmissio = new JButton("Retransmissió");
		btnRetransmissio.setForeground(new Color(255, 0, 204));
		btnRetransmissio.setBackground(new Color(0, 255, 255));
		btnRetransmissio.setBounds(542, 512, 158, 43);
		btnRetransmissio.setBorder(new LineBorder(new Color(255, 0, 153), 1, true));
		panelCos.add(btnRetransmissio);

		JLabel bgCosPagina;
		bgCosPagina = new JLabel("",
				new ImageIcon(MenuPpal.class.getResource("/imatgesPerPantalles/imatgesApp/podcastsBG_Neon.jpg")),
				SwingConstants.CENTER);
		bgCosPagina.setBackground(new Color(0, 204, 204));
		bgCosPagina.setBounds(0, -100, 1920, 1080);
		panelCos.add(bgCosPagina);

		frame.setBounds(300, 100, 1920, 1080);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}
