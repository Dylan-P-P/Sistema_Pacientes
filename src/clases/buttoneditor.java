package clases;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

public class buttoneditor extends AbstractCellEditor implements TableCellEditor {
	
	private JButton boton;
	private int filaActual;
	private JTable tablaRef;
	
	public buttoneditor(JCheckBox checkBox) {
		boton = new JButton();
		boton.setText("Ver Caso");
		boton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			paciente p = lista.listaPacientes.get(filaActual);
			JOptionPane.showMessageDialog(tablaRef,
					p.getCaso(),
					"Caso de "+ p.getNom() + " " + p.getApellido(),
					JOptionPane.INFORMATION_MESSAGE);
				fireEditingStopped();
			}
		});
	}
	@Override
	public Component getTableCellEditorComponent (JTable table, Object value, boolean isSelected, int row, int column) {
		filaActual = row;
		tablaRef = table;
		return boton;
	}
	public Object getCellEditorValue() {

		return "Ver Caso";
	}
}
