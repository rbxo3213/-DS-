package ch20.prac;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionExampleByMyself {
	public static void main(String[] args) {
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "testuser","test1234");
			
			
		}
	}
}
