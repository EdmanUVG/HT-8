import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.sun.javafx.sg.prism.NGShape.Mode;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.ListModel;
import javax.swing.Icon;

public class Main {

	private JFrame frame;
	private JPanel pHospital;
	private JTextField tfNombre;
	private JTextField tfSintoma;
	private JButton btnGuardar;
	private JLabel lblGuardadoExitosmante;
	private JLabel lblError;
	private JPanel panelResultados;
	
	private Controller controller;
	
	private JPanel pElegirADT;
	private JPanel panelHospital;
	private JRadioButton rdbPriorityQueue;
	private JRadioButton rdbVectorHeap;
	private JScrollPane scrollPacientes;
	private JComboBox boxEmergencia;
	private JScrollPane scrollAAtender;
	private JLabel lblAAtender;
	private JButton btnMandarACola;
	private JLabel lblADTError;
	private JLabel label;

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
		frame.setSize(1000, 650);
		frame.setLocationRelativeTo(null);
		frame.setIconImage(new ImageIcon(Main.class.getResource("resources/white.jpg")).getImage());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		// HOSPITAL LOGO
		ImageIcon hospitalImage = new ImageIcon(Main.class.getResource("resources/hospital.png"));	
		Image imageH = hospitalImage.getImage();
		Image hispitalImg = imageH.getScaledInstance(50, 30, Image.SCALE_DEFAULT);
		hospitalImage = new ImageIcon(hispitalImg);
		
		pElegirADT = new JPanel();
		pElegirADT.setBackground(new Color(255, 255, 255));
		frame.getContentPane().add(pElegirADT, "name_596031541153800");
		pElegirADT.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("UVG Hospital");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(0, 50, 884, 33);
		pElegirADT.add(lblNewLabel_3);
		
		
		
		rdbVectorHeap = new JRadioButton("Vector Heap", true);
		rdbVectorHeap.setFont(new Font("Arial", Font.PLAIN, 12));
		rdbVectorHeap.setBounds(392, 212, 109, 23);
		pElegirADT.add(rdbVectorHeap);
		
