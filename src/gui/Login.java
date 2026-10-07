package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtUsuario;
	private JLabel lblNewLabel_1;
	private JTextField txtCodigo;
	private JButton btENTER;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Login dialog = new Login();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Login() {
		setModal(true);
		setBounds(100, 100, 200, 200);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Usuario");
			lblNewLabel.setBounds(73, 29, 46, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			txtUsuario = new JTextField();
			txtUsuario.setBounds(50, 46, 86, 20);
			contentPanel.add(txtUsuario);
			txtUsuario.setColumns(10);
		}
		{
			lblNewLabel_1 = new JLabel("Código");
			lblNewLabel_1.setBounds(73, 77, 46, 14);
			contentPanel.add(lblNewLabel_1);
		}
		{
			txtCodigo = new JTextField();
			txtCodigo.setBounds(50, 92, 86, 20);
			contentPanel.add(txtCodigo);
			txtCodigo.setColumns(10);
		}
		{
			btENTER = new JButton("ENTER");
			btENTER.addActionListener(this);
			btENTER.setBounds(50, 127, 89, 23);
			contentPanel.add(btENTER);
		}
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btENTER) {
			do_btnNewButton_actionPerformed(e);
		}
	}
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		btENTER.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String usuario = txtUsuario.getText().trim();
				String codigotexto = txtCodigo.getText().trim();
				
				try {
					int codigo = Integer.parseInt(codigotexto);
					
					if (usuario.equals("Marisol") && codigo == 170626) {
						dispose();
						Sistema st=new Sistema();
						st.setVisible(true);
					} 
					
					else if (usuario.equals("Luis") && codigo == 190921) {
						dispose();
						Sistemadoctor1 sd=new Sistemadoctor1();
						sd.setVisible(true);
					}
					else {
						JOptionPane.showMessageDialog(rootPane,
								"Usuario o Código incorrecto",
								"Error",
								JOptionPane.ERROR_MESSAGE);
					}
					
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(rootPane,
							"El código debe ser un valor númerico",
							"Error",
							JOptionPane.ERROR_MESSAGE);
				}
			
			
			}
		});
		
	}
}
