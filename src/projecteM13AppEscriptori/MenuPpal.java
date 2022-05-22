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

public class MenuPpal {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPpal window = new MenuPpal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MenuPpal() {
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
				LlistaPodcasts llistaPodcasts = null;
				try {
					llistaPodcasts = new LlistaPodcasts();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String[] s = new String[] { "0" };
				llistaPodcasts.main(s);
				frame.dispose();
			}
		});

		JLabel lblElsMeusPodcasts = new JLabel(" Els meus podcasts ");
		lblElsMeusPodcasts.setForeground(Color.CYAN);
		panelMenu.add(lblElsMeusPodcasts);
		lblElsMeusPodcasts.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// you can open a new frame here as
				// i have assumed you have declared "frame" as instance variable
				/*
				 * frame = new JFrame("Els meus Podcasts"); frame.setVisible(true);
				 * frame.setBounds(300, 100, 800, 800);
				 */

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
				String[] s = new String[] { "0" };
				paginaRegistre.main(s);
				frame.dispose();
			}
		});

		// cos de la pàgina
		JPanel panelCos = new JPanel();
		panelCos.setLayout(null);
		panelCos.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(panelCos, BorderLayout.CENTER);

		JLabel lblTitol = new JLabel("Qui som, que oferim...etc.");
		lblTitol.setBounds(262, 195, 501, 50);
		lblTitol.setFont(new Font("Arial", Font.BOLD, 30));
		lblTitol.setPreferredSize(new Dimension(250, 100));
		panelCos.add(lblTitol);
		lblTitol.setForeground(Color.WHITE);

		JLabel lblDescripcio = new JLabel("Una breu descripció del que fem");
		lblDescripcio.setBounds(362, 449, 386, 50);
		lblDescripcio.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblDescripcio.setPreferredSize(new Dimension(250, 100));
		panelCos.add(lblDescripcio);
		lblDescripcio.setForeground(Color.WHITE);

		JButton btnLlistaPodcasts = new JButton("Llista Podcasts");
		btnLlistaPodcasts.setBackground(new Color(0, 204, 204));
		btnLlistaPodcasts.setBounds(372, 512, 158, 43);
		btnLlistaPodcasts.setBorder(new LineBorder(new Color(255, 0, 153), 1, true));
		panelCos.add(btnLlistaPodcasts);
		// funcionalitat del boto de llista Podcasts
		btnLlistaPodcasts.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				LlistaPodcasts llistaPodcasts = null;
				try {
					llistaPodcasts = new LlistaPodcasts();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
				String[] s = new String[] { "0" };
				llistaPodcasts.main(s);
				frame.dispose();
			}
		});

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
