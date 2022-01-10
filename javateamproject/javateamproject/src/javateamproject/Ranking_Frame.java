package javateamproject;

import java.awt.BorderLayout;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.EventQueue;
import java.util.TreeSet;
import java.util.Iterator;

import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;

public class Ranking_Frame extends JFrame {
	

	private JPanel contentPane;
	TreeSet<Person> tree=new TreeSet<>();
	int num=0;
	int st=1;
	JPanel panel;
	JPanel panel2;
	JPanel panel3;
	JPanel panel4;
	private JButton btnNewButton_4;

	
	public Ranking_Frame() {
		setTitle("\uB7AD\uD0B9");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 481, 424);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("\uB2E8\uC5B4\uC810\uC218");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(true);
				panel2.setVisible(false);
				panel3.setVisible(false);
				panel4.setVisible(false);
			}
		});
		btnNewButton.setBounds(0, 0, 97, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uC9E7\uC740\uAE00\uC810\uC218");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				panel2.setVisible(true);
				panel3.setVisible(false);
				panel4.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(91, 0, 97, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\uAE34\uAE00\uC810\uC218");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				panel2.setVisible(false);
				panel3.setVisible(true);
				panel4.setVisible(false);
			}
		});
		btnNewButton_2.setBounds(187, 0, 97, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("\uB450\uB354\uC9C0\uC7A1\uAE30");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				panel2.setVisible(false);
				panel3.setVisible(false);
				panel4.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(282, 0, 100, 23);
		contentPane.add(btnNewButton_3);
		
		panel = new JPanel();
		panel.setBackground(new Color(102, 204, 255));
		panel.setBounds(0, 22, 465, 363);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(10,3));
		
		
		panel2 = new JPanel();
		panel2.setBackground(new Color(102, 204, 255));
		panel2.setBounds(0, 22, 465, 363);
		contentPane.add(panel2);
		panel2.setLayout(new GridLayout(10,3));
		
		panel3 = new JPanel();
		panel3.setBackground(new Color(102, 204, 255));
		panel3.setBounds(0, 22, 465, 363);
		contentPane.add(panel3);
		panel3.setLayout(new GridLayout(10,3));
		
		panel4 = new JPanel();
		panel4.setBackground(new Color(102, 204, 255));
		panel4.setBounds(0, 22, 465, 363);
		contentPane.add(panel4);
		panel4.setLayout(new GridLayout(10,3));
		
		btnNewButton_4 = new JButton("\uD648\uC73C\uB85C");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				team.f1.setVisible(true);
			}
		});
		btnNewButton_4.setBounds(380, 0, 85, 23);
		contentPane.add(btnNewButton_4);
		
		
		String query="select count(*) from gamer";
		try {
			Statement stmt=BasicData.con.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			rs.next();
			int a= rs.getInt(1);
			query="select 아이디, 단어점수 from gamer";
			rs=stmt.executeQuery(query);
			for(int i=0;i<a;i++) {
				
				rs.next();
				String number=rs.getString(1).trim();
				double score=rs.getDouble(2);
				if(score==3000)
					continue;
				tree.add(new Person(number,score));
				
			}
			for(Person p:tree) {
				panel.add(new JLabel("등수:"+Integer.toString(st)));
				panel.add(new Label("아이디:"+p.ID));
				panel.add(new JLabel("점수:"+Double.toString(p.score)));
				num+=3;
				st++;
			}
			for(int i=0;i<30-num;i++) {
				panel.add(new JLabel(""));
			}
			num=0;
			st=1;
			tree.clear();
			
		}catch(SQLException e) {e.printStackTrace();}
		
		query="select count(*) from gamer";
		try {
			Statement stmt=BasicData.con.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			rs.next();
			int a= rs.getInt(1);
			query="select 아이디, 짧은글점수 from gamer";
			rs=stmt.executeQuery(query);
			for(int i=0;i<a;i++) {
				
				rs.next();
				String number=rs.getString(1).trim();
				double score=rs.getDouble(2);
				if(score==3000)
					continue;
				tree.add(new Person(number,score));
				
			}
			for(Person p:tree) {
				panel2.add(new JLabel("등수:"+Integer.toString(st)));
				panel2.add(new Label("아이디:"+p.ID));
				panel2.add(new JLabel("점수:"+Double.toString(p.score)));
				num+=3;
				st++;
			}
			for(int i=0;i<30-num;i++) {
				panel2.add(new JLabel(""));
			}
			num=0;
			st=1;
			tree.clear();
			
		}catch(SQLException e) {e.printStackTrace();}
		
		query="select count(*) from gamer";
		try {
			Statement stmt=BasicData.con.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			rs.next();
			int a= rs.getInt(1);
			query="select 아이디, 긴글점수 from gamer";
			rs=stmt.executeQuery(query);
			for(int i=0;i<a;i++) {
				
				rs.next();
				String number=rs.getString(1).trim();
				double score=rs.getDouble(2);
				if(score==3000)
					continue;
				tree.add(new Person(number,score));
				
			}
			for(Person p:tree) {
				panel3.add(new JLabel("등수:"+Integer.toString(st)));
				panel3.add(new Label("아이디:"+p.ID));
				panel3.add(new JLabel("점수:"+Double.toString(p.score)));
				num+=3;
				st++;
			}
			for(int i=0;i<30-num;i++) {
				panel3.add(new JLabel(""));
			}
			
			num=0;
			st=1;
			tree.clear();
			
		}catch(SQLException e) {e.printStackTrace();}
		
		query="select count(*) from gamer";
		try {
			Statement stmt=BasicData.con.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			rs.next();
			int a= rs.getInt(1);
			query="select 아이디, 두더지점수 from gamer";
			rs=stmt.executeQuery(query);
			for(int i=0;i<a;i++) {
				
				rs.next();
				String number=rs.getString(1).trim();
				double score=rs.getDouble(2);
				if(score==3000)
					continue;
				tree.add(new Person(number,score));
				
			}
			for(Person p:tree) {
				panel4.add(new JLabel("등수:"+Integer.toString(st)));
				panel4.add(new Label("아이디:"+p.ID));
				panel4.add(new JLabel("점수:"+Double.toString(p.score)));
				num+=3;
				st++;
			}
			for(int i=0;i<30-num;i++) {
				panel4.add(new JLabel(""));
			}
			num=0;
			st=1;
			tree.clear();
			
		}catch(SQLException e) {e.printStackTrace();}
		
		panel2.setVisible(false);
		panel3.setVisible(false);
		panel4.setVisible(false);
		
	}
}
