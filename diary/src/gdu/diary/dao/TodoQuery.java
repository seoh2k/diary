package gdu.diary.dao;

public class TodoQuery {
	public final static String DELETE_TODO_BY_MEMBER;
	public final static String INSERT_TODO;
	public final static String SELECT_TODO_LIST_BY_DATE;
	public final static String SELECT_TODO_ONE;
	public static final String UPDATE_TODO_ONE;
	public static final String DELETE_TODO_ONE;
	static {
		DELETE_TODO_BY_MEMBER = "DELETE FROM todo WHERE member_no=?";
		INSERT_TODO = "INSERT INTO todo(member_no, todo_date, todo_title, todo_content, todo_font_color, todo_add_date) VALUES (?, ?, ?, ?, ?, NOW())";
		SELECT_TODO_LIST_BY_DATE = "SELECT todo_no todoNo, DAY(todo_date) todoDate, LEFT(todo_title, 10) todoTitle, todo_font_color todoFontColor FROM todo WHERE member_no=? AND YEAR(todo_date)=? AND MONTH(todo_date)=?";
		SELECT_TODO_ONE = "SELECT todo_no todoNo, todo_date todoDate, todo_title todoTitle, todo_content todoContent, todo_font_color todoFontColor, todo_add_date todoAddDate FROM todo WHERE todo_no=?";
		UPDATE_TODO_ONE = "UPDATE todo SET todo_title=?, todo_content=?, todo_font_color=? WHERE todo_no=?";
		DELETE_TODO_ONE = "DELETE FROM todo WHERE todo_no=?";
	}
}
