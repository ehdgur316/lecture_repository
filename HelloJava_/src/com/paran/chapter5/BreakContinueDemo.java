package com.paran.chapter5;

public class BreakContinueDemo {
	public static void main(String[] args) {
		int count = 10;
		for (int i = 0 ; i < count ; i++) {
			/*
			 * continue 구문 사용(i가 0이거나 2의 배수가 아닐 때 조건문으로 복귀
			 *                   = i가 0이 아니고 2의 배수일 때 출력)
			 */
			if ( i == 0 || i % 2 != 0 ) continue;
			//System.out.println("2의 배수 " + i);
			// if ( i != 0 && i % 2 == 0 ) System.out.println("2의 배수 " + i);
			
			/*
			 * break 구문 사용(i가 0이 아니고 5의 배수일 때 loop를 빠져나옴)
			 */
			//if ( i != 0 && i == 5 ) break;
		}
		/*
		 * 2중 for 구문에서의 break
		 */
		int forCount = 3;
		for (int i = 1 ; i < forCount ; i++) {
			for (int j = 1 ; j < forCount ; j++) {
				if ( i == 2 ) break;
				System.out.println(i + " X " + j + " = " + i * j);
			}
		}
	}
}
