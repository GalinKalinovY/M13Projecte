package projecteM13AppEscriptori;

import cat.almata.projectem13.connexioBBDD.*;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.SwingConstants;


import java.awt.FlowLayout;
import java.awt.Font;

import java.awt.Color;

import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
					"root", "galinkalinov99");
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
		btnEntra_Registrat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
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
		Object[] p = podcasts.toArray();
		lblLlista = new JLabel("", new ImageIcon(MenuPpal.class.getResource(podcasts.get(0).getImatge())),
				SwingConstants.CENTER);
		lblLlista.setBackground(new Color(0, 204, 204));
		lblLlista.setBounds(159, 48, 294, 248);
		panelCos.add(lblLlista);

	    JPanel panelInfo = new JPanel();
	    panelInfo.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		//ens portara a la pàgina del podcast amb la seva informació
	    	}
	    });

		panelInfo.setLayout(new GridBagLayout());
		panelInfo.setSize(1000, 1000);
		panelInfo.setBackground(new Color(51, 51, 255));
		panelInfo.setBounds(159, 295, 294, 102);
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

		JLabel lblPreuPodcast = new JLabel(String.valueOf("Preu: " + podcasts.get(0).getPreu()));
		GridBagConstraints gbc_lblPreuPodcast = new GridBagConstraints();
		gbc_lblPreuPodcast.gridx = 3;
		gbc_lblPreuPodcast.gridy = 5;
		panelInfo.add(lblPreuPodcast, gbc_lblPreuPodcast);
		lblPreuPodcast.setForeground(Color.WHITE);

		/*********** PODCAST 2 **************/

		JLabel lblLlista2 = new JLabel("");
		lblLlista2 = new JLabel("", new ImageIcon(MenuPpal.class.getResource(podcasts.get(1).getImatge())),
				SwingConstants.CENTER);
		lblLlista2.setBackground(new Color(0, 204, 204));
		lblLlista2.setBounds(555, 48, 294, 248);
		panelCos.add(lblLlista2);

		JPanel panelInfo2 = new JPanel();
		panelInfo2.setLayout(new GridBagLayout());
		panelInfo2.setSize(1000, 1000);
		panelInfo2.setBackground(new Color(51, 51, 255));
		panelInfo2.setBounds(555, 295, 294, 102);
		panelCos.add(panelInfo2);

		JLabel lblNomPodcast2 = new JLabel(podcasts.get(1).getNom());
		lblNomPodcast2.setFont(new Font("Dialog", Font.BOLD, 13));
		GridBagConstraints gbc_lblNomPodcast2 = new GridBagConstraints();
		gbc_lblNomPodcast2.insets = new Insets(0, 0, 40, 40);
		gbc_lblNomPodcast2.gridx = 2;
		gbc_lblNomPodcast2.gridy = 0;
		panelInfo2.add(lblNomPodcast2, gbc_lblNomPodcast2);
		lblNomPodcast2.setForeground(Color.BLACK);

		JLabel lblTemaPodcast2 = new JLabel(podcasts.get(1).getTemaPodcast());
		GridBagConstraints gbc_lblTemaPodcast2 = new GridBagConstraints();
		gbc_lblTemaPodcast2.gridx = 0;
		gbc_lblTemaPodcast2.gridy = 5;
		panelInfo2.add(lblTemaPodcast2, gbc_lblTemaPodcast2);
		lblTemaPodcast2.setForeground(Color.WHITE);

		JLabel lblPreuPodcast2 = new JLabel(String.valueOf("Preu: " + podcasts.get(1).getPreu()));
		GridBagConstraints gbc_lblPreuPodcast2 = new GridBagConstraints();
		gbc_lblPreuPodcast2.gridx = 3;
		gbc_lblPreuPodcast2.gridy = 5;
		panelInfo2.add(lblPreuPodcast2, gbc_lblPreuPodcast2);
		lblPreuPodcast2.setForeground(Color.WHITE);

		/*********** PODCAST 3 **************/

		JLabel lblLlista3 = new JLabel("");
		lblLlista3 = new JLabel("", new ImageIcon(MenuPpal.class.getResource(podcasts.get(2).getImatge())),
				SwingConstants.CENTER);
		lblLlista3.setBackground(new Color(0, 204, 204));
		lblLlista3.setBounds(964, 48, 294, 248);
		panelCos.add(lblLlista3);

		JPanel panelInfo3 = new JPanel();
		panelInfo3.setLayout(new GridBagLayout());
		panelInfo3.setSize(1000, 1000);
		panelInfo3.setBackground(new Color(51, 51, 255));
		panelInfo3.setBounds(964, 295, 294, 102);
		panelCos.add(panelInfo3);

		JLabel lblNomPodcast3 = new JLabel(podcasts.get(2).getNom());
		lblNomPodcast3.setFont(new Font("Dialog", Font.BOLD, 13));
		GridBagConstraints gbc_lblNomPodcast3 = new GridBagConstraints();
		gbc_lblNomPodcast3.insets = new Insets(0, 0, 40, 40);
		gbc_lblNomPodcast3.gridx = 2;
		gbc_lblNomPodcast3.gridy = 0;
		panelInfo3.add(lblNomPodcast3, gbc_lblNomPodcast3);
		lblNomPodcast3.setForeground(Color.BLACK);

		JLabel lblTemaPodcast3 = new JLabel(podcasts.get(2).getTemaPodcast());
		GridBagConstraints gbc_lblTemaPodcast3 = new GridBagConstraints();
		gbc_lblTemaPodcast3.gridx = 0;
		gbc_lblTemaPodcast3.gridy = 5;
		panelInfo3.add(lblTemaPodcast3, gbc_lblTemaPodcast3);
		lblTemaPodcast3.setForeground(Color.WHITE);

		JLabel lblPreuPodcast3 = new JLabel(String.valueOf("Preu: " + podcasts.get(2).getPreu()));
		GridBagConstraints gbc_lblPreuPodcast3 = new GridBagConstraints();
		gbc_lblPreuPodcast3.gridx = 3;
		gbc_lblPreuPodcast3.gridy = 5;
		panelInfo3.add(lblPreuPodcast3, gbc_lblPreuPodcast3);
		lblPreuPodcast3.setForeground(Color.WHITE);

		/*********** PODCAST 4 **************/

		JLabel lblLlista4 = new JLabel("");
		lblLlista4 = new JLabel("", new ImageIcon(MenuPpal.class.getResource(podcasts.get(3).getImatge())),
				SwingConstants.CENTER);
		lblLlista4.setBackground(new Color(0, 204, 204));
		lblLlista4.setBounds(1410, 48, 294, 248);
		panelCos.add(lblLlista4);

		JPanel panelInfo4 = new JPanel();
		panelInfo4.setLayout(new GridBagLayout());
		panelInfo4.setSize(1000, 1000);
		panelInfo4.setBackground(new Color(51, 51, 255));
		panelInfo4.setBounds(1410, 295, 294, 102);
		panelCos.add(panelInfo4);

		JLabel lblNomPodcast4 = new JLabel(podcasts.get(3).getNom());
		lblNomPodcast4.setFont(new Font("Dialog", Font.BOLD, 13));
		GridBagConstraints gbc_lblNomPodcast4 = new GridBagConstraints();
		gbc_lblNomPodcast4.insets = new Insets(0, 0, 40, 40);
		gbc_lblNomPodcast4.gridx = 2;
		gbc_lblNomPodcast4.gridy = 0;
		panelInfo4.add(lblNomPodcast4, gbc_lblNomPodcast4);
		lblNomPodcast4.setForeground(Color.BLACK);

		JLabel lblTemaPodcast4 = new JLabel(podcasts.get(3).getTemaPodcast());
		GridBagConstraints gbc_lblTemaPodcast4 = new GridBagConstraints();
		gbc_lblTemaPodcast4.gridx = 0;
		gbc_lblTemaPodcast4.gridy = 5;
		panelInfo4.add(lblTemaPodcast4, gbc_lblTemaPodcast4);
		lblTemaPodcast4.setForeground(Color.WHITE);

		JLabel lblPreuPodcast4 = new JLabel(String.valueOf("Preu: " + podcasts.get(3).getPreu()));
		GridBagConstraints gbc_lblPreuPodcast4 = new GridBagConstraints();
		gbc_lblPreuPodcast4.gridx = 3;
		gbc_lblPreuPodcast4.gridy = 5;
		panelInfo4.add(lblPreuPodcast4, gbc_lblPreuPodcast4);
		lblPreuPodcast4.setForeground(Color.WHITE);

		/*********** PODCAST 5 **************/

		JLabel lblLlista5 = new JLabel("");
		lblLlista5 = new JLabel("", new ImageIcon(MenuPpal.class.getResource(podcasts.get(4).getImatge())),
				SwingConstants.CENTER);
		lblLlista5.setBackground(new Color(0, 204, 204));
		lblLlista5.setBounds(169, 403, 294, 248);
		panelCos.add(lblLlista5);

		JPanel panelInfo5 = new JPanel();
		panelInfo5.setLayout(new GridBagLayout());
		panelInfo5.setSize(1000, 1000);
		panelInfo5.setBackground(new Color(51, 51, 255));
		panelInfo5.setBounds(169, 644, 294, 102);
		panelCos.add(panelInfo5);

		JLabel lblNomPodcast5 = new JLabel(podcasts.get(4).getNom());
		lblNomPodcast5.setFont(new Font("Dialog", Font.BOLD, 13));
		GridBagConstraints gbc_lblNomPodcast5 = new GridBagConstraints();
		gbc_lblNomPodcast5.insets = new Insets(0, 0, 40, 40);
		gbc_lblNomPodcast5.gridx = 2;
		gbc_lblNomPodcast5.gridy = 0;
		panelInfo5.add(lblNomPodcast5, gbc_lblNomPodcast5);
		lblNomPodcast5.setForeground(Color.BLACK);

		JLabel lblTemaPodcast5 = new JLabel(podcasts.get(4).getTemaPodcast());
		GridBagConstraints gbc_lblTemaPodcast5 = new GridBagConstraints();
		gbc_lblTemaPodcast5.gridx = 0;
		gbc_lblTemaPodcast5.gridy = 5;
		panelInfo5.add(lblTemaPodcast5, gbc_lblTemaPodcast5);
		lblTemaPodcast5.setForeground(Color.WHITE);

		JLabel lblPreuPodcast5 = new JLabel(String.valueOf("Preu: " + podcasts.get(4).getPreu()));
		GridBagConstraints gbc_lblPreuPodcast5 = new GridBagConstraints();
		gbc_lblPreuPodcast5.gridx = 3;
		gbc_lblPreuPodcast5.gridy = 5;
		panelInfo5.add(lblPreuPodcast5, gbc_lblPreuPodcast5);
		lblPreuPodcast5.setForeground(Color.WHITE);

		/*********** PODCAST 6 **************/

		JPanel panelInfo6 = new JPanel();
		panelInfo6.setBackground(new Color(51, 51, 255));
		panelInfo6.setBounds(555, 644, 294, 102);
		panelCos.add(panelInfo6);
		GridBagLayout gbl_panelInfo6 = new GridBagLayout();
		gbl_panelInfo6.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gbl_panelInfo6.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gbl_panelInfo6.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panelInfo6.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panelInfo6.setLayout(gbl_panelInfo6);

		JLabel lblLlista6 = new JLabel("", new ImageIcon(MenuPpal.class.getResource(podcasts.get(5).getImatge())),
				SwingConstants.CENTER);
		lblLlista6.setBackground(new Color(0, 204, 204));
		lblLlista6.setBounds(555, 403, 294, 248);
		panelCos.add(lblLlista6);

		JLabel lblNomPodcast6 = new JLabel(podcasts.get(5).getNom());
		lblNomPodcast6.setForeground(Color.BLACK);
		lblNomPodcast6.setFont(new Font("Dialog", Font.BOLD, 13));
		GridBagConstraints gbc_lblNomPodcast6 = new GridBagConstraints();
		gbc_lblNomPodcast6.insets = new Insets(0, 0, 40, 40);
		gbc_lblNomPodcast6.gridx = 2;
		gbc_lblNomPodcast6.gridy = 0;
		panelInfo6.add(lblNomPodcast6, gbc_lblNomPodcast6);

		JLabel lblTemaPodcast6 = new JLabel(podcasts.get(5).getTemaPodcast());
		lblTemaPodcast6.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblTemaPodcast6 = new GridBagConstraints();
		gbc_lblTemaPodcast6.insets = new Insets(0, 0, 0, 5);
		gbc_lblTemaPodcast6.gridx = 0;
		gbc_lblTemaPodcast6.gridy = 5;
		panelInfo6.add(lblTemaPodcast6, gbc_lblTemaPodcast6);

		JLabel lblPreuPodcast6 = new JLabel(String.valueOf("Preu: " + podcasts.get(5).getPreu()));
		lblPreuPodcast6.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblPreuPodcast6 = new GridBagConstraints();
		gbc_lblPreuPodcast6.gridx = 3;
		gbc_lblPreuPodcast6.gridy = 5;
		panelInfo6.add(lblPreuPodcast6, gbc_lblPreuPodcast6);

		/*********** PODCAST 7 **************/

		JLabel lblLlista7 = new JLabel("", new ImageIcon(MenuPpal.class.getResource(podcasts.get(6).getImatge())),
				SwingConstants.CENTER);
		lblLlista7.setBackground(new Color(0, 204, 204));
		lblLlista7.setBounds(964, 403, 294, 248);
		panelCos.add(lblLlista7);

		JPanel panelInfo7 = new JPanel();
		panelInfo7.setBackground(new Color(51, 51, 255));
		panelInfo7.setBounds(964, 644, 294, 102);
		panelCos.add(panelInfo7);
		GridBagLayout gbl_panelInfo7 = new GridBagLayout();
		gbl_panelInfo7.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gbl_panelInfo7.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gbl_panelInfo7.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panelInfo7.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panelInfo7.setLayout(gbl_panelInfo7);

		JLabel lblNomPodcast7 = new JLabel(podcasts.get(6).getNom());
		lblNomPodcast7.setForeground(Color.BLACK);
		lblNomPodcast7.setFont(new Font("Dialog", Font.BOLD, 13));
		GridBagConstraints gbc_lblNomPodcast7 = new GridBagConstraints();
		gbc_lblNomPodcast7.insets = new Insets(0, 0, 40, 40);
		gbc_lblNomPodcast7.gridx = 2;
		gbc_lblNomPodcast7.gridy = 0;
		panelInfo7.add(lblNomPodcast7, gbc_lblNomPodcast7);

		JLabel lblTemaPodcast7 = new JLabel(podcasts.get(6).getTemaPodcast());
		lblTemaPodcast7.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblTemaPodcast7 = new GridBagConstraints();
		gbc_lblTemaPodcast7.insets = new Insets(0, 0, 0, 5);
		gbc_lblTemaPodcast7.gridx = 0;
		gbc_lblTemaPodcast7.gridy = 5;
		panelInfo7.add(lblTemaPodcast7, gbc_lblTemaPodcast7);

		JLabel lblPreuPodcast7 = new JLabel(String.valueOf("Preu: " + podcasts.get(6).getPreu()));
		lblPreuPodcast7.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblPreuPodcast7 = new GridBagConstraints();
		gbc_lblPreuPodcast7.gridx = 3;
		gbc_lblPreuPodcast7.gridy = 5;
		panelInfo7.add(lblPreuPodcast7, gbc_lblPreuPodcast7);

		/*********** PODCAST 8 **************/

		JPanel panelInfo8 = new JPanel();
		panelInfo8.setBackground(new Color(51, 51, 255));
		panelInfo8.setBounds(1410, 644, 294, 102);
		panelCos.add(panelInfo8);
		GridBagLayout gbl_panelInfo8 = new GridBagLayout();
		gbl_panelInfo8.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gbl_panelInfo8.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gbl_panelInfo8.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panelInfo8.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panelInfo8.setLayout(gbl_panelInfo8);

		JLabel lblNomPodcast8 = new JLabel(podcasts.get(7).getNom());
		lblNomPodcast8.setForeground(Color.BLACK);
		lblNomPodcast8.setFont(new Font("Dialog", Font.BOLD, 13));
		GridBagConstraints gbc_lblNomPodcast8 = new GridBagConstraints();
		gbc_lblNomPodcast8.insets = new Insets(0, 0, 40, 40);
		gbc_lblNomPodcast8.gridx = 2;
		gbc_lblNomPodcast8.gridy = 0;
		panelInfo8.add(lblNomPodcast8, gbc_lblNomPodcast8);

		JLabel lblTemaPodcast8 = new JLabel(podcasts.get(7).getTemaPodcast());
		lblTemaPodcast8.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblTemaPodcast8 = new GridBagConstraints();
		gbc_lblTemaPodcast8.insets = new Insets(0, 0, 0, 5);
		gbc_lblTemaPodcast8.gridx = 0;
		gbc_lblTemaPodcast8.gridy = 5;
		panelInfo8.add(lblTemaPodcast8, gbc_lblTemaPodcast8);

		JLabel lblPreuPodcast8 = new JLabel(String.valueOf("Preu: " + podcasts.get(7).getPreu()));
		lblPreuPodcast8.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblPreuPodcast8 = new GridBagConstraints();
		gbc_lblPreuPodcast8.gridx = 3;
		gbc_lblPreuPodcast8.gridy = 5;
		panelInfo8.add(lblPreuPodcast8, gbc_lblPreuPodcast8);

		JLabel lblLlista8 = new JLabel("", new ImageIcon(MenuPpal.class.getResource(podcasts.get(7).getImatge())),
				SwingConstants.CENTER);
		lblLlista8.setBackground(new Color(0, 204, 204));
		lblLlista8.setBounds(1410, 409, 294, 248);
		panelCos.add(lblLlista8);

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