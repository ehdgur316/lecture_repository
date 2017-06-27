package com.paran.chapter5;

import java.util.Scanner;

public class SwitchDemo {
	public static void main(String[] args) {	
		Scanner monthScanner = new Scanner(System.in);
		int month = monthScanner.nextInt();
		//int month = 10;
		String monthString = "";
		String quarter = "";
		
		/*
		 * switch 조건문 - 다른 조건문의 조합으로도 구현 가능
		 */
		switch(month) {
		case 1 :
			monthString = "January";
			break;
		case 2 : 
			monthString = "Febuary";
			break;
		case 3 : 
			monthString = "March";
			break;
		case 4 : 
			monthString = "April";
			break;
		case 5 : 
			monthString = "May";
			break;
		case 6 : 
			monthString = "June";
			break;
		case 7 : 
			monthString = "July";
			break;
		case 8 : 
			monthString = "August";
			break;
		case 9 : 
			monthString = "September";
			break;
		case 10 : 
			monthString = "October";
			break;
		case 11 : 
			monthString = "November";
			break;
		case 12 : 
			monthString = "December";
			break;
		default :
			monthString = "Invalid Month";
			// default 구문(맨 아래에 위치)에는 break;가 불필요 
		}
		
		switch(month) {
		case 1 : 
		case 2 : 
		case 3 :
			quarter = "1/4";
			break;
		case 4 : 
		case 5 : 
		case 6 :
			quarter = "2/4";
			break;
		case 7 : 
		case 8 : 
		case 9 :
			quarter = "3/4";
			break;
		case 10 : 
		case 11 : 
		case 12 :
			quarter = "4/4";
			break;
		default :
			quarter = "Invalid Quarter";
		}
		
		System.out.println("Switch - " + monthString + ", " + quarter);
		
		/*
		 * 상단의 Switch 구문을 if-else 구문으로 치환한 결과
		 */
		if ( month == 1 ) monthString = "January";
		else if ( month == 2 ) monthString = "Febuary";
		else if ( month == 3 ) monthString = "March";
		else if ( month == 4 ) monthString = "April";
		else if ( month == 5 ) monthString = "May";
		else if ( month == 6 ) monthString = "June";
		else if ( month == 7 ) monthString = "July";
		else if ( month == 8 ) monthString = "August";
		else if ( month == 9 ) monthString = "September";
		else if ( month == 10 ) monthString = "October";
		else if ( month == 11 ) monthString = "November";
		else if ( month == 12 ) monthString = "December";
		else monthString = "Invalid Month";
		
		if ( month >= 1 && month <= 3) quarter = "1/4";
		else if ( month >= 4 && month <= 6) quarter = "2/4";
		else if ( month >= 7 && month <= 9) quarter = "3/4";
		else if ( month >= 10 && month <= 12) quarter = "4/4";
		else quarter = "Invalid Quarter";

		System.out.println("if-else - " + monthString + ", " + quarter);
		
		monthScanner.close();
	}
}
