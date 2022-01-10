package javateamproject;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import javax.swing.JToggleButton;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JProgressBar;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPasswordField;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.UIManager;
import javax.swing.SwingConstants;

public class team extends JFrame {
	
	public static Student st;
	public static JFrame f1;
	public static int order=0;

	private JPanel contentPane;
	private JPasswordField passwordField;
	ImageIcon[] icon=new ImageIcon[]{new ImageIcon("image\\image_1.png"),new ImageIcon("image\\image_2.png"),new ImageIcon("image\\image_3.png")
			,new ImageIcon("image\\image_4.png"),new ImageIcon("image\\image_5.png"),new ImageIcon("image\\image_6.png")};
	JPanel a;

	
	public static void main(String[] args) {
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					team frame = new team();
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
	
	class ImageThread extends Thread{
		public void run() {
			while(true) {
				if(order==5) {
					order=0;
				}
				else {
					order++;
				}
				a.repaint();
				try {
					sleep(500);
				}catch(Exception e) {return;}
			}
			
		}
	}
	class MyPanel extends JPanel{
		
		public MyPanel() {
			a=this;
		}
		public void paintComponent(Graphics g) {
			
			g.drawImage(icon[order].getImage(), 0, 0, getWidth(), getHeight(),this);
			setOpaque(false);
			super.paintComponent(g);
			
		}
	}
	public team() {
		
		new BasicData();
		setResizable(false);		
		setTitle("\uD0C0\uC790\uC5F0\uC2B5 \uAC8C\uC784");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		Image background = Toolkit.getDefaultToolkit().createImage("C:\\workspace\\javateamproject\\GUI그림\\LoginBackground.png");
		setBounds(100, 100, 640, 360);
		contentPane = new MyPanel() ;
		ImageThread th4= new ImageThread();
		th4.start();
		
		
//		contentPane = new JPanel() {
//			public void paintComponent(Graphics g) {
//				g.drawImage(icon.getImage(),0,0,getWidth(),getHeight(),this);
//				setOpaque(false);
//				super.paintComponent(g);
//			}
//		};
//		contentPane.setBackground(background);
//		ImageIcon icon= new ImageIcon("C:\\workspace\\javateamproject\\GUI그림\\LoginBackground.png");
//		Image img= icon.getImage();
		
		contentPane.setBackground(new Color(0, 191, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextField ID_Field = new JTextField();
		
		ID_Field.setBounds(362, 125, 116, 21);
		contentPane.add(ID_Field);
		ID_Field.setColumns(10);
		ID_Field.setFocusable(true);
		ID_Field.requestFocus();
		
		JLabel numberLabel = new JLabel("\uC544\uC774\uB514");
		numberLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		numberLabel.setBounds(362, 103, 49, 21);
		contentPane.add(numberLabel);
		
		JButton btnNewButton_1 = new JButton("\uB85C\uADF8\uC778");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				int num=Integer.parseInt(ID_Field.getText());
//				st=new Student(num);
//				f1=new HomeFrame();
//				f1.setVisible(true);
//				setVisible(false);
				
				String s=ID_Field.getText();
				String query="select count(*) from gamer where 아이디='"+ID_Field.getText()+"'";
				try {
					Statement stmt=BasicData.con.createStatement();
					ResultSet rs=stmt.executeQuery(query);
					rs.next();
					int a= rs.getInt(1);
					if(a==0) {
						JOptionPane.showMessageDialog(null, "일치하는 아이디가 없습니다.","warning",JOptionPane.ERROR_MESSAGE);
						ID_Field.setText("");
						passwordField.setText("");
						
						return;
					}
					query="select 비밀번호 from gamer where 아이디='"+ID_Field.getText()+"'";
					rs=stmt.executeQuery(query);
					rs.next();
					String p=rs.getString(1).trim();
					if(!passwordField.getText().contentEquals(p)) {
						JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다.","warning",JOptionPane.ERROR_MESSAGE);
						passwordField.setText("");
						return;
					}
					st=new Student(s);
					f1=new HomeFrame();
					f1.setVisible(true);
					setVisible(false);
				}catch(Exception se) {se.printStackTrace();}
			}
		});
		
		btnNewButton_1.setBackground(UIManager.getColor("Button.background"));
		btnNewButton_1.setForeground(UIManager.getColor("Button.foreground"));
		btnNewButton_1.setBounds(489, 125, 90, 73);
		contentPane.add(btnNewButton_1);
		
		JLabel label = new JLabel("\uBE44\uBC00\uBC88\uD638");
		label.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		label.setBounds(361, 156, 74, 21);
		contentPane.add(label);
		
		JButton btnNewButton = new JButton("\uD68C\uC6D0\uAC00\uC785");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame f2= new MakeAccount_Frame();
				f2.setVisible(true);
			}
		});
		btnNewButton.setBounds(362, 208, 97, 23);
		contentPane.add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s=ID_Field.getText();
				String query="select count(*) from gamer where 아이디='"+ID_Field.getText()+"'";
				try {
					Statement stmt=BasicData.con.createStatement();
					ResultSet rs=stmt.executeQuery(query);
					rs.next();
					int a= rs.getInt(1);
					if(a==0) {
						JOptionPane.showMessageDialog(null, "일치하는 아이디가 없습니다.","warning",JOptionPane.ERROR_MESSAGE);
						ID_Field.setText("");
						passwordField.setText("");
						
						return;
					}
					query="select 비밀번호 from gamer where 아이디='"+ID_Field.getText()+"'";
					rs=stmt.executeQuery(query);
					rs.next();
					String p=rs.getString(1).trim();
					if(!passwordField.getText().contentEquals(p)) {
						JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다.","warning",JOptionPane.ERROR_MESSAGE);
						passwordField.setText("");
						return;
					}
					st=new Student(s);
					f1=new HomeFrame();
					f1.setVisible(true);
					setVisible(false);
				}catch(Exception se) {se.printStackTrace();}
			
			}
		});
		passwordField.setBounds(362, 177, 116, 23);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel = new JLabel("\uD0C0\uC790 \uC5F0\uC2B5 \uAC8C\uC784");
		lblNewLabel.setFont(new Font("새굴림", Font.BOLD, 30));
		lblNewLabel.setBounds(193, 10, 234, 84);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(354, 98, 234, 141);
		lblNewLabel_1.setBackground(new Color(51, 204, 255));
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBorder(new LineBorder(Color.black));
		contentPane.add(lblNewLabel_1);
		
	}
}