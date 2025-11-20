package ch20;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class FunctionCallExample {
	public static void main(String[] args) {
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe","testuser","test1234");
			
			String sql = "{? = call user_login(?,?)}";
			CallableStatement cstmt = conn.prepareCall(sql);
			
			//? 값 지정 및 리턴 타입 저장
			cstmt.registerOutParameter(1,  Types.INTEGER);
			cstmt.setString(2,"winter");
			cstmt.setString(3, "12345");
			
			// 함수 실행 및 리턴값 얻기
			cstmt.execute();
			int result = cstmt.getInt(1);
			
			// CallableStatement 닫기
			cstmt.close();
			
			// 로그인 결과(Switch Expressions 이용)
			String message = switch(result) {
			case 0 -> "로그인 성공"; // case->화살표는 break문을 함께 쓰는것과 같음.
			case 1 -> "비밀번호가 틀림";
			default -> "아이디가 존재하지 않음";
			};
			System.out.println(message);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(conn!=null) {
				try {
					//연결 끊기
					conn.close();
				} catch(SQLException e) {}
			}
		}
	}
}
