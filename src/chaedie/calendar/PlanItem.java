package chaedie.calendar;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PlanItem {
	public Date planDate;
	public String detail;
	
	public void planItem(String strDate, String plan) {
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(strDate);
		System.out.println(date);
		planMap.put(date, plan);
	}
}
