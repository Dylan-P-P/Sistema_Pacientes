package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import clases.buttoneditor;
import clases.buttonrender;
import clases.lista;
import clases.paciente;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Listadoctor1 extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JScrollPane scrollPane;
	private JTable txtTabla1;
	private JButton btRetroceder;
	private JButton btMostrar1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Listadoctor1 dialog = new Listadoctor1();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Listadoctor1() {
		setBounds(100, 100, 621, 302);
		getContentPane().setLayout(null);
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 58, 585, 192);
			getContentPane().add(scrollPane);
			{
				txtTabla1 = new JTable();
				scrollPane.setViewportView(txtTabla1);
			}
		}
		{
			btRetroceder = new JButton("Retroceder");
			btRetroceder.addActionListener(this);
			btRetroceder.setFont(new Font("Tahoma", Font.PLAIN, 23));
			btRetroceder.setBounds(10, 11, 200, 36);
			getContentPane().add(btRetroceder);
		}
		{
			btMostrar1 = new JButton("Mostrar");
			btMostrar1.setFont(new Font("Tahoma", Font.PLAIN, 23));
			btMostrar1.addActionListener(this);
			btMostrar1.setBounds(374, 11, 221, 36);
			getContentPane().add(btMostrar1);
		}
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btRetroceder) {
			do_btnNewButton_actionPerformed(e);
		}
		if (e.getSource() == btMostrar1) {
			do_btMostrar1_actionPerformed(e);
		}
	}
	protected void do_btMostrar1_actionPerformed(ActionEvent e) {
		btMostrar1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] columnas = {"DNI", "Nombre", "Apellido", "Edad", "Fecha", "Caso"};
				
				DefaultTableModel modelo = new DefaultTableModel(columnas, 0) {
					@Override
					public boolean isCellEditable(int row, int column) {
						return column == 5;
					}
				};
				
				for (paciente p: lista.listaLuisAlvarez) {
					Object[] fila = {p.getDni(), p.getNom(), p.getApellido(), p.getEdad(), p.getFecha(), "Ver Caso"};
					modelo.addRow(fila);
				}
				
				txtTabla1.setModel(modelo);
				txtTabla1.getColumn("Caso").setCellRenderer(new buttonrender());
				txtTabla1.getColumn("Caso").setCellEditor(new buttoneditor(new JCheckBox()));
			}
		});
	}
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		btRetroceder.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				Sistemadoctor1 sd1= new Sistemadoctor1();
				sd1.setVisible(true);
				
			}
		});
	}
}
