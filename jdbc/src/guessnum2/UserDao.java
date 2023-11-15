package guessnum2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao extends BasicAbstractDao {
	
	private static UserDao instance = new UserDao();
	private UserDao() {}
	public static UserDao getInstance() {
		return instance;
	}
	
	
	
	public boolean addUser(UserVo userVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = this.getConnection();
			String sql = "INSERT INTO TBL_USER"
					+ "		(USER_ID,USER_PW,USER_NAME,USER_EMAIL)"
					+ "	VALUES(?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userVo.getUserId());
			pstmt.setString(2, userVo.getUserPw());
			pstmt.setString(3, userVo.getUserName());
			pstmt.setString(4, userVo.getUserEmail());
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
	
	
	public UserVo login(LoginDto loginDto) {  //다시해
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String sql = "SELECT * FROM TBL_USER"
					+ "   WHERE USER_ID = ?"
					+ "   AND USER_PW = ?";
			String userId = loginDto.getUserId();
			String userPw = loginDto.getUserPw();//많이쓰고 길어서 위로 올려서 간단하게쓸려고
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPw);
			rs = pstmt.executeQuery();//
			if (rs.next()) {
				String userName = rs.getString("USER_NAME");
				String userEmail = rs.getString("USER_EMAIL");
				UserVo userVo = new UserVo(userId, userPw, userName, userEmail);
				
				return userVo;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
		return null;
	}
}
