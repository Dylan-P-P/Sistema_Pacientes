package clases;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class botonVerAtencionRender extends JButton implements TableCellRenderer{

	public botonVerAtencionRender() {
		setOpaque(true);
	}
	
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		setText("Ver Atención");
		return this;
	}
	

}
