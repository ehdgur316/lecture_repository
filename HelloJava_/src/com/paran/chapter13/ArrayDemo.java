package com.paran.chapter13;

/**
 * for-each 구문을 활용한 배열 값 설정 및 역순 재배치, 출력
 * @author ehdgur316
 */
public class ArrayDemo {
	public static void main(String[] args) {
		int[] numArr = new int[10];
		
		setArray(numArr);
		printArray(numArr);
		
		reverseArray(numArr);
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
	 * Array의 시작 값과 끝 값의 크기를 비교하여<br/>
	 * 순차증가 배열이면 Original Array,<br/>
	 * 순차감소 배열이면 Reversed Array를 출력하고<br/>
	 * 매개변수 Array의 배열값을 순차적으로 출력<br/>
	 * @param array 값을 출력할 배열
	 */
	public static void printArray(int[] array) {
		if (array[0] < array[array.length - 1]) {
			System.out.println("Original Array");
		} else {
			System.out.println("Reversed Array");
		}
		
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
