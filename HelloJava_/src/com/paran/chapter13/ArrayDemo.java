package com.paran.chapter13;

/**
 * 배열 값 설정 및 역순 재배치, 출력
 * @author ehdgur316
 */
public class ArrayDemo {
	public static void main(String[] args) {
		int[] numArr = new int[10];
		
		// 1부터 10까지 값을 가진 배열 생성 및 출력
		setArray(numArr);
		System.out.println("Original Array");
		printArray(numArr);
		
		// 1부터 10까지 값을 가진 배열의 값을 뒤집고 출력
		reverseArray(numArr);
		System.out.println("Reversed Array");
		printArray(numArr);
	}
	
	/**
	 * 매개변수 Array의 배열값을 설정<br/>
	 * 배열 값은 1부터 시작
	 * @param array 값을 설정할 배열
	 */
	public static void setArray(int[] array) {
		for (int i = 0 ; i < array.length ; i++) {
			array[i] = i + 1;
		}
	}
	
	/**
	 * 매개변수 Array의 배열값을 순차적으로 출력<br/>
	 * @param array 값을 출력할 배열
	 */
	public static void printArray(int[] array) {
		for (int num : array) {
			System.out.print(num + " ");
		}
		System.out.println();
	}
	
	/**
	 * Array에 설정되어 있는 값을 역순으로 재배치
	 * @param array 값을 역순 재배치할 배열
	 */
	public static void reverseArray(int[] array) {
		int targetNum;
		
		for (int i = 0 ; i < array.length / 2 ; i++) {
			targetNum = array[(array.length - 1) - i];
			array[(array.length - 1) - i] = array[i];
			array[i] = targetNum;
		}
	}
}
