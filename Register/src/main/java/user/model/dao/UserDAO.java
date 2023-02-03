package user.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

import user.model.vo.User;

public class UserDAO {

	/**
	 * 회원가입 DAO
	 * 
	 * @param conn
	 * @param user
	 * @return result
	 */
	public int insertUser(Connection conn, User user) {
		String sql = "INSERT INTO USER_TBL(USER_ID, USER_PW, USER_NAME, USER_PHONE_NO, USER_DATE) VALUES(?, ?, ?, ?, DEFAULT)";
		int result = -1;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUserId());
			pstmt.setString(2, user.getUserPw());
			pstmt.setString(3, user.getUserName());
			pstmt.setString(4, user.getUserPhoneNo());

			result = pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	/**
	 * 중복되는 아이디 확인 DAO
	 * 
	 * @param conn
	 * @param id
	 * @return result
	 */
	public int selectOneByIdCnt(Connection conn, String id) {
		String sql = "SELECT COUNT(*) FROM USER_TBL WHERE USER_ID = ?";
		int result = -1;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getInt(1);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	/**
	 * 로그인 DAO
	 * 
	 * @param conn
	 * @param id
	 * @param pw
	 * @return result
	 */
	public int selectLogin(Connection conn, String id, String pw) {
		String query = "SELECT COUNT(*) FROM USER_TBL WHERE USER_ID = ? AND USER_PW = ?";
		int result = -1;
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);

			ResultSet rset = pstmt.executeQuery();
			if (rset.next()) {
				result = rset.getInt(1);
			}
			pstmt.close();
			rset.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	/**
	 * 정보변경 DAO
	 * 
	 * @param conn
	 * @param user
	 * @return result
	 */
	public int updateUser(Connection conn, User user) {
		String sql = "UPDATE USER_TBL SET USER_PW = ?, USER_NAME = ?, USER_PHONE_NO = ? WHERE USER_ID = ?";
		int result = -1;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUserPw());
			pstmt.setString(2, user.getUserName());
			pstmt.setString(3, user.getUserPhoneNo());
			pstmt.setString(4, user.getUserId());

			result = pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	/**
	 * 아이디로 정보조회 DAO
	 * 
	 * @param id
	 * @return user
	 */
	public User selectOneById(Connection conn, String id) {
		String sql = "SELECT * FROM USER_TBL WHERE USER_ID = ?";
		User user = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setUserId(rs.getString("USER_ID"));
				user.setUserPw(rs.getString("USER_PW"));
				user.setUserName(rs.getString("USER_NAME"));
				user.setSubjectCode(rs.getInt("SUBJECT_CODE"));
				user.setUserPhoneNo(rs.getString("USER_PHONE_NO"));
				user.setUserDate(rs.getTimestamp("USER_DATE"));
			}
			pstmt.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	/**
	 * 아이디로 회원탈퇴 DAO
	 * 
	 * @param conn
	 * @param id
	 * @return result
	 */
	public int deleteUser(Connection conn, String id) {
		String sql = "DELETE FROM USER_TBL WHERE USER_ID = ?";
		int result = -1;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			result = pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	/**
	 * 비밀번호 찾기 DAO
	 * 
	 * @param conn
	 * @param user
	 * @return result
	 */
	public int findPw(Connection conn, User user) {
		String sql = "SELECT COUNT(*) FROM USER_TBL WHERE USER_ID = ? AND USER_NAME = ? AND USER_PHONE_NO = ?";
		int result = -1;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUserId());
			pstmt.setString(2, user.getUserName());
			pstmt.setString(3, user.getUserPhoneNo());

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getInt(1);
			}
			pstmt.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	/**
	 * 비밀번호 변경 DAO
	 * 
	 * @param conn
	 * @param id
	 * @return
	 */
	public int updatePw(Connection conn, String id, String pwd) {
		String sql = "UPDATE USER_TBL SET USER_PW = ? WHERE USER_ID = ?";
		int result = -1;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pwd);
			pstmt.setString(2, id);

			result = pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	/**
	 * 수강신청 DAO
	 * 
	 * @param conn
	 * @param code
	 * @return result
	 */
	public int addCodeSubject(Connection conn, int code, String id) {
		String sql = "UPDATE USER_TBL SET SUBJECT_CODE = ? WHERE USER_ID = ?";
		int result = -1;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, code);
			pstmt.setString(2, id);

			result = pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

}
