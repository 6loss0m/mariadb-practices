package bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookmall.main.BookMall;
import bookmall.vo.CategoryVo;

public class CategoryDao {

	public List<CategoryVo> findByNo(int no) {
		List<CategoryVo> result = new ArrayList<CategoryVo>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();

			// 3. SQL 준비
			String query = "select * from category where no = ?";
			pstmt = conn.prepareStatement(query);

			// 4. binding
			pstmt.setInt(1, no);

			// 5. SQL 실행
			rs = pstmt.executeQuery();

			// 6. 결과 처리
			while (rs.next()) {
				CategoryVo vo = new CategoryVo();
				int category_no = rs.getInt(1);
				String category_name = rs.getString(2);
				vo.setNo(category_no);
				vo.setName(category_name);

				result.add(vo);
			}

		}catch (SQLException e) {
			System.out.println("error : " + e);
		} finally {
			try {
				// 7. 자원정리
				if (rs != null) {
					rs.close();
				}
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

	public List<CategoryVo> findByTitle(String title) {
		List<CategoryVo> result = new ArrayList<CategoryVo>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();

			// 3. SQL 준비
			String query = "select * from category where name = ?";
			pstmt = conn.prepareStatement(query);

			// 4. binding
			pstmt.setString(1, title);

			// 5. SQL 실행
			rs = pstmt.executeQuery();

			// 6. 결과 처리
			while (rs.next()) {
				CategoryVo vo = new CategoryVo();
				int category_no = rs.getInt(1);
				String category_name = rs.getString(2);
				vo.setNo(category_no);
				vo.setName(category_name);

				result.add(vo);
			}

		}catch (SQLException e) {
			System.out.println("error : " + e);
		} finally {
			try {
				// 7. 자원정리
				if (rs != null) {
					rs.close();
				}
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

	public boolean insertCategory(String name) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();

			// 3. SQL 준비 (값이 binding 될 수 있도록)
			String sql = "insert into category values(null, ?)";
			pstmt = conn.prepareStatement(sql);

			// 4. 값 binding
			pstmt.setString(1, name);

			// 5. SQL 실행
			// sql 준비하고 값 넣고, sql을 실행해야함.
			int count = pstmt.executeUpdate();

			// 6. 결과 처리
			result = count == 1;
		}catch (SQLException e) {
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

	public List<CategoryVo> findByAll() {
		List<CategoryVo> result = new ArrayList<CategoryVo>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			
			// 3. SQL 준비
			String query = "select * from category";
			pstmt = conn.prepareStatement(query);

			// 4. binding

			// 5. SQL 실행
			rs = pstmt.executeQuery();

			// 6. 결과 처리
			while (rs.next()) {
				CategoryVo vo = new CategoryVo();
				int category_no = rs.getInt(1);
				String category_name = rs.getString(2);
				vo.setNo(category_no);
				vo.setName(category_name);

				result.add(vo);
			}

		} catch (SQLException e) {
			System.out.println("error : " + e);
		} finally {
			try {
				// 7. 자원정리
				if (rs != null) {
					rs.close();
				}
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
	
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			// 1. JDBC Driver Class 로딩
			Class.forName("org.mariadb.jdbc.Driver");

			// 2. 연결하기
			conn = DriverManager.getConnection(BookMall.url, BookMall.user, BookMall.password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public boolean deleteByNo(Long no) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			
			conn = getConnection();

			String sql = "delete from category where no = ?";
			pstmt = conn.prepareStatement(sql);

			// 4. 값 binding
			pstmt.setLong(1, no);

			// 5. SQL 실행
			// sql 준비하고 값 넣고, sql을 실행해야함.
			int count = pstmt.executeUpdate();

			// 6. 결과 처리
			result = count >= 1;
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

	public boolean deleteByName(String title) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			
			conn = getConnection();

			String sql = "delete from category where title = ?";
			pstmt = conn.prepareStatement(sql);

			// 4. 값 binding
			pstmt.setString(1, title);

			// 5. SQL 실행
			// sql 준비하고 값 넣고, sql을 실행해야함.
			int count = pstmt.executeUpdate();

			// 6. 결과 처리
			result = count >= 1;
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
