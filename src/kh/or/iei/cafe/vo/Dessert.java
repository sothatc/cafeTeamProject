package kh.or.iei.cafe.vo;

public class Dessert {
	private String dessertName;//디저트이름
	private int dessertCount;//디저트수량
	private int dessertPrice;//디저트가격
	private String takeOut;
	private String pay; // 결제(카드/현금)
	
	public Dessert() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Dessert(String dessertName, int dessertCount, int dessertPrice) {
		super();
		this.dessertName = dessertName;
		this.dessertCount = dessertCount;
		this.dessertPrice = dessertPrice;
	}
	

	public Dessert(String dessertName, int dessertCount, int dessertPrice, String takeOut, String pay ) {
		super();
		this.dessertName = dessertName;
		this.dessertCount = dessertCount;
		this.dessertPrice = dessertPrice;
		this.takeOut = takeOut;
		this.pay = pay;
	}
	public String getDessertName() {
		return dessertName;
	}

	public void setDessertName(String dessertName) {
		this.dessertName = dessertName;
	}

	public int getDessertCount() {
		return dessertCount;
	}

	public void setDessertCount(int dessertCount) {
		this.dessertCount = dessertCount;
	}

	public int getDessertPrice() {
		return dessertPrice;
	}

	public void setDessertPrice(int dessertPrice) {
		this.dessertPrice = dessertPrice;
	}
	public String getTakeOut() {
		return takeOut;
	}
	public void setTakeOut(String takeOut) {
		this.takeOut = takeOut;
	}
	public String getPay() {
		return pay;
	}
	public void setPay(String Pay) {
		this.pay = Pay;
	}
	
	
}