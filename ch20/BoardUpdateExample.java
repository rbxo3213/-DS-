package ch20;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class BoardUpdateExample {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//JDBC Driver 등록
			Class.forName("oracle.jdbc.OracleDriver");
			
			conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521/xe",
				"testuser",
				"test1234");
			
			// 매개변수화된 SQL문 작성
			String sql = new StringBuilder()
					.append("UPDATE boards SET ")
					.append("btitle=?, ")
					.append("bcontent=?, ")
					.append("bfilename=?, ")
					.append("bfiledata=? ")
					.append("WHERE bno=?")
					.toString();
			
			//PreparedStatement 얻기 및 값 지정
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  "눈사람");
			pstmt.setString(2, "눈으로 만든 사람");
			pstmt.setString(3, "snowman.jpg");
			pstmt.setBlob(4, BoardUpdateExample.class.getResourceAsStream("snowman.jpg"));
			pstmt.setInt(5,1);
			
			// SQL문 실행
			int rows = pstmt.executeUpdate();
			System.out.println("수정된 행 수 : "+rows);
			
			// PreparedStatement닫기
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
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
