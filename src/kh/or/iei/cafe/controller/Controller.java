package kh.or.iei.cafe.controller;

public class Controller {
	
	public interface CafeController {
	//메인메뉴가 되는 인터페이스
	public void main();
	//음료 메뉴 추가 메소드
	public void addDrink();
	//음료 수정 메소드
	public void updateDrink();
	//음료 삭제 메소드
	public void deleteDrink();
	//전체 주문 메뉴 확인
	public void inventoryDrink();
	//디저트 메뉴 재고 현황 메소드
	public void inventoryDessert();
	//디저트 메뉴 추가 메소드
	public void addDessert();
	//디저트 메뉴 수정 메소드
	public void updateDessert();
	//디저트 메뉴 삭제 메소드
	public void deleteDessert();
	}
}
