package com.paran.chapter13;

/**
 * 정렬을 사용한 배열 오름차순, 내림차순 정렬
 * @author ehdgur316
 */
public class ArraySorting {
	public static void main(String[] args) {
		// 정렬되지 않은 배열 생성 및 출력
		int[] nonSortedArr = new int[] { 8, 1, 6, 4, 10, 7, 5, 2, 9, 3 };
		System.out.println("Non Sorted Array");
		printArray(nonSortedArr);

		// 버블 정렬을 사용하여 주어진 배열을 오름차순으로 정렬
		int[] bubbleIncSortArr = new int[nonSortedArr.length];
		copyArray(nonSortedArr, bubbleIncSortArr);
		bubbleSort(bubbleIncSortArr, true);
		System.out.println("Bubble Sorted(Inc) Array");
		printArray(bubbleIncSortArr);

		// 버블 정렬을 사용하여 주어진 배열을 내림차순으로 정렬
		int[] bubbleDecSortArr = new int[nonSortedArr.length];
		copyArray(nonSortedArr, bubbleDecSortArr);
		bubbleSort(bubbleDecSortArr, false);
		System.out.println("Bubble Sorted(Dec) Array");
		printArray(bubbleDecSortArr);
		
		// 삽입 정렬을 사용하여 주어진 배열을 오름차순으로 정렬
		int[] selectIncSortArray = new int[nonSortedArr.length];
		copyArray(nonSortedArr, selectIncSortArray);
		selectionSort(selectIncSortArray, true);
		System.out.println("Selection Sorted(Inc) Array");
		printArray(selectIncSortArray);
		
		// 삽입 정렬을 사용하여 주어진 배열을 오름차순으로 정렬
		int[] selectDecSortArray = new int[nonSortedArr.length];
		copyArray(nonSortedArr, selectDecSortArray);
		selectionSort(selectDecSortArray, false);
		System.out.println("Selection Sorted(Dec) Array");
		printArray(selectDecSortArray);
	}
	
	/**
	 * 주어진 배열을 복사하여 다른 배열에 대입
	 * @param srcArray 값이 주어진 배열
	 * @param destArray 복사하여 값을 대입할 배열
	 */
	public static void copyArray(int[] srcArray, int[] destArray) {
		for (int i = 0; i < srcArray.length ; i++) {
			destArray[i] = srcArray[i];
		}
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
	 * Array 배열을 Bubble Sort Algorithm을 사용하여<br/>
	 * incSort에 따라 오름차순 또는 내림차순으로 정렬
	 * @param array 값을 정렬할 배열
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
	
	/**
	 * Array 배열을 Selection Sort Algorithm을 사용하여<br/>
	 * incSort에 따라 오름차순 또는 내림차순으로 정렬
	 * @param array 값을 정렬할 배열
	 * @param incSort 오름차순 또는 내림차순 설정
	 */
	public static void selectionSort(int[] array, boolean incSort) {
		int[] targetNum;
		int tmpNum;

		for (int i = 0; i < array.length; i++) {
			targetNum = new int[] { array[i], i };
			for (int j = i; j < array.length; j++) {
				if (incSort == true && targetNum[0] > array[j]) {
					targetNum[0] = array[j];
					targetNum[1] = j;
				} else if (incSort == false && targetNum[0] < array[j]) {
					targetNum[0] = array[j];
					targetNum[1] = j;
				}
			}
			tmpNum = array[targetNum[1]];
			array[targetNum[1]] = array[i];
			array[i] = tmpNum;
		}

	}
	
	public static void radixSort(int[] array) {
		int exponent = 0;
		
		radixSort(array, exponent + 1);
	}
	
	public static void radixSort(int[] array, int exponent) {
		
		radixSort(array, exponent + 1);
	}
}