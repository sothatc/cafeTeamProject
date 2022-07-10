package kh.or.iei.cafe.vo;

public class ConsumerDes  extends Dessert {
	
	private String inOutSel;
	private String dessertSel;
	private int orderDessertCount;
	public ConsumerDes() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ConsumerDes(String dessertName, int dessertCount, int dessertPrice, String takeOut, String pay) {
		super(dessertName, dessertCount, dessertPrice, takeOut, pay);
		// TODO Auto-generated constructor stub
	}
	public ConsumerDes(String dessertName, int dessertCount, int dessertPrice) {
		super(dessertName, dessertCount, dessertPrice);
		// TODO Auto-generated constructor stub
	}
	
	
	
	public ConsumerDes(String inOutSel, String dessertSel, int orderDessertCount) {
		super();
		this.inOutSel = inOutSel;
		this.dessertSel = dessertSel;
		this.orderDessertCount = orderDessertCount;
	}
	public String getInOutSel() {
		return inOutSel;
	}
	public void setInOutSel(String inOutSel) {
		this.inOutSel = inOutSel;
	}
	public String getDessertSel() {
		return dessertSel;
	}
	public void setDessertSel(String dessertSel) {
		this.dessertSel = dessertSel;
	}
	public int getOrderDessertCount() {
		return orderDessertCount;
	}
	public void setOrderDessertCount(int orderDessertCount) {
		this.orderDessertCount = orderDessertCount;
	}
	
	
	
	
}
