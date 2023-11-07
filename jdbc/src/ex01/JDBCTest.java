package ex01;

import java.sql.Connection;//접속된객체(세션 -session)
import java.sql.DriverManager;//접속시도
import java.sql.PreparedStatement;//SQL문장을 실행할 객체
import java.sql.ResultSet;//결과가 담겨 있는 객체

public class JDBCTest {
	
	public static final String DRIVER_NAME ="oracle.jdbc.driver.OracleDriver";
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	public static final String ID = "USER01";
	public static final String PW = "1234";
	
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		
		try {
			//SQL Plus 띄운다.- 메모리에 오라클 드라이버를 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2.접속-conn system/1234
			conn = DriverManager.getConnection(URL, ID, PW);
			//3.SQL 문자 작성
			String sql = "SELECT SYSDATE FROM DUAL";
			//4.엔터칠 객체 얻어옴
			pstmt = conn.prepareStatement(sql);
			System.out.println("conn:"+conn);
			//5.엔터를 치게 한다.
			rs = pstmt.executeQuery();
			//->6.결과 도출.. rs에 결과 들어있음
			if(rs.next() == true) {
				String result = rs.getString("SYSDATE");
				System.out.println("result:"+result);
			}else {
				System.out.println("결과없음");
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		
		} finally {
			if(rs != null) try {rs.close();}catch(Exception e) {}
			if(pstmt != null) try {pstmt.close();}catch(Exception e) {}
			if(conn != null) try {conn.close();}catch(Exception e) {}
		}
	}

}
