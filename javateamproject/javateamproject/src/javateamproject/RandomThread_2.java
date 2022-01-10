package javateamproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class RandomThread_2 extends Thread{
	JPanel[] panelArray;
	int a;

	ImageIcon icon = new ImageIcon("doduge.jpeg");
	Image img = icon.getImage();
	
	public RandomThread_2(JPanel[] panelArray,int a) {
		this.panelArray=panelArray;
		for(int i = 0; i<9; i++) {
			this.panelArray[i].setLayout(new BorderLayout());
		}
		if(a==1) {
			this.a=1500;
		}
		else if(a==2) {
			this.a=1000;
		}
		else if(a==3) {
			this.a=500;
		}
	}
	

	class MyPanel extends JPanel{
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(img, 0, 0, this.getWidth(),this.getHeight(), this);

				
		}
	}
	
	class MyPanel2 extends JPanel{
		public void paintComponent(Graphics g) {
			super.paintComponent(g);				
			g.setColor(new Color(0,0,0));
			g.fillRect(0, 0, this.getWidth(),this.getHeight());
			}
			
			
		}
	
	
	public void run() {
		Random random=new Random();
		while(true) {
//			panelArray[random.nextInt(9)].setBackground(Color.BLACK);
//			panelArray[random.nextInt(9)].setBackground(Color.BLACK);
//			panelArray[random.nextInt(9)].setBackground(Color.BLACK);
//			panelArray[random.nextInt(9)].setBackground(Color.RED);
			int a1=random.nextInt(9);
			int a2=random.nextInt(9);
			int a3=random.nextInt(9);
			int a4=random.nextInt(9);
			panelArray[a1].add(new MyPanel()).setBackground(Color.RED);
			Content5_Frame.rd[a1]=1;
			panelArray[a2].add(new MyPanel2()).setBackground(Color.BLACK);
			Content5_Frame.rd[a2]=0;
			panelArray[a3].add(new MyPanel2()).setBackground(Color.BLACK);
			Content5_Frame.rd[a3]=0;
			panelArray[a4].add(new MyPanel2()).setBackground(Color.BLACK);
			Content5_Frame.rd[a4]=0;
			try {
				sleep(a);
			}catch(Exception e) {return;}
		}
	}

}
