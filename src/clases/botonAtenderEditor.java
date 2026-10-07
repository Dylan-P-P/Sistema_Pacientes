package clases;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

import gui.Atencion1;
import gui.VentanaAtencion;

public class botonAtenderEditor extends AbstractCellEditor implements TableCellEditor{

	private JButton boton;
	private int filaActual;
	private ArrayList<paciente> listaRef;
	
	public botonAtenderEditor(JCheckBox checkBox, ArrayList<paciente> listaOrigen) {
		this.listaRef = listaOrigen;
		boton = new JButton();
		boton.setText("Atender");
		boton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				paciente p= listaRef.get(filaActual);
				
				VentanaAtencion at1 = new VentanaAtencion(p);
				at1.setVisible(true);
				
				fireEditingStopped();
			}
		});
				
	}
	
	
	
	@Override
	public Object getCellEditorValue() {
		return "Atender";
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		filaActual = row;
		return boton;
	}

}
