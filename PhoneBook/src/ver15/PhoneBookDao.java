package ver15;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;

public class PhoneBookDao {
	//싱글톤
	private static PhoneBookDao instance = new PhoneBookDao();
	private PhoneBookDao() {}
	public static PhoneBookDao getInstance() {
		return instance;
	}
	public static final String DRIVER_NAME ="oracle.jdbc.driver.OracleDriver";
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	public static final String ID = "USER01";
	public static final String PW = "1234";
	
	private Connection getConnection() {
		try {
			Class.forName(DRIVER_NAME);
			Connection conn = DriverManager.getConnection(URL,ID,PW);
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	private void closeAll(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		if(rs != null)try {rs.close();}catch(Exception e) {}
		if(conn != null)try {conn.close();}catch(Exception e){}
		if(pstmt != null)try {pstmt.close();}catch(Exception e){}
	}
	//입력
	public boolean InputFunction(PhoneInfo info) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			StringBuffer sb = new StringBuffer();
			sb.append("INSERT INTO TBL_PHONEINFO(NAME,PHONE_NUMBER,BIRTHDAY,SC_NAME,SC_TYPE)");
			sb.append("VALUES(?,?,?,?,?)");
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1,info.getName());
			pstmt.setString(2, info.getPhoneNumber());
			pstmt.setString(3, info.getBirthDay());
			pstmt.setString(4, );
			String schoolOrCompanyName = "";
			if (info instanceof PhoneInfoSchool) {
				schoolOrCompanyName = ((PhoneInfoSchool)info).getSchool();
			} else {
				schoolOrCompanyName = ((PhoneInfoCompany)info).getCompany();
			}
			
			
			
			int count = pstmt.executeUpdate();
			if(count > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(null,pstmt,conn);
			
		}
		return false;
	}
	//수정
	public void UpdateFunction(PhoneBook pb) {
		
		
		try {
			Connection conn = getConnection();
			StringBuilder sb = new StringBuilder();
			sb.append("UPDATE TBL_PHONEINFO SET");
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
		}
	}
	//삭제
	//전체조회
	//검색
	
}
