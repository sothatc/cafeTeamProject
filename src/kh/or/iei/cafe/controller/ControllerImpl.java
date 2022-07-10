package kh.or.iei.cafe.controller;

import java.util.ArrayList;
import java.util.Scanner;

import kh.or.iei.cafe.controller.Controller.CafeController;
import kh.or.iei.cafe.view.CafeView;
import kh.or.iei.cafe.vo.Consumer;
import kh.or.iei.cafe.vo.ConsumerDes;
import kh.or.iei.cafe.vo.Dessert;
import kh.or.iei.cafe.vo.MenuKind;


public class ControllerImpl implements CafeController{
	
	private Scanner sc;
	private CafeView view;
	private ArrayList<MenuKind> drinkMenu;
	private ArrayList<Dessert> dessertMenu;
	private int indexDr;
	private int indexDes;
	private ArrayList<Consumer> consumer;
	private ConsumerDes[] consumerDes;
	
	public ControllerImpl() {
		super();
		sc = new Scanner(System.in);
		dessertMenu = new ArrayList<Dessert>();
		view = new CafeView();
		drinkMenu = new ArrayList<MenuKind>(); //추가 된 음료 메뉴를 저장할 배열
		consumer = new ArrayList<Consumer>(); // 고객이 주문한 메뉴를 저장할 배열
		consumerDes = new ArrayList<ConsumerDes>(); 
	}
	
	@Override
	public void main() {
		while(true) {
			int sel = view.showMenu1();
			switch(sel) {
			case 1:
				int sel1 = view.showMenu2();
				switch(sel1) {
				case 1:
					addDrink();
		            break;
		        case 2:
		        	updateDrink();
		            break;
		        case 3:
		        	deleteDrink();
		            break;
		        case 4:
		        	 inventoryDrink();
		            break;
				case 5:
					inventoryDessert();
					break;
				case 6:
					addDessert();
					break;
				case 7:
					updateDessert();
					break;
				case 8:
					deleteDessert();
					break;
				case 0:
					break;
				}
				break;
			
			case 2:
				int sel2 = view.showMenu3();
				switch(sel2) {
				case 1: 
					checkOrder();
					break;
				case 2: 
					orderDrink();
					break;
				case 3: 
					orderDessert();
					break;
				case 4: 
					cancelOrder();
					break;
				case 0: 
					return;
				}
				break;
			case 3:
				view.exit();
				return;
			}//switch 종료
		}//while 종료
	}//main 종료
	
	//1-1.음료 메뉴 추가 메소드
	@Override
	public void addDrink() {
		drinkMenu.add(view.addDrink());
	}

	//1-2.음료 수정 메소드
	@Override
	public void updateDrink() { // 메뉴 수정
		int searchindexDr = searchMenu(view.getName("수정"));

		if (searchindexDr == -1) {
			view.nosearchName();
		} else {
			drinkMenu.set(searchindexDr, view.updateDrink());
		}
	}

	//1-3.음료 삭제 메소드
	@Override
	public void deleteDrink() {
		int searchindexDr = searchMenu(view.getName("삭제"));

		if (searchindexDr == -1) {
			view.nosearchName();
		} else {
			drinkMenu.remove(searchindexDr);
			view.msg("삭제");
		} 
	}

	//1-4.전체 주문 메뉴 확인 메소드
	@Override
	public void inventoryDrink() {
		view.inventoryDrink(drinkMenu, indexDr);
	}
	
	//1-5.재고현황 메소드
	@Override
	public void inventoryDessert() {
		view.inventoryDessert(dessertMenu, indexDes);
	}
	
	//1-6.디저트추가 메소드
	@Override
	public void addDessert() {
		Dessert des = view.addDessert();
		dessertMenu[indexDes++] = des;
	}
	
	//1-7.디저트수정 메소드
	@Override
	public void updateDessert() {
		String name = view.getDessertName("수정");
		int searchindexDr = searchDessert(name);
		if(searchindexDr == -1) {
			view.noSearch();
		}else {
			dessertMenu[searchindexDr] = view.updateDessert();
		}
	}
	
	//1-8.디저트삭제 메소드
	@Override
	public void deleteDessert() {
		String name = view.getDessertName("삭제");
		int searchindexDr = searchDessert(name);
		if(searchindexDr == -1) {
			view.noSearch();
		}else {
			for(int i=searchindexDr;i<indexDes-1;i++) {
				dessertMenu[i] = dessertMenu[i+1];//하나씩 땡기며 삭제
			}
			indexDes--;
		}
		//view.deleteDessert();
	}//deleteDessert()종료
	
	////음료 메뉴이름이 배열의 몇번째에 있는지 찾아서 리턴하는 메소드
	public int searchMenu(String name) {
		for (int i = 0; i < indexDr; i++) {
			MenuKind m = drinkMenu[i];
			if (name.equals(m.getMenuName())) {
				return i;
			} // if종료
		}return -1;
	}// searchMenu(String name)종료
	
	public void orderDrink() {
		view.orderDrink(indexDr, drinkMenu, consumer);
	}
	
	public void checkOrder() {
		view.checkDrinkOrder(indexDr,consumer);
		view.checkDessertOrder(dessertMenu,indexDes);
	}
	public void orderDessert() {
		view.orderDessert(consumerDes,dessertMenu,indexDes);
	}
	
	public void cancelOrder() {
		view.checkDrinkOrder(indexDr,consumer);
		view.checkDessertOrder(dessertMenu,indexDes);
		String name = view.cancelOrder();
		int searchIndex1 = searchMenu(name);
		int searchIndex2 = searchDessert(name);
		if(searchIndex1 == -1 && searchIndex2 == -1) {
			view.nosearchName();
		}else if(searchIndex1 == -1){
			for(int i=searchIndex2;i<view.getDessertK();i++) {
				consumerDes[i] = consumerDes[i+1];
			}
			indexDes--;
//			view.setDrinkK(view.getDrinkK()-1);
		}else {
			for(int i=searchIndex1;i<view.getDrinkK()-1;i++) {
				consumer[i] = consumer[i+1];
			}
			view.setDrinkK(view.getDrinkK()-1);
//			view.setDessertK(view.getDessertK()-1);
		}
		view.deleteSuccess();
		
	}
	
	
	
	
	//디저트이름이 배열의 몇번째에 있는지 찾아서 리턴하는 메소드
	public int searchDessert(String name) {
		for(int i=0;i<indexDes;i++) {
			Dessert d = dessertMenu[i];
			if(name.equals(d.getDessertName())) {
				return i;
			}
		}
		return -1;
	}//searchDessert(String name)종료
	

}
