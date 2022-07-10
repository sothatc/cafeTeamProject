package kh.or.iei.cafe.vo;

public class Consumer extends MenuKind {
	
	private String drinkSel;
	private String tempSel; 
	private String sizeSel; 
	private int drinkConut; 
	private String inOutSel;
	
	private String dessertSel;
	private int orderDessertCount;

	public Consumer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Consumer(String menuName, int money) {
		super(menuName, money);
		// TODO Auto-generated constructor stub
	}

	public Consumer(String menuName, String temp, String size, int shot, String pay, int drinkConut, int money) {
		super(menuName, temp, size, shot, pay, drinkConut, money);
		// TODO Auto-generated constructor stub
	}
	public Consumer(String dessertSel, int orderDessertCount, String inOutSel) {
		this.dessertSel = dessertSel;
		this.orderDessertCount = orderDessertCount;
		this.inOutSel = inOutSel;
	}
	
	public Consumer(String drinkSel, String tempSel, String sizeSel, int drinkConut, String inOutSel) {
		super();
		this.drinkSel = drinkSel;
		this.tempSel = tempSel;
		this.sizeSel = sizeSel;
		this.drinkConut = drinkConut;
		this.inOutSel = inOutSel;
		
	}

	public String getDrinkSel() {
		return drinkSel;
	}

	public void setDrinkSel(String drinkSel) {
		this.drinkSel = drinkSel;
	}

	public String getTempSel() {
		return tempSel;
	}

	public void setTempSel(String tempSel) {
		this.tempSel = tempSel;
	}

	public String getSizeSel() {
		return sizeSel;
	}

	public void setSizeSel(String sizeSel) {
		this.sizeSel = sizeSel;
	}

	public int getDrinkConut() {
		return drinkConut;
	}

	public void setDrinkConut(int drinkConut) {
		this.drinkConut = drinkConut;
	}

	public String getInOutSel() {
		return inOutSel;
	}

	public void setInOutSel(String inOutSel) {
		this.inOutSel = inOutSel;
	}
	
	 
	
	
	
	
}
