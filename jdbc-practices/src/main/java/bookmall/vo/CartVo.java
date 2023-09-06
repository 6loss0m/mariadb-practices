package bookmall.vo;

public class CartVo {
	private Long no;
	private Long count;
	private Long price;
	private Long book_no;
	private Long member_no;

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Long getBook_no() {
		return book_no;
	}

	public void setBook_no(Long book_no) {
		this.book_no = book_no;
	}

	public Long getMember_no() {
		return member_no;
	}

	public void setMember_no(Long member_no) {
		this.member_no = member_no;
	}

	@Override
	public String toString() {
		return "CartVo [no=" + no + ", count=" + count + ", price=" + price + ", book_no=" + book_no + ", member_no="
				+ member_no + "]";
	}
}
