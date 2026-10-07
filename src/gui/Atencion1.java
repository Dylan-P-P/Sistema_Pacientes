package gui;

import java.awt.BorderLayout;
import java.awt.DefaultFocusTraversalPolicy;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import clases.botonAtenderEditor;
import clases.botonAtenderRender;
import clases.buttoneditor;
import clases.buttonrender;
import clases.lista;
import clases.paciente;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Atencion1 extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTable txtTablaAtender;
	private JButton btMostrarAtender;
	private JButton btRetroceder;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 */
	public Atencion1() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 62, 414, 188);
			getContentPane().add(scrollPane);
			{
				txtTablaAtender = new JTable();
				scrollPane.setViewportView(txtTablaAtender);
			}
		}
		{
			btMostrarAtender = new JButton("Mostrar");
			btMostrarAtender.addActionListener(this);
			btMostrarAtender.setBounds(295, 28, 89, 23);
			getContentPane().add(btMostrarAtender);
		}
		{
			btRetroceder = new JButton("Retroceder");
			btRetroceder.addActionListener(this);
			btRetroceder.setBounds(40, 28, 89, 23);
			getContentPane().add(btRetroceder);
		}
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btRetroceder) {
			do_btRetroceder_actionPerformed(e);
		}
		if (e.getSource() == btMostrarAtender) {
			do_btMostrarAtender_actionPerformed(e);
		}
	}
	protected void do_btMostrarAtender_actionPerformed(ActionEvent e) {
		btMostrarAtender.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			String[] columnas = {"DNI", "Nombre", "Caso", "Atender"};
			
			DefaultTableModel modelo = new DefaultTableModel(columnas, 0) {
				@Override
				public boolean isCellEditable(int row, int column) {
					return column == 3;
				}
			};
			
			ArrayList<paciente> pacienteDelDoctor = new ArrayList<>();
			
			for(paciente p: lista.listaPacientes) {
				if(p.getDoctor().equals("Luis Alvarez")) {
					pacienteDelDoctor.add(p);
					
					Object[] fila = {p.getDni(), p.getNom(), "Ver Caso", "Atender"};
					modelo.addRow(fila);
				}
			}
			txtTablaAtender.setModel(modelo);
			txtTablaAtender.getColumn("Caso").setCellRenderer(new buttonrender());
			txtTablaAtender.getColumn("Caso").setCellEditor(new buttoneditor(new JCheckBox()));
			
			txtTablaAtender.setModel(modelo);
			txtTablaAtender.getColumn("Atender").setCellRenderer(new botonAtenderRender());
			txtTablaAtender.getColumn("Atender").setCellEditor(new botonAtenderEditor(new JCheckBox(), pacienteDelDoctor));
			
				
			}
		});
	}
	protected void do_btRetroceder_actionPerformed(ActionEvent e) {
		btRetroceder.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				Sistemadoctor1 st1 = new Sistemadoctor1();
				st1.setVisible(true);
			}
		});
	}
}
