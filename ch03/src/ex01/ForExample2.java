package ex01;

public class ForExample2 {

	public static void main(String[] args) {
		
		int sumOdd = 0; //홀수의합
		int sumEven =0; //짝수의합
		
		for (int count = 1; count <= 100; count++) {
			if(count % 2 ==1) {//홀수라면
				sumOdd += count;
			} else {//짝수라면
				sumEven += count;
			}
		}
		System.out.println("홀수의합: "+sumOdd);
		System.out.println("짝수의합: "+sumEven);
		System.out.println("전체합: "+(sumOdd+sumEven));

	}

}
