package bookshop.example;

public class BookVo {
	private int no;
	private String title;
	private String rent;
	private String author_name;

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getRent() {
		return rent;
	}

	public void setRent(String rent) {
		this.rent = rent;
	}

	public String getAuthor_name() {
		return author_name;
	}

	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}

	@Override
	public String toString() {
		return "BookVo [no=" + no + ", title=" + title + ", rent=" + rent + ", author_name=" + author_name + "]";
	}

	public void print() {
		System.out.println("[" + no + "] 책 제목 : " + title + ", 작가 : " + author_name + ", 대여 유무 : "
				+ ((rent.equals("Y")) ? "대여중" : "재고있음"));
	}
}
