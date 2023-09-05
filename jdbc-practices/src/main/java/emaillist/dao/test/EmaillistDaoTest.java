package emaillist.dao.test;

import java.util.List;

import emaillist.dao.EmaillistDao;
import emaillist.vo.EmaillistVo;

public class EmaillistDaoTest {

	public static void main(String[] args) {
		EmaillistVo vo = new EmaillistVo();
		vo.setFirstName("홍");
		vo.setLastName("길동");
		vo.setEmail("hong@gmail.com");
		
		testInsert(vo);
		testFindAll();
		testDeleteByEmail("hong@gmail.com");
		testFindAll();
	}

	private static void testDeleteByEmail(String email) {
		boolean result = new EmaillistDao().deleteByEmail(email);
		System.out.println((result == true) ? "성공" : "실패");
	}

	private static void testFindAll() {
		List<EmaillistVo> list = new EmaillistDao().findAll();
		for(EmaillistVo vo : list) {
			System.out.println(vo);
		}
	}

	private static void testInsert(EmaillistVo vo) {
		boolean result = new EmaillistDao().insert(vo);
		System.out.println((result == true) ? "성공" : "실패");
	}

}
