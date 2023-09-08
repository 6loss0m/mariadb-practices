package bookmall.dao.test;

import java.util.List;

import bookmall.dao.MemberDao;
import bookmall.vo.MemberVo;

public class MemberDaoTest {
	
	public static void test(){

		MemberVo memberVo1 = new MemberVo();
		memberVo1.setId("dolydoly");
		memberVo1.setPassword("doly123");
		memberVo1.setName("둘리");
		memberVo1.setEmail("doly@gmail.com");
		memberVo1.setPhone("010-1357-2345");
		
		MemberVo memberVo2 = new MemberVo();
		memberVo2.setId("toto");
		memberVo2.setPassword("to0101");
		memberVo2.setName("또치");
		memberVo2.setEmail("ttochi@gmail.com");
		memberVo2.setPhone("010-6543-2109");
		
		testInsert(memberVo1);
		testInsert(memberVo2);
		
		testFindByAll();

//		String id = "aaa321";
//		testFindById(id);
//
//		String name = "또치";
//		testFindByName(name);
//
//		testDeleteById(id);
//
//		testFindByAll();
//		
//		testDeleteByName(name);
//		
//		testFindByAll();
	}

	private static void testFindByAll() {
		List<MemberVo> list = new MemberDao().findAll();
		for (MemberVo vo : list) {
			System.out.println(vo);
		}
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
			System.out.println(vo);
		}
		System.out.println("-------------------------------");
	}

	private static void testFindById(String id) {
		List<MemberVo> list = new MemberDao().findById(id);
		for (MemberVo vo : list) {
			System.out.println(vo);
		}
		System.out.println("-------------------------------");
	}

	private static boolean testInsert(MemberVo vo) {
		boolean result = false;
		result = new MemberDao().insert(vo);
		return result;
	}
}
