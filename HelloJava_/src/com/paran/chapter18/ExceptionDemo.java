package com.paran.chapter18;

import java.util.logging.Logger;

/*
 * 예외(Exception)
 *  프로그램 실행 중 발생한 비정상적 행위(Event)
 *  try-catch 또는 throws로 Handling 가능
 *  Error도 비슷한 개념이지만 예외는 아님
 *  비정상적인 흐름(Exception)에 대한 대응(Handling)을 정의하는 것
 *  
 *  Run Time Exception
 *   Unchecked Exception, 컴파일 과정에서는 알 수 없지만 실제 작동중에 발생하는 예외
 *   (대표적으로 IndexOutOfBounds Exception)
 *   Handling을 해도 되도 안해도 되는 예외(별다른 처리 없이 Complie은 가능)
 *   
 *  Complie Time Exception
 *   Checked Exception, 컴파일 과정에서부터 예외 처리를 요구하는 예외
 *   (대표적으로 IOException)
 *   반드시 Handling해야하는 예외(Complie 단계에서 반드시 try-catch로 처리 또는 throw해야 함)
 *   
 * 예외 전파(Exception Propagate)
 *  메서드가 중첩 호출되어 있는 상태에서 예외가 발생할 경우 (Stack 구조상)하위 메서드로 해당 예외를 전파
 *  하위 메서드에서 Handling이 가능한 예외일 경우 해당 메서드에서 처리
 *  하위 메서드에 Handling 가능한 Handler가 없으면 main 메서드까지 지속적으로 전파
 *  main 메서드에서 처리 불가시 Exception 오류 발생
 *  
 * 예외 처리(Exception Handling)
 *  try-catch block 또는 throws 선언을 메서드에 선언
 *  해당 예외 처리기(Exception Handler)가 처리할 수 있는 예외가 발생하면 처리
 *  발생한 예외가 예외 처리기에 선언된 예외의 하위 클래스일 경우 예외 처리기에서 처리 가능
 *  try-catch block에는 복수의 예외를 처리할 수 있도록 중복 catch 선언이 가능
 *  단, 계층 구조에 따라 하위 class의 예외를 상단에 기술할 것
 *  
 * throw와 throws
 *  throw는 예외를 던지는 행위 그 자체를 명시적으로 선언하는 것
 *   (throw new ArithmeticException("Exception occured");)
 *  throws는 메서드에 선언, 메서드에서 예외가 발생했을 경우 그 예외를 던지라는 선언
 *   (public static void main(String[] args) throws IOException {})
 *   
 * finally
 *  try-catch block에서 사용가능한 구문. catch 여부에 상관없이 무조건 실행됨
 *  주로 메모리 해제와 같은 동작을 선언하는 것을 권장함
 */
public class ExceptionDemo {
	private static final Logger log = Logger.getLogger(ExceptionDemo.class.getName());
	
	static void methodA() {
		/*
		 * try-catch에서 처리한 예외를 throws를 통해 Stack하위 메서드로 강제전파하는 것도 가능
		 * 또한, throws에 다시 try-catch를 씌워 throw의 예외 처리를 하는 것도 가능
		 */
		try{
			methodB();
		} catch(ArithmeticException aE) {
			System.out.println("Catch Arithmetic Exception");
			log.warning("Catch Arithmetic Exception");
			aE.printStackTrace();
			try {
				throw aE;
			} catch(Exception e) {
				e.printStackTrace();
			}
		} catch(Exception e){
			// to do something
			System.out.println("Catch All Exception");
			log.warning("Catch All Exception");
			e.printStackTrace();
			throw e;
		} 
	}
	
	static void methodB() {
		System.out.println("before calling methodC");
		methodC();
		System.out.println("after calling methodC");
	}
	
	static void methodC() {
		System.out.println("before exception occured");
		@SuppressWarnings("unused")
		int i = 0;
		i /= 0;
		System.out.println("after exception occured in methodC");
	}
	
	public static void main(String[] args) {
		methodA();
		System.out.println("main 정상종료");
	}
}