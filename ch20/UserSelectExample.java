package ch20;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserSelectExample {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			//JDBC Driver 등록
			Class.forName("oracle.jdbc.OracleDriver");
			
			conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521/xe",
				"testuser",
				"test1234");
			
			// 매개변수화된 SQL문 작성
			String sql = ""+
			"SELECT userid, username, userpassword, userage, useremail " +
			"FROM users " +
			"WHERE userid=?";
			
			//PreparedStatement 얻기 및 값 지정
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "winter");
			
			// SQL문 실행
			rs = pstmt.executeQuery();
			if(rs.next()) {
				User user = new User();
				user.setUserId(rs.getString("userid"));
				user.setUserName(rs.getString("username"));
				user.setUserPassword(rs.getString("userpassword"));
				user.setUserAge(rs.getInt(4));
				user.setUserEmail(rs.getString(5));
				System.out.println(user);
			} else {
				System.out.println("사용자 아이디가 존재하지 않음.");
			}
			
			// PreparedStatement닫기
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {rs.close();} catch(Exception e) {}
			try {pstmt.close();} catch(Exception e) {}
			if(conn!=null) {
				try {
					//연결 끊기
					conn.close();
					
				} catch (SQLException e) {}
			}
		}
	}
}
