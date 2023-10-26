package ex02;


public class LottoMain {

	public static void main(String[] args) {
		//1~10 노란색
		//11~20 파란색
		//21~30 빨간
		//31~40 회색
		//41~45 녹색
//		LottoBall aBall =new LottoBall(1,"yellow");
//		aBall.showInfo();
		
		
		//공 45개 넣기
		LottoBall[] balls = new LottoBall[45];//{null,null,...,null}
//		System.out.println(balls[0]);
		
		
		//로또 1~45번 각각의 색 나타내기
		
		for (int i = 0; i < balls.length; i++) {
			String color = "";
			if(0 <= i && i < 10) {
				color = "yellow";
			}else if (10 <= i && i < 20){
				color = "Blue";
			}else if (20 <= i && i < 30){
				color = "red";
			}else if (30 <= i && i < 40){
				color = "gray";
			}else if (40 <= i && i < 45){
				color = "green";
			}
			balls[i] = new LottoBall(i + 1, color);
			
		}
		
		//섞기 -0번째 <- 임의의 위치 -> 스와핑 (데이터갯수 2배)		
		for(int i = 0; i < balls.length * 2; i++) {
			int rand = (int)(Math.random() * 44)+ 1; //1~44번째 위치 숫자아님
			LottoBall tempBall = balls[0];
			balls[0] = balls[rand];
			balls[rand] = tempBall;
		}
		/*
		for(LottoBall ball : balls) {
			ball.showInfo();
		}
		*/
		for (int i =0; i < 6; i++) {
			balls[i].showInfo();
		}

	}

}
