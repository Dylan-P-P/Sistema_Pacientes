package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.TextArea;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;

import clases.buttoneditor;
import clases.buttonrender;
import clases.lista;
import clases.paciente;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Lista extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton btMostrar;
	private JButton btBack;
	private JScrollPane scrollPane;
	private JTable txtTable;
	private JButton btnModificar;
	private JButton btBuscar;
	private JTextField txtBuscarDni;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Lista dialog = new Lista();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Lista() {
		setBounds(100, 100, 675, 350);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			btMostrar = new JButton("Mostrar");
			btMostrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btMostrar.addActionListener(this);
			btMostrar.setBounds(189, 31, 119, 33);
			contentPanel.add(btMostrar);
		}
		{
			btBack = new JButton("Retroceder");
			btBack.addActionListener(this);
			btBack.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btBack.setBounds(24, 31, 119, 33);
			contentPanel.add(btBack);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 92, 639, 208);
			contentPanel.add(scrollPane);
			{
				txtTable = new JTable();
				scrollPane.setViewportView(txtTable);
			}
		}
		{
			btnModificar = new JButton("Modificar");
			btnModificar.addActionListener(this);
			btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnModificar.setBounds(509, 31, 119, 33);
			contentPanel.add(btnModificar);
		}
		{
			btBuscar = new JButton("Buscar");
			btBuscar.addActionListener(this);
			btBuscar.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btBuscar.setBounds(346, 48, 119, 33);
			contentPanel.add(btBuscar);
		}
		{
			txtBuscarDni = new JTextField();
			txtBuscarDni.setBounds(357, 19, 98, 20);
			contentPanel.add(txtBuscarDni);
			txtBuscarDni.setColumns(10);
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btBuscar) {
			do_btBuscar_actionPerformed(e);
		}
		if (e.getSource() == btnModificar) {
			do_btnModificar_actionPerformed(e);
		}
		if (e.getSource() == btBack) {
			do_btBack_actionPerformed(e);
		}
		if (e.getSource() == btMostrar) {
			do_btnNewButton_actionPerformed(e);
		}
	}
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		btMostrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			String[] columnas = {"DNI", "Nombre", "Apellido", "Edad", "Fecha", "Doctor", "Caso", };
			
			DefaultTableModel modelo = new DefaultTableModel(columnas, 0) {
				@Override
				public boolean isCellEditable(int row, int column) {
					return column == 6;
				}
			};
			
			for (paciente p: lista.listaPacientes) {
				Object[] fila = {p.getDni(), p.getNom(), p.getApellido() ,p.getEdad(), p.getFecha(), p.getDoctor(), "Ver Caso"};
				modelo.addRow(fila);
			}
			
			txtTable.setModel(modelo);
			txtTable.getColumn("Caso").setCellRenderer(new buttonrender());
			txtTable.getColumn("Caso").setCellEditor(new buttoneditor(new JCheckBox()));
			}});
	}
	protected void do_btBack_actionPerformed(ActionEvent e) {
		btBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				Sistema st=new Sistema();
				st.setVisible(true);
			}
		});
	}
	protected void do_btnModificar_actionPerformed(ActionEvent e) {
		btnModificar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String dnibuscado = JOptionPane.showInputDialog(rootPane,
						"Ingrese el DNI del paciente a modificar",
						"Modificar Paciente",
						JOptionPane.QUESTION_MESSAGE);
				
				if (dnibuscado == null || dnibuscado.trim().isEmpty()) {
					return;
				}
				
				dnibuscado = dnibuscado.trim();
				
				paciente pacienteencontrado= null;
				for (paciente p : lista.listaPacientes) {
					if (p.getDni().equals(dnibuscado)) {
						pacienteencontrado = p;
						break;
				}
				}
				
				if (pacienteencontrado == null) {
					JOptionPane.showMessageDialog(rootPane,
							"No se encontró ningún paciente con ese DNI",
							"Error",
							JOptionPane.WARNING_MESSAGE);
					return;
							
				}
				
				ConGeneral editar = new ConGeneral(pacienteencontrado);
				editar.setVisible(true);
				dispose();
			}
		});
	}
	protected void do_btBuscar_actionPerformed(ActionEvent e) {
		btBuscar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String dniBuscado = txtBuscarDni.getText().trim();

		        String[] columnas = {"DNI", "Nombre", "Apellido", "Edad", "Fecha", "Doctor", "Caso"};

		        DefaultTableModel modelo = new DefaultTableModel(columnas, 0) {
		            @Override
		            public boolean isCellEditable(int row, int column) {
		                return column == 6;
		            }
		        };

		        if (dniBuscado.isEmpty()) {
		            for (paciente p : lista.listaPacientes) {
		                Object[] fila = {
		                        p.getDni(), p.getNom(), p.getApellido(), p.getEdad(),
		                        p.getFecha(), p.getDoctor(), "Ver caso"
		                };
		                modelo.addRow(fila);
		            }
		        } else {
		            boolean encontrado = false;
		            for (paciente p : lista.listaPacientes) {
		                if (p.getDni().equals(dniBuscado)) {
		                    Object[] fila = {
		                            p.getDni(), p.getNom(), p.getApellido(), p.getEdad(),
		                            p.getFecha(), p.getDoctor(), "Ver caso"
		                    };
		                    modelo.addRow(fila);
		                    encontrado = true;
		                    break;
		                }
		            }

		            if (!encontrado) {
		                JOptionPane.showMessageDialog(rootPane,
		                        "No se encontró ningún paciente con ese DNI",
		                        "Sin resultados",
		                        JOptionPane.WARNING_MESSAGE);
		            }
		        }

		        txtTable.setModel(modelo);
		        txtTable.getColumn("Caso").setCellRenderer(new buttonrender());
		        txtTable.getColumn("Caso").setCellEditor(new buttoneditor(new JCheckBox()));
				
			}
		});
	}
}
