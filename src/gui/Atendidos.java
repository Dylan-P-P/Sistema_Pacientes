package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import clases.botonVerAtencionEditor;
import clases.botonVerAtencionRender;
import clases.lista;
import clases.paciente;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Atendidos extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JScrollPane scrollPane;
	private JButton btMostrar;
	private JTable txtTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Atendidos dialog = new Atendidos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Atendidos() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 50, 414, 200);
			getContentPane().add(scrollPane);
			{
				txtTable = new JTable();
				scrollPane.setViewportView(txtTable);
			}
		}
		{
			btMostrar = new JButton("Mostrar");
			btMostrar.addActionListener(this);
			btMostrar.setBounds(173, 11, 89, 23);
			getContentPane().add(btMostrar);
		}
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btMostrar) {
			do_btMostrar_actionPerformed(e);
		}
	}
	protected void do_btMostrar_actionPerformed(ActionEvent e) {
		btMostrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] columnas = {"DNI", "Nombre", "Apellido", "Edad", "Fecha", "Atención"};

		        DefaultTableModel modelo = new DefaultTableModel(columnas, 0) {
		            @Override
		            public boolean isCellEditable(int row, int column) {
		                return column == 5; // "Atención" está en la posición 5
		            }
		        };

		        for (paciente p : lista.listaAtendidos) {
		            Object[] fila = {
		                    p.getDni(), p.getNom(), p.getApellido(),
		                    p.getEdad(), p.getFecha(), "Ver Atención"
		            };
		            modelo.addRow(fila);
		        }

		        txtTable.setModel(modelo);
		        txtTable.getColumn("Atención").setCellRenderer(new botonVerAtencionRender());
		        txtTable.getColumn("Atención").setCellEditor(new botonVerAtencionEditor(new JCheckBox(), lista.listaAtendidos));
				
			}
		});
	}
}
