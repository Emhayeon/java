package ex01;

public class RandomEx {

	public static void main(String[] args) {
		
		for (int count = 1; count <= 100; count++) {
		double n = Math.random();
		
		n *= 10;
		//n=(int)n;
		n += 1;//1~10임의의수 
		
		//공식 : (int)(math.random()*갯수) + 시작값
		//ex 주사위 : (int)(math.random()*6) + 1
		//ex 가위바위보 : (int)(math.random()*3) + 1
		//ex 501~1000: int n =(int)(math.random()*500)+501
		//             ㄴ system.out.ptintIn(n);
		//우리반인원13명: int m = (int)(math.random()*13)+1
		 //            ㄴ system.out.ptintIn(m);
		System.out.println((int)n);
		
		
		
		}//for
		
	}//main

}//class
