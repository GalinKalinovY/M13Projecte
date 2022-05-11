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
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class PaginaPodcastInfo {

	private JFrame frame;
	private JLabel lblCosPagina_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaginaPodcastInfo window = new PaginaPodcastInfo();
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
	public PaginaPodcastInfo() throws ClassNotFoundException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws ClassNotFoundException
	 */
	private void initialize() throws ClassNotFoundException {

		List<cat.almata.projectem13.classes.Podcast> podcasts = new ArrayList<cat.almata.projectem13.classes.Podcast>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/M13Projecte",
					"root", "galin");
			System.out.println("Conectant...");

			ConnexioMysql conMysql = new ConnexioMysql();
			//podcasts = conMysql.consultaPodcast(connection);

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
		/********** ACABAMENT DEL MENU *********/

		
		
		
		/*********** COS PAGINA **************/
		JPanel panelCos = new JPanel();
		panelCos.setLayout(null);
		panelCos.setBackground(Color.DARK_GRAY);

		frame.getContentPane().add(panelCos, BorderLayout.CENTER);
		
		JLabel lblCosPagina = new JLabel("");

		lblCosPagina = new JLabel("",
				new ImageIcon(MenuPpal.class.getResource("/imatgesPerPantalles/imatgesApp/neon_podcast_bg.jpg")),
				SwingConstants.CENTER);
		lblCosPagina.setBackground(new Color(0, 204, 204));
		lblCosPagina.setBounds(-100, -300, 1920, 1080);
		panelCos.add(lblCosPagina);

		frame.setBounds(300, 100, 1920, 1080);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}

}
