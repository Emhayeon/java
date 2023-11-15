package sql_exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class sql_examDao {
	//싱글톤
	private static sql_examDao instance = new sql_examDao();
	private sql_examDao() {}
	public static sql_examDao getInstance() {
		return instance;
	}
	//접속 정보
	private static final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String ID = "SQL_EXAM";
	private static final String PW = "EXAM5678";
	
	protected Connection getConnection() {
		try {
			Class.forName(DRIVER_NAME);
			Connection conn = DriverManager.getConnection(URL, ID, PW);
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	protected void closeAll(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		if (rs != null) try { rs.close(); } catch (Exception e) { }
		if (pstmt != null) try { pstmt.close(); } catch (Exception e) { }
		if (conn != null) try { conn.close(); } catch (Exception e) { }
	}
	
	//입력
	public boolean addInput(sql_examVo examVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = this.getConnection();
			String sql = "INSERT INTO TBL_STUDENT"
					+ "		(SNO,SNAME,SYEAR,GENDER,MAJOR,SCORE)"
					+ "		VALUES(?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, examVo.getStudentid());
			pstmt.setString(2, examVo.getName());
			pstmt.setInt(3, examVo.getGrade());
			pstmt.setString(4, examVo.getGender());
			pstmt.setInt(5, examVo.getMajor());
			pstmt.setInt(6, examVo.getScore());
			int count = pstmt.executeUpdate();
			if(count > 0) {
				//System.out.println("데이터입력완료");
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
			
		}
		return false;
	}
	//수정
	public boolean update(sql_examVo examVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = this.getConnection();
			String sql ="UPDATE TBL_STUDENT "
					+ "  SET SNAME=?,SYEAR=?,GENDER=?,MAJOR=?,SCORE=?"
					+ "  WHERE SNO = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, examVo.getName());
			pstmt.setInt(2, examVo.getGrade());
			pstmt.setString(3, examVo.getGender());
			pstmt.setInt(4, examVo.getMajor());
			pstmt.setInt(5, examVo.getScore());
			pstmt.setString(6, examVo.getStudentid());
			
			
			int count = pstmt.executeUpdate();
			if(count > 0){
				return true;
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}
		return false;
	}
	//수정한값 가져오기
	public boolean getinfo() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = this.getConnection();
			String sql ="SELECT SNO,SNAME,SYEAR,GENDER,MAJOR,SCORE ";
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
		return false;
	}
	//삭제
	public boolean delete(String name) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn= this.getConnection();
			String sql = "DELETE FROM TBL_STUDENT WHERE SNAME=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			int count = pstmt.executeUpdate();
			if(count > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}
		return false;
	}
	//조회
	public Vector<sql_examVo> getAll(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = this.getConnection();
			String sql = "SELECT SNO,SNAME,SYEAR,GENDER,MAJOR,SCORE "
					+ "		FROM TBL_STUDENT";
			pstmt = conn.prepareStatement(sql);
			rs= pstmt.executeQuery();
			Vector<sql_examVo> vec = new Vector<>();
			while(rs.next()) {
				String stdentid = rs.getString("SNO");
				String name = rs.getString("SNAME");
				int grade = rs.getInt("SYEAR");
				String gender = rs.getString("GENDER");
				int major = rs.getInt("MAJOR");
				int score = rs.getInt("SCORE");
				sql_examVo examVo = new sql_examVo(stdentid, name, grade, gender, major, score);
				vec.add(examVo);
			}
			return vec;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
		return null;
	}
	
	
}
