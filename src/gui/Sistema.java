package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Sistema extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton btCITAS;
	private JButton btLISTA;
	private JButton btRetroceder;
	private JButton btAtendidos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Sistema dialog = new Sistema();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Sistema() {
		setBounds(100, 100, 400, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Sistema de atención");
			lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 30));
			lblNewLabel.setBounds(61, 11, 273, 90);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblAPacientes = new JLabel("a pacientes");
			lblAPacientes.setFont(new Font("Tahoma", Font.ITALIC, 30));
			lblAPacientes.setBounds(112, 52, 165, 66);
			contentPanel.add(lblAPacientes);
		}
		{
			btCITAS = new JButton("CITAS");
			btCITAS.addActionListener(this);
			btCITAS.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btCITAS.setBounds(10, 112, 115, 40);
			contentPanel.add(btCITAS);
		}
		{
			btLISTA = new JButton("LISTA");
			btLISTA.addActionListener(this);
			btLISTA.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btLISTA.setBounds(259, 112, 115, 40);
			contentPanel.add(btLISTA);
		}
		{
			btRetroceder = new JButton("Retroceder");
			btRetroceder.addActionListener(this);
			btRetroceder.setBounds(140, 227, 106, 23);
			contentPanel.add(btRetroceder);
		}
		{
			btAtendidos = new JButton("Atendidos");
			btAtendidos.addActionListener(this);
			btAtendidos.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btAtendidos.setBounds(131, 164, 115, 40);
			contentPanel.add(btAtendidos);
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btAtendidos) {
			do_btAtendidos_actionPerformed(e);
		}
		if (e.getSource() == btRetroceder) {
			do_btnNewButton_actionPerformed(e);
		}
		if (e.getSource() == btLISTA) {
			do_btnLista_actionPerformed(e);
		}
		if (e.getSource() == btCITAS) {
			do_btCITAS_actionPerformed(e);
		}
	}
	protected void do_btCITAS_actionPerformed(ActionEvent e) {
		btCITAS.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			dispose();
			ConGeneral cg=new ConGeneral();
			cg.setVisible(true);
			}
		});
	
	}
	protected void do_btnLista_actionPerformed(ActionEvent e) {
		btLISTA.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			dispose();
			Lista lt=new Lista();
			lt.setVisible(true);
			}
		});
	
	}
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		btRetroceder.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				Login lg = new Login();
				lg.setVisible(true);
				
			}
		});
	}
	protected void do_btAtendidos_actionPerformed(ActionEvent e) {
		btAtendidos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			dispose();
			Atendidos at= new Atendidos();
			at.setVisible(true);
				
			}
		});
	}
}
