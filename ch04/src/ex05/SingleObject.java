package ex05;

public class SingleObject {
	
	// Lazy Loading (지연 로딩)
	
	private static SingleObject instance;
	
	private SingleObject() {  }
	
	public static SingleObject getInstance() { 
		if (instance == null) {
			instance = new SingleObject();
		}
		
		return instance;
	}
	
	/*
	// Simple Version
	private static SingleObject instance = new SingleObject();
	private SingleObject() {
		System.out.println("객체 생성을 했어요");
	}
	public static SingleObject getInstance() { 
		return instance;
	}
	*/
	
}