package javateamproject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class MakeAccount_Frame extends JFrame {
	

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	

	/**
	 * Create the frame.
	 */
	public MakeAccount_Frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 328, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 191, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uC544\uC774\uB514");
		lblNewLabel.setBounds(81, 77, 57, 15);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(81, 102, 116, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("\uBE44\uBC00\uBC88\uD638");
		label.setBounds(81, 133, 57, 15);
		contentPane.add(label);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(81, 158, 116, 21);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel_1 = new JLabel("\uBE44\uBC00\uBC88\uD638 \uC7AC\uD655\uC778");
		lblNewLabel_1.setBounds(81, 189, 98, 15);
		contentPane.add(lblNewLabel_1);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText()=="") {
					JOptionPane.showMessageDialog(null, "아이디를 입력하시오","warning",JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(passwordField.getText()=="") {
					JOptionPane.showMessageDialog(null, "비밀번호를 입력하시오","warning",JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(!passwordField.getText().contentEquals(passwordField_1.getText())) {
					JOptionPane.showMessageDialog(null, "비밀번호가 틀립니다.","warning",JOptionPane.ERROR_MESSAGE);
					passwordField.setText("");
					passwordField_1.setText("");
					return;
					
				}
				String query="select count(*) from gamer where 아이디='"+textField.getText()+"'";
				try {
					Statement stmt=BasicData.con.createStatement();
					ResultSet rs=stmt.executeQuery(query);
					rs.next();
					int a= rs.getInt(1);
					if(a==1) {
						JOptionPane.showMessageDialog(null, "아이디가 이미 사용중입니다.","warning",JOptionPane.ERROR_MESSAGE);
						textField.setText("");
						passwordField.setText("");
						passwordField_1.setText("");
						return;
					}
					
					
					query="insert into gamer values ('"+textField.getText()+"','"+passwordField.getText()+"',3000,3000,3000,3000)";
					stmt.executeUpdate(query);
					textField.setText("");
					passwordField.setText("");
					passwordField_1.setText("");
					setVisible(false);
				}catch(Exception se) {se.printStackTrace();}
			}
		});
		passwordField_1.setBounds(81, 214, 116, 21);
		contentPane.add(passwordField_1);
		
		JButton btnNewButton = new JButton("\uAC00\uC785\uD558\uAE30");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText()=="") {
					JOptionPane.showMessageDialog(null, "아이디를 입력하시오","warning",JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(passwordField.getText()=="") {
					JOptionPane.showMessageDialog(null, "비밀번호를 입력하시오","warning",JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(!passwordField.getText().contentEquals(passwordField_1.getText())) {
					JOptionPane.showMessageDialog(null, "비밀번호가 틀립니다.","warning",JOptionPane.ERROR_MESSAGE);
					passwordField.setText("");
					passwordField_1.setText("");
					return;
					
				}
				String query="select count(*) from gamer where 아이디='"+textField.getText()+"'";
				try {
					Statement stmt=BasicData.con.createStatement();
					ResultSet rs=stmt.executeQuery(query);
					rs.next();
					int a= rs.getInt(1);
					if(a==1) {
						JOptionPane.showMessageDialog(null, "아이디가 이미 사용중입니다.","warning",JOptionPane.ERROR_MESSAGE);
						textField.setText("");
						passwordField.setText("");
						passwordField_1.setText("");
						return;
					}
					
					
					query="insert into gamer values ('"+textField.getText()+"','"+passwordField.getText()+"',3000,3000,3000,3000)";
					stmt.executeUpdate(query);
					textField.setText("");
					passwordField.setText("");
					passwordField_1.setText("");
					setVisible(false);
				}catch(Exception se) {se.printStackTrace();}
				
			}
		});
		btnNewButton.setBounds(100, 260, 97, 23);
		contentPane.add(btnNewButton);
	}
}
