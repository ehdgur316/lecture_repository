package com.paran.chapter13;

public class ArrayDemo {
	public static void main(String[] args) {
		int[] numArr = new int[10];
		
		for (int i = 0 ; i < numArr.length ; i++) {
			numArr[i] = i + 1;
		}
		printArray(numArr);
		
		reverseArray(numArr);
		printArray(numArr);
	}
	
	public static void reverseArray(int[] array) {
		int targetNum;
		
		for (int i = 0 ; i < array.length / 2 ; i++) {
			targetNum = array[(array.length - 1) - i];
			array[(array.length - 1) - i] = array[i];
			array[i] = targetNum;
		}
	}
	
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
}
