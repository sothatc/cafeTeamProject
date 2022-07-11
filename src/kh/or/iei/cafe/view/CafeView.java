package kh.or.iei.cafe.view;

import java.util.ArrayList;
import java.util.Scanner;

import kh.or.iei.cafe.vo.Consumer;
import kh.or.iei.cafe.vo.ConsumerDes;
import kh.or.iei.cafe.vo.Dessert;
import kh.or.iei.cafe.vo.MenuKind;

public class CafeView {
	public String tempSel;
	public String sizeSel;
	public String inOutSel;
	public int drinkConut;
	public int orderDessertCount;
	public Dessert d = new Dessert();
	private int drinkK; //고객이 주문한 횟수 (주문취소위한거)
	private int dessertK;//
	private String drinkSel;
	private String dessertSel;
	private Scanner sc;
	private MenuKind m;
//	private Dessert d;
	
	public CafeView() {
		sc = new Scanner(System.in);
		MenuKind[] mk = null;
		Dessert[] d = null;
	}
	
	public int getDrinkK() {
		return drinkK;
	}

	public void setDrinkK(int drinkK) {
		this.drinkK = drinkK;
	}

	public int getDessertK() {
		return dessertK;
	}

	public void setDessertK(int dessertK) {
		this.dessertK = dessertK;
	}

	public int showMenu1() {
		System.out.println("=== 탐탐에 오신걸 환영합니다! ===");
		System.out.println("1.알바생");
		System.out.println("2.손님");
		System.out.println("3.종료");
		System.out.print("선택 > ");
		int sel = sc.nextInt();
		return sel;
	}//showMenu1()종료
	
	public int showMenu2(){
		System.out.println("=== 음료 파트 ===");
		System.out.println("1.메뉴 추가");
		System.out.println("2.메뉴 수정");
		System.out.println("3.메뉴 삭제");
		System.out.println("4.메뉴 확인");
		System.out.println();
		System.out.println("=== 디저트 파트 ===");
		System.out.println("5.재고현황");
		System.out.println("6.디저트 추가");
		System.out.println("7.디저트 수정");
		System.out.println("8.디저트 삭제");
		System.out.println("0.처음화면으로");
		System.out.println("-------------");
		System.out.print("선택 > ");
		
		int sel1 = sc.nextInt();
		
		return sel1;
	}//showMenu2()종료
	
	public int showMenu3() {
		System.out.println("1.주문 내역");
		System.out.println("2.음료 주문");
		System.out.println("3.디저트 주문");
		System.out.println("4.주문 취소");
		System.out.println("0.처음화면으로");
		System.out.println();
		System.out.print("선택 > ");
		
		int sel2 = sc.nextInt();
		return sel2;
	}//showMenu3()종료
	
	
	public MenuKind addDrink() {
		 System.out.print("추가할 음료 이름을 입력해주세요.(띄어쓰기x) :");
		 String addDrinkName = sc.next();
		 
		 System.out.print("추가할 음료의 판매 가격을 입력해주세요 : ");
		 int drinkPrice = sc.nextInt();
		 
		 MenuKind m = new MenuKind(addDrinkName,drinkPrice);
		 msg("추가");
		 
		 return m; 
		
	 }// addDrink()종료
	 
	 public MenuKind updateDrink(){
		 System.out.print("수정할 메뉴 이름을 입력해주세요.(띄어쓰기x) : ");
		 String name = sc.next();
		 
		 System.out.print("수정할 메뉴의 가격을 입력해주세요. : ");
		 int price = sc.nextInt();
		 
		 MenuKind m = new MenuKind(name,price);
		 return m;
	 } //updateDrink()종료
	 
	 
	 public String getName(String str) {
		 System.out.print(str+"하고 싶은 메뉴 이름을 입력해주세요.(띄어쓰기x) : ");
		 String name = sc.next();
		 return name;
	 }
	 
	 public void nosearchName() {
		 System.out.println("주문하신 메뉴를 찾을 수 없습니다.");
	 }
	 
	 public void inventoryDrink(ArrayList<MenuKind> drinkMenu) {
		System.out.println("===음료 내역 확인===");
		System.out.println("메뉴이름\t가격"); 
		for (int i = 0; i < drinkMenu.size(); i++) {
			MenuKind m = drinkMenu.get(i);
			System.out.println(m.getMenuName() + "\t" + m.getMoney());
		}
	 }
	 
