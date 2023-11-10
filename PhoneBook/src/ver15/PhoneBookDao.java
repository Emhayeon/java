package ver15;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JFrame;

public class PhoneBookDao {
	//싱글톤
	private static PhoneBookDao instance = new PhoneBookDao();
	private PhoneBookDao() {}
	public static PhoneBookDao getInstance() {
//		new PhoneBookDao();
		return instance;
	}
	//접속 정보 -복사해서 써도됨
	private static final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String ID = "USER01";
	private static final String PW = "1234";
	private static final int SCHOOL_TYPE = 1;
	private static final int COMPANY_TYPE = 2;
	
	//접속메서드
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
	//닫기메서드
	private void closeAll(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		if(rs != null)try {rs.close();}catch(Exception e) {}
		if(conn != null)try {conn.close();}catch(Exception e){}
		if(pstmt != null)try {pstmt.close();}catch(Exception e){}
	}
	//입력기능 - INSERT
	public boolean addInfo(PhoneInfo info) {
		Connection conn = null; //닫아야하니깐 선언하고 시작
		PreparedStatement pstmt = null;
		try {
//			//1.SQL Command Line 띄우기
//			getClass().forName(DRIVER_NAME);
			//2.접속( conn USER01/1234)
			conn = this.getConnection();//접속 메서드만듬
			//3.쿼리문 작성
//			String sql = "INSERT INTO 테이블명(컬럼명1,...)"+"VALUES(값1,...)";
			String sql = "INSERT INTO TBL_PHONEINFO (NAME,PHONE_NUMBER,BIRTHDAY,SC_NAME,SC_TYPE)"+"VALUES(?,?,?,?,?)";
//			StringBuffer sb = new StringBuffer(); 이렇게 해도됨
//			sb.append("INSERT INTO TBL_PHONEINFO(NAME,PHONE_NUMBER,BIRTHDAY,SC_NAME,SC_TYPE)");
//			sb.append("VALUES(?,?,?,?,?)");
		
			//4.쿼리문 실행
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, info.getName());
			pstmt.setString(2, info.getPhoneNumber());
			pstmt.setString(3, info.getBirthDay());
			if(info instanceof PhoneInfoSchool) {
				pstmt.setString(4, ((PhoneInfoSchool)info).getSchool());
				pstmt.setInt(5, SCHOOL_TYPE);
			} else if (info instanceof PhoneInfoCompany) {
				pstmt.setString(4, ((PhoneInfoCompany)info).getCompany());
				pstmt.setInt(5, COMPANY_TYPE);
			} //다시봐 형변환
			int count = pstmt.executeUpdate();
			if(count > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();//에러 추적
		}finally {
			closeAll(null,pstmt,conn);
			
		}
		return false;
	}
	//수정 기능
	public boolean modify(PhoneInfo info){
		Connection conn = null;
		PreparedStatement pstmt =null;
		int count =0;
		try {
			conn = this.getConnection();
			String sql ="FROM TBL_PHONEINFO SET NAME,PHONE_NUMBER,BIRTHDAY,SC_NAME,SC_TYPE WHERE NAME=?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, info.getName());
			pstmt.setString(2, info.getPhoneNumber());
			pstmt.setString(3, info.getBirthDay());
			if(info instanceof PhoneInfoSchool) {
				pstmt.setString(4, ((PhoneInfoSchool)info).getSchool());
				pstmt.setInt(5, SCHOOL_TYPE);
			} else if (info instanceof PhoneInfoCompany) {
				pstmt.setString(4, ((PhoneInfoCompany)info).getCompany());
				pstmt.setInt(5, COMPANY_TYPE);
			}
			count = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
			}
			if (count > 0) {
				//성공
				return true;
			} else {
				//실패
				return false;
			}

	
	}
	
	//삭제 기능
	public boolean delete(String name){
		Connection conn = null;
		PreparedStatement pstmt =null;
		int count =0;
		try {
			conn = this.getConnection();
			String sql ="DELETE FROM TBL_PHONEINFO WHERE NAME=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			
			count = pstmt.executeUpdate();
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
	
	//전체조회
	public Vector<PhoneInfo> getAll() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = this.getConnection(); //벌스데이 뒤 "," 
			String sql = "SELECT NAME, PHONE_NUMBER, BIRTHDAY,"
					+ "SC_NAME, SC_TYPE"
					+ "FROM TBL_PHONEINFO";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			Vector<PhoneInfo> vec = new Vector<>();
			while (rs.next()) {
				String name = rs.getString("NAME");
				String phoneNumber = rs.getString("PHONE_NUMBER");
				String birthDay = rs.getString("BIRTHDAY");
				String scName = rs.getString("SC_NAME");
				int scType = rs.getInt("SC_TYPE");
				PhoneInfo info = null;
				if (scType == SCHOOL_TYPE) {
					info = new PhoneInfoSchool(name, phoneNumber, birthDay, scName);
				} else if (scType == COMPANY_TYPE) {
					info = new PhoneInfoCompany(name, phoneNumber, birthDay, scName);
				}
				vec.add(info);
			}
			return vec;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
		return null;
	}
	//검색 기능
	
}
