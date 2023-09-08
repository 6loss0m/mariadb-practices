package bookmall.main;

import bookmall.dao.test.BookDaoTest;
import bookmall.dao.test.CartDaoTest;
import bookmall.dao.test.CategoryDaoTest;
import bookmall.dao.test.MemberDaoTest;
import bookmall.dao.test.OrdersDaoTest;

public class BookMall {
	public static String user = "bookmall";
	public static String password = "bookmall";
	public static String ip = "192.168.0.179";
	public static int port = 3307;
	public static String url = "jdbc:mariadb://" + ip + ":" + port + "/bookmall?charset=utf8";

	public static void main(String[] args) {
		
		System.out.println("## 회원리스트"); // 2명
		MemberDaoTest memberDaoTest = new MemberDaoTest();
		memberDaoTest.test();
		
		System.out.println("## 카테고리"); // 3개
		CategoryDaoTest categoryDaoTest = new CategoryDaoTest();
		categoryDaoTest.test();

		System.out.println("## 상품"); // 3개
		BookDaoTest bookDaoTest = new BookDaoTest();
		bookDaoTest.test();
		
		System.out.println("## 카트"); // 2개
		CartDaoTest cartDaoTest = new CartDaoTest();
		cartDaoTest.test();

		System.out.println("## 주문"); // 1개
		OrdersDaoTest ordersDaoTest = new OrdersDaoTest();
		ordersDaoTest.ordersTest();

		System.out.println("## 주문 도서"); // 2개
		ordersDaoTest.ordersBookTest();

	}

}