	 public void orderDrink(int indexDr,ArrayList<MenuKind> drinkMunu,ArrayList<Consumer> consumer) {
		 MenuKind m = new MenuKind();
		 int i;
		 int j=1;
		 for(i=0;i<drinkMunu.size();i++) {
			 m = drinkMunu.get(i);
			 System.out.println(j+"\t"+m.getMenuName() + "\t" + m.getMoney());
			 j++;
		 }
		 System.out.print("음료를 선택하세요 : ");
	 	 drinkSel = sc.next();
	 	 loop1:while(true) {
			System.out.print("온도선택[1.ICE / 2.HOT] : ");
			tempSel = sc.next();
				
				if(tempSel.equalsIgnoreCase("ice")) {
					m.setTemp("ice");
					break loop1;
				}else if(tempSel.equalsIgnoreCase("hot")) {
					m.setTemp("hot");
					break loop1;
				}else {
					System.out.println("잘못 선택하였습니다, 다시 선택해주세요.");
				}
			}
			
			loop2:while(true) {
				System.out.print("음료 사이즈 선택[1.tall / 2.grande] : ");
				sizeSel = sc.next();
				if(sizeSel.equalsIgnoreCase("tall")) {
					m.setSize("tall");
					
					break loop2;
				}else if(sizeSel.equalsIgnoreCase("grande")) {
					m.setSize("grande");
					break loop2;
				}else {
					System.out.println("잘못 선택하였습니다, 다시 선택해주세요.");
				}
				
			}
			loop3:while(true) {
				System.out.print("결제수단 선택[1.카드 / 2.현금] : ");
				String moneySel = sc.next();
				if(moneySel.equalsIgnoreCase("카드")) {
					m.setPay("카드");
					break loop3;
				}else if(moneySel.equalsIgnoreCase("현금")) {
					m.setPay("현금");
					break loop3;
				}else {
					System.out.println("잘못 선택하였습니다, 다시 선택해주세요.");
				}
			}
			loop4:while(true) {
				System.out.print("1.테이크아웃 / 2. 매장 : ");
				inOutSel = sc.next();
				if(inOutSel.equalsIgnoreCase("테이크아웃")) {
					m.setTakeOut("테이크아웃");
					break loop4;
				}else if(inOutSel.equalsIgnoreCase("매장")) {
					m.setTakeOut("매장");
					break loop4;
				}else {
					System.out.println("잘못 선택하였습니다, 다시 선택해주세요.");
				}
				
			}
			System.out.print("수량을 입력하세요 : ");
			drinkConut = sc.nextInt();
			System.out.println("주문이 완료되었습니다.");
			m.setConut(drinkConut);
			Consumer c = new Consumer(drinkSel,tempSel,sizeSel,drinkConut,inOutSel);
			consumer.add(c);
			
			
			
	 }
	 public void orderDessert(ArrayList<ConsumerDes> consumerDes, ArrayList<Dessert> dessertMenu, int indexDes) {
		
		 int i;
		 int j=1;
		 for(i=0;i<indexDes;i++) {
			 d = dessertMenu.get(i);
			 System.out.println(j+". "+d.getDessertName() + "\t" + d.getDessertPrice());
			 j++;
		 }
		 System.out.print("디저트를 선택하세요 : ");
		 dessertSel = sc.next();
			loop1:while(true) {
				System.out.print("결제수단 선택[1.카드 / 2.현금] : ");
				String moneySel = sc.next();
				if(moneySel.equalsIgnoreCase("카드")) {
					d.setPay("카드");
					break loop1;
				}else if(moneySel.equalsIgnoreCase("현금")) {
					d.setPay("현금");
					break loop1;
				}else {
					System.out.println("잘못 선택하였습니다, 다시 선택해주세요.");
				}
			}
			loop2:while(true) {
				System.out.print("1.테이크아웃 / 2. 매장 : ");
				String inOutSel = sc.next();
				if(inOutSel.equalsIgnoreCase("테이크아웃")) {
					d.setTakeOut("테이크아웃");
					break loop2;
				}else if(inOutSel.equalsIgnoreCase("매장")) {
					d.setTakeOut("매장");
					break loop2;
				}else {
					System.out.println("잘못 선택하였습니다, 다시 선택해주세요.");
				}
				
			}
			System.out.print("수량을 입력하세요 : ");
			orderDessertCount = sc.nextInt();
			System.out.println("주문이 완료되었습니다.");
//			d.setDessertCount(orderDessertCount);
			d.setDessertCount(d.getDessertCount() - orderDessertCount);
			ConsumerDes cd = new ConsumerDes(inOutSel,dessertSel,orderDessertCount);
			consumerDes.add(cd);
			
	 }
	 public void checkDrinkOrder(int indexDr,ArrayList<Consumer> consumer) {
		 Consumer c = new Consumer();
		 System.out.println("==== 주문 내역 확인 ====");
		 System.out.println("메뉴이름\t수량\t사이즈\t온도\t포장여부");
		 for(int i=0;i<drinkK;i++) {
			 c = consumer.get(i);
			 if(drinkSel.equals(c.getDrinkSel())) {
				
				 System.out.println(c.getDrinkSel()+"\t"
						 		+c.getDrinkConut()+"\t"
						 		+c.getSizeSel()+"\t"
						 		+c.getTempSel()+"\t"
						 		+c.getInOutSel());
				 
			 }
		 }
	 }
	 public void checkDessertOrder(ArrayList<Dessert> dessertMenu,int indexDes) {
		
		 System.out.println("==== 주문 내역 확인 ====");
		 System.out.println("메뉴이름\t수량\t포장여부");
		 for(int i=0;i<indexDes;i++) {
			 d = dessertMenu.get(i);
			 if(dessertSel.equals(d.getDessertName())) {
				 System.out.println(d.getDessertName()+"\t"
						 		+d.getDessertCount()+"\t"
						 		+d.getTakeOut());
			 }else {
			 }
		 }
	 }
	 
	 
	 public void msg(String str) {
		 System.out.println("메뉴 "+str+" 완료!");
	 }
	
