package guessnum;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class GameManager {
	private static GameManager instance = new GameManager();
	private GameManager() {
		/* singleton */
	}
	public static GameManager getInstance() {
		return instance;
	}
	// -------------------------------------------------------
	
	private int targetNum = 0;
	private int count = 5;
	public static final int RESULT_OK = 1;
	public static final int RESULT_BIG = 2;
	public static final int RESULT_SMALL = 3;
	
	public void init() {
		count = 5;
		targetNum = (int)(Math.random() * 100) + 1;
		 System.out.println("targetNum:" + targetNum);
	}
	
	public int getCount() {
		return count;
	}
	
	public int judge(int userNum) {
				count--;
		if (userNum == targetNum) {
			return RESULT_OK;
		} else if (userNum < targetNum) {
			return RESULT_BIG;
		} else {
			return RESULT_SMALL;
		}
	}
//	public void save(String recordTime) {
//		try {
//			BufferedWriter bw = new BufferedWriter(new FileWriter(recordTime));
//			StringBuffer sb = new StringBuffer();
//			bw.write(sb.toString());
//			bw.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//	
}