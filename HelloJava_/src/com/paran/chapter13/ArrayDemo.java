package com.paran.chapter13;

/**
 * 배열 값 설정 및 역순 재배치, 출력
 * @author ehdgur316
 */
public class ArrayDemo {
	int[][] dataMatrixArray;
	/**
	 * 2차원 행렬을 정해진 값으로 채워 초기화.<br/>
	 * 정해진 값은 1부터 순차적으로 증가하는 행렬
	 * @param firstDimSize 2차원 행렬의 행의 크기
	 * @param secondDimSize 2차원 행렬의 열의 크기
	 */
	public void initMatrixArray(int firstDimSize, int secondDimSize){
		// nXn Matrix 형태. {{}, ...}, ... 형태로도 초기화 가능
		dataMatrixArray = new int[firstDimSize][secondDimSize];
		// 배열의 길이를 확인하여 Index 제어 -> NullPointerException 회피
		for (int i = 0 ; i < dataMatrixArray.length ; i++) {
			for (int j = 0 ; j < dataMatrixArray[i].length ; j++) {
				dataMatrixArray[i][j] = i * dataMatrixArray[i].length + j + 1;
			}
		}
	}
	
	/**
	 * 행렬의 형태를 무시하고 변형 이차원 행렬 생성
	 */
	public void transformArray(){
		dataMatrixArray[3] = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
	}
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
		
		// 2차원 행렬 생성
		ArrayDemo matrixArray = new ArrayDemo();
		matrixArray.initMatrixArray(4, 4);
		
		// 2차원 행렬의 형태 변형(4X4에서 3X4 + 1X8 조합배열로)
		matrixArray.transformArray();
		
		// 2차원 행렬 출력
		for (int i = 0 ; i < matrixArray.dataMatrixArray.length ; i++) {
			for (int j = 0 ; j < matrixArray.dataMatrixArray[i].length ; j++) {
				System.out.print(matrixArray.dataMatrixArray[i][j] + "\t");
			}
			System.out.println();
		}
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
