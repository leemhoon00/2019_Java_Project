package javateamproject;

import java.sql.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import javateamproject.Content1_Frame.ImageThread;
import javateamproject.Content1_Frame.MyPanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Content2_Frame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	String [] wordArray= {"가는 날이 장날","가는 말에 채찍질","가는 말이 고와야 오는 말이 곱다.","간에 기별도 안 간다."};
	private int num;
	int count=0;	//맞춘 갯수
	JLabel wordLabel = new JLabel(wordArray[num]);
	private JLabel TimeLabel;
	TimerThread th;
	
	Statement stmt=null;
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


	/**
	 * Create the frame.
	 */
	public Content2_Frame() {
		setTitle("\uC9E7\uC740\uAE00\uC5F0\uC2B5");
		num=0;	//단어배열 인덱스로 활용
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 599, 444);
		contentPane = new MyPanel();
		ImageThread th4= new ImageThread();
		th4.start();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		textField = new JTextField();
		textField.setFont(new Font("굴림", Font.PLAIN, 14));
		textField.addActionListener(new ActionListener() {		//단어입력 후 엔터
			public void actionPerformed(ActionEvent e) {
				JTextField j1=(JTextField)e.getSource();
				if(j1.getText().equals(wordArray[num])) {
					if(num==3) {
						th.interrupt();
						count++;
						try {
							stmt=BasicData.con.createStatement();
							
							if(team.st.score2>TimerThread.n) {
								String query="update gamer set 짧은글점수="+TimerThread.n+" where 아이디='"+team.st.ID+"'";
								team.st.score2=TimerThread.n;
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
						wordLabel.setText(wordArray[++num]);
						count++;
					}
					
					j1.setText("");
				}
				else {
					j1.setText("");
				}
			}
		});
		textField.setBounds(139, 273, 257, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		wordLabel.setFont(new Font("굴림", Font.BOLD, 16));
		
		
		wordLabel.setBounds(139, 99, 296, 30);
		contentPane.add(wordLabel);
		
		textField.setFocusable(true);
		
		TimeLabel = new JLabel("");
		TimeLabel.setBounds(139, 338, 195, 15);
		contentPane.add(TimeLabel);
		
		th= new TimerThread(TimeLabel);
		th.start();
		textField.requestFocus();
		
	}
	

}