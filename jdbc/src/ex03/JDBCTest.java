package ex03; //다오랑 브이오를 이용해서 데이터 가져오기

import java.util.Scanner;
import java.util.Vector;

public class JDBCTest {
	private static ScoreDao dao = ScoreDao.getInstance();
	private static  Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		
		//insertData();
		readData();
		scanner.close();
		
	}
	  
	
	private static void readData() {
		Vector<ScoreVo> vec = dao.getAll();
		for(ScoreVo scoreVo : vec) {
			String username = scoreVo.getUsername();
			int score = scoreVo.getScore();
			System.out.println(username + " | " + score);
		}
	}


	private static void insertData() {
		System.out.print("이름:");
		String name = scanner.next();
		System.out.print("점수:");
		int score = scanner.nextInt();
		ScoreVo scoreVo = new ScoreVo();
		scoreVo.setUsername(name);
		scoreVo.setScore(score);
		boolean result = dao.addScore(scoreVo);
		System.out.println("result:"+result);
	}

}
