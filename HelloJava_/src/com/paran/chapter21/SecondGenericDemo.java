package com.paran.chapter21;

import java.util.ArrayList;
import java.util.List;

public class SecondGenericDemo {
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Object refObj;
		/*
		 * 각각의 interface, class의 reference type 변수 선언
		 *  단, Generic Type을 Low Type으로 생성(Type Argument 없음)하면 런타임 에러 발생
		 *  
		 * 현재의 구조에서 refApple(또는 refMango) IS-A refFruit
		 * refFruit IS-A refPlants 관계가 성립
		 */
		Plants refPlants;
		Fruit<Seed> refFruit;
		//Fruit<Leaf> refFruitLeaf;
		Apple<Seed, String> refApple = new Apple<>(new Seed(), "Apple");
		Mango<Seed> refMango = new Mango<>(new Seed());
		
		
		/*
		 * 세 reference 변수끼리 IS-A 관계가 성립하기 때문에 모두 할당 가능
		 *  Apple이 <Seed, String> Generic Type이 된다 해도 Seed를 갖고 있으므로
		 *  마찬가지로 Seed를 갖고있는 부모 클래스인 Fruit reference 변수로 할당 가능
		 */
		refFruit = refApple;
		refPlants = refFruit;
		refPlants = refApple;
		refPlants = refMango;
		
		// Leaf를 갖고있는 refFruitLeaf에 Leaf를 가지고있지 않은 Apple을 할당하는 것은 불가능
		//refFruitLeaf = refApple;
		
		// 모든 class, interface의 상위 class Object에는 모든 객체를 할당 가능
		refObj = refPlants;
		
		/*
		 *  와일드카드 ?의 단점 -> 요소를 추가하는 행위가 제한적(null은 넣을 수 있음)
		 *   Generic Type이 어떤 타입인지 알 수 없음
		 *   Helper Method를 사용하는 것으로 와일드카드의 문제를 해결할 수는 있음
		 */
		@SuppressWarnings("unused")
		List<?> ref = new ArrayList<String>();
		//ref.add("New String");
	}
}

interface Plants {
	public int photosynthesize(int amountOfCO2);
}

class Fruit<T> implements Plants {
	public T seedType;
	@Override
	public int photosynthesize(int amountOfCO2) {
		// TODO Auto-generated method stub
		return amountOfCO2;
	}
}

class Apple<T extends Seed, S> extends Fruit<Seed> {
	public S var;
	public Apple(T seedType) {
		this.seedType = seedType;
	}
	
	public Apple(T seedType, S var) {
		this.seedType = seedType;
		this.var = var;
	}
}

class Mango<T extends Seed> extends Fruit<Seed> {
	public Mango(T seedType) {
		this.seedType = seedType;
	}
}

class Seed {
	
}

class Leaf {
	
}