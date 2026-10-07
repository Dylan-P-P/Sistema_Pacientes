package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.lista;
import clases.paciente;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaAtencion extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextArea txtDiagnostico;
	private JLabel lblNewLabel_1;
	private JScrollPane scrollPane_1;
	private JTextArea txtReceta;
	private JButton btGuardarAtencion;
	private paciente pacienteActual;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VentanaAtencion dialog = new VentanaAtencion();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VentanaAtencion() {
		setBounds(100, 100, 205, 350);
		getContentPane().setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Diagnóstico");
			lblNewLabel.setBounds(10, 11, 71, 14);
			getContentPane().add(lblNewLabel);
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(20, 36, 135, 89);
			getContentPane().add(scrollPane);
			{
				txtDiagnostico = new JTextArea();
				scrollPane.setViewportView(txtDiagnostico);
			}
		}
		{
			lblNewLabel_1 = new JLabel("Receta");
			lblNewLabel_1.setBounds(10, 136, 46, 14);
			getContentPane().add(lblNewLabel_1);
		}
		{
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(20, 161, 135, 89);
			getContentPane().add(scrollPane_1);
			{
				txtReceta = new JTextArea();
				scrollPane_1.setViewportView(txtReceta);
			}
		}
		{
			btGuardarAtencion = new JButton("Guardar");
			btGuardarAtencion.addActionListener(this);
			btGuardarAtencion.setBounds(50, 261, 89, 23);
			getContentPane().add(btGuardarAtencion);
		}
	}
	
	public VentanaAtencion(paciente p) {
		this();
		this.pacienteActual = p;
		
		setTitle("Atencion - " + p.getNom());
		
		txtDiagnostico.setText(p.getDiagnostico());
		txtReceta.setText(p.getReceta());
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btGuardarAtencion) {
			do_btGuardarAtencion_actionPerformed(e);
		}
	}
	protected void do_btGuardarAtencion_actionPerformed(ActionEvent e) {
		btGuardarAtencion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String diagnostico= txtDiagnostico.getText().trim();
				String receta = txtReceta.getText().trim();
				
				if (diagnostico.isBlank()) {
					JOptionPane.showMessageDialog(rootPane,
							"El diagnóstico no puede estar vacío",
							"Error",
							JOptionPane.WARNING_MESSAGE);
					return;
				}
				
				pacienteActual.setDiagnostico(diagnostico);
				pacienteActual.setReceta(receta);
				
				lista.listaAtendidos.add(pacienteActual);
				
				lista.listaPacientes.remove(pacienteActual);
				lista.listaLuisAlvarez.remove(pacienteActual);
				
				JOptionPane.showMessageDialog(rootPane,
						"Atención guardada correctamente",
						"Éxito",
						JOptionPane.INFORMATION_MESSAGE);
				
				dispose();
				
			}
		});
	}
}
