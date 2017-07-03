package com.paran.chapter21;

import java.util.ArrayList;
import java.util.List;

/*
 * 각 학생(8명)에게 개인정보를 부여하는 방법
 *  생성자 함수를 선언하여 값을 대입하거나 Getter Setter 함수 사용
 */

/*
 * 목표 2. 각 학생의 등수를 가지고 있는 class를 생성, 관리
 */
public class ClassInfo {
	/*
	 * Generic Class
	 * stdList 안에는 DomeStudent, ForeStudent 두 가지 타입의 변수 할당
	 * IS-A 관계의 변수를 모두 포함할 수 있는 복합자료체 Generic
	 */
	List<Student> stdList = new ArrayList<Student>();
	public void initStudent() {
		stdList.add(new DomeStudent());
		stdList.add(new DomeStudent());
		stdList.add(new DomeStudent());
		stdList.add(new DomeStudent());
		stdList.add(new ForeStudent());
		stdList.add(new ForeStudent());
		stdList.add(new ForeStudent());
		stdList.add(new ForeStudent());
	}
}

/*
 * abstract class -> Instance 생성이 불가능한 class
 */
abstract class Student {
	private String name;
	private String stdID;
	
	public abstract void showInfo(); // abstract method -> 구현체가 없이 선언만 되어있는 메서드
	
	/*
	 * private 선언된 name과 stdID에 접근하는 getter, setter 메서드
	 */
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStdID() {
		return stdID;
	}
	public void setStdID(String stdID) {
		this.stdID = stdID;
	}
	
}
/*
 * 목표 1. txt 파일로부터 값(이름, 학번, 국/영/수 점수, 내/외국인 구분, 주민/외국인 번호)을 읽어
 * 각 학생별로 정보를 채워넣는 코드 작성
 */
class DomeStudent extends Student {
	private String resiID;
	@Override
	public void showInfo() {
		// TODO Auto-generated method stub
		System.out.println("Name => " + getName() + ", Std ID => " + getStdID() +
												", Residence ID => " + resiID);
	}
}

class ForeStudent extends Student {
	private String foreignID;
	@Override
	public void showInfo() {
		// TODO Auto-generated method stub
		System.out.println("Name => " + getName() + ", Std ID => " + getStdID() +
												", Foreign ID => " + foreignID);
	}
}