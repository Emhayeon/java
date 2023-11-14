package guessnum2;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class ScoreDao {
	private static ScoreDao instance = new ScoreDao();
	private ScoreDao() { }
	public static ScoreDao getInstance() {
		return instance;
	}
	
	private static final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String ID = "USER01";
	private static final String PW = "1234";
	private static final int MIN_SCORE = 30000;
	
	private Connection getConnection() {
		try {
			Class.forName(DRIVER_NAME);
			Connection conn = DriverManager.getConnection(URL, ID, PW);
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private void closeAll(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		if (rs != null) try { rs.close(); } catch (Exception e) { }
		if (pstmt != null) try { pstmt.close(); } catch (Exception e) { }
		if (conn != null) try { conn.close(); } catch (Exception e) { }
	}
	
	public boolean addScore(ScoreVo scoreVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			StringBuffer sb = new StringBuffer();
			sb.append("INSERT INTO TBL_SCORE "
					+ "	(SCORE_ID, USER_ID, SCORE)");
			sb.append(" VALUES "
					+ "	(SEQ_SCORE_ID.NEXTVAL, ?, ?)");
			pstmt = conn.prepareStatement(sb.toString());
			// 데이터 바인딩
			pstmt.setString(1, scoreVo.getUserId()); // 작은따옴표를 자동으로 붙임
			pstmt.setInt(2, scoreVo.getScore());
			// 입력, 수정, 삭제 작업
			int count = pstmt.executeUpdate();
			if (count > 0) {
				System.out.println("데이터입력완료");
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}
		return false;
	}
	//신기록 기록하기
	public int getMinScore() {//신기록 다시보기
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String sql = "SELECT MIN(SCORE) AS MIN_SCORE FROM TBL_SCORE";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {//다시보ㅏ
				int minScore = rs.getInt("MIN_SCORE");
				return minScore;
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
		return MIN_SCORE;
		
	}
	
	// 읽기 기록보기 벡터 다시보기(쌤) //10개씩 끊어 보기 sql바뀌고 추가됨 다시봐
	
	public Vector<ScoreUserVo> getAll(RowNumDto rowNumDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			/*String sql ="SELECT U.USER_ID, U.USER_NAME, S.SCORE, S.REGDATE, G.GRADE --Į�� �߷�����\r\n"
					+ "FROM TBL_USER U, TBL_SCORE S, TBL_SCORE_GRADE G\r\n"
					+ "WHERE U.USER_ID = S.USER_ID\r\n"
					+ "AND S.SCORE BETWEEN G.LO_SCORE AND G.HI_SCORE\r\n"
					+ "ORDER BY S.SCORE ASC,U.USER_ID ASC ";*/
			String sql = "SELECT * FROM(SELECT ROWNUM RN, A.*"
					+ "					FROM (SELECT U.USER_ID, U.USER_NAME, S.SCORE, S.REGDATE, G.GRADE"
					+ "							FROM TBL_USER U, TBL_SCORE S, TBL_SCORE_GRADE G"
					+ "							WHERE U.USER_ID = S.USER_ID"
					+ "							AND S.SCORE BETWEEN G.LO_SCORE AND G.HI_SCORE"
					+ "							ORDER BY S.SCORE ASC,U.USER_ID ASC) A)"
					+ "		WHERE RN BETWEEN ? AND ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rowNumDto.getStartRow());
			pstmt.setInt(2, rowNumDto.getEndRow());
			rs = pstmt.executeQuery();
			Vector<ScoreUserVo> vec = new Vector<>();
			while (rs.next()) {
				String userId = rs.getString("USER_ID");
				String userName = rs.getString("USER_NAME");
				int score = rs.getInt("SCORE");
				Date regdate = rs.getDate("REGDATE");
				String grade = rs.getString("GRADE");
				ScoreUserVo scoreUserVo = new ScoreUserVo(userId, userName, score, regdate, grade);		
				vec.add(scoreUserVo);
			}
			return vec;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
		
		return null;
	}
	//전체 데이터 갯수
	public int getCount() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String sql = "SELECT COUNT(*) AS CNT FROM TBL_SCORE";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				int count = rs.getInt("CNT");
				return count;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
		return 0;
		
	}
	
	
	
	//기록보기 내가한거 오류남
	/*
	public Vector<ScoreUserVo> recordList(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn=getConnection();
			String sql ="SELECT U.USER_ID, U.USER_NAME, S.SCORE, S.REGDATE, G.GRADE"
					+ "FROM TBL_USER U, TBL_SCORE S, TBL_SCORE_GRADE G"
					+ "WHERE U.USER_ID = S.USER_ID"
					+ "AND S.SCORE BETWEEN G.LO_SCORE AND G.HI_SCORE"
					+ "ORDER BY S.SCORE ASC,U.USER_ID ASC";
			
			pstmt=conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			Vector<ScoreUserVo> suvec = new Vector<>();
			while(rs.next()) {
				String userId = rs.getString("USER_ID");
				String userName = rs.getString("USER_NAME");
				int score = rs.getInt("SCORE");
				Date regdate = rs.getString("REGDATE");
				String grade = rs.getString("GRADE");
				ScoreUserVo scoreuserVo = new ScoreUserVo();
				scoreuserVo.setUserId(userid);
				scoreuserVo.setUserName(username);
				scoreuserVo.setScore(score);;
				scoreuserVo.setRegdate(regdate);
				scoreuserVo.setGrade(grade);
				suvec.add(scoreuserVo);
			}
			return suvec;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
		return null;
	}
	*/
} // class