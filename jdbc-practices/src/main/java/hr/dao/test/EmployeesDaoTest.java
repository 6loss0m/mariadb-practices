package hr.dao.test;

import java.util.List;

import hr.dao.EmployeesDao;
import hr.dao.vo.EmployeesVo;

public class EmployeesDaoTest {

	public static void main(String[] args) {
//		testFindByName("ma");
		testFindBySalary(10000, 50000);
	}

	private static void testFindBySalary(int minSalary, int maxSalary) {
		List<EmployeesVo> list = new EmployeesDao().findBySalary(minSalary, maxSalary);
		int count = 0;
		for (EmployeesVo vo : list) {
			if(count >= 1000) {
				break;
			}
			System.out.println("name : " + vo.getFirstName() + "\t salary : " + vo.getSalary());
			count++;
		}
	}

	private static void testFindByName(String name) {
		List<EmployeesVo> list = new EmployeesDao().findByName(name);
		for (EmployeesVo vo : list) {
			System.out.println(vo);
		}
	}
}
