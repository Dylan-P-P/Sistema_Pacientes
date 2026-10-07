package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Programadores extends JDialog {

	private static final long serialVersionUID = 1L;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_11;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Programadores dialog = new Programadores();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Programadores() {
		setModal(true);
		setBounds(100, 100, 850, 610);
		getContentPane().setLayout(null);
		{
			lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(Programadores.class.getResource("/imagenes/Anderson Mato.png")));
			lblNewLabel.setBounds(10, 11, 290, 245);
			getContentPane().add(lblNewLabel);
		}
		{
			lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(new ImageIcon(Programadores.class.getResource("/imagenes/{25143884-E70A-4364-AB71-11C06BC48DB2}.png")));
			lblNewLabel_1.setBounds(543, 11, 281, 245);
			getContentPane().add(lblNewLabel_1);
		}
		{
			lblNewLabel_2 = new JLabel("");
			lblNewLabel_2.setIcon(new ImageIcon(Programadores.class.getResource("/imagenes/Jorge Huaman.png")));
			lblNewLabel_2.setBounds(10, 315, 290, 245);
			getContentPane().add(lblNewLabel_2);
		}
		{
			lblNewLabel_3 = new JLabel("");
			lblNewLabel_3.setIcon(new ImageIcon(Programadores.class.getResource("/imagenes/Dylan Perez.png")));
			lblNewLabel_3.setBounds(534, 315, 218, 245);
			getContentPane().add(lblNewLabel_3);
		}
		{
			lblNewLabel_4 = new JLabel("Jorge Huaman");
			lblNewLabel_4.setBounds(310, 359, 98, 14);
			getContentPane().add(lblNewLabel_4);
		}
		{
			lblNewLabel_5 = new JLabel("Anderson Mato");
			lblNewLabel_5.setBounds(310, 55, 98, 14);
			getContentPane().add(lblNewLabel_5);
		}
		{
			lblNewLabel_6 = new JLabel("Mathias Fernandez");
			lblNewLabel_6.setBounds(433, 55, 110, 14);
			getContentPane().add(lblNewLabel_6);
		}
		{
			lblNewLabel_7 = new JLabel("Dylan Perez");
			lblNewLabel_7.setBounds(445, 359, 79, 14);
			getContentPane().add(lblNewLabel_7);
		}
		{
			lblNewLabel_8 = new JLabel("N00557755");
			lblNewLabel_8.setBounds(310, 80, 79, 14);
			getContentPane().add(lblNewLabel_8);
		}
		{
			lblNewLabel_9 = new JLabel("N00549130");
			lblNewLabel_9.setBounds(433, 80, 79, 14);
			getContentPane().add(lblNewLabel_9);
		}
		{
			lblNewLabel_10 = new JLabel("N00560734");
			lblNewLabel_10.setBounds(445, 384, 79, 14);
			getContentPane().add(lblNewLabel_10);
		}
		{
			lblNewLabel_11 = new JLabel("N00552147");
			lblNewLabel_11.setBounds(310, 384, 79, 14);
			getContentPane().add(lblNewLabel_11);
		}
	}
}
