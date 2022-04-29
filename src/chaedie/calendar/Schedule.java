package chaedie.calendar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Schedule {
	
	public Map<String, ArrayList<String>> schedules = new HashMap<>();
	public ArrayList<String> schedulesOfDay = new ArrayList<String>();
	
//	public Schedule() {
//		Boole date;
//		Map schedules;
//		ArrayList ArrayList;		
//	}

	public String parseIntScheduleDateStr(String scheduleDateStr) throws Exception {
		// (xxxx-xx-xx) 형식을 (xxxxxxxx) 형식으로 변환 
		String[] str = scheduleDateStr.split("-");
		int month = Integer.parseInt(str[1]);
		int date = Integer.parseInt(str[2]);
		String keyOfSchedule = str[0] + Integer.toString(month) + Integer.toString(date);
		return keyOfSchedule;
	
		
	}

	public Boolean setSchedule(String scheduleDateStr, String scheduleStr) {
		try {
			schedulesOfDay.add(scheduleStr);
			String date = parseIntScheduleDateStr(scheduleDateStr);
			schedules.put(date, schedulesOfDay);
			return true;
		} catch (Exception e) {
			System.err.println("잘못된 입력입니다.");
			System.err.println("날짜를 확인해주세요. (xxxx-xx-xx)");
			return false;
		}		
	}

	public void getSchedule(String scheduleDateStr) {
		// 갯수 세기
		try {
			schedulesOfDay = schedules.get(parseIntScheduleDateStr(scheduleDateStr));
		} catch (Exception e) {
			System.err.println("잘못된 입력입니다.");
			System.err.println("날짜를 확인해주세요. (xxxx-xx-xx)");
			return;
		}

		if (schedulesOfDay == null) {
			System.out.println("0개의 일정이 있습니다.");
		} else {
			System.out.printf("%d개의 일정이 있습니다. \n", schedulesOfDay.size());
			for (String tmp : schedulesOfDay) {
				System.out.println(tmp);
			}
		}
	}

}
