package ex02;

import java.util.Scanner;

public class GuessNum {
	
	public static final Scanner scanner = new Scanner(System.in);
	public static int[] records = new int[5];
	public static int count = 5;
	public static int targetNum = 0;
	
	public static void main(String[] args) {
		// Scanner scanner = new Scanner(System.in);
		//int[] records = {30000, 30000, 30000, 30000, 30000};
		// int[] records = new int[5]; // {0, 0, 0, 0, 0}
		// int count = 5;
		initRecords();
		// showRecords(records);
		targetNum = makeTargetNum();
		System.out.println("targetNum:" + targetNum);
		showRule();
		runGame();
		
		
		System.out.println("기회를 모두 소진하였습니다.");
		
		scanner.close();
	} // main
	
	public static void runGame() {
		while(true) {
			//System.out.println("for");
			int userNum = inputData();
			judge(targetNum, userNum);
			count--;
			if (count == 0) {
				break;
			}
			System.out.println("남은 기회는 " + count + "번 입니다.");
		}
	}
	
	public static int makeTargetNum() {
		int targetNum = (int)(Math.random() * 100) + 1;
		return targetNum;
	}
	
	public static void judge(int targetNum, int userNum) {
		if (targetNum == userNum) {
			System.out.println("정답입니다.");
		} else if (targetNum > userNum) {
			System.out.println(userNum + "보다 큽니다.");
		} else {
			System.out.println(userNum + "보다 작습니다.");
		}
	}
	
	public static int inputData() {
		System.out.print("입력:");
		int num = scanner.nextInt();
		return num;
	}
	
	// 시작 메시지(게임 규칙) 출력하기
	public static void showRule() {
		System.out.println("===== 1 ~ 100 사이의 임의의 수를 맞춰 보세요 =====");
		System.out.println("----- 기회는 5번 입니다. -----");
	}
	
	/**
	 * 기록을 30000으로 초기화하기
	 * @param records 점수 기록 배열
	 */
	public static void initRecords() {
		for (int i = 0; i < records.length; i++) {
			records[i] = 30000; // 넣기
		}
	}
	
	// 기록 보여주기
	public static void showRecords(int[] records) {
		for (int aRecord : records) { // 읽기
			System.out.print(aRecord + " ");
		}
	}
		
}