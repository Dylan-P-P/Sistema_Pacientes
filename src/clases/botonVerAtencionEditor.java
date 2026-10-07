package clases;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

public class botonVerAtencionEditor extends AbstractCellEditor implements TableCellEditor{

	private JButton boton;
	private int filaActual;
	private ArrayList<paciente> listaRef;
	private JTable tablaRef;
	
	

	public botonVerAtencionEditor(JCheckBox checkBox, ArrayList<paciente> listaOrigen) {
        this.listaRef = listaOrigen;
        boton = new JButton();
        boton.setText("Ver Atención");
        boton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (filaActual < 0 || filaActual >= listaRef.size()) {
                    fireEditingStopped();
                    return;
                }

                paciente p = listaRef.get(filaActual);

                String info = "Diagnóstico: " + p.getDiagnostico() +
                              "\n\nReceta: " + p.getReceta();

                JOptionPane.showMessageDialog(tablaRef,
                        info,
                        "Atención de " + p.getNom(),
                        JOptionPane.INFORMATION_MESSAGE);

                fireEditingStopped();
				
			}
		});	
	}		
	
	@Override
	public Object getCellEditorValue() {
		return "Ver Atención";
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		filaActual = row;
		tablaRef = table;
		return boton;
	}

}
