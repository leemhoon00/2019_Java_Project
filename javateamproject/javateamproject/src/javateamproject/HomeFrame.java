package javateamproject;

import java.awt.BorderLayout;
import java.sql.*;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javateamproject.team.ImageThread;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.Color;
import java.awt.Font;

public class HomeFrame extends JFrame {

	private JPanel contentPane;
	JSpinner spinner;
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


	public HomeFrame() {
		setTitle("\uD0C0\uC790\uC5F0\uC2B5");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 590, 435);
		contentPane = new MyPanel();
		ImageThread th4= new ImageThread();
		th4.start();
		contentPane.setBackground(new Color(0, 191, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("\uB0B1\uB9D0 \uC5F0\uC2B5");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	//낱말연습버튼 누르면
				setVisible(false);
				JFrame f2=new Content1_Frame();
				f2.setVisible(true);
			}
		});
		btnNewButton.setBounds(96, 44, 127, 75);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uC9E7\uC740 \uAE00 \uC5F0\uC2B5");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				JFrame f3=new Content2_Frame();
				f3.setVisible(true);
			}
		});
		
		btnNewButton_1.setBounds(321, 44, 133, 75);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\uAE34 \uAE00 \uC5F0\uC2B5");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame f3=new Content3_Frame();
				setVisible(false);
				f3.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(96, 143, 127, 75);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("\uB450\uB354\uC9C0 \uC7A1\uAE30");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame f5= new Content4_Frame();
				f5.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_3.setBounds(321, 143, 133, 75);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel = new JLabel("사용자: "+team.st.ID);
		lblNewLabel.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 14));
		lblNewLabel.setBounds(293, 350, 161, 23);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_4 = new JButton("\uB7AD\uD0B9\uC870\uD68C");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame f1=new Ranking_Frame();
				setVisible(false);
				f1.setVisible(true);
			}
		});
		btnNewButton_4.setBounds(321, 249, 133, 75);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("\uB450\uB354\uC9C0\uC7A1\uAE30(\uBC84\uD2BC)");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a=(int)spinner.getValue();
				JFrame f10=new Content5_Frame(a);
				setVisible(false);
				f10.setVisible(true);
			}
		});
		btnNewButton_5.setBounds(96, 249, 127, 75);
		contentPane.add(btnNewButton_5);
		
		spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(1, 1, 3, 1));
		spinner.setBounds(237, 249, 34, 75);
		contentPane.add(spinner);
	}
}