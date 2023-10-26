package ex01;

public class ForExample {

	public static void main(String[] args) {
		
		for (int count = 1;count <= 10;count++) {
		//(초기식;조건;실행후처리)
			System.out.println(count + ":Hello");
		}
		
		//1부터 10까지의 누적(쌓아나아감) 합계
		//1+2+3+....+10=?
		int sum = 0;
		
		for(int count = 1; count <= 10; count++) {
			sum += count; //sum = sum + count; //1
		}
		
		//sum +=2;
		//sum +=3;
		
		System.out.println("합계:" + sum);

		
		System.out.println("프로그램 종료");

	}

}
