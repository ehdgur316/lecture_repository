package com.paran.chapter18;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class ThrownDemo {
	public final static int SIZE = 100;
	/*
	 * Throws -> 이 메서드를 호출한 다른 메서드에서 예외를 처리할 것(예외 회피)
	 */
	public static void method() throws IOException {
		PrintWriter out = new PrintWriter(new FileWriter("OutFile.txt"));
		for (int i = 0; i < SIZE; i++) {
			// do something
		}
		out.close();
	}
	
	public static void main(String[] args) {
		/*
		 * 예외처리가 없을 때 Complie Error가 되는 이유
		 *  1. method에서 던진 예외를 처리하지 않음
		 *  2. method에서 선언된 throws가 checked exception
		 */
		try {
			method();
		} catch(IOException e) {
			System.err.println(e.getStackTrace().toString());
		}
	}
}