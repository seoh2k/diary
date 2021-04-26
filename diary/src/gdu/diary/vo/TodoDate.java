package gdu.diary.vo;

public class TodoDate {
	private int year;
	private int month;
	private int day;
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	@Override
	public String toString() {
		String str = "" + this.year; // 정수인 this.year을 String으로 만들어주기 위해 ""를 붙여준다
		
		if(this.month < 10) {
			str += "-0" + this.month;
		} else {
			str += "-" + this.month;
		}
		
		if(this.day < 10) {
			str += "-0" + this.day;
		} else {
			str += "-" + this.day;
		}
		return str;
	}
	
}
