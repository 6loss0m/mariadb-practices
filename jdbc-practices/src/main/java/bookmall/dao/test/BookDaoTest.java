package bookmall.dao.test;

import java.util.List;

import bookmall.dao.BookDao;
import bookmall.vo.BookVo;

public class BookDaoTest {
	public static void test() {
		
		BookVo bookVo1 = new BookVo();
		bookVo1.setTitle("오펜하이머");
		bookVo1.setCategory_no(3L);
		bookVo1.setPrice(15800L);

		BookVo bookVo2 = new BookVo();
		bookVo2.setTitle("도둑맞은 집중력");
		bookVo2.setCategory_no(1L);
		bookVo2.setPrice(16920L);
		
		BookVo bookVo3 = new BookVo();
		bookVo3.setTitle("말하기 수업");
		bookVo3.setCategory_no(2L);
		bookVo3.setPrice(15120L);

		
		insertTest(bookVo1);
		insertTest(bookVo2);
		insertTest(bookVo3);

		findAllTest();
//
//		String title = "오펜하이머";
//
//		findByNo(1L);
//		
//		findByTitle(title);
//		
//		result = deleteByTitleTest(title);
//		System.out.print((result == true) ? "성공" : "실패");
//		findAllTest();

	}

	private static void findAllTest() {
		List<BookVo> list = new BookDao().findAll();
		for (BookVo vo : list) {
			System.out.println(vo);
		}
	}
	
	private static void findByNo(Long no) {
		BookVo result = new BookDao().findByNo(no);
		System.out.println("[" + result.getBook_no() + "] 제목 : " + result.getTitle() + ", 가격 : " + result.getPrice());
	}
	
	private static void findByTitle(String title) {
		List<BookVo> list = new BookDao().findByTitle(title);
		for (BookVo vo : list) {
			System.out.println("[" + vo.getBook_no() + "] 제목 : " + vo.getTitle() + ", 가격 : " + vo.getPrice());
		}
	}

	private static boolean insertTest(BookVo vo) {
		boolean result = false;
		result = new BookDao().insert(vo);

		return result;
	}
	
	private static boolean deleteByTitleTest(String title) {
		boolean result = false;
		result = new BookDao().deleteByTitle(title);

		return result;
	}
}
