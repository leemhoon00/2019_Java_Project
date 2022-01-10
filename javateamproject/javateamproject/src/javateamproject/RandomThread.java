package javateamproject;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.util.Random;

public class RandomThread extends Thread {
	String[] array;
	JLabel[] labelArray;
	public RandomThread(String[] array,JLabel[] labelArray) {
		this.array=array;
		this.labelArray=labelArray;
	}
	public void run() {
		Random random= new Random();
		while(true) {
			int a= random.nextInt(9);
			int b= random.nextInt(23);
			labelArray[random.nextInt(9)].setText("");
			labelArray[random.nextInt(9)].setText("");
			labelArray[random.nextInt(9)].setText("");
			labelArray[a].setText(array[b]);
			try {
				sleep(1000);
			}catch(Exception e) {
				return;
			}
		}
		
	}

}
