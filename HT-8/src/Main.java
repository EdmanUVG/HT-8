import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JList;

public class Main {

	private JFrame frame;
	private JPanel pHospital;
	private JTextField tfNombre;
	private JTextField tfSintoma;
	private JButton btnGuardar;
	private JLabel lblGuardadoExitosmante;
	private JLabel lblError;
	private JPanel panelResultados;
	private JPanel pInicio;
	
	private DefaultListModel ListaPacientes;
	private JList list;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
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
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setSize(900, 550);
		frame.setLocationRelativeTo(null);
		frame.setIconImage(new ImageIcon(Main.class.getResource("resources/white.jpg")).getImage());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		frame.getContentPane().add(panel, "name_176810167288600");
		panel.setLayout(null);
		
		pHospital = new JPanel();
		pHospital.setBackground(Color.WHITE);
		pHospital.setBounds(0, 0, 450, 511);
		panel.add(pHospital);
		pHospital.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Hospital UVG");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 110, 430, 30);
		pHospital.add(lblNewLabel);
		
		tfNombre = new JTextField();
		tfNombre.setBounds(126, 180, 200, 30);
		pHospital.add(tfNombre);
		tfNombre.setColumns(10);
		
		tfSintoma = new JTextField();
		tfSintoma.setColumns(10);
		tfSintoma.setBounds(126, 220, 200, 30);
		pHospital.add(tfSintoma);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(tfNombre.getText().toString().isEmpty() || tfSintoma.getText().toString().isEmpty()) {
					lblError.setText("Algun campo vacio!");
					lblGuardadoExitosmante.setText("");
				} else {
					tfNombre.setText("");
					tfSintoma.setText("");
					lblError.setText("");
					lblGuardadoExitosmante.setText("Guardado exitosmante");
					
					pInicio.setVisible(false);
					panelResultados.setVisible(true);
					
				}
			}
		});
		btnGuardar.setForeground(new Color(255, 255, 255));
		btnGuardar.setBorder(null);
		btnGuardar.setBackground(new Color(0, 153, 204));
		btnGuardar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnGuardar.setBounds(150, 310, 150, 30);
		pHospital.add(btnGuardar);
		
//		lblGuardadoExitosmante.setText("");
//		lblError.setText("");
		
		
		// HOSPITAL LOGO
		ImageIcon hispitalImage = new ImageIcon(Main.class.getResource("resources/hospital.png"));	
		Image imageH = hispitalImage.getImage();
		Image hispitalImg = imageH.getScaledInstance(50, 30, Image.SCALE_DEFAULT);
		hispitalImage = new ImageIcon(hispitalImg);
		
		JLabel lblHospital = new JLabel("", hispitalImage, JLabel.CENTER);
		lblHospital.setHorizontalAlignment(SwingConstants.CENTER);
		lblHospital.setBounds(0, 0, 90, 60);
		pHospital.add(lblHospital);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(10, 180, 100, 30);
		pHospital.add(lblNewLabel_1);
		
		JLabel lblSintoma = new JLabel("Sintoma");
		lblSintoma.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSintoma.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSintoma.setBounds(10, 220, 100, 30);
		pHospital.add(lblSintoma);
		
		JLabel lblEmergencia = new JLabel("Emergencia");
		lblEmergencia.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmergencia.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEmergencia.setBounds(16, 260, 100, 30);
		pHospital.add(lblEmergencia);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(126, 260, 200, 30);
		comboBox.addItem("A");
		comboBox.addItem("B");
		comboBox.addItem("C");
		comboBox.addItem("D");
		comboBox.addItem("E");
		pHospital.add(comboBox);
		
		lblGuardadoExitosmante = new JLabel("");
		lblGuardadoExitosmante.setForeground(new Color(0, 153, 102));
		lblGuardadoExitosmante.setHorizontalAlignment(SwingConstants.CENTER);
		lblGuardadoExitosmante.setFont(new Font("Arial", Font.BOLD, 14));
		lblGuardadoExitosmante.setBounds(0, 360, 450, 30);
		pHospital.add(lblGuardadoExitosmante);
		
		lblError = new JLabel("");
		lblError.setHorizontalAlignment(SwingConstants.CENTER);
		lblError.setForeground(new Color(255, 51, 102));
		lblError.setFont(new Font("Arial", Font.BOLD, 14));
		lblError.setBounds(0, 360, 450, 30);
		pHospital.add(lblError);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(450, 0, 434, 511);
		panel.add(panel_2);
		panel_2.setLayout(new CardLayout(0, 0));
		
		// UVG LOGO
		ImageIcon uvgImage = new ImageIcon(Main.class.getResource("resources/uvg.png"));	
		Image image = uvgImage.getImage();
		Image userImg = image.getScaledInstance(400, 200, Image.SCALE_DEFAULT);
		uvgImage = new ImageIcon(userImg);
		
		pInicio = new JPanel();
		pInicio.setBackground(new Color(251, 251, 251));
		panel_2.add(pInicio, "name_176945063737700");
		pInicio.setLayout(null);
		
		JLabel lblUVG = new JLabel("", uvgImage, JLabel.CENTER);
		lblUVG.setBounds(146, 163, 150, 170);
		pInicio.add(lblUVG);
		
		panelResultados = new JPanel();
		panelResultados.setBackground(new Color(251, 251, 251));
		panel_2.add(panelResultados, "name_553788472686300");
		panelResultados.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Pacientes en cola");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(0, 25, 434, 30);
		panelResultados.add(lblNewLabel_2);
		
		ListaPacientes = new DefaultListModel();
		
		ListaPacientes.addElement("Uno dso tress");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 82, 434, 376);
		panelResultados.add(scrollPane);
		
		list = new JList(ListaPacientes);
		list.setBounds(0, 0, 550, 641);
		
		scrollPane.setViewportView(list);
		
		JButton btnAtentederPaciente = new JButton("Atender paciente");
		btnAtentederPaciente.setForeground(Color.WHITE);
		btnAtentederPaciente.setFont(new Font("Arial", Font.BOLD, 12));
		btnAtentederPaciente.setBorder(null);
		btnAtentederPaciente.setBackground(new Color(0, 153, 204));
		btnAtentederPaciente.setBounds(120, 469, 200, 30);
		panelResultados.add(btnAtentederPaciente);
		
		
	}
}
