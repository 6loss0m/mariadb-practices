package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertTest02 {
	public static void main(String[] args) {
		boolean result = insertDepartment("QA팀");
		System.out.println(result ? "성공" : "실패");
	}

	private static boolean insertDepartment(String name) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			// 1. JDBC Driver Class 로딩
			Class.forName("org.mariadb.jdbc.Driver");

			// 2. 연결하기
			String database = "webdb";
			String user = "webdb";
			String password = "webdb";
			String url = "jdbc:mariadb://192.168.0.179:3307/" + database + "?charset=utf8";
			conn = DriverManager.getConnection(url, user, password);

			// 3. SQL 준비 (값이 binding 될 수 있도록)
 			String sql = "insert into dept values(null, ?)";
			pstmt = conn.prepareStatement(sql);

			// 4. 값 binding
			pstmt.setString(1, name);
			
			// 5. SQL 실행
			// sql 준비하고 값 넣고, sql을 실행해야함.
			int count = pstmt.executeUpdate();

			// 6. 결과 처리
			result = count == 1;
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패 : " + e);
		} catch (SQLException e) {
			System.out.println("error : " + e);
		} finally {
			try {
				// 7. 자원정리
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
