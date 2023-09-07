package bookmall.dao.test;

import java.util.List;

import bookmall.dao.OrdersDao;
import bookmall.vo.OrdersVo;
import bookmall.dao.MemberDao;

public class OrdersDaoTest {
	public static void main(String[] args) {
//		MemberDao dao = new MemberDao();
//		OrdersVo vo1 = new OrdersVo();
//		vo1.setDeliveryAddress("서울특별시 동작구 사당동");
//		vo1.setMemberNo(1L);
//		vo1.setPayment(85860L);
//		vo1.setEmail(dao.findByNo(1L).getEmail());
//		vo1.setName(dao.findByNo(1L).getName());
//
//		OrdersVo vo2 = new OrdersVo();
//		vo2.setDeliveryAddress("서울특별시 동작구 사당동");
//		vo2.setMemberNo(1L);
//		vo2.setPayment(85860L);
//		vo2.setEmail(dao.findByNo(1L).getEmail());
//		vo2.setName(dao.findByNo(1L).getName());
//
//		testInsertOrders(vo1);
//		testInsertOrders(vo2);

//		testFindByAll();

		testFindByMemberNo(1L);
		testFindByOrderNo("1-20230907101046647");
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
}
