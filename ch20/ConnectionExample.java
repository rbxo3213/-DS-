package ch20;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionExample {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//JDBC Driver 등록 (드라이버 로드)
			Class.forName("oracle.jdbc.OracleDriver");
			
			// 연결하기 (Connection 객체 생성)
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521/xe",
					"testuser",
					"test1234"
					);
			System.out.println("연결성공");
			
			// PreparedStatement전에 Statement 형태로 먼저 해보기
			String userid = "winter3";
			String username = "한겨울";
			String userpassword = "12345";
			int userage = 25;
			String useremail = "winter@mycompany.com";
			
			// Statement
			/*
			Statement stmt = conn.createStatement();
			String sql = "INSERT INTO users (userid, username, userpassword, userage, useremail)";
			sql += " VALUES ('"+userid+"', '"+username+"', '"+userpassword+"', "+userage+", '"+useremail+"')";
			System.out.println(sql);
			
			int result = stmt.executeUpdate(sql); // int 를 리턴 (등록한 개수 리턴)
			if (result > 0) {
				System.out.println("등록 성공");
			} else System.out.println("등록 실패");
			*/
			
			// PreparedStatement
			String sql = "INSERT INTO users (userid, username, userpassword, userage, useremail) ";
			sql += " VALUES (?, ?, ?, ?, ?)"; // 따옴표 쌍따옴표 구분 안 해도 되서 일단 편리함
			pstmt = conn.prepareStatement(sql); // 미리 준비

			// ? 자리에 값을 대입
			pstmt.setString(1, userid);
			pstmt.setString(2, username);
			pstmt.setString(3, userpassword);
			pstmt.setInt(4, userage);
			pstmt.setString(5, useremail);
			
			int result = pstmt.executeUpdate(); // sql문 실행하면서 등록된 개수 리턴
			if(result>0) {
				System.out.println("등록 성공");
			} else System.out.println("등록 실패");
			
			// pstmt.close(); // 여기에 두면 실행하다 중간에 에러가 나면 close()가 실행이 안 되는 문제가 있다. 
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {pstmt.close();} catch (Exception e) {}
			if(conn != null) {
				try {
					//연결 끊기
					conn.close();
					System.out.println("연결 끊기");
				} catch(SQLException e) {}
			}
		}
	}
}
