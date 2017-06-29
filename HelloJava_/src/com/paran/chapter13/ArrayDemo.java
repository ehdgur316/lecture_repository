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
	
	/**
	 * Array 배열을 incSort에 따라 오름차순 또는 내림차순으로 정렬
	 * @param array 값을 정렬할 배치
	 * @param incSort 오름차순 또는 내림차순 설정
	 */
	public static void bubbleSort(int[] array, boolean incSort) {
		int tmpNum;
		int sortLoop = array.length;
		
		while (sortLoop != 1) {
			for (int i = 1; i < array.length; i++) {
				if (incSort == true && array[i - 1] > array[i]) {
					tmpNum = array[i];
					array[i] = array[i - 1];
					array[i - 1] = tmpNum;
				} else if (incSort == false && array[i - 1] < array[i]) {
					tmpNum = array[i];
					array[i] = array[i - 1];
					array[i - 1] = tmpNum;
				}
			}
			sortLoop--;
		}
	}
}
