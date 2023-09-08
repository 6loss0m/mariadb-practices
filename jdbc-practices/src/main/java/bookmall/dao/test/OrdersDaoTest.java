package bookmall.dao.test;

import java.util.List;

import bookmall.dao.OrdersDao;
import bookmall.vo.OrdersBookVo;
import bookmall.vo.OrdersVo;
import bookmall.dao.BookDao;
import bookmall.dao.MemberDao;

public class OrdersDaoTest {
	public static void ordersTest() {
		
		MemberDao memberDao = new MemberDao();
		BookDao bookDao = new BookDao();
		OrdersVo vo1 = new OrdersVo();
		vo1.setDeliveryAddress("서울특별시 동작구 사당동");
		vo1.setMemberNo(1L);
		vo1.setPayment(bookDao.findByNo(1L).getPrice()*2 + bookDao.findByNo(2L).getPrice()*3);
		vo1.setEmail(memberDao.findByNo(1L).getEmail());
		vo1.setName(memberDao.findByNo(1L).getName());

//		OrdersVo vo2 = new OrdersVo();
//		vo2.setDeliveryAddress("서울특별시 서초구 역삼동");
//		vo2.setMemberNo(2L);
//		vo2.setPayment(bookDao.findByNo(1L).getPrice()*1 + bookDao.findByNo(2L).getPrice()*1);
//		vo2.setEmail(memberDao.findByNo(2L).getEmail());
//		vo2.setName(memberDao.findByNo(2L).getName());

		testInsertOrders(vo1);
//		testInsertOrders(vo2);

		testFindByAll();

//		testFindByMemberNo(1L);
//		testFindByOrderNo("1-20230907101046647");
		
		
	}
	public static void ordersBookTest() {
		testInsertOrderBook();
		testFindByAllOrderBook();
	}

	private static void testFindByOrderNo(String orderNo) {
		OrdersVo vo = new OrdersDao().findByOrdersNo(orderNo);
		System.out.println(vo);
	}

	private static void testFindByMemberNo(Long no) {
		List<OrdersVo> list = new OrdersDao().findByMemberNo(no);
		for (OrdersVo vo : list) {
			System.out.println(vo);
		}
	}

	private static boolean testInsertOrders(OrdersVo vo) {
		return new OrdersDao().insert(vo);
	}

	private static void testFindByAll() {
		List<OrdersVo> list = new OrdersDao().findByAll();
		for (OrdersVo vo : list) {
			System.out.println(vo);
		}
	}

	private static void testInsertOrderBook() {
		// ordersNo, bookNo, bookCount
		new OrdersDao().ordersBookInsert(1L, 1L, 2L);
		new OrdersDao().ordersBookInsert(1L, 2L, 3L);
	}
	private static void testFindByAllOrderBook() {
		List<OrdersBookVo> list = new OrdersDao().findByOrdersBook(1L);
		for(OrdersBookVo vo : list) {
			System.out.println(vo);
		}
	}
}
