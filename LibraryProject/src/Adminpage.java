import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;

public class Adminpage extends JPanel {
	private JFrame frame;
	static String ID[]={"name","Username","Password"};
	static DefaultTableModel model;
	private JTextField NametextField;
	private JTextField UsertextField;
	private JTextField PasstextField;
	private JTable table;
	/**
	 * Create the panel.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 497, 545);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAdminstratorPortal = new JLabel("Adminstrator Portal");
		lblAdminstratorPortal.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAdminstratorPortal.setBounds(109, 26, 218, 25);
		frame.getContentPane().add(lblAdminstratorPortal);
		
		JButton btnNewButton = new JButton("Add Librarian");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//model= (DefaultTableModel)table.getModel();
				//model.addColumn("name");
				//model.addColumn("Username");
				//model.addColumn("Password");
				model.addRow(new Object[]{NametextField.getText(),UsertextField.getText(),PasstextField.getText()});
				
			}
		});
		btnNewButton.setBounds(10, 62, 108, 35);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnDelete.setBounds(130, 62, 108, 35);
		frame.getContentPane().add(btnDelete);
		
		JButton btnViewLibrarian = new JButton("View Librarian");
		btnViewLibrarian.setBounds(245, 62, 108, 35);
		frame.getContentPane().add(btnViewLibrarian);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnLogout.setBounds(363, 62, 108, 35);
		frame.getContentPane().add(btnLogout);
		//model= (DefaultTableModel)table.getModel();
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(21, 144, 60, 14);
		frame.getContentPane().add(lblName);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(21, 195, 60, 14);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(21, 250, 60, 14);
		frame.getContentPane().add(lblPassword);
		
		NametextField = new JTextField();
		NametextField.setBounds(119, 141, 119, 20);
		frame.getContentPane().add(NametextField);
		NametextField.setColumns(10);
		
		UsertextField = new JTextField();
		UsertextField.setColumns(10);
		UsertextField.setBounds(119, 192, 119, 20);
		frame.getContentPane().add(UsertextField);
		
		PasstextField = new JTextField();
		PasstextField.setColumns(10);
		PasstextField.setBounds(119, 247, 119, 20);
		frame.getContentPane().add(PasstextField);
		
		
		table = new JTable();
		table.setBounds(10, 304, 461, 189);
		frame.getContentPane().add(table);
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Adminpage() {
		database();
		setLayout(null);
		initialize();
		model= (DefaultTableModel)table.getModel();
		model.addColumn("name");
		model.addColumn("Username");
		model.addColumn("Password");
		

	}
	public void database(){
		try {
			Class.forName("sun.jdbc.odbc.JdbsOdbcDriver");
			Connection con = DriverManager.getConnection("jdbc:odbc:Games");
			Statement st = con.createStatement();
			String getquery = ("Select* from Games");
			ResultSet rs= st.executeQuery(getquery);
			while(rs.next()){
			System.out.println(rs.getString(2));
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
	}
}
