package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Sistemadoctor1 extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JButton btPacientes;
	private JButton btAtender;
	private JLabel lblNewLabel;
	private JLabel lblDoctorLuislvarez;
	private JButton btRetroceder;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Sistemadoctor1 dialog = new Sistemadoctor1();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Sistemadoctor1() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		{
			btPacientes = new JButton("Pacientes");
			btPacientes.addActionListener(this);
			btPacientes.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btPacientes.setBounds(25, 148, 121, 36);
			getContentPane().add(btPacientes);
		}
		{
			btAtender = new JButton("Atención");
			btAtender.addActionListener(this);
			btAtender.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btAtender.setBounds(282, 148, 121, 36);
			getContentPane().add(btAtender);
		}
		{
			lblNewLabel = new JLabel("Bienvenido");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
			lblNewLabel.setBounds(154, 11, 151, 55);
			getContentPane().add(lblNewLabel);
		}
		{
			lblDoctorLuislvarez = new JLabel("Doctor Luis Álvarez");
			lblDoctorLuislvarez.setFont(new Font("Tahoma", Font.PLAIN, 25));
			lblDoctorLuislvarez.setBounds(106, 48, 228, 55);
			getContentPane().add(lblDoctorLuislvarez);
		}
		{
			btRetroceder = new JButton("Retroceder");
			btRetroceder.addActionListener(this);
			btRetroceder.setBounds(164, 227, 89, 23);
			getContentPane().add(btRetroceder);
		}
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btRetroceder) {
			do_btRetroceder_actionPerformed(e);
		}
		if (e.getSource() == btAtender) {
			do_btAtender_actionPerformed(e);
		}
		if (e.getSource() == btPacientes) {
			do_btPacientes_actionPerformed(e);
		}
	}
	protected void do_btPacientes_actionPerformed(ActionEvent e) {
		btPacientes.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				Listadoctor1 ld1= new Listadoctor1();
				ld1.setVisible(true);
				
				
			}
		});
	}
	protected void do_btAtender_actionPerformed(ActionEvent e) {
		btAtender.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				Atencion1 at1 = new Atencion1();
				at1.setVisible(true);
				
			}
		});
	}
	protected void do_btRetroceder_actionPerformed(ActionEvent e) {
		btRetroceder.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			dispose();
			Login lg = new Login();
			lg.setVisible(true);
				
			}
		});
	}
}
