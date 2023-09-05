package emaillist.main;

import java.util.List;
import java.util.Scanner;

import emaillist.dao.EmaillistDao;
import emaillist.vo.EmaillistVo;

public class EmaillistApp {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		while (true) {
			System.out.print("[ (l)ist (i)nsert (d)elete (q)uit ] > ");
			String command = scanner.nextLine();

			if ("l".equals(command)) {
				doList();
			} else if ("i".equals(command)) {
				doInsert();
			} else if ("d".equals(command)) {
				doDelete();
			} else if ("q".equals(command)) {
				break;
			}
		}
	}

	public static void doList() {
		List<EmaillistVo> list = new EmaillistDao().findAll();
		for (EmaillistVo vo : list) {
			System.out.println("[" + vo.getNo() + "] 이름 : " + vo.getFirstName()+ vo.getLastName() + ", 이메일 : "
					+ vo.getEmail());
		}
	}

	public static void doInsert() {
		System.out.print("성을 입력하세요 : ");
		String firstName = scanner.nextLine();
		System.out.print("이름을 입력하세요 : ");
		String lastName = scanner.nextLine();
		System.out.print("이메일을 입력하세요 : ");
		String email = scanner.nextLine();
		
		EmaillistVo vo = new EmaillistVo();
		vo.setFirstName(firstName);
		vo.setLastName(lastName);
		vo.setEmail(email);
		
		boolean result = new EmaillistDao().insert(vo);
		System.out.print("입력을 ");
		System.out.print((result == true) ? "성공" : "실패");
		System.out.println(" 하였습니다.");
	}

	public static void doDelete() {
		System.out.print("이메일을 입력하세요 : ");
		String email = scanner.nextLine();
		boolean result = new EmaillistDao().deleteByEmail(email);
		System.out.print("삭제를 ");
		System.out.print((result == true) ? "성공" : "실패");
		System.out.println(" 하였습니다.");	}

}
