package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.lista;
import clases.paciente;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import com.toedter.calendar.JDateChooser;
import javax.swing.UIManager;
import javax.swing.JComboBox;

public class ConGeneral extends JDialog implements ActionListener {
	
	private paciente pacienteEditando = null;
	
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtNOM;
	private JTextField txtEDAD;
	private JTextField txtDNI;
	private JScrollPane scrollPane;
	private JButton btGuardar;
	private JButton btRetroceder;
	private JTextArea txtCaso;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblFecha;
	private JTextField txtApellido;
	private JDateChooser dateChooser;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		try {
			ConGeneral dialog = new ConGeneral();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ConGeneral() {
		setModal(true);
		setBounds(100, 100, 246, 380);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Nombre:");
			lblNewLabel.setBounds(10, 95, 60, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblEdad = new JLabel("Edad:");
			lblEdad.setBounds(10, 64, 60, 14);
			contentPanel.add(lblEdad);
		}
		{
			JLabel lblDni = new JLabel("DNI:");
			lblDni.setBounds(10, 33, 60, 14);
			contentPanel.add(lblDni);
		}
		{
			JLabel lblCaso = new JLabel("Pre-Diagnóstico:");
			lblCaso.setBounds(10, 216, 89, 14);
			contentPanel.add(lblCaso);
		}
		{
			txtNOM = new JTextField();
			txtNOM.setBounds(80, 92, 100, 20);
			contentPanel.add(txtNOM);
			txtNOM.setColumns(10);
		}
		{
			txtEDAD = new JTextField();
			txtEDAD.setColumns(10);
			txtEDAD.setBounds(80, 61, 100, 20);
			contentPanel.add(txtEDAD);
		}
		{
			txtDNI = new JTextField();
			txtDNI.setColumns(10);
			txtDNI.setBounds(80, 30, 100, 20);
			contentPanel.add(txtDNI);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 241, 210, 44);
			contentPanel.add(scrollPane);
			{
				txtCaso = new JTextArea();
				scrollPane.setViewportView(txtCaso);
			}
		}
		{
			btGuardar = new JButton("Guardar");
			btGuardar.addActionListener(this);
			btGuardar.setBounds(109, 296, 89, 23);
			contentPanel.add(btGuardar);
		}
		{
			btRetroceder = new JButton("Retroceder");
			btRetroceder.addActionListener(this);
			btRetroceder.setBounds(10, 296, 89, 23);
			contentPanel.add(btRetroceder);
		}
		{
			lblNewLabel_1 = new JLabel("Apellido:");
			lblNewLabel_1.setBounds(10, 126, 46, 14);
			contentPanel.add(lblNewLabel_1);
		}
		{
			lblNewLabel_2 = new JLabel("Doctor");
			lblNewLabel_2.setBounds(10, 159, 46, 14);
			contentPanel.add(lblNewLabel_2);
		}
		{
			lblFecha = new JLabel("Fecha");
			lblFecha.setBounds(10, 191, 46, 14);
			contentPanel.add(lblFecha);
		}
		{
			txtApellido = new JTextField();
			txtApellido.setBounds(80, 123, 100, 20);
			contentPanel.add(txtApellido);
			txtApellido.setColumns(10);
		}
		{
			dateChooser = new JDateChooser();
			dateChooser.getCalendarButton().addActionListener(this);
			dateChooser.setBounds(80, 191, 100, 20);
			contentPanel.add(dateChooser);
		}
		{
			comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"Ninguno", "Maria Lopez", "Luis Alvarez"}));
			comboBox.setBounds(80, 155, 100, 22);
			contentPanel.add(comboBox);
			
			
		}
		
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == dateChooser.getCalendarButton()) {
			do_dateChooserCalendarButton_actionPerformed(e);
		}
		if (e.getSource() == btRetroceder) {
			do_btRetroceder_actionPerformed(e);
		}
		if (e.getSource() == btGuardar) {
			do_btnNewButton_actionPerformed(e);
		}
	}
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
	btGuardar.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
			String nom= txtNOM.getText();
			int edad= Integer.parseInt(txtEDAD.getText());
			String dnitext= txtDNI.getText().trim();
			String caso= txtCaso.getText();
			String doctorselecionado = (String) comboBox.getSelectedItem();
			String apellido = txtApellido.getText();
			Date fechaseleccionada = dateChooser.getDate();
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
			String fechatexto = formato.format(fechaseleccionada);
			if (fechaseleccionada == null) {
				JOptionPane.showMessageDialog(rootPane,
						"Debe seleccionar una fecha",
						"Error",
						JOptionPane.WARNING_MESSAGE);
				return;
			}
		
			if (nom.isBlank() || caso.isBlank()) {
				JOptionPane.showMessageDialog(rootPane,
						"Nombre y caso no pueden estar vacíos",
                        "Error",
                        JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			if (!nom.matches("[\\p{L} ]+")) {
				JOptionPane.showMessageDialog(rootPane,
						"El nombre no puede contener números ni simbolos",
						"Error",
						JOptionPane.WARNING_MESSAGE);
				return;
			
			}
			
			if (edad < 0 || edad > 140) {
				JOptionPane.showMessageDialog(rootPane,
						"La edad no puede ser un número negativo o mayor de 100",
						"Error",
						JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			if (dnitext.length() !=8) {
				JOptionPane.showMessageDialog(rootPane, 
						"El DNI debe tener exactamente 8 dígitos",
						"ERROR",
						JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			if (!dnitext.matches("\\d+")) {
				JOptionPane.showMessageDialog(rootPane,
						"El dni solo debe contener números",
						"Error",
						JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			if (dnitext.startsWith("0")) {
				JOptionPane.showMessageDialog(rootPane, 
						"El DNI no puede empezar con 0",
						"Error",
						JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			Boolean dniRepetido = false;
			for (paciente p : lista.listaPacientes) {
				if (p.getNom().equals(dnitext)) {
					dniRepetido = true;
					break;
				}
			}
			
			if (dniRepetido) {
				JOptionPane.showMessageDialog(rootPane,
						"Ya existe un paciente registrado con ese DNI",
						"Error",
						JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			dispose();
			
			if (pacienteEditando == null) {
				paciente p= new paciente(dnitext, nom, apellido, edad, fechatexto, doctorselecionado, caso);
				lista.listaPacientes.add(p);
				
				if (doctorselecionado.equals("Luis Alvarez")) {
					lista.listaLuisAlvarez.add(p);
				}
				
			} else {
			    pacienteEditando.setNom(nom);
			    pacienteEditando.setApellido(apellido);
			    pacienteEditando.setEdad(edad);
			    pacienteEditando.setDni(dnitext);
			    pacienteEditando.setFecha(fechatexto);
			    pacienteEditando.setDoctor(doctorselecionado);
			    pacienteEditando.setCaso(caso);
			    
			    if (doctorselecionado.equals("Luiz Alvarez") && !lista.listaLuisAlvarez.contains(pacienteEditando)) {
			    	lista.listaLuisAlvarez.add(pacienteEditando);
			    
			    }
			    
			    else if (!doctorselecionado.equals("Luiz Alvarez")) {
			    	lista.listaLuisAlvarez.remove(pacienteEditando);
			    }
			    
			}
			
			JOptionPane.showMessageDialog(rootPane, 
					"Paciente guardado correctamente",
                    "Éxito",
                    JOptionPane.INFORMATION_MESSAGE);
			
			txtNOM.setText("");
			txtApellido.setText("");
			txtEDAD.setText("");
			txtDNI.setText("");
			txtCaso.setText("");
			Sistema st=new Sistema();
			st.setVisible(true);
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(rootPane,
						"Edad y DNI deben ser valores numéricos",
	                    "Error",
	                    JOptionPane.ERROR_MESSAGE);
			}
		}
	});
	}
	protected void do_btRetroceder_actionPerformed(ActionEvent e) {
		btRetroceder.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			dispose();
			Sistema st=new Sistema();
			st.setVisible(true);
			}
		});
	}
	protected void do_dateChooserCalendarButton_actionPerformed(ActionEvent e) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		dateChooser.setMinSelectableDate(cal.getTime());
		dateChooser.setDateFormatString("dd/MM/yyyy");
	}
	public ConGeneral(paciente p) {
		this();
		this.pacienteEditando = p;
	}
}
