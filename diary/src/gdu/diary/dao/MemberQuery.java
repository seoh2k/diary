package gdu.diary.dao;

public class MemberQuery {
	public final static String SELECT_MEMBER_BY_KEY;
	public final static String INSERT_MEMBER;
	public final static String DELETE_MEMBER_BY_KEY;
	public final static String UPDATE_MEMBER_PW;
	
	static {
		SELECT_MEMBER_BY_KEY = "SELECT member_no memberNo, member_id memberId FROM member WHERE member_id=? AND member_pw=PASSWORD(?)"; 
		INSERT_MEMBER = "INSERT INTO member(member_id, member_pw, member_date) VALUES(?,PASSWORD(?),NOW())";
		DELETE_MEMBER_BY_KEY = "DELETE FROM member WHERE member_no=? AND member_pw=PASSWORD(?)";
		UPDATE_MEMBER_PW = "UPDATE member SET member_pw=PASSWORD(?) WHERE member_id=?";
	}
}
