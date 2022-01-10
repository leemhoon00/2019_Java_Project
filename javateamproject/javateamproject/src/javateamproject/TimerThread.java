package javateamproject;

import java.awt.*;
import java.sql.*;
import javax.swing.*;

public class TimerThread extends Thread {
	public JLabel timerLabel;
	public static double n;
	
	public TimerThread(JLabel timerLabel) {
		this.timerLabel=timerLabel;
	}
	
	@Override
	public void run() {
		n=0;
		while(true) {
			
			timerLabel.setText(String.format("%.1f", n));
			n+=0.1;
			try {
				Thread.sleep(100);
			}
			catch(InterruptedException e) {
				return;
			}
		}
	}

}
