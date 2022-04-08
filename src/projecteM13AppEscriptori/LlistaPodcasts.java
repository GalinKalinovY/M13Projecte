package projecteM13AppEscriptori;

import cat.almata.projectem13.classes.*;
import cat.almata.projectem13.connexioBBDD.*;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Icon;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JMenuBar;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.SystemColor;
import javax.swing.table.DefaultTableModel;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class LlistaPodcasts extends ConnexioMysql {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LlistaPodcasts window = new LlistaPodcasts();
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
	 * @throws ClassNotFoundException
	 */
	public LlistaPodcasts() throws ClassNotFoundException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws ClassNotFoundException
	 */
	private void initialize() throws ClassNotFoundException {

		List<cat.almata.projectem13.classes.LlistaPodcasts> podcasts = new ArrayList<cat.almata.projectem13.classes.LlistaPodcasts>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/M13Projecte",
					"root", "galin");
			System.out.println("Conectant...");

			podcasts = consultaPodcasts(connection);

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
				frame = new JFrame("Els meus Podcasts");
				frame.setVisible(true);
				frame.setBounds(300, 100, 800, 800);
				frame.dispose();
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

		// cos de la pàgina
		JPanel panelCos = new JPanel();
		panelCos.setLayout(null);
		panelCos.setBackground(Color.DARK_GRAY);

		frame.getContentPane().add(panelCos, BorderLayout.CENTER);

		/*********** PODCAST 1 **************/
		JLabel lblLlista = new JLabel("");
		lblLlista = new JLabel("", new ImageIcon(MenuPpal.class.getResource(podcasts.get(0).getImatge())),
				SwingConstants.CENTER);
		lblLlista.setBackground(new Color(0, 204, 204));
		lblLlista.setBounds(149, 72, 294, 248);
		panelCos.add(lblLlista);

		JPanel panelInfo = new JPanel();
		panelInfo.setLayout(new GridBagLayout());
		panelInfo.setSize(1000, 1000);
		panelInfo.setBackground(new Color(51, 51, 255));
		panelInfo.setBounds(149, 319, 294, 102);
		panelCos.add(panelInfo);

		JLabel lblNomPodcast = new JLabel(podcasts.get(0).getNom());
		lblNomPodcast.setFont(new Font("Dialog", Font.BOLD, 13));
		GridBagConstraints gbc_lblNomPodcast = new GridBagConstraints();
		gbc_lblNomPodcast.insets = new Insets(0, 0, 40, 40);
		gbc_lblNomPodcast.gridx = 2;
		gbc_lblNomPodcast.gridy = 0;
		panelInfo.add(lblNomPodcast, gbc_lblNomPodcast);
		lblNomPodcast.setForeground(Color.BLACK);

		JLabel lblTemaPodcast = new JLabel(podcasts.get(0).getTemaPodcast());
		GridBagConstraints gbc_lblTemaPodcast = new GridBagConstraints();
		gbc_lblTemaPodcast.gridx = 0;
		gbc_lblTemaPodcast.gridy = 5;
		panelInfo.add(lblTemaPodcast, gbc_lblTemaPodcast);
		lblTemaPodcast.setForeground(Color.WHITE);

		JLabel lblPreuPodcast = new JLabel(String.valueOf("Preu: "+podcasts.get(0).getPreu()));
		GridBagConstraints gbc_lblPreuPodcast = new GridBagConstraints();
		gbc_lblPreuPodcast.gridx = 3;
		gbc_lblPreuPodcast.gridy = 5;
		panelInfo.add(lblPreuPodcast, gbc_lblPreuPodcast);
		lblPreuPodcast.setForeground(Color.WHITE);

		/*********** PODCAST 2 **************/

		JLabel lblLlista2 = new JLabel("");
		lblLlista2 = new JLabel("", new ImageIcon(MenuPpal.class.getResource(podcasts.get(0).getImatge())),
				SwingConstants.CENTER);
		lblLlista2.setBackground(new Color(0, 204, 204));
		lblLlista2.setBounds(555, 72, 294, 248);
		panelCos.add(lblLlista2);

		JPanel panelInfo2 = new JPanel();
		panelInfo2.setLayout(new GridBagLayout());
		panelInfo2.setSize(1000, 1000);
		panelInfo2.setBackground(new Color(51, 51, 255));
		panelInfo2.setBounds(555, 319, 294, 102);
		panelCos.add(panelInfo2);

		JLabel lblNomPodcast2 = new JLabel(podcasts.get(0).getNom());
		lblNomPodcast2.setFont(new Font("Dialog", Font.BOLD, 13));
		GridBagConstraints gbc_lblNomPodcast2 = new GridBagConstraints();
		gbc_lblNomPodcast2.insets = new Insets(0, 0, 40, 40);
		gbc_lblNomPodcast2.gridx = 2;
		gbc_lblNomPodcast2.gridy = 0;
		panelInfo2.add(lblNomPodcast2, gbc_lblNomPodcast2);
		lblNomPodcast2.setForeground(Color.BLACK);

		JLabel lblTemaPodcast2 = new JLabel(podcasts.get(0).getTemaPodcast());
		GridBagConstraints gbc_lblTemaPodcast2 = new GridBagConstraints();
		gbc_lblTemaPodcast2.gridx = 0;
		gbc_lblTemaPodcast2.gridy = 5;
		panelInfo2.add(lblTemaPodcast2, gbc_lblTemaPodcast2);
		lblTemaPodcast2.setForeground(Color.WHITE);

		JLabel lblPreuPodcast2 = new JLabel(String.valueOf("Preu: "+podcasts.get(0).getPreu()));
		GridBagConstraints gbc_lblPreuPodcast2 = new GridBagConstraints();
		gbc_lblPreuPodcast2.gridx = 3;
		gbc_lblPreuPodcast2.gridy = 5;
		panelInfo2.add(lblPreuPodcast2, gbc_lblPreuPodcast2);
		lblPreuPodcast2.setForeground(Color.WHITE);

		/*********** COS PAGINA **************/
		JLabel lblCosPagina = new JLabel("");

		lblCosPagina = new JLabel("",
				new ImageIcon(MenuPpal.class.getResource("/imatgesPerPantalles/imatgesApp/BG_Llista_Podcasts.jpg")),
				SwingConstants.CENTER);
		lblCosPagina.setBackground(new Color(0, 204, 204));
		lblCosPagina.setBounds(-100, -300, 1920, 1080);
		panelCos.add(lblCosPagina);

		frame.setBounds(300, 100, 1920, 1080);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}
}