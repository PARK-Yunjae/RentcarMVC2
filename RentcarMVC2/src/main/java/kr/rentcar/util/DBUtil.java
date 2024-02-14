package kr.rentcar.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBUtil {

	// 데이터 베이스 연결하기
	public static Connection getConnect() {
		String URL = "jdbc:mysql://localhost:3306/rentcarDB01?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
		String user = "root";
		String password = "Abcd123@";
		Connection conn= null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(URL, user, password);
		}catch (Exception e) {
			e.printStackTrace();		
		}
		return conn;
	}
	
	// 데이터 베이스 연결 끊기
	public static void dbClose(Connection conn, PreparedStatement ps, ResultSet rs) {
		try {
			if(rs != null) rs.close();
			if(ps != null) ps.close();
			if(conn != null) conn.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