		rdbPriorityQueue = new JRadioButton("Priority Queue");
		rdbPriorityQueue.setFont(new Font("Arial", Font.PLAIN, 12));
		rdbPriorityQueue.setBounds(392, 252, 109, 23);
		pElegirADT.add(rdbPriorityQueue);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbVectorHeap);
		bg.add(rdbPriorityQueue);
		
		JLabel lblNewLabel_4 = new JLabel("Elegir el tipo de ADT");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(0, 155, 884, 33);
		pElegirADT.add(lblNewLabel_4);
		
		JButton btnContinuar = new JButton("Continuar");
		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (rdbVectorHeap.isSelected() || rdbPriorityQueue.isSelected()) {
					if (rdbVectorHeap.isSelected()) {
						controller = new Controller("VectorHeap");
					}else if (rdbPriorityQueue.isSelected()) {
						controller = new Controller("PriorityQueue");
					}
					
					panelHospital.setVisible(true);
					pElegirADT.setVisible(false);
					
					controller.addPacientes();
					setPacientes();
					
				}else {
					lblADTError.setText("No hay ADT seleccionado... Intentar de nuevo ");
				}
			}
		});
		btnContinuar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnContinuar.setForeground(new Color(255, 255, 255));
		btnContinuar.setBackground(new Color(0, 153, 204));
		btnContinuar.setBounds(375, 319, 150, 30);
		pElegirADT.add(btnContinuar);
		
		lblADTError = new JLabel("");
		lblADTError.setForeground(new Color(255, 51, 102));
		lblADTError.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblADTError.setHorizontalAlignment(SwingConstants.CENTER);
		lblADTError.setBounds(0, 365, 884, 30);
		pElegirADT.add(lblADTError);
		
		label = new JLabel("", hospitalImage, JLabel.CENTER);
		label.setBounds(0, 0, 90, 60);
		pElegirADT.add(label);
		
		panelHospital = new JPanel();
		panelHospital.setBackground(Color.WHITE);
		frame.getContentPane().add(panelHospital, "name_176810167288600");
		panelHospital.setLayout(null);
		
		pHospital = new JPanel();
		pHospital.setBackground(Color.WHITE);
		pHospital.setBounds(0, 0, 450, 511);
		panelHospital.add(pHospital);
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
					
					String paciente = "";
					
					paciente = tfNombre.getText().toString() + ", " + tfSintoma.getText().toString() 
					+ ", " + boxEmergencia.getSelectedItem();
					
					// Guardar paciente en archivo .txt
					try {
						BufferedWriter writer = new BufferedWriter( new FileWriter("src/pacientes.txt", true));
						
						writer.newLine();   //Add new line
					    writer.write(paciente);
					    writer.close();
					    
					} catch (IOException e) {
						e.printStackTrace();
					}
					
					// LIMPIAR las entradas de texto
					tfNombre.setText("");
					tfSintoma.setText("");
					lblError.setText("");
					lblGuardadoExitosmante.setText("Guardado exitosmante");
										
					// Agrega paciente a la lista de pacientes
					controller.addPacientes();
					setPacientes();
					
				}
			}
		});
		btnGuardar.setForeground(new Color(255, 255, 255));
		btnGuardar.setBorder(null);
		btnGuardar.setBackground(new Color(0, 153, 204));
		btnGuardar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnGuardar.setBounds(150, 310, 150, 30);
		pHospital.add(btnGuardar);
		
		
		
		
		JLabel lblHospital = new JLabel("", hospitalImage, JLabel.CENTER);
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
		
		boxEmergencia = new JComboBox();
		boxEmergencia.setBounds(126, 260, 200, 30);
		boxEmergencia.addItem("A");
		boxEmergencia.addItem("B");
		boxEmergencia.addItem("C");
		boxEmergencia.addItem("D");
		boxEmergencia.addItem("E");
		pHospital.add(boxEmergencia);
		
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
		panel_2.setBounds(450, 0, 534, 611);
		panelHospital.add(panel_2);
		panel_2.setLayout(new CardLayout(0, 0));
		
		// UVG LOGO
		ImageIcon uvgImage = new ImageIcon(Main.class.getResource("resources/uvg.png"));	
		Image image = uvgImage.getImage();
		Image userImg = image.getScaledInstance(400, 200, Image.SCALE_DEFAULT);
		uvgImage = new ImageIcon(userImg);
		
		panelResultados = new JPanel();
		panelResultados.setBackground(new Color(251, 251, 251));
		panel_2.add(panelResultados, "name_553788472686300");
		panelResultados.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Pacientes");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(0, 25, 534, 30);
		panelResultados.add(lblNewLabel_2);
		
		// Scroll
		scrollAAtender = new JScrollPane();
		scrollAAtender.setBounds(82, 477, 352, 50);
		panelResultados.add(scrollAAtender);
		

		// Scroll
		scrollPacientes = new JScrollPane();
		scrollPacientes.setBounds(0, 109, 534, 307);
		panelResultados.add(scrollPacientes);

		
		// Button Paciente a atender
		JButton btnAtentederPaciente = new JButton("Atender paciente");
		btnAtentederPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(controller.getPaciente() != null) {
					controller.atender();
					setPacienteActual();
					setPacientes();
					JOptionPane.showMessageDialog(null, "Paciente atendido exitosamente");
				}else {
					JOptionPane.showMessageDialog(null, "No hay paciente para atender");
				}
			}
		});
		btnAtentederPaciente.setForeground(Color.WHITE);
		btnAtentederPaciente.setFont(new Font("Arial", Font.BOLD, 12));
		btnAtentederPaciente.setBorder(null);
		btnAtentederPaciente.setBackground(new Color(0, 153, 204));
		btnAtentederPaciente.setBounds(155, 533, 200, 30);
		panelResultados.add(btnAtentederPaciente);
		
		lblAAtender = new JLabel("A atender:");
		lblAAtender.setHorizontalAlignment(SwingConstants.CENTER);
		lblAAtender.setFont(new Font("Arial", Font.PLAIN, 15));
		lblAAtender.setBounds(0, 487, 77, 30);
		panelResultados.add(lblAAtender);
		
		btnMandarACola = new JButton("Mandar a cola");
		btnMandarACola.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (controller.getPaciente() == null) {
					try {
						controller.transferir();
						setPacienteActual();
						setPacientes();
					}catch(Exception ex) {}
				}else {
					JOptionPane.showMessageDialog(null, "Lista llena. Un paciente esta siendo atendido");
				}
			}
		});
		btnMandarACola.setForeground(Color.WHITE);
		btnMandarACola.setFont(new Font("Arial", Font.BOLD, 12));
		btnMandarACola.setBorder(null);
		btnMandarACola.setBackground(new Color(0, 153, 204));
		btnMandarACola.setBounds(334, 79, 200, 30);
		panelResultados.add(btnMandarACola);
		
		
	}
	
	private void setPacienteActual() {
		
		// Tabla de paciente actual
		
		Paciente paciente = controller.getPaciente();
		DefaultTableModel pacienteTableModel = new DefaultTableModel();
		
		pacienteTableModel.setColumnCount(3);
		pacienteTableModel.setColumnIdentifiers(new String[] {"Codigo", "Nombre", "Sintoma"});
		pacienteTableModel.setRowCount(0);
		
		if (controller.getPaciente() != null) {
			pacienteTableModel.setRowCount(1);
			pacienteTableModel.setValueAt(paciente.getCodigo(), 0, 0);
			pacienteTableModel.setValueAt(paciente.getNombre(), 0, 1);
			pacienteTableModel.setValueAt(paciente.getSintoma(), 0, 2);
		}
		
		scrollAAtender.setViewportView(new JTable(pacienteTableModel));
		
	}
	
	private void setPacientes() {
		
		// Tabla del pacientes
		
		PriorityQueue<Paciente> dato = controller.getPacientes();
		DefaultTableModel pacienteTableModel = new DefaultTableModel();
				
		pacienteTableModel.setColumnCount(3);
		pacienteTableModel.setColumnIdentifiers(new String[] {"Codigo", "Nombre", "Sintoma"});
		pacienteTableModel.setRowCount(controller.size());
		
		int control = controller.size();
		
		for (int i = 0; i < control; i++) {
			Paciente paciente = dato.remove();
			pacienteTableModel.setValueAt(paciente.getCodigo(), i, 0);
			pacienteTableModel.setValueAt(paciente.getNombre(), i, 1);
			pacienteTableModel.setValueAt(paciente.getSintoma(), i, 2);
		}
		
		scrollPacientes.setViewportView(new JTable(pacienteTableModel));
		
	}
}














