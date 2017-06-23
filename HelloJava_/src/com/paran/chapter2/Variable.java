package com.paran.chapter2;

/*
 * github 작업 중 실수로 데이터 삭제함
 * 코드는 복원, 주석은 전부 삭제됨
 */
public class Variable {
	int varType;
	final static int MAX_NO = 5;
	static int MAX_NUM = 10;
	
	public static void main(String[] args){
		System.out.println(MAX_NO);
		System.out.println(MAX_NUM);
		
		//MAX_NO = 6;
		MAX_NUM = 11;
	}
	
	public final void showInfo() {
			System.out.println(varType);
	}
}

class Animal {
	public void breathe() {
		System.out.println("동물 호흡");
	}
}

class Person extends Animal {
	public static void main(String[] args) {
		Person human = new Person();
		human.breathe();
	}
}