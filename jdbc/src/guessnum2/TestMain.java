package guessnum2;

public class TestMain {
	private static ScoreDao scoreDao = ScoreDao.getInstance();
	public static void main(String[] args) {
		// insertTestData();
		getCount();
	}
	
	private static void getCount() {
		int count = scoreDao.getCount();
		System.out.println("count: " + count);
	}
	
	private static void insertTestData() {
		for (int i = 1; i <= 100; i++) {
			ScoreVo scoreVo = new ScoreVo(null, "hong", 15000 + i, null);
			scoreDao.addScore(scoreVo);
		}
	}

}