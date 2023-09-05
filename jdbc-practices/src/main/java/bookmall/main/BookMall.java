package bookmall.main;

public class BookMall {
	public static String user = "bookmall";
	public static String password = "bookmall";
	public static String ip = "192.168.0.179";
	public static int port = 3307;
	public static String url = "jdbc:mariadb://" + ip + ":" + port + "/bookmall?charset=utf8";

	public static void main(String[] args) {
//		MemberDao memberDao = new MemberDao();
//		memberDao.insert(memberVo1); 
//		memberDao.insert(memberVo2); 

		System.out.println("## 회원리스트"); // 2명

		System.out.println("## 카테고리"); // 3개

		System.out.println("## 상품"); // 3개

		System.out.println("## 카트"); // 2개

		System.out.println("## 주문"); // 1개

		// 주문 도서 리스트는 Order, Book에서 두번 가져와서 join
		System.out.println("## 주문 도서"); // 2개

	}

}
