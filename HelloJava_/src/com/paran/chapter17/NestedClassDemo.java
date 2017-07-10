package com.paran.chapter17;

/*
 * Nested Inner Class에서의 Private Member 접근
 *  자세한 설명은 Inner Class 내용 때
 *  private와 Inner Class의 선언 위치가 같음 -> 같은 멤버로 간주
 *  Inner Class의 경우 private 접근 지정자 선언이 가능
 */
public class NestedClassDemo {
	private int age;
	class InnerClass {
		public void showAge() {
			System.out.println(age);
		}
	}
}
