package ex03;

public class DivideByZero {

	public static void main(String[] args) {
		int num1 = 10;
		int num2 = 0;
		try {
			int result = num1 / num2;
			System.out.println(result);
		} catch (ArithmeticException e) {
			System.out.println("0으로 나눌 수 없어요.");
		} finally { //finally는 생략가능
			System.out.println("프로그램 종료");
		}
		
		

	}//main
	
	
	public static int calculate(int n1,int n2) throws ArithmeticException {
		return n1 / n2;
	}
	

}
