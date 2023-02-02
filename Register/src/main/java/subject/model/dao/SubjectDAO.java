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

}
