package bookmall.dao.test;

import java.util.List;

import bookmall.dao.MemberDao;
import bookmall.vo.MemberVo;

public class MemberDaoTest {
	public static void main(String[] args) {
		testFindByAll();

		MemberVo memVo1 = new MemberVo();
		memVo1.setId("aaa321");
		memVo1.setPassword("123");
		memVo1.setName("둘리");
		memVo1.setEmail("a@naver.com");
		memVo1.setPhone("1234-5678-0000");

		MemberVo memVo2 = new MemberVo();
		memVo2.setId("b111");
		memVo2.setPassword("123");
		memVo2.setName("또치");
		memVo2.setEmail("b111@naver.com");
		memVo2.setPhone("4321-1233-9999");
		
		testInsert(memVo1);
		testInsert(memVo2);

		testFindByAll();
		
		String id = "aaa321";
		testFindById(id);

		String name = "또치";
		testFindByName(name);

		testDeleteById(id);

		testFindByAll();
		
		testDeleteByName(name);
		
		testFindByAll();
	}

	private static void testFindByAll() {
		List<MemberVo> list = new MemberDao().findAll();
		for (MemberVo vo : list) {
			System.out.println("[" + vo.getNo() + "] " + vo.getName() + "(" + vo.getId() + ") phone : " + vo.getPhone()
					+ ", email : " + vo.getEmail() + ", password : " + vo.getPassword());
		}
		System.out.println("-------------------------------");
	}

	private static boolean testDeleteByName(String name) {
		boolean result = false;
		result = new MemberDao().deleteByName(name);
		return result;

	}

	private static boolean testDeleteById(String id) {
		boolean result = false;
		result = new MemberDao().deleteById(id);
		return result;
	}

	private static void testFindByName(String name) {
		List<MemberVo> list = new MemberDao().findByName(name);
		for (MemberVo vo : list) {
			System.out.println("[" + vo.getNo() + "] " + vo.getName() + "(" + vo.getId() + ") phone : " + vo.getPhone()
					+ ", email : " + vo.getEmail() + ", password : " + vo.getPassword());
		}
		System.out.println("-------------------------------");
	}

	private static void testFindById(String id) {
		List<MemberVo> list = new MemberDao().findById(id);
		for (MemberVo vo : list) {
			System.out.println("[" + vo.getNo() + "] " + vo.getName() + "(" + vo.getId() + ") phone : " + vo.getPhone()
					+ ", email : " + vo.getEmail() + ", password : " + vo.getPassword());
		}
		System.out.println("-------------------------------");
	}

	private static boolean testInsert(MemberVo vo) {
		boolean result = false;
		result = new MemberDao().insert(vo);
		return result;
	}
}
