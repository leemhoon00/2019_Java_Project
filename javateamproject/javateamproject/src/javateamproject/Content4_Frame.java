package javateamproject;

import java.awt.BorderLayout;
import java.util.Random;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Content4_Frame extends JFrame {
	
	
	int totalNum=9;	//9개 맞추면 끝

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	TimerThread th;
	RandomThread th2;
	JLabel [] wordLabel;
	String [] array= {"아리랑","한글","단어","자바","씨샵","산성비","두더지","컴퓨터","보리","안경","커피","물","콜라","사이다","인형","종이","시간","책","가방","전구","침대","충전기","우유"};
	int size=23;
	int count=0;
	JLabel countLabel;
	Statement stmt=null;

	
	public Content4_Frame() {
		
		setTitle("\uB450\uB354\uC9C0\uC7A1\uAE30");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 544, 438);
		contentPane = new MyPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		getContentPane().setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextField tf= (JTextField)e.getSource();
				for(int i=0;i<9;i++) {
					if(tf.getText().contentEquals(wordLabel[i].getText()) && !tf.getText().contentEquals("")) {
						count++;
						wordLabel[i].setText("");
						countLabel.setText("맞춘갯수: "+count);
						if(count==totalNum) {
							th.interrupt();
							th2.interrupt();
							try {
								stmt=BasicData.con.createStatement();
								
								if(team.st.score4>TimerThread.n) {
									String query="update gamer set 두더지점수="+TimerThread.n+" where 아이디='"+team.st.ID+"'";
									team.st.score4=TimerThread.n;
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
						break;
					}
				}
				tf.setText("");
			}
		});
		textField_1.setBounds(190, 324, 116, 21);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel TimeLabel = new JLabel("New label");
		TimeLabel.setBounds(348, 327, 57, 15);
		getContentPane().add(TimeLabel);
		contentPane.setLayout(null);
		
		wordLabel= new JLabel[9];
		for(int i=0;i<9;i++) {
			wordLabel[i]=new JLabel();
			getContentPane().add(wordLabel[i]);
			
		}
		
		wordLabel[0].setBounds(140,75,57,15);
		wordLabel[1].setBounds(220,75,57,15);
		wordLabel[2].setBounds(300,75,57,15);
		wordLabel[3].setBounds(140,155,57,15);
		wordLabel[4].setBounds(220,155,57,15);
		wordLabel[5].setBounds(300,155,57,15);
		wordLabel[6].setBounds(140,235,57,15);
		wordLabel[7].setBounds(220,235,57,15);
		wordLabel[8].setBounds(300,235,57,15);
		
		getContentPane().add(wordLabel[0]);
		th=new TimerThread(TimeLabel);
		
		countLabel = new JLabel("맞춘갯수: 0");
		countLabel.setBounds(33, 327, 80, 15);
		getContentPane().add(countLabel);
		th.start();
		th2=new RandomThread(array,wordLabel);
		th2.start();
		
		
		
	}
	
	class MyPanel extends JPanel{
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawOval(120, 40, 80, 80);
			g.drawOval(200, 40, 80, 80);
			g.drawOval(280, 40, 80, 80);
			g.drawOval(120, 120, 80, 80);
			g.drawOval(200, 120, 80, 80);
			g.drawOval(280, 120, 80, 80);
			g.drawOval(120, 200, 80, 80);
			g.drawOval(200, 200, 80, 80);
			g.drawOval(280, 200, 80, 80);
		}
	}
}
