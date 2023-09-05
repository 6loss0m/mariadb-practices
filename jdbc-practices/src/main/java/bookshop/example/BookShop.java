package bookshop.example;

import java.util.List;
import java.util.Scanner;

public class BookShop {

	public static void main(String[] args) {
		while (true) {
			displayBookInfo();

			Scanner scanner = new Scanner(System.in);
			System.out.println("1. 대여");
			System.out.println("2. 반납");
			System.out.println("3. 종료");
			System.out.print("메뉴를 선택하시오 >> ");

			int no = scanner.nextInt();
			String state = null;
			if (no == 3) {
				scanner.close();
				break;
			} else if (no == 1) {
				state = "대여";
			} else if (no == 2) {
				state = "반납";
			}
			System.out.print(state + " 하고 싶은 책의 번호를 입력하세요 >> ");
			no = scanner.nextInt();

			BookVo vo = new BookVo();
			vo.setNo(no);
			vo.setRent((state.equals("대여") ? "Y" : "N"));

			boolean result = new BookDao().updateRent(vo);
			if (result == true) {
				System.out.println(state + "가 완료되었습니다.");
			} else {
				System.out.println("이미 " + state + "중인 책입니다.");
			}
		}
	}

	private static void displayBookInfo() {
		System.out.println("********************도서 정보 출력하기*********************");

		List<BookVo> list = new BookDao().finaAll();
		for (BookVo book : list) {
			book.print();
		}
		
		System.out.println("********************************************************");
	}
}