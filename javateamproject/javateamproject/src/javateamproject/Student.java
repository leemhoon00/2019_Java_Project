package javateamproject;

import java.sql.*;

public class Student {
	String ID;
	String password;
	double score1;
	double score2;
	double score3;
	double score4;
	
	public Student(String ID) {
		this.ID=ID; 
		
		BasicData.setDataBase(ID,this);
	}
	void setID(String id){ this.ID=ID;}
	void setScore1(double score) {score1=score;}
	void setScore2(double score) {score2=score;}
	void setScore3(double score) {score3=score;}
	void setScore4(double score) {score4=score;}

}
