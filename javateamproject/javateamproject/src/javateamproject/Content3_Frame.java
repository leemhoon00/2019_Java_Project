package javateamproject;

import java.awt.BorderLayout;
import java.sql.*;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javateamproject.Content2_Frame.ImageThread;
import javateamproject.Content2_Frame.MyPanel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Content3_Frame extends JFrame {
	ImageIcon[] icon=new ImageIcon[]{new ImageIcon("image\\image_1.png"),new ImageIcon("image\\image_2.png"),new ImageIcon("image\\image_3.png")
			,new ImageIcon("image\\image_4.png"),new ImageIcon("image\\image_5.png"),new ImageIcon("image\\image_6.png")};
	JPanel a;
	public static int order=0;
	
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

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	JLabel TimeLabel = new JLabel("");
	String [] wordArray= {"동해물과 백두산이 마르고 닳도록","하느님이 보우하사 우리나라 만세",
			"무궁화 삼천리 화려 강산","대한 사람 대한으로 길이 보전하세"};
	int num;
	TimerThread th;
	Statement stmt=null;

	

	/**
	 * Create the frame.
	 */
	public Content3_Frame() {
		num=0;
		setTitle("\uAE34\uAE00\uC5F0\uC2B5");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 552, 425);
		contentPane = new MyPanel();
		ImageThread th4= new ImageThread();
		th4.start();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Lable_1 = new JLabel("\uB3D9\uD574\uBB3C\uACFC \uBC31\uB450\uC0B0\uC774 \uB9C8\uB974\uACE0 \uB2F3\uB3C4\uB85D");
		Lable_1.setBounds(153, 52, 189, 15);
		contentPane.add(Lable_1);
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextField a=(JTextField)e.getSource();
				if(a.getText().contentEquals(wordArray[0])) {
					textField_1.setFocusable(true);
					textField_1.requestFocus();
				}
				else {
					a.setText("");
				}
			}
		});
		textField.setBounds(153, 77, 189, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel Label_2 = new JLabel("\uD558\uB290\uB2D8\uC774 \uBCF4\uC6B0\uD558\uC0AC \uC6B0\uB9AC\uB098\uB77C \uB9CC\uC138");
		Label_2.setBounds(153, 132, 189, 15);
		contentPane.add(Label_2);
		
		textField_1 = new JTextField();
		textField_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextField a=(JTextField)e.getSource();
				if(a.getText().contentEquals(wordArray[1])) {
					textField_2.setFocusable(true);
					textField_2.requestFocus();
				}
				else {
					a.setText("");
				}
			}
		});
		textField_1.setBounds(153, 157, 189, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel Label_3 = new JLabel("\uBB34\uAD81\uD654 \uC0BC\uCC9C\uB9AC \uD654\uB824 \uAC15\uC0B0");
		Label_3.setBounds(153, 199, 189, 15);
		contentPane.add(Label_3);
		
		textField_2 = new JTextField();
		textField_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextField a=(JTextField)e.getSource();
				if(a.getText().contentEquals(wordArray[2])) {
					textField_3.setFocusable(true);
					textField_3.requestFocus();
				}
				else {
					a.setText("");
				}
			}
		});
		textField_2.setBounds(153, 224, 189, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel Label_4 = new JLabel("\uB300\uD55C \uC0AC\uB78C \uB300\uD55C\uC73C\uB85C \uAE38\uC774 \uBCF4\uC804\uD558\uC138");
		Label_4.setBounds(153, 266, 189, 15);
		contentPane.add(Label_4);
		
		textField_3 = new JTextField();
		textField_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextField a=(JTextField)e.getSource();
				if(a.getText().contentEquals(wordArray[3])) {
					th.interrupt();
					try {
						stmt=BasicData.con.createStatement();
						if(team.st.score3>TimerThread.n) {
							String query="update gamer set 긴글점수="+TimerThread.n+" where 아이디='"+team.st.ID+"'";
							team.st.score3=TimerThread.n;
							stmt.executeUpdate(query);
						}
						
					}catch(SQLException se) {se.printStackTrace();}
					int result= JOptionPane.showConfirmDialog(null,"걸린 시간:"+String.format("%.1f",TimerThread.n) +"계속하시겠습니까?","Confirm",JOptionPane.YES_NO_OPTION);
					if(result==JOptionPane.NO_OPTION) {
						System.exit(0);
					}
					else if(result==JOptionPane.YES_OPTION) {
						TimerThread.n=0;
						setVisible(false);
						team.f1.setVisible(true);
						
					}
				}
				else {
					a.setText("");
				}
			}
		});
		textField_3.setBounds(153, 301, 189, 21);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		TimeLabel.setBounds(153, 343, 57, 15);
		contentPane.add(TimeLabel);
		textField.setFocusable(true);
		textField.requestFocus();
		th=new TimerThread(TimeLabel);
		th.start();
		
		
	}
}
