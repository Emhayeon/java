package ex02;

public class StringBufferTest {

	public static void main(String[] args) {
		
		/*
		String s = "";
		long start = System.currentTimeMillis();
		for(int i = 0; i <10000; i++) {
			s +="Hello";
		}
		long end = System.currentTimeMillis();
		System.out.println("걸린시간:" + (end - start));
		*/
		StringBuffer s = new StringBuffer();
		long start = System.currentTimeMillis();
		for(int i = 0; i <1000000; i++) {
			s.append("Hello");
		}
		long end = System.currentTimeMillis();
		System.out.println("걸린시간:" + (end - start));
	}

}
