package bookmall.vo;

public class OrdersVo {
	private Long no;
	private String orderManageNo;
	private String name;
	private String email;
	private String deliveryAddress;
	private Long payment;
	private Long memberNo;

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getOrderManageNo() {
		return orderManageNo;
	}

	public void setOrderManageNo(String orderManageNo) {
		this.orderManageNo = orderManageNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public Long getPayment() {
		return payment;
	}

	public void setPayment(Long payment) {
		this.payment = payment;
	}

	public Long getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(Long memberNo) {
		this.memberNo = memberNo;
	}

	@Override
	public String toString() {
		return "[ 주문번호(" + orderManageNo + ") ]\n"
				+" 주문자 : " + name + " / " + email + "\n"
				+" 결제금액 : "+payment + "\n"
				+" 배송지 : " + deliveryAddress;
	}

}