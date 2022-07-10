package kh.or.iei.cafe.vo;

public class MenuKind {
	private String menuName; //추가할 메뉴 이름
	private String temp; //추가메뉴 ice/hot
	private String size; //사이즈(tall/grade)
	private int shot; //샷추가
	private String pay; // 결제(카드/현금)
	private int drinkConut; //주문수량
	private int money; //가격
	private String takeOut;
	
	public MenuKind() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public MenuKind(String menuName, String temp, String size, int shot, String pay, int drinkConut, int money) {
		super();
		this.menuName = menuName;
		this.temp = temp;
		this.size = size;
		this.shot = shot;
		this.pay = pay;
		this.drinkConut = drinkConut;
		this.money = money;
	}
	
	public MenuKind(String menuName, int money) {
		this.menuName = menuName;
		this.money = money;
	}
	
	
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getTemp() {
		return temp;
	}
	public void setTemp(String temp) {
		this.temp = temp;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public int getShot() {
		return shot;
	}
	public void setShot(int shot) {
		this.shot = shot;
	}
	public String getPay() {
		return pay;
	}
	public void setPay(String pay) {
		this.pay = pay;
	}
	public int getConut() {
		return drinkConut;
	}
	public void setConut(int conut) {
		this.drinkConut = conut;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public String getTakeOut() {
		return takeOut;
	}
	public void setTakeOut(String takeOut) {
		this.takeOut = takeOut;
	}
	
	
}// MenuKind종료
