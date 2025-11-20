package ch20;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class BoardSelectExample {
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
			"SELECT bno, btitle, bcontent, bwriter, bdate, bfilename, bfiledata "+
			"FROM boards "+
			"WHERE bwriter=?";
			
			//PreparedStatement 얻기 및 값 지정
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "winter");
			
			// SQL문 실행
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Board board = new Board();
				board.setBno(rs.getInt("bno"));
				board.setBtitle(rs.getString("btitle"));
				board.setBcontent(rs.getString("bcontent"));
				board.setBwriter(rs.getString("bwriter"));
				board.setBdate(rs.getDate("bdate"));
				board.setBfilename(rs.getString("bfilename"));
				board.setBfiledata(rs.getBlob("bfiledata"));
				
				System.out.println(board);
				
				Blob blob = board.getBfiledata();
				if(blob != null) {
					InputStream is = blob.getBinaryStream();
					OutputStream os = new FileOutputStream("C:\\Temp\\"+
					board.getBfilename());
					is.transferTo(os);
					os.flush();
					os.close();
					is.close();
				}
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
