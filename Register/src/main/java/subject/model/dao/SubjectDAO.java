package subject.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import subject.model.vo.Subject;

public class SubjectDAO {

	/**
	 * 과목 추가 DAO
	 * 
	 * @param conn
	 * @param subject
	 * @return result
	 */
	public int insertSubject(Connection conn, Subject subject) {
		String sql = "INSERT INTO SUBJECT_TBL VALUES(? ,SUB_SEQUENCE.NEXTVAL, ?, DEFAULT, ?, ?, ?)";
		int result = -1;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, subject.getSubjectName());
			pstmt.setString(2, subject.getName());
			pstmt.setInt(3, subject.getMaxNo());
			pstmt.setDate(4, subject.getStartDate());
			pstmt.setDate(5, subject.getEndDate());

			result = pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	/**
	 * 과목 조회 DAO
	 * 
	 * @param conn
	 * @return list
	 */
	public List<Subject> selectAll(Connection conn) {
		String sql = "SELECT * FROM SUBJECT_TBL";
		List<Subject> list = new ArrayList<Subject>();

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Subject subject = new Subject();
				subject.setSubjectName(rs.getString(1));
				subject.setSubjectCode(rs.getInt(2));
				subject.setName(rs.getString(3));
				subject.setEnrollNo(rs.getInt(4));
				subject.setMaxNo(rs.getInt(5));
				subject.setStartDate(rs.getDate(6));
				subject.setEndDate(rs.getDate(7));
				list.add(subject);
			}
			stmt.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	/**
	 * 과목 삭제 DAO
	 * 
	 * @param conn
	 * @param codeNum
	 * @return
	 */
	public int deleteSubject(Connection conn, int codeNum) {
		String sql = "DELETE FROM SUBJECT_TBL WHERE SUBJECT_CODE = ?";
		int result = -1;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, codeNum);

			result = pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	/**
	 * 과목 수정 DAO
	 * 
	 * @param conn
	 * @param subject
	 * @return result
	 */
	public int updateSubject(Connection conn, Subject subject) {
		String sql = "UPDATE SUBJECT_TBL SET SUBJECT_NAME = ?, NAME = ?, MAX_NO = ?, START_DATE = ?, END_DATE = ? WHERE SUBJECT_CODE = ?";
		int result = -1;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, subject.getSubjectName());
			pstmt.setString(2, subject.getName());
			pstmt.setInt(3, subject.getMaxNo());
			pstmt.setDate(4, subject.getStartDate());
			pstmt.setDate(5, subject.getEndDate());
			pstmt.setInt(6, subject.getSubjectCode());

			result = pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	/**
	 * 해당 과목 조회 DAO
	 * 
	 * @param conn
	 * @param code
	 * @return subject
	 */
	public Subject selectSubject(Connection conn, int code) {
		String sql = "SELECT * FROM SUBJECT_TBL WHERE SUBJECT_CODE = ?";
		Subject subject = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, code);

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				subject = new Subject();
				subject.setSubjectName(rs.getString(1));
				subject.setSubjectCode(rs.getInt(2));
				subject.setName(rs.getString(3));
				subject.setEnrollNo(rs.getInt(4));
				subject.setMaxNo(rs.getInt(5));
				subject.setStartDate(rs.getDate(6));
				subject.setEndDate(rs.getDate(7));
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return subject;
	}

	/**
	 * 수강신청 인원 더하기 DAO
	 * 
	 * @param conn
	 * @param code
	 * @param enrollNum
	 * @return result
	 */
	public int plusSubject(Connection conn, int code, Subject subject) {
		String sql = "UPDATE SUBJECT_TBL SET ENROLL_NO = ? WHERE SUBJECT_CODE = ?";
		int result = -1;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, subject.getEnrollNo() + 1);
			pstmt.setInt(2, code);

			result = pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	/**
	 * 수강신청 인원 빼기 DAO
	 * 
	 * @param conn
	 * @param code
	 * @param enrollNum
	 * @return result
	 */
	public int minusSubject(Connection conn, int code, Subject subject) {
		String sql = "UPDATE SUBJECT_TBL SET ENROLL_NO = ? WHERE SUBJECT_CODE = ?";
		int result = -1;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, subject.getEnrollNo() - 1);
			pstmt.setInt(2, code);

			result = pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	/**
	 * 수강신청한 과목 조회 DAO
	 * 
	 * @param conn
	 * @param id
	 * @return subject
	 */
	public Subject selectUserSubject(Connection conn, String id) {
		String sql = "SELECT SUBJECT_NAME, SUBJECT_CODE, NAME, ENROLL_NO, MAX_NO, START_DATE, END_DATE FROM SUBJECT_TBL "
				+ "JOIN USER_TBL USING(SUBJECT_CODE) WHERE USER_ID = ?";
		Subject subject = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				subject = new Subject();
				subject.setSubjectName(rs.getString(1));
				subject.setSubjectCode(rs.getInt(2));
				subject.setName(rs.getString(3));
				subject.setEnrollNo(rs.getInt(4));
				subject.setMaxNo(rs.getInt(5));
				subject.setStartDate(rs.getDate(6));
				subject.setEndDate(rs.getDate(7));
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return subject;
	}

}
