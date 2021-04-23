package gdu.diary.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import gdu.diary.util.DBUtil;
import gdu.diary.vo.Member;

public class MemberDao {
	private DBUtil dbUtil;
	
	// 회원정보 수정 
	public void updateMemberPw(Connection conn, Member member) throws SQLException {
		this.dbUtil = new DBUtil();
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(MemberQuery.UPDATE_MEMBER_PW);
			stmt.setString(1, member.getMemberPw());
			stmt.setString(2, member.getMemberId());
			// 디버깅
			System.out.println("updateMemberPw "+stmt);
			stmt.executeUpdate();
		} finally {
			dbUtil.close(null, stmt, null);
		}
	}
	
	public int deleteMemberByKey(Connection conn, Member member) throws SQLException {
		this.dbUtil = new DBUtil();
		int rowCnt = 0;
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(MemberQuery.DELETE_MEMBER_BY_KEY);
			stmt.setInt(1, member.getMemberNo());
			stmt.setString(2, member.getMemberPw());
			rowCnt = stmt.executeUpdate();
		} finally {
			dbUtil.close(null, stmt, null);
		}
		return rowCnt;
	}
	
	public Member selectMemberByKey(Connection conn, Member member) throws SQLException { //Connection 무조건 매개변수로 받아야된다
		this.dbUtil = new DBUtil();
		Member returnMember = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement(MemberQuery.SELECT_MEMBER_BY_KEY);
			stmt.setString(1, member.getMemberId());
			stmt.setString(2, member.getMemberPw());
			rs = stmt.executeQuery();
			if(rs.next()) {
				returnMember = new Member();
				returnMember.setMemberNo(rs.getInt("memberNo"));
				returnMember.setMemberId(rs.getString("memberId"));
			}
		} finally {
			dbUtil.close(rs, stmt, null);
		}
		return returnMember;
	}
	
	// 회원가입 
	public Member insertMember(Connection conn, Member member) throws SQLException {
		this.dbUtil = new DBUtil();
		Member returnMember = null;
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(MemberQuery.INSERT_MEMBER);
			stmt.setString(1, member.getMemberId());
			stmt.setString(2, member.getMemberPw());
			// 디버깅
			System.out.println("insertMember "+stmt);
			stmt.executeUpdate();
		} finally {
			dbUtil.close(null, stmt, null);
		}
		return returnMember;
	}
}
