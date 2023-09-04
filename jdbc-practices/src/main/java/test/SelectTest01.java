package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectTest01 {
	public static void main(String[] args) {
		searchEmployees("ko");
	}

	public static void searchEmployees(String keyword) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// 1. JDBC Driver Class 로딩
			Class.forName("org.mariadb.jdbc.Driver");

			// 2. 연결하기
			String database = "employees";
			String user = "hr";
			String password = "hr";
			String url = "jdbc:mariadb://192.168.0.179:3307/" + database + "?charset=utf8";
			conn = DriverManager.getConnection(url, user, password);

			// 3. Statement 객체 생성
			stmt = conn.createStatement();

			// 4. SQL 실행
			// jdbc에 넣는 쿼리는 무조건 ; 뺴기 !
			String query = "select emp_no, first_name, last_name" + "	from employees" + "	where first_name like '%"
					+ keyword + "%'\r\n" + "	and last_name like'%" + keyword + "\'";

			// 입력, 수정, 삭제는 executeUpdate
			rs = stmt.executeQuery(query);

			// 5. 결과 처리
			while (rs.next()) {
				Long empNo = rs.getLong(1);
				String firstName = rs.getString(2);
				String lastName = rs.getString(3);
				System.out.println(empNo + " : " + firstName + " " + lastName);
			}

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패 : " + e);
		} catch (SQLException e) {
			System.out.println("error : " + e);
		} finally {
			try {
				// 6. 자원정리
				if(rs != null) {
					rs.close();
				}
				if(stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
