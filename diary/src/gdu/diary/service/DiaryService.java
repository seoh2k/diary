package gdu.diary.service;

import java.util.*;

public class DiaryService {
	public Map<String, Object> getDiary(String targetYear, String targetMonth) {
		// 타겟 년, 월, 일(날짜)
		// 타겟 달의 1일(날짜)
		// 타겟 달의 마지막 일의 숫자 -> endDay
		
		// startBlank + endDay + (7 - (startBlank + endDay)%7)
		// 전체 셀의 갯수(마지막 일의 숫자 보다는 크고 7로 나누어 떨어져야 한다)
		// 앞의 빈 셀 갯수 -> startBlank
		// 이번 달 숫자가 나와야 할 셀의 갯수(1~마지막 날짜)
		// 뒤의 빈 셀의 갯수 -> endBlank -> (startBlank + endDay)%7 
		Map<String, Object> map = new HashMap<String, Object>();
		Calendar target = Calendar.getInstance();
		
		if(targetYear != null) {
			target.set(Calendar.YEAR, Integer.parseInt(targetYear));
		}
		if(targetMonth != null) {
			// 두번째 인수값이 -1이면 target의 년을 -1하고 월은 11값(12월)이 들어간다.
			// 두번째 인수값이 12이면 target의 년을 +1하고 월은 0(1월)값이 들어간다.
			target.set(Calendar.MONTH, Integer.parseInt(targetMonth));
		}
		/*
		 * target.set(Calendar.MONTH, Integer.parseInt(targetMonth)) 코드의 알고리즘을 직접 구현하면...
		int numTargetMonth = 0;
		int numTargetYear = 0;
		if(targetYear != null && targetMonth != null) {
			numTargetYear = Integer.parseInt(targetYear);
			numTargetMonth = Integer.parseInt(targetMonth);
			if(numTargetMonth == 0) {
				numTargetYear = numTargetYear - 1;
				numTargetMonth = 12;
			} else if (numTargetMonth == 13) {
				numTargetYear = numTargetYear + 1;
				numTargetMonth = 1;
			}
			target.set(Calendar.YEAR, numTargetYear);
			target.set(Calendar.MONTH, numTargetMonth-1);
		}
		*/
		
		target.set(Calendar.DATE, 1); // 무조건 날짜를 1로 바꾼다
		// 타겟 달의 1 숫자 앞에 와야 할 빈 셀의 갯수 
		int startBlank = target.get(Calendar.DAY_OF_WEEK) - 1;
		// 타겟 달의 마지막 날짜
		int endDay = target.getActualMaximum(Calendar.DATE);
		int endBlank = 0;
		if ((startBlank + endDay) % 7 != 0) {
			endBlank = 7 - (startBlank + endDay) % 7;
		}
		// int totalCall = startBlank + endDay + endBlank;
		
		map.put("targetYear", target.get(Calendar.YEAR));
		map.put("targetMonth", target.get(Calendar.MONTH));
		map.put("startBlank", startBlank);
		map.put("endDay", endDay);
		map.put("endBlank", endBlank);
		
		return map;
	}
}
