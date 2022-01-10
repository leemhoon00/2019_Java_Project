package javateamproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.net.*;
import java.io.*;

public class Content5_Frame extends JFrame {

	private JPanel contentPane;
	JPanel[] panelArray;
	TimerThread th1;
	RandomThread_2 th2;
	TcpThread th3;
	public static int[] rd= {0,0,0,0,0,0,0,0,0};


	
	public Content5_Frame(int a) {
		setTitle("\uB450\uB354\uC9C0\uC7A1\uAE30(\uBC84\uD2BC)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 508, 448);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(95, 37, 100, 92);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(194, 37, 100, 92);
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(293, 37, 100, 92);
		contentPane.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(95, 128, 100, 92);
		contentPane.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(194, 128, 100, 92);
		contentPane.add(panel_4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(293, 128, 100, 92);
		contentPane.add(panel_5);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(95, 218, 100, 92);
		contentPane.add(panel_6);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(194, 218, 100, 92);
		contentPane.add(panel_7);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBounds(293, 218, 100, 92);
		contentPane.add(panel_8);
		
		JLabel countLabel = new JLabel("¸ÂÃá°¹¼ö: 0");
		countLabel.setBounds(95, 354, 87, 15);
		contentPane.add(countLabel);
		
		JLabel timeLabel = new JLabel("");
		timeLabel.setBounds(194, 354, 57, 15);
		contentPane.add(timeLabel);
		

		
		panelArray= new JPanel[] {panel,panel_1,panel_2,panel_3,panel_4,panel_5,panel_6,panel_7,panel_8};
		for(int i=0;i<9;i++) {
			panelArray[i].setBackground(Color.BLACK);
		}
		th1= new TimerThread(timeLabel);
		th2= new RandomThread_2(panelArray,a);
		th1.start();
		th2.start();
		th3= new TcpThread(panelArray,countLabel,this,th1,th2);
		th3.start();
		
		
		
		
	}
	

}
