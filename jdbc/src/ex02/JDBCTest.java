package ex02;

import java.util.Scanner;

public class JDBCTest {
	private static ScoreDao dao = ScoreDao.getInstance();
	private static  Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		
		insertData();
		scanner.close();
		
	}
	
	private static void insertData() {
		System.out.print("이름:");
		String name = scanner.next();
		System.out.print("점수:");
		int score = scanner.nextInt();
		boolean result = dao.addScore(name, score);
		System.out.println("result:"+result);
	}

}
