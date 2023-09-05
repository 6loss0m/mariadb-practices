package bookmall.vo;

public class CartVo {
	private Long no;
	private Long count;
	private Long price;
	private Long book_no;
	private Long members_no;
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
	public Long getMembers_no() {
		return members_no;
	}
	public void setMembers_no(Long members_no) {
		this.members_no = members_no;
	}
	@Override
	public String toString() {
		return "CartVo [no=" + no + ", count=" + count + ", price=" + price + ", book_no=" + book_no + ", members_no="
				+ members_no + "]";
	}
}
