package bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import bookmall.main.BookMall;
import bookmall.vo.BookVo;
import bookmall.vo.OrdersBookVo;
import bookmall.vo.OrdersVo;

public class OrdersDao {
	public List<OrdersVo> findByAll() {
		List<OrdersVo> result = new ArrayList<OrdersVo>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			conn = getConnection();

			// 3. SQL 준비
			String query = "select no, order_manage_no, name, email, dilivery_address, payment, member_no from orders order by member_no";
			pstmt = conn.prepareStatement(query);

			// 4. binding

			// 5. SQL 실행
			rs = pstmt.executeQuery();

			// 6. 결과 처리
			while (rs.next()) {
				Long no = rs.getLong(1);
				String order_manage_no = rs.getString(2);
				String name = rs.getString(3);
				String email = rs.getString(4);
				String dilivery_address = rs.getString(5);
				Long payment = rs.getLong(6);
				Long member_no = rs.getLong(7);

				OrdersVo vo = new OrdersVo();
				vo.setNo(no);
				vo.setMemberNo(member_no);
				vo.setOrderManageNo(order_manage_no);
				vo.setName(name);
				vo.setEmail(email);
				vo.setDeliveryAddress(dilivery_address);
				vo.setPayment(payment);

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

	public boolean insert(OrdersVo vo) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {

			conn = getConnection();

			// 3. SQL 준비 (값이 binding 될 수 있도록)
			String sql = "insert into orders values (null, ?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);

			// 4. 값 binding
			pstmt.setString(1, orderNoGenerator(vo.getMemberNo()));
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getEmail());
			pstmt.setString(4, vo.getDeliveryAddress());
			pstmt.setLong(5, vo.getPayment());
			pstmt.setLong(6, vo.getMemberNo());

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

	public boolean ordersBookInsert(Long ordersNo, Long bookNo, Long bookCount) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {

			conn = getConnection();

			// 3. SQL 준비 (값이 binding 될 수 있도록)
			String sql = "insert into orders_book values (null, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);

			BookVo book = new BookDao().findByNo(bookNo);

			String title = book.getTitle();
			Long price = book.getPrice();

			// 4. 값 binding
			pstmt.setString(1, title);
			pstmt.setLong(2, bookCount);
			pstmt.setLong(3, bookCount * price);
			pstmt.setLong(4, ordersNo);
			pstmt.setLong(5, bookNo);

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

	public List<OrdersVo> findByMemberNo(Long member_no) {
		List<OrdersVo> result = new ArrayList<OrdersVo>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			conn = getConnection();

			// 3. SQL 준비
			String query = "select no, order_manage_no, name, email, dilivery_address, payment from orders where member_no = ? order by order_manage_no";
			pstmt = conn.prepareStatement(query);

			// 4. binding
			pstmt.setLong(1, member_no);

			// 5. SQL 실행
			rs = pstmt.executeQuery();

			// 6. 결과 처리
			while (rs.next()) {
				Long no = rs.getLong(1);
				String order_manage_no = rs.getString(2);
				String name = rs.getString(3);
				String email = rs.getString(4);
				String dilivery_address = rs.getString(5);
				Long payment = rs.getLong(6);

				OrdersVo vo = new OrdersVo();
				vo.setNo(no);
				vo.setMemberNo(member_no);
				vo.setOrderManageNo(order_manage_no);
				vo.setName(name);
				vo.setEmail(email);
				vo.setDeliveryAddress(dilivery_address);
				vo.setPayment(payment);

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

	public OrdersVo findByOrdersNo(String orderNo) {
		OrdersVo result = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			conn = getConnection();

			// 3. SQL 준비
			String query = "select no, name, email, dilivery_address, payment, member_no from orders where order_manage_no = ?";
			pstmt = conn.prepareStatement(query);

			// 4. binding
			pstmt.setString(1, orderNo);

			// 5. SQL 실행
			rs = pstmt.executeQuery();

			// 6. 결과 처리
			while (rs.next()) {
				Long no = rs.getLong(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				String dilivery_address = rs.getString(4);
				Long payment = rs.getLong(5);
				Long member_no = rs.getLong(6);

				OrdersVo vo = new OrdersVo();
				vo.setNo(no);
				vo.setMemberNo(member_no);
				vo.setOrderManageNo(orderNo);
				vo.setName(name);
				vo.setEmail(email);
				vo.setDeliveryAddress(dilivery_address);
				vo.setPayment(payment);

				result = vo;
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

	public List<OrdersBookVo> findByOrdersBook(Long ordersNo) {
		List<OrdersBookVo> result = new ArrayList<OrdersBookVo>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			conn = getConnection();
			// 도서번호, 도서제목 ,수량
			// 3. SQL 준비
			String query = "select ob.no, ob.title, ob.count, ob.total_price, ob.book_no "
					+ " from orders o, orders_book ob"
					+ " where o.no = ob.orders_no"
					+ " and o.member_no = (select order_manage_no"
					+ "						from orders"
					+ "						where member_no = ?)";
			pstmt = conn.prepareStatement(query);

			// 4. binding
			pstmt.setLong(1, ordersNo);

			// 5. SQL 실행
			rs = pstmt.executeQuery();

			// 6. 결과 처리
			while (rs.next()) {
				Long no = rs.getLong(1);
				String title = rs.getString(2);
				Long count = rs.getLong(3);
				Long total_price = rs.getLong(4);
				Long book_no = rs.getLong(5);
				
				OrdersBookVo vo = new OrdersBookVo();
				vo.setNo(no);
				vo.setTitle(title);
				vo.setCount(count);
				vo.setBookNo(book_no);
				vo.setTotalPriece(total_price);
				
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

	// OrderNo 생성 함수 (멤버고유식별번호-연도월일시분초밀리초)
	private String orderNoGenerator(Long memberNo) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddhhmmssSSS");
		String timeData = formatter.format(new Date());

		return memberNo + "-" + timeData;
	}

	private Long getOrdersNoByManageNo(String manage_no) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			conn = getConnection();

			// 3. SQL 준비
			String query = "select no from orders where order_manage_no = ?";
			pstmt = conn.prepareStatement(query);

			// 4. binding
			pstmt.setString(1, manage_no);

			// 5. SQL 실행
			rs = pstmt.executeQuery();

			// 6. 결과 처리
			Long no = rs.getLong(1);
			System.out.println(no);
			return no;
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
		return null;
	}
}
