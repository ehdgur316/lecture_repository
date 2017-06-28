package com.paran.chapter7;

/*
 *  외부 패키지의 class를 가져오는 방법 - import
 *  단, 서로 다른 패키지에서는 public class만 가져올 수 있음
 */
// com.paran.chapter5 패키지 내에 있는 Student class import
import com.paran.chapter5.Student;

public class ClassInstanceDemo {
	@SuppressWarnings("unused") // if 조건문 내의 Dead Code 경고 비활성화
	public static void main(String[] args) {
		/*
		 * Null로 초기화한 Reference 변수에 접근할 경우
		 *  Compile 단계 오류 없음. Runtime 단계 NullPointerException 발생
		 */
		Student obj = null;
		// if 조건을 활용한 NullPointerException 검사
		if ( obj != null ) System.out.println(obj.getIsMilSer());
	}
}
