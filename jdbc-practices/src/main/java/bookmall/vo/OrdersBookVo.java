package bookmall.vo;

public class OrdersBookVo {
	private Long no;
	private String title;
	private Long count;
	private Long totalPriece;
	private Long ordersNo;
	private Long bookNo;

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public Long getOrdersNo() {
		return ordersNo;
	}

	public void setOrdersNo(Long ordersNo) {
		this.ordersNo = ordersNo;
	}

	public Long getBookNo() {
		return bookNo;
	}

	public void setBookNo(Long bookNo) {
		this.bookNo = bookNo;
	}
	

	public Long getTotalPriece() {
		return totalPriece;
	}

	public void setTotalPriece(Long totalPriece) {
		this.totalPriece = totalPriece;
	}

	@Override
	public String toString() {
		return "도서번호 : " + bookNo + ", 도서제목 : " + title + ", 수량 : " + count;
	}
}
