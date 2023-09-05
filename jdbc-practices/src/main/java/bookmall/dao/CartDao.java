package bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookmall.main.BookMall;
import bookmall.vo.CartVo;
import bookmall.vo.MemberVo;

public class CartDao {
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

	public List<CartVo> findAll() {
		List<CartVo> result = new ArrayList<CartVo>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			conn = getConnection();

			// 3. SQL 준비
			String query = "select no, members_no, book_no, count, price from cart order by members_no";
			pstmt = conn.prepareStatement(query);

			// 4. binding

			// 5. SQL 실행
			rs = pstmt.executeQuery();

			// 6. 결과 처리
			while (rs.next()) {
				Long no = rs.getLong(1);
				Long members_no = rs.getLong(2);
				Long book_no = rs.getLong(3);
				Long count = rs.getLong(4);
				Long price = rs.getLong(5);

				CartVo vo = new CartVo();
				vo.setNo(no);
				vo.setMembers_no(members_no);
				vo.setBook_no(book_no);
				vo.setCount(count);
				vo.setPrice(price);

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

	public boolean insert(CartVo vo) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {

			conn = getConnection();

			// 3. SQL 준비 (값이 binding 될 수 있도록)
			String sql = "insert into cart values (null, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);

			// 4. 값 binding
			pstmt.setLong(1, vo.getCount());
			pstmt.setLong(2, new BookDao().findByNo(vo.getBook_no()).getPrice() * vo.getCount());
			pstmt.setLong(3, vo.getBook_no());
			pstmt.setLong(4, vo.getMembers_no());

			// 5. SQL 실행
			// sql 준비하고 값 넣고, sql을 실행해야함.
			int count = pstmt.executeUpdate();

			// 6. 결과 처리
			result = count == 1;
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

	public List<CartVo> findByMemberNo(Long no) {
		List<CartVo> result = new ArrayList<CartVo>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			conn = getConnection();

			// 3. SQL 준비
			String query = "select book_no, count, price from cart where members_no = ?";
			pstmt = conn.prepareStatement(query);

			// 4. binding
			pstmt.setLong(1, no);

			// 5. SQL 실행
			rs = pstmt.executeQuery();

			// 6. 결과 처리
			while (rs.next()) {
				Long book_no = rs.getLong(1);
				Long count = rs.getLong(2);
				Long price = rs.getLong(3);

				CartVo vo = new CartVo();
				vo.setBook_no(book_no);
				vo.setCount(count);
				vo.setMembers_no(no);
				vo.setPrice(price);

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
	
	public List<CartVo> findByMemberName(String name) {
		List<CartVo> result = new ArrayList<CartVo>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			conn = getConnection();

			// 3. SQL 준비
			String query = "select c.members_no, c.book_no, c.count, c.price "
					+ " from cart c, members m "
					+ " where c.members_no = m.no"
					+ " and m.name = ?";
			pstmt = conn.prepareStatement(query);

			// 4. binding
			pstmt.setString(1, name);

			// 5. SQL 실행
			rs = pstmt.executeQuery();

			// 6. 결과 처리
			while (rs.next()) {
				Long no = rs.getLong(1);
				Long book_no = rs.getLong(2);
				Long count = rs.getLong(2);
				Long price = rs.getLong(3);

				CartVo vo = new CartVo();
				vo.setBook_no(book_no);
				vo.setCount(count);
				vo.setMembers_no(no);
				vo.setPrice(price);

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

}
