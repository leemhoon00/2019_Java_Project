package javateamproject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TcpThread extends Thread {
	JPanel[] panelArray;
	JLabel countLabel;
	Thread th1;
	Thread th2;
	JFrame f;
	
	ImageIcon icon = new ImageIcon("doduge.jpeg");
	Image img = icon.getImage();
	
	public TcpThread(JPanel[] panelArray,JLabel countLabel,JFrame f,Thread th1, Thread th2) {
		this.panelArray=panelArray;
		this.countLabel=countLabel;
		this.th1=th1;
		this.th2=th2;
		this.f=f;
		
	}
	public void run() {
		try {
			int count=0;
			ServerSocket server= new ServerSocket(7000);
			Socket sock=server.accept();
			InetAddress inetaddr=sock.getInetAddress();
			InputStream in=sock.getInputStream();
			BufferedReader br= new BufferedReader(new InputStreamReader(in));
			String line=null;
			while((line=br.readLine())!=null) {
				line=line.trim();
				int a=Integer.parseInt(line);
				System.out.println(line);
				if(Content5_Frame.rd[a-1]==1) {
					count++;
					panelArray[a-1].add(new MyPanel2()).setBackground(Color.BLACK);;
					Content5_Frame.rd[a-1] = 0;
					
					if(count==9) {
						br.close();
						sock.close();
						server.close();
						th1.interrupt();
						th2.interrupt();
						int result= JOptionPane.showConfirmDialog(null,"걸린 시간:"+String.format("%.1f",TimerThread.n) +"계속하시겠습니까?","Confirm",JOptionPane.YES_NO_OPTION);
						if(result==JOptionPane.NO_OPTION) {
							System.exit(0);
						}
						else if(result==JOptionPane.YES_OPTION) {
							TimerThread.n=0;
							f.setVisible(false);
							team.f1.setVisible(true);
							for(int i=0;i<9;i++) {
								Content5_Frame.rd[i]=0;
							}
							return;
							
						}
						
						
					}
					panelArray[a-1].setBackground(Color.BLACK);
					countLabel.setText("맞춘갯수: "+count);
				}
			}
		}catch(Exception e) {return;}
	}
	
	class MyPanel2 extends JPanel{
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Random random=new Random();
			int a = random.nextInt(4);
				
			g.setColor(new Color(0,0,0));
				
			g.fillRect(0, 0, this.getWidth(),this.getHeight());
			}
			
			
		}

}
