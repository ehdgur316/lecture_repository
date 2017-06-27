package com.paran.chapter5;

import java.util.Scanner;

public class SwitchDemo {
	public static void main(String[] args) {	
		Scanner monthScanner = new Scanner(System.in);
		int month = monthScanner.nextInt();
		//int month = 10;
		String monthString = "";
		
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
			break;
		}
		
		System.out.println(monthString);
		monthScanner.close();
	}
}
