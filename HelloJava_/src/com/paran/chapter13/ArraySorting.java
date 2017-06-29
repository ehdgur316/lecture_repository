package com.paran.chapter13;

/**
 * 버블 정렬을 사용한 배열 오름차순, 내림차순 정렬
 * @author ehdgur316
 */
public class ArraySorting {
	public static void main(String[] args) {
		// 정렬되지 않은 배열 생성 및 출력
		int[] nonSortedToIncArr = new int[] { 8, 1, 6, 4, 10, 7, 5, 2, 9, 3 };
		System.out.println("Non Sorted Array");
		printArray(nonSortedToIncArr);

		// 버블 정렬을 사용하여 주어진 배열을 오름차순으로 정렬
		bubbleSort(nonSortedToIncArr, true);
		System.out.println("Bubble Sorted(Inc) Array");
		printArray(nonSortedToIncArr);

		// 버블 정렬을 사용하여 주어진 배열을 내림차순으로 정렬
		int[] nonSortedToDecArr = new int[] { 8, 1, 6, 4, 10, 7, 5, 2, 9, 3 };
		bubbleSort(nonSortedToDecArr, false);
		System.out.println("Bubble Sorted(Dec) Array");
		printArray(nonSortedToDecArr);
	}

	/**
	 * 매개변수 Array의 배열값을 순차적으로 출력
	 * @param array 값을 출력할 배열
	 */
	public static void printArray(int[] array) {
		for (int num : array) {
			System.out.print(num + " ");
		}
		System.out.println();
	}
	
	/**
	 * Array 배열을 incSort에 따라 오름차순 또는 내림차순으로 정렬
	 * @param array 값을 정렬할 배치
	 * @param incSort 오름차순 또는 내림차순 설정
	 */
	public static void bubbleSort(int[] array, boolean incSort) {
		int tmpNum;
		
		for (int i = 1; i < array.length; i++) {
			if (incSort == true && array[i - 1] > array[i]) {
				tmpNum = array[i];
				array[i] = array[i - 1];
				array[i - 1] = tmpNum;
				i = 0;
			} else if (incSort == false && array[i - 1] < array[i]) {
				tmpNum = array[i];
				array[i] = array[i - 1];
				array[i - 1] = tmpNum;
				i = 0;
			}
		}
	}
}
