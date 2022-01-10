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
			System.out.println("드라이버 적재 성공");
			con=DriverManager.getConnection(url,id,password);
			System.out.println("데이터베이스 연결 성공");
		}catch (ClassNotFoundException e) {
			System.out.println("드라이버를 찾을 수 없습니다.");
		}catch(SQLException e) {
			System.out.println("연결에 실패하였습니다.");
		}
		
	}
	
	
	
	public static void setDataBase(String ID,Student s) {
		String query="select 단어점수 from gamer where 아이디='"+ID+"'";
		try {
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			if(rs.next()) {
				s.score1=rs.getDouble(1);
				query="select 짧은글점수 from gamer where 아이디='"+ID+"'";
				rs=stmt.executeQuery(query);
				rs.next();
				s.score2=rs.getDouble(1);
				query="select 긴글점수 from gamer where 아이디='"+ID+"'";
				rs=stmt.executeQuery(query);
				rs.next();
				s.score3=rs.getDouble(1);
				query="select 두더지점수 from gamer where 아이디='"+ID+"'";
				rs=stmt.executeQuery(query);
				rs.next();
				s.score4=rs.getDouble(1);
			}
			
		}catch(SQLException e) {e.printStackTrace();}
		
	}

	

}