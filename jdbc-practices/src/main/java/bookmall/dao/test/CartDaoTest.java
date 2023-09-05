package bookmall.dao.test;

import java.util.List;

import bookmall.dao.BookDao;
import bookmall.dao.CartDao;
import bookmall.dao.MemberDao;
import bookmall.vo.BookVo;
import bookmall.vo.CartVo;
import bookmall.vo.MemberVo;

public class CartDaoTest {
	public static void main(String[] args) {
		testFindByAll();
//
//		// member1이 book1을 3개 담음
//		CartVo vo1 = new CartVo();
//		vo1.setBook_no(5L);
//		vo1.setCount(3L);
//		vo1.setMembers_no(1L);
//
//		// member3이 book4를 2개 담음
//		CartVo vo2 = new CartVo();
//		vo2.setBook_no(5L);
//		vo2.setCount(2L);
//		vo2.setMembers_no(3L);
//
//		testFindByAll();
//
//		testInsert(vo1);
//		testInsert(vo2);
//
//		testFindByAll();

		testFindByMemberNo(1L);
		
		testFindByMemberName("홍길동");

	}

	private static void testFindByMemberNo(Long no) {
		List<CartVo> list = new CartDao().findByMemberNo(no);
		System.out.println("[" + new MemberDao().findByNo(no).getName() + "님의 장바구니 ]");
		for (CartVo vo : list) {
			BookVo book = new BookDao().findByNo(vo.getBook_no());
			System.out.println(
					book.getTitle() + " | " + vo.getCount() + "개 | " + (vo.getCount() * book.getPrice()) + "원");
		}
	}

	private static void testFindByMemberName(String name) {
		List<CartVo> list = new CartDao().findByMemberName(name);
		System.out.println("[" + name + "님의 장바구니 ]");
		for (CartVo vo : list) {
			BookVo book = new BookDao().findByNo(vo.getBook_no());
			System.out.println(
					book.getTitle() + " | " + vo.getCount() + "개 | " + (vo.getCount() * book.getPrice()) + "원");
		}
	}

	private static void testInsert(CartVo vo) {
		new CartDao().insert(vo);
	}

	private static void testFindByAll() {
		List<CartVo> list = new CartDao().findAll();
		System.out.println("\t[ 장 바 구 니 ]\t");
		for (CartVo vo : list) {
			BookVo book = new BookDao().findByNo(vo.getBook_no());
//			MemberVo member = new MemberDao().findByNo(vo.getMembers_no());
//			System.out.println("(주문자 : " + member.getName());
			System.out.println(
					book.getTitle() + " | " + vo.getCount() + "개 | " + (vo.getCount() * book.getPrice()) + "원");
		}
		System.out.println("-----------------------------------");
	}

}
