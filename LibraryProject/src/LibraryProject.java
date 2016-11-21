import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LibraryProject {

	private JFrame frame;
	private JTextField txtPassword;
	private JTextField txtPaasword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LibraryProject window = new LibraryProject();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LibraryProject() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUserLogin = new JLabel("User Login");
		lblUserLogin.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblUserLogin.setBounds(127, 27, 192, 27);
		frame.getContentPane().add(lblUserLogin);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Administrator");
		rdbtnNewRadioButton.setBounds(61, 81, 109, 23);
		frame.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Librarian");
		rdbtnNewRadioButton_1.setBounds(235, 81, 109, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_1);
		
		txtPassword = new JTextField();
		txtPassword.setText("Username");
		txtPassword.setBounds(75, 139, 127, 20);
		frame.getContentPane().add(txtPassword);
		txtPassword.setColumns(10);
		
		txtPaasword = new JTextField();
		txtPaasword.setText("Password");
		txtPaasword.setBounds(75, 194, 127, 20);
		frame.getContentPane().add(txtPaasword);
		txtPaasword.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Adminpage ad = new Adminpage();
				frame.setVisible(false);
				ad.setVisible(true);
			}
		});
		btnNewButton.setBounds(253, 164, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
