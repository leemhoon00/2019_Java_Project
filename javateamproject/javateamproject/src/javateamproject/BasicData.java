package javateamproject;
import java.sql.*;

public class BasicData {
	public static Connection con=null;
	
	public BasicData() {
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String id="team";
		String password="team";
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("����̹� ���� ����");
			con=DriverManager.getConnection(url,id,password);
			System.out.println("�����ͺ��̽� ���� ����");
		}catch (ClassNotFoundException e) {
			System.out.println("����̹��� ã�� �� �����ϴ�.");
		}catch(SQLException e) {
			System.out.println("���ῡ �����Ͽ����ϴ�.");
		}
		
	}
	
	
	
	public static void setDataBase(String ID,Student s) {
		String query="select �ܾ����� from gamer where ���̵�='"+ID+"'";
		try {
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			if(rs.next()) {
				s.score1=rs.getDouble(1);
				query="select ª�������� from gamer where ���̵�='"+ID+"'";
				rs=stmt.executeQuery(query);
				rs.next();
				s.score2=rs.getDouble(1);
				query="select ������� from gamer where ���̵�='"+ID+"'";
				rs=stmt.executeQuery(query);
				rs.next();
				s.score3=rs.getDouble(1);
				query="select �δ������� from gamer where ���̵�='"+ID+"'";
				rs=stmt.executeQuery(query);
				rs.next();
				s.score4=rs.getDouble(1);
			}
			
		}catch(SQLException e) {e.printStackTrace();}
		
	}

	

}