package ex02;//싱글톤

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ScoreDao {
	private static ScoreDao instance = new ScoreDao();
	private ScoreDao() {}
	public static ScoreDao getInstance() {
		return  instance;
	}
	public static final String DRIVER_NAME ="oracle.jdbc.driver.OracleDriver";
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	public static final String ID = "USER01";
	public static final String PW = "1234";
	
	public boolean addScore(String username, int score) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {//순서기억하기
			Class.forName(DRIVER_NAME);//메모리로딩
			conn = DriverManager.getConnection(URL, ID, PW); //접속- 맨앞Connection지움
			StringBuffer sb = new StringBuffer(); //

//			sb.append("INSERT INTO TBL_SCORE(USERNAME, SCORE)");
//			sb.append("VALUES ('"+username+"',"+ score+")");//문장완성 1번작업 작은따옴표 주의
			
			sb.append("INSERT INTO TBL_SCORE(USERNAME, SCORE)");
			sb.append("VALUES (?, ?)");//문장완성
			
			pstmt = conn.prepareStatement(sb.toString()); //엔터 -맨앞 PreparedStatement지움
			//데이터 바인딩: 1번작업 위에 처럼 따옴표 하기 번거로울때 데이터 바인딩 이방법 사용
			pstmt.setString(1, username);//setSting 작은 따옴표를 자동을 붙임
			pstmt.setInt(2, score);
			
			//입력 ,수정, 삭제 작업 할때 는 executeUpdate();하면됨
			int count = pstmt.executeUpdate();
			if(count > 0) {
				return true;
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null)try {pstmt.close();}catch(Exception e){}
			if(conn != null)try {conn.close();}catch(Exception e){}
		}
		return false;
	}
}