	public void inventoryDessert(Dessert[] dessertMenu, int indexDes) {
		if(indexDes == 0) {
			System.out.println("디저트 추가를 해주세요.");
		}else {
			System.out.println("=========== 재고현황 ===========");
			System.out.printf("[제품명]\t[수량]\t[판매가]\n");
			for(int i=0;i<indexDes;i++) {
				Dessert d = dessertMenu[i];
				System.out.print(d.getDessertName()+"\t");
				System.out.print(d.getDessertCount()+"\t");
				System.out.print(d.getDessertPrice()+"\n");
			}
		}
	}//inventoryDessert()종료
	
	public Dessert addDessert() {
		System.out.println("============ 디저트 추가 ============");
		System.out.print("추가할 제품명 입력 : ");
		String name = sc.next();
		System.out.print("수량 입력 : ");
		int count = sc.nextInt();
		System.out.print("판매가 입력 : ");
		int price = sc.nextInt();
//		Dessert des = null;
		Dessert d = new Dessert(name,count,price);
//		des = (Dessert)d;
		System.out.println("디저트 추가 완료!");
		
		return d;
		

		 
		
	}//addDessert()종료
	
	public String getDessertName(String str) {
		System.out.println("============ 디저트 "+str+" ============");
		System.out.print(str+"할 제품명 입력 : ");
		String name = sc.next();
		return name;
	}//getDessertName()종료
	
	public Dessert updateDessert() {
		System.out.print("어떤 제품으로 바꾸시겠습니까? : ");
		String name = sc.next();
		System.out.print("수정할 수량 입력 : ");
		int count = sc.nextInt();
		System.out.print("수정할 판매가 입력 : ");
		int price = sc.nextInt();
		Dessert des = null;
		des = new Dessert(name,count,price);
		System.out.println("디저트 수정 완료!");
		return des;
	}//updateDessert()종료
	
	public String cancelOrder() {
		System.out.print("취소할 메뉴를 선택하세요 : ");
		String name = sc.next();
		return name;
		
	}

	public void deleteDessert() {
		System.out.println("디저트 삭제 완료!");
	}//deleteDessert()종료
	
	public void noSearch() {
		System.out.println("재고가 없는 제품입니다.");
	}//검색실패 메소드
	
	public void deleteSuccess() {
		System.out.println("주문취소가 완료되었습니다.");
	}
		
	public void exit() {
		System.out.println("안녕히 가세요!");
	}//메인에서 종료 시 출력문
	
	
}//cafeView 종료
