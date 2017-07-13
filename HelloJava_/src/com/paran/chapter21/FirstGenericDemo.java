package com.paran.chapter21;

public class FirstGenericDemo {
	public static void main(String[] args) {
		/*
		 * Inventory<T>로 Instance를 생성하는 예제
		 *  Type Parameter T 대신 실제로 넣을 자료형을 Type Argument로서 지정해줘야 함
		 *  또는 와일드카드 ?를 사용할 수도 있음(대신 new로 선언되는 부분에서 실제 자료형 선언)
		 *  Instance에 있는 Type Parameter T는 모두 Type Argument로 치환됨
		 * 
		 * Type Parameter T를 사용하여 Instance 생성 불가
		 * Type Argument로 올 수 있는 자료형은 Reference Data Type에 한함
		 *  Primitive Data Type은 Wrapper Class를 사용하면 쓸 수 있음
		 */
		Inventory<String> inven = new Inventory<String>("Item1");
		Inventory<Item> itemInven = new Inventory<Item>(new Item());
		Inventory<?> randInven = new Inventory<String>("Random Item");
		Inventory<Object> objInven = new Inventory<Object>(new Object());
		
		// 와일드카드를 사용한 randInven에는 모든 Generic Class 할당 가능
//		randInven = inven;
//		randInven = itemInven;
		
		@SuppressWarnings("unused")
		// Item과 SubItem의 IS-A 관계 -> Inventory<Item>과 Inventory<SubItem>의 IS-A 관계X
		Inventory<SubItem> subItemInven1 = new Inventory<SubItem>(new SubItem());
		@SuppressWarnings("unused")
		// Item과 SubItem의 IS-A 관계 -> Inventory<Item>에 SubItem 객체 할당 가능
		Inventory<Item> subItemInven2 = new Inventory<>(new SubItem());
		//subItemInven2 = subItemInven1; // IS-A 관계가 아니므로 할당 불가능
		
		/*
		 * Generic Class의 상속 관계
		 *  A<T> Generic Class를 상속받는 B<T> Generic Class 선언
		 *  class A<T> {}
		 *  class B<T> extends A<T> {}
		 *  
		 *  A<Item> inst = new B<Item>(); -> 할당가능(단, 부모와 자식의 Type Argument가 같아야 함)
		 *  Type Argument가 상속관계라고 해서 Generic Class도 서로 상속관계가 되는 것이 아님
		 */
		
		// Inventory<?> 메서드 - Type Argument가 어떤 것이든 제약이 없음
		showInvenItemA(inven);
		showInvenItemA(itemInven);
		showInvenItemA(randInven);
		showInvenItemA(objInven);
		
		// Inventory<? extends Item> 메서드 - Upper Bounded
		//showInvenItemB(inven); // String과 Item 사이에 상속관계가 없음
		showInvenItemB(itemInven);
		//showInvenItemB(randInven); // 와일드카드로 선언된 String과 Item 사이에 상속관계가 없음
		//showInvenItemB(objInven); // Object와 Item 사이에 상속관계가 없음
		
		// Inventory<? super Item> 메서드 - Lower Bounded
		//showInvenItemC(inven); // String과 Item 사이에 상속관계가 없음
		showInvenItemC(itemInven);
		//showInvenItemC(randInven); // 와일드카드로 선언된 String과 Item 사이에 상속관계가 없음
		showInvenItemC(objInven);
		
		// Inventory<Item> 메서드 - Upper Bounded
		//showInvenItemD(inven); // Type Argument가 Item인 Generic Class가 아님
		showInvenItemD(itemInven);
		//showInvenItemD(randInven); // 와일드카드로 선언된 Type Argument가 Item이 아님
		//showInvenItemD(objInven); // Type Argument가 Item인 Generic Class가 아님
		//showInvenItemD(subItemInven); // Type Argument가 Item인 Generic Class가 아님
	}
	
	/*
	 * Inventory<T>를 매개변수로 선언하는 예제
	 *  Type Parameter T 대신 와일드카드 ?를 사용하여 들어올 자료형을 신경쓰지 않을 것을 명시하거나
	 *  실제로 사용할 자료형을 extends나 super를 사용하여 특정 타입에만 반응하도록 명시해야 함 
	 *  Type Parameter를 기술하지 않고 Generic Class명만 기재할 경우 Raw Type
	 *   - 구버전과의 호환성을 위해 남겨둔 기능으로, 사용하면 안 됨
	 */
	// Type Argument가 어떤 것이든 신경X
	public static void showInvenItemA(Inventory<?> inven) {
		inven.showInfo();
	}
	// Type Argument가 Item과 IS-A 관계(Item 또는 Item의 자식)일 경우 실행 - Upper Bounded Type
	public static void showInvenItemB(Inventory<? extends Item> inven) {
		inven.showInfo();
	}
	// Type Argument가 Item과 IS-A 관계(Item 또는 Item의 부모)일 경우 실행 - Lower Bounded Type
	public static void showInvenItemC(Inventory<? super Item> inven) {
		inven.showInfo();
	}
	// Type Argument가 Item일 경우 실행 - Upper Bounded Type
	public static void showInvenItemD(Inventory<Item> inven) {
		inven.showInfo();
	}
}

class Item {
	String name;
	String id;
	String originalOwner;
}

class SubItem extends Item {
	
}

/*
 * Type Parameter T - 자료형이 정해져있지 않은 임의의 매개변수
 */
class Inventory<T> {
	public T item;
	public Inventory(T item) {
		this.item = item;
	}
	
	public void setItem(T item) {
		this.item = item;
	}
	public T getItem() {
		return item;
	}
	public void showInfo() {
		System.out.println(item);
	}
}