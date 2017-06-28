package com.paran.chapter8;

/*
 *  class 누락 변수에 ctrl + shift + O 입력 -> 해당 class를 자동으로 import
 *  해당 class의 이름이 복수로 존재할 경우 선택 창을 보여줌
 */
//import com.paran.chapter5.Student;

public class PackageDemo {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		/*
		 * import 이외의 방법으로 다른 Package 내의 class에 접근하는 방법
		 *  import 없이 Package의 경로를 모두 지정해줘도 사용 가능
		 *  (비정상적인 사용방법)
		 */
		com.paran.chapter5.Student obj = new com.paran.chapter5.Student();
		//Student obj1 = new Student();
	}
}
