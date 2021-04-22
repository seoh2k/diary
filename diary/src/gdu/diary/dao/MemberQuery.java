package gdu.diary.dao;

public class MemberQuery {
	public final static String SELECT_MEMBER_BY_KEY;
	public final static String INSERT_MEMBER;
	
	static {
		SELECT_MEMBER_BY_KEY = "SELECT member_no memberNo, member_id memberId FROM member WHERE member_id=? AND member_pw=PASSWORD(?)"; 
		INSERT_MEMBER = "INSERT INTO member(member_id, member_pw, member_date) VALUES(?,PASSWORD(?),NOW())";
	}
}
