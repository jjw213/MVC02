package com.globalin.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBManager {

	private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String USER = "spring";
	private static final String PASSWORD = "1234";

	public static Connection getConnection() throws ClassNotFoundException, SQLException {

//	      1.����̹� �ε�
//	      2.����̹��� ���� ��ü ��ȯ
		Class.forName("oracle.jdbc.driver.OracleDriver");
		return DriverManager.getConnection(URL, USER, PASSWORD);

	}

	// �츮�� ���� finally��Ͽ��� ó������� close�޼ҵ带 ������ݴϴ�
	//
	public static void close(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void close(PreparedStatement pstmt, Connection conn) {
		try {
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
