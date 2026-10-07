package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class V1 extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JButton btLOGIN;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mntmNewMenuItem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					V1 frame = new V1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public V1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 675, 535);
		{
			menuBar = new JMenuBar();
			setJMenuBar(menuBar);
			{
				mnNewMenu = new JMenu("Menú");
				menuBar.add(mnNewMenu);
				{
					mntmNewMenuItem = new JMenuItem("Programadores");
					mntmNewMenuItem.addActionListener(this);
					mnNewMenu.add(mntmNewMenuItem);
				}
			}
		}
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(V1.class.getResource("/imagenes/Puesto de Salud.png")));
			lblNewLabel.setBounds(138, 11, 385, 366);
			contentPane.add(lblNewLabel);
		}
		{
			btLOGIN = new JButton("LOGIN");
			btLOGIN.setFont(new Font("Tahoma", Font.PLAIN, 22));
			btLOGIN.addActionListener(this);
			btLOGIN.setBounds(249, 399, 150, 40);
			contentPane.add(btLOGIN);
		}

	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btLOGIN) {
			do_btnNewButton_actionPerformed(e);
		}
		if (e.getSource() == mntmNewMenuItem) {
			do_mntmNewMenuItem_actionPerformed(e);
		}
	}
	public void do_mntmNewMenuItem_actionPerformed(ActionEvent e) {
		Programadores pr=new Programadores();
		pr.setVisible(true);
		
	}
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		btLOGIN.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			dispose();
				// TODO Auto-generated method stub
			Login lg= new Login();
			lg.setVisible(true);
			}
		});
	}
}
