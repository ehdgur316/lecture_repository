package com.paran.chapter7;
public class Student {
	/*
	 * public, private - 접근한정자/지정자
	 * 멤버 변수나 함수의 접근 가능 범주를 제한하는 한정자(자세한 설명은 해당 챕터에서)
	 *  1. public - 전 지역에서 접근 가능한 멤버 변수 또는 함수
	 *  2. private - 내 class 내에서만 접근 가능한 멤버 변수 또는 함수
	 */
	String name;
	String stdID;
	protected boolean isMilSer;
	
	/*
	 * private instance 멤버 변수를 가진 class에 기본 생성자를 만들면 안되는 이유
	 *  private instance 멤버 변수를 Instance를 통해 재할당하는 것이 불가능
	 *  -> 값이 비어있는 Instance가 생성되고 그 값을 변경할 수 없어 사용 불가능한 Instance 생성
	 */
	// Default Constructor
	public Student() {
		
	}
	
	// User Constructor
	public Student(String name, String stdID, boolean isMilSer) {
		this.name = name;
		this.stdID = stdID;
		this.isMilSer = isMilSer;
	}
	
	public void showInfo() {
		System.out.println("이름 : " + name + ", 학번 : " + stdID);
	}
	
	/*
	 * private instance 멤버 변수에 접근하는 public 메서드 선언(setter 메서드)
	 *  -> 기본생성자 활용 가능
	 */
	public void setName(String name) {
		this.name = name;
	}
	public void setID(String stdID) {
		this.stdID = stdID;
	}
	public void setIsMilSer(boolean isMilSer) {
		this.isMilSer = isMilSer;
	}
	
	/*
	 * private instance 멤버 변수를 반환하는 public 메서드 선언(getter 메서드)
	 *  -> Student class 외에서 private instance 멤버 변수 접근 가능
	 */
	public String getName() {
		return this.name;
	}
	public String getID() {
		return this.stdID;
	}
	public boolean getIsMilSer() {
		return this.isMilSer;
	}
}