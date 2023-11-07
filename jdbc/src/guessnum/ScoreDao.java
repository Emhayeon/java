package guessnum;//싱글톤

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

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
	
	private Connection getConnection() {
		
		try {
			Class.forName(DRIVER_NAME);
			Connection conn = DriverManager.getConnection(URL, ID, PW); 
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null; //참조형
	}
	
	private void closeAll(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		if(rs != null)try {rs.close();}catch(Exception e) {}
		if(conn != null)try {conn.close();}catch(Exception e){}
		if(pstmt != null)try {pstmt.close();}catch(Exception e){}
	}
	
	public boolean addScore(ScoreVo scoreVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {//순서기억하기
			
			conn = getConnection();
			StringBuffer sb = new StringBuffer(); //

//			sb.append("INSERT INTO TBL_SCORE(USERNAME, SCORE)");
//			sb.append("VALUES ('"+username+"',"+ score+")");//문장완성 1번작업 작은따옴표 주의
			
			sb.append("INSERT INTO TBL_SCORE(USERNAME, SCORE)");
			sb.append("VALUES (?, ?)");//문장완성 중요함 우리가 해야할것임!!!
			
			pstmt = conn.prepareStatement(sb.toString()); //엔터 -맨앞 PreparedStatement지움
			//데이터 바인딩: 1번작업 위에 처럼 따옴표 하기 번거로울때 데이터 바인딩 이방법 사용
			pstmt.setString(1, scoreVo.getUsername());//setSting 작은 따옴표를 자동을 붙임
			pstmt.setInt(2, scoreVo.getScore());
			
			//입력 ,수정, 삭제 작업 할때 는 executeUpdate();하면됨
			int count = pstmt.executeUpdate();
			if(count > 0) {
				return true;
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null,pstmt,conn);
		}
		return false;
	}
	//읽기
	public Vector<ScoreVo> getAll() {
		
		Connection conn = null; //필드에 빼면 안됨 각각 해야함
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn= getConnection();
			StringBuffer sb = new StringBuffer();
			sb.append("SELECT USERNAME, SCORE FROM TBL_SCORE");
			pstmt = conn.prepareStatement(sb.toString());
			rs = pstmt.executeQuery(); //쓰기 읽기 각각 쓰는 함수 다름 외워
			
			Vector<ScoreVo> vec = new Vector<>();
			while (rs.next()) {
				String username = rs.getString("USERNAME");
				int score = rs.getInt("SCORE");
				ScoreVo scoreVo = new ScoreVo();
				scoreVo.setUsername(username);
				scoreVo.setScore(score);
				vec.add(scoreVo);
			}
			return vec;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(rs,pstmt,conn);
		}
		return null; //벡터는 참조형이라 return null 해야함
	}
}//class
