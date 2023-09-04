package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateTest01 {
	
	public static void main(String[] args) {
		DeptVo vo = new DeptVo();
		vo.setNo(2L);
		vo.setName("전략기획팀");
		
		boolean result = updateDepartment(vo);
		System.out.println(result ? "성공" : "실패");
	}

	private static boolean updateDepartment(DeptVo vo) {
		boolean result = false;
		Connection conn = null;
		Statement stmt = null;
		try {
			// 1. JDBC Driver Class 로딩
			Class.forName("org.mariadb.jdbc.Driver");

			// 2. 연결하기
			String database = "webdb";
			String user = "webdb";
			String password = "webdb";
			String url = "jdbc:mariadb://192.168.0.179:3307/" + database + "?charset=utf8";
			conn = DriverManager.getConnection(url, user, password);

			// 3. Statement 객체 생성
			stmt = conn.createStatement();

			// 4. SQL 실행
			// jdbc에 넣는 쿼리는 무조건 ; 뺴기 !
			String query = "update dept set name = '" + vo.getName() + "' where no = " + vo.getNo();

			// 입력, 수정, 삭제는 executeUpdate
			int count = stmt.executeUpdate(query); // insert된 개수 return

			// 5. 결과 처리
			result = count == 1;
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패 : " + e);
		} catch (SQLException e) {
			System.out.println("error : " + e);
		} finally {
			try {
				// 6. 자원정리
				if (stmt != null) {
					stmt.close();
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
