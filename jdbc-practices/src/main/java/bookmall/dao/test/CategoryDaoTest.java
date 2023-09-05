package bookmall.dao.test;

import java.util.List;

import bookmall.dao.CategoryDao;
import bookmall.vo.CategoryVo;
import hr.dao.EmployeesDao;
import hr.dao.vo.EmployeesVo;

public class CategoryDaoTest {

	public static void main(String[] args) {
		testFindByAll();
		
		testFindByNo(1);
		
		testFindByTitle("컴퓨터/IT");
		
		boolean result = testInsertCategory("에세이");
		System.out.println(result ? "성공" : "실패");
		
		result = testDeleteByNo(7L);
		System.out.println(result ? "성공" : "실패");
		
		testFindByAll();
	} 

	private static void testFindByAll() {
		List<CategoryVo> list = new CategoryDao().findByAll();
		for (CategoryVo vo : list) {
			System.out.println(vo.getNo() + " : " + vo.getName());
		}
	}

	private static void testFindByNo(int no) {
		List<CategoryVo> list = new CategoryDao().findByNo(no);
		for (CategoryVo vo : list) {
			System.out.println(vo.getNo() + " : " + vo.getName());
		}
	}

	private static void testFindByTitle(String title) {
		List<CategoryVo> list = new CategoryDao().findByTitle(title);
		for (CategoryVo vo : list) {
			System.out.println(vo.getNo() + " : " + vo.getName());
		}
	}
	
	private static boolean testInsertCategory(String title) {
		boolean result = new CategoryDao().insertCategory(title);
		return result;
	}
	
	private static boolean testDeleteByNo(Long no) {
		boolean result = new CategoryDao().deleteByNo(no);
		return result;
	}
	
	private static boolean testDeleteByName(String title) {
		boolean result = new CategoryDao().deleteByName(title);
		return result;
	}
}
