package com.paran.chapter17;

/*
 * Interface -> 상수 + abstract 메서드로만 구성된 특수 클래스
 * instanceof 연산자 -> 연산 대상이 interface를 구현중인지 아닌지 판별하는 연산자
 * 
 * JRE 1.8.0 이상부터 default 메서드, static 메서드를 interface에서 구현해놓는 것이 가능
 *  -> 이게 과연 Interface의 기능일까? Abstract 메서드와의 차별점 논란
 *  interface에 구현되어 있는 메서드가 존재할 경우, interface를 구현한 클래스에서는 그 메서드를 호출해줘야 함
 */
interface Animal{
	/*
	 * 한정자 선언이 없어도 자동으로 abstract public이 적용
	 */
	abstract public void eat();
	abstract public void travel();
}

interface Walkable{
	abstract public void walk();
}

class Mammal implements Animal, Walkable {

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("Mammal eat method");
	}

	@Override
	public void travel() {
		// TODO Auto-generated method stub
		System.out.println("Mammal travel method");
	}

	@Override
	public void walk() {
		// TODO Auto-generated method stub
		System.out.println("Mammal walk method");
	}
	
}

class Amphibian implements Animal, Walkable {
	
	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("Amphibian eat method");
	}
	
	@Override
	public void travel() {
		// TODO Auto-generated method stub
		System.out.println("Amphibian travel method");
	}
	
	@Override
	public void walk() {
		// TODO Auto-generated method stub
		System.out.println("Amphibian walk method");
	}
}

/*
 * Design Pattern에 대해 학습
 */
public class InterfaceDemo {
	public static void main(String[] args) {
		Animal obj1 = new Mammal();
		Animal obj2 = new Amphibian();
		// 구현된 Interface type으로는 서로 형변환이 가능
		Walkable obj3 = (Walkable)obj1;
		/*
		 * obj1, obj2는 Animal Interface type
		 *  Animal Interface로는 Walkable Interface에 구현되어 있는 walk 메서드를 호출할 수 없음
		 */
		obj1.eat();
		obj1.travel();
		
		obj2.eat();
		obj2.travel();
		
		// 따로 형변환한 변수를 만들지 않았어도 즉시 형변환하여 사용할 수도 있음
		obj3.walk();
		((Walkable)obj1).walk();
	}
}
