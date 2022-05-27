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
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import cat.almata.projectem13.classes.Podcast;
import cat.almata.projectem13.classes.Usuaris;
import cat.almata.projectem13.connexioBBDD.ConnexioMysql;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class PaginaRegistre {

	private JFrame frame;
	private JTextField txbNom;
	private JTextField txtContrassenya;
	private JTextField txtContrassenya2;
	private JTextField txtAdrea;
	private JTextField txtCognoms;
	private JTextField txtDniniecif;
	private JTextField txtTelefon;
	private JTextField txtInfoAdicional;
	private JTextField txbNomLogin;
	private JTextField txbContraLogin;
	String nomUsu = null;
	JLabel lblUsuariLogin;
	/**
	 * Launch the application.
	 */
	public void main(String[] args) {
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
		if(nomUsu!=null)lblUsuariLogin.setText("Benvingut, "+ nomUsu);

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
		
		lblUsuariLogin = new JLabel("Benvingut,");
		lblUsuariLogin.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		lblUsuariLogin.setForeground(new Color(255, 255, 255));
		panelMenu.add(lblUsuariLogin);

		JLabel lblSpacer = new JLabel("               ");
		panelMenu.add(lblSpacer);
		
				JLabel lblIconaMenu = new JLabel("");
				lblIconaMenu.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						MenuPpal menuPpal = null;
						if(nomUsu!=null) {
							menuPpal = new MenuPpal(nomUsu);
							String[] s = new String[] { nomUsu };
							menuPpal.main(s);
							frame.dispose();
						}else {
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
					llistaPodcasts = new LlistaPodcasts("");
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
				String[] s = new String[] { "" };
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
				if (nomUsu != null) {
					try {
						elsmeusPodcasts = new ElsMeusPodcasts(nomUsu);
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					}
					String[] s = new String[] { nomUsu };
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
		lblMissatge.setBounds(1147, 233, 371, 15);
		panelCos.add(lblMissatge);
		lblMissatge.setVisible(false);

		txbNom = new JTextField();
		txbNom.setToolTipText("Nom");
		txbNom.setColumns(10);
		txbNom.setBounds(1000, 277, 200, 39);
		panelCos.add(txbNom);

		txtContrassenya = new JTextField();
		txtContrassenya.setToolTipText("contrea");
		txtContrassenya.setColumns(10);
		txtContrassenya.setBounds(1000, 350, 200, 39);
		panelCos.add(txtContrassenya);

		txtContrassenya2 = new JTextField();
		txtContrassenya2.setToolTipText("Nom");
		txtContrassenya2.setColumns(10);
		txtContrassenya2.setBounds(1000, 423, 200, 39);
		panelCos.add(txtContrassenya2);

		UtilDateModel model = new UtilDateModel();
		model.setDate(1990, 8, 24);
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		datePicker.setBounds(1000, 489, 200, 39);
		panelCos.add(datePicker);

		txtAdrea = new JTextField();
		txtAdrea.setToolTipText("Nom");
		txtAdrea.setColumns(10);
		txtAdrea.setBounds(1000, 564, 200, 39);
		panelCos.add(txtAdrea);

		txtCognoms = new JTextField();
		txtCognoms.setToolTipText("Nom");
		txtCognoms.setColumns(10);
		txtCognoms.setBounds(1420, 277, 200, 39);
		panelCos.add(txtCognoms);

		txtDniniecif = new JTextField();
		txtDniniecif.setToolTipText("Nom");
		txtDniniecif.setColumns(10);
		txtDniniecif.setBounds(1420, 350, 200, 39);
		panelCos.add(txtDniniecif);

		txtTelefon = new JTextField();
		txtTelefon.setToolTipText("telefon");
		txtTelefon.setColumns(10);
		txtTelefon.setBounds(1420, 423, 200, 39);
		panelCos.add(txtTelefon);

		txtInfoAdicional = new JTextField();
		txtInfoAdicional.setToolTipText("info");
		txtInfoAdicional.setColumns(10);
		txtInfoAdicional.setBounds(1420, 501, 200, 119);
		panelCos.add(txtInfoAdicional);

		JButton btnRegistre = new JButton("Registre");
		btnRegistre.setForeground(Color.CYAN);
		btnRegistre.setBorder(new LineBorder(Color.CYAN, 1, true));
		btnRegistre.setBackground(Color.MAGENTA);
		btnRegistre.setBounds(1234, 647, 158, 43);
		panelCos.add(btnRegistre);

		btnRegistre.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// cridem la validació del usuari per a que pugui fer la consulta sql si esta
				// validat.
				String valid = validarUsuari(usuaris, usuariComplet, lblMissatge, datePicker);
				try {
					if (usuaris != null && valid == "usuariValid") {
						Connection connection = null;
						Class.forName("com.mysql.cj.jdbc.Driver");
						connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/M13Projecte",
								"root", "galinkalinov99");
						System.out.println("Conectant...");

						ConnexioMysql cm = new ConnexioMysql();
						String missatge = cm.registreUsuari(usuaris, connection);

						if(missatge.equals("inscrit")) {
							lblMissatge.setText("Usuari insertat!");
							lblMissatge.setVisible(true);
							
							LlistaPodcasts llistaPodcasts = null;
							try {
								llistaPodcasts = new LlistaPodcasts(usuaris.getNomUsuari());
							} catch (ClassNotFoundException e1) {
								e1.printStackTrace();
							}
							String[] s = new String[] { usuaris.getNomUsuari() };
							llistaPodcasts.main(s);
							frame.dispose();
							
						}else if(missatge.equals("existeix")){
							lblMissatge.setText("El usuari ja existeix! Canvia el nom");
							lblMissatge.setVisible(true);
						}else {
							lblMissatge.setVisible(false);
						}
						
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

		JLabel lblNewLabel = new JLabel("Nom");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(912, 289, 70, 15);
		panelCos.add(lblNewLabel);

		JLabel lblContrassenya = new JLabel("Contrassenya");
		lblContrassenya.setForeground(Color.WHITE);
		lblContrassenya.setBounds(875, 362, 107, 15);
		panelCos.add(lblContrassenya);

		JLabel lblRepetirContrassenya = new JLabel("Repetir \ncontrassenya");
		lblRepetirContrassenya.setForeground(Color.WHITE);
		lblRepetirContrassenya.setBounds(828, 423, 168, 39);
		panelCos.add(lblRepetirContrassenya);
		
		JLabel lblUsuariIncorrecte = new JLabel("usuariIncorrecte");
		lblUsuariIncorrecte.setForeground(new Color(255, 255, 255));
		lblUsuariIncorrecte.setBounds(548, 277, 168, 15);
		lblUsuariIncorrecte.setVisible(false);
		
		panelCos.add(lblUsuariIncorrecte);

		JLabel lblNewLabel_3 = new JLabel("Data naix");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(912, 501, 70, 15);
		panelCos.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Adreça");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(912, 576, 70, 15);
		panelCos.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Cognoms");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setBounds(1332, 289, 70, 15);
		panelCos.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("DNI/NIE/CIF");
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setBounds(1312, 362, 98, 15);
		panelCos.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("Telefon");
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setBounds(1332, 435, 70, 15);
		panelCos.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("Info adicional");
		lblNewLabel_8.setForeground(Color.WHITE);
		lblNewLabel_8.setBounds(1312, 501, 98, 15);
		panelCos.add(lblNewLabel_8);
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {

					Connection connection = null;
					Class.forName("com.mysql.cj.jdbc.Driver");
					connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/M13Projecte",
							"root", "galinkalinov99");
					System.out.println("Conectant...");

					ConnexioMysql cm = new ConnexioMysql();
					nomUsu = cm.autenticacioUsuari(txbNomLogin.getText(), txbContraLogin.getText(), connection);

					if (connection != null) {
						connection.close();
					}
					if (nomUsu!=null && nomUsu.equals(txbNomLogin.getText())) {
						lblUsuariLogin.setText("Benvingut, "+ nomUsu);
						
						LlistaPodcasts llistaPodcasts = null;
						try {
							llistaPodcasts = new LlistaPodcasts(nomUsu);
						} catch (ClassNotFoundException e1) {
							e1.printStackTrace();
						}
						String[] s = new String[] { nomUsu };
						llistaPodcasts.main(s);
						frame.dispose();
					} else {
						lblUsuariIncorrecte.setVisible(true);
						lblUsuariIncorrecte.setText("El usuari es incorrecte!");
						System.out.println("No hi ha cap dada de l'usuari per poder ser inserit.");
					}

				} catch (SQLException | ClassNotFoundException sqlException) {
					sqlException.printStackTrace();
				}
			}
		});
		btnLogin.setForeground(new Color(255, 51, 255));
		btnLogin.setBorder(new LineBorder(Color.CYAN, 1, true));
		btnLogin.setBackground(new Color(0, 204, 255));
		btnLogin.setBounds(530, 647, 158, 43);
		panelCos.add(btnLogin);

		txbContraLogin = new JTextField();
		txbContraLogin.setToolTipText("Contrassenya");
		txbContraLogin.setColumns(10);
		txbContraLogin.setBounds(498, 477, 200, 39);
		panelCos.add(txbContraLogin);

		txbNomLogin = new JTextField();
		txbNomLogin.setToolTipText("Nom");
		txbNomLogin.setColumns(10);
		txbNomLogin.setBounds(498, 350, 200, 39);
		panelCos.add(txbNomLogin);

		JLabel lblContrassenya_1 = new JLabel("Contrassenya");
		lblContrassenya_1.setForeground(Color.WHITE);
		lblContrassenya_1.setBounds(386, 489, 107, 15);
		panelCos.add(lblContrassenya_1);

		JLabel lblNewLabel_1 = new JLabel("Nom");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(410, 362, 70, 15);
		panelCos.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBackground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(803, 176, 12, 580);
		panelCos.add(lblNewLabel_2);
		lblCosPagina = new JLabel("",
				new ImageIcon(MenuPpal.class.getResource("/imatgesPerPantalles/imatgesApp/paginaRegiste.jpg")),
				SwingConstants.CENTER);
		lblCosPagina.setBackground(new Color(0, 204, 204));
		lblCosPagina.setBounds(0, -52, 1920, 1080);
		panelCos.add(lblCosPagina);

		frame.setBounds(300, 100, 1920, 1080);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public class DateLabelFormatter extends AbstractFormatter {

		private String datePattern = "dd/MM/yyyy";
		private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

		@Override
		public Object stringToValue(String text) throws ParseException {
			return dateFormatter.parseObject(text);
		}

		@Override
		public String valueToString(Object value) throws ParseException {
			if (value != null) {
				Calendar cal = (Calendar) value;
				return dateFormatter.format(cal.getTime());
			}

			return "";
		}

	}

	public String validarUsuari(Usuaris usuari, boolean usuariComplet, JLabel lblMissatge, JDatePickerImpl datePicker) {

		// comprovació per el nom
		if (txbNom.getText() != null && !txbNom.getText().trim().isEmpty()) {
			usuari.setNomUsuari(txbNom.getText());
			usuariComplet = true;
		} else {
			lblMissatge.setText("Revisa el nom");
			lblMissatge.setVisible(true);
			usuariComplet = false;
			return null;
		}

		// comprovació per la contrassenya
		if (txtContrassenya.getText() != null && !txtContrassenya.getText().trim().isEmpty()
				&& txtContrassenya.getText().length() > 8) {
			usuari.setContrasenyaUsuari(txtContrassenya.getText());
			usuariComplet = true;
		} else {
			lblMissatge.setText("Revisa la contrassenya, 8 caracters minim");
			lblMissatge.setVisible(true);
			usuariComplet = false;
			return null;
		}
		// comprovació per la contrassenya
		if (txtContrassenya2.getText() != null && !txtContrassenya2.getText().trim().isEmpty()
				&& txtContrassenya2.getText().length() > 8) {
			usuari.setContrasenyaUsuari2(txtContrassenya2.getText());
			usuariComplet = true;
		} else {
			lblMissatge.setText("Revisa la contrassenya, 8 caracters minim");
			lblMissatge.setVisible(true);
			usuariComplet = false;
			return null;
		}

		if (datePicker.getModel().getValue() != null) {
			Date date1 = (Date) datePicker.getModel().getValue();
			usuari.setAnyNaixement(date1);
			usuariComplet = true;
		} else {
			lblMissatge.setText("Revisa la data de naixement");
			lblMissatge.setVisible(true);
			usuariComplet = false;
			return null;
		}

		if (txtAdrea.getText() != null && !txtAdrea.getText().trim().isEmpty()) {
			usuari.setAdreca(txtAdrea.getText());
			usuariComplet = true;
		} else {
			lblMissatge.setText("Revisa la adreça");
			lblMissatge.setVisible(true);
			usuariComplet = false;
			return null;
		}
		// agafem el text del formulari
		if (txtCognoms.getText() != null && !txtCognoms.getText().trim().isEmpty()) {
			usuari.setCognomsUsuari(txtCognoms.getText());
			usuariComplet = true;
		} else {
			lblMissatge.setText("Revisa els cognoms");
			lblMissatge.setVisible(true);
			usuariComplet = false;
			return null;
		}
		// agafem el text del formulari
		if (txtDniniecif.getText() != null && !txtDniniecif.getText().trim().isEmpty() && txtDniniecif.getText().length() > 8  && txtDniniecif.getText().length() <= 9) {
			usuari.setNIF(txtDniniecif.getText());
			usuariComplet = true;
		} else {
			lblMissatge.setText("Revisa el dni, ha de tenir 9 caracters");
			lblMissatge.setVisible(true);
			usuariComplet = false;
			return null;
		}
		if (txtTelefon.getText() != null && !txtTelefon.getText().trim().isEmpty()) {
			boolean esNumeric =isNumeric(txtTelefon.getText());
			if(esNumeric == true) {
				int telefon = Integer.parseInt(txtTelefon.getText());
				usuari.setTelefon(telefon);
				usuariComplet = true;
			}else {
				lblMissatge.setText("Revisa el telefon, no es numeric");
				lblMissatge.setVisible(true);
				usuariComplet = false;
				return null;
			}
		} else {
			lblMissatge.setText("Revisa el telefon");
			lblMissatge.setVisible(true);
			usuariComplet = false;
			return null;
		}
		if (txtInfoAdicional.getText() != null && !txtInfoAdicional.getText().trim().isEmpty()) {
			usuari.setInfoAdicional(txtInfoAdicional.getText());
			usuariComplet = true;
		} else {
			lblMissatge.setText("Revisa la info adicional");
			lblMissatge.setVisible(true);
			usuariComplet = false;
			return null;
		}

		// si hem validat l'usuari i es valid retornem el missatge de que ho es, sino
		// retornem un null.
		if (usuariComplet == true) {
			return "usuariValid";
		} else {
			return null;
		}

	}
	public static boolean isNumeric(String strNum) {
	    if (strNum == null) {
	        return false;
	    }
	    try {
	        int d = Integer.parseInt(strNum);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
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
