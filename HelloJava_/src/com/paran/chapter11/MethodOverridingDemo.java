package com.paran.chapter11;

public class MethodOverridingDemo {

}

class Animal {
	public static void testClassMethod() {
		System.out.println("The static method in Animal");
	}
	public void testInstanceMethod() {
		System.out.println("The instance method in Animal");
	}
}

class Cat extends Animal {
	public static void testClassMethod() {
		System.out.println("The static method in Cat");
	}
	public void testInstanceMethod() {
		System.out.println("The instance method in Cat");
	}
	
	public static void main(String[] args) {
		Cat myCat = new Cat();
		Animal myAnimal = myCat;
		
		// Instance에서 Class Method 호출 -> 권장하지 않음(경고)
		myCat.testClassMethod();
		myAnimal.testClassMethod();
		Animal.testClassMethod();
		myAnimal.testInstanceMethod();
	}
}