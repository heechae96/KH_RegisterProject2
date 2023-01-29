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
			if(rs.next()) {
				result = rs.getInt(1);
			}
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
		String sql = "SELECT USER_ID, USER_PW, USER_NAME, USER_PHONE_NO, USER_DATE FROM USER_TBL WHERE USER_ID = ?";
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

}
