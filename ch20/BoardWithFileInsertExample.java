package ch20;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BoardWithFileInsertExample {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// 1. JDBC Driver 등록 (드라이버 로드)
			Class.forName("oracle.jdbc.OracleDriver");
			
			// 2. 연결하기 (Connection 객체 생성)
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
			
			// 3. Statement/PreparedStatement 객체 생성
			
			// Statement : 그냥 있는 그대로 실행
			
			/* Statement 예시
			Statement stmt = conn.createStatement();
			String sql = "INSERT INTO users (userid, username, userpassword, userage, useremail)";
			sql += " VALUES ('"+userid+"', '"+username+"', '"+userpassword+"', "+userage+", '"+useremail+"')";
			System.out.println(sql);
			
			int result = stmt.executeUpdate(sql); // int 를 리턴 (등록한 개수 리턴)
			if (result > 0) {
				System.out.println("등록 성공");
			} else System.out.println("등록 실패");
			*/
			
			// PreparedStatement : 먼저 준비시키고 나중에 실행
			String sql = "INSERT INTO boards (bno, btitle, bcontent, bwriter, bdate, bfilename, bfiledata) ";
			sql += " VALUES (SEQ_BNO.NEXTVAL, ?, ?, ?, SYSDATE, ?, ?)"; // 따옴표 쌍따옴표 구분 안 해도 되서 일단 편리함
			pstmt = conn.prepareStatement(sql, new String[] {"bno"}); // 미리 준비
			// ? 자리에 값을 대입
			
			pstmt.setString(1, "눈 오는 날3");
			pstmt.setString(2, "함박눈이 내려요");
			pstmt.setString(3, "winter");
			pstmt.setString(4, "snow.jpg");
			pstmt.setBlob(5, BoardWithFileInsertExample.class.getResourceAsStream("snow.jpg"));
			
			// 4. sql 실행
			int rows = pstmt.executeUpdate(); // 등록된 개수 리턴
			System.out.println("저장된 행 수: "+rows);
			
			// bno 값 얻기
			if(rows==1) {
				rs = pstmt.getGeneratedKeys();
				if(rs.next()) { // rs.next()에서 한 칸 움직임
					int bno = rs.getInt(1); // 맨 앞에 있는 것 : 1
					System.out.println("저장된 bno"+bno);
					
				}
				
			}
		
			
			// pstmt.close(); // 여기에 두면 실행하다 중간에 에러가 나면 close()가 실행이 안 되는 문제가 있다. 
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {rs.close();} catch(Exception e) {}
			// 5. 자원 해제
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
