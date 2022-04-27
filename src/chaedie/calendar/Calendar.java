package chaedie.calendar;

public class Calendar {

	private final int[] MAX_DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private final int[] LEAP_MAX_DAYS = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public boolean isLeapYear(int year) {

		if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
			return true;
		}
		return false;
	}

	public int getMaxDaysOfMonth(int year, int month) {

		if (isLeapYear(year) == true) {
			return LEAP_MAX_DAYS[month - 1];
		}

		return MAX_DAYS[month - 1];
	}

//	public int parseWeekDay(String weekday) {
//		int dayIndex = 0;
//		switch (weekday) {
//		case "MO":
//			dayIndex = 1;
//			break;
//		case "TU":
//			dayIndex = 2;
//			break;
//		case "WE":
//			dayIndex = 3;
//			break;
//		case "TH":
//			dayIndex = 4;
//			break;
//		case "FR":
//			dayIndex = 5;
//			break;
//		case "SA":
//			dayIndex = 6;
//			break;
//		default:
//			dayIndex = 0;
//		}
//
//		return dayIndex;
//	}

	public int getCountLeapYearGap(int year) {
		int count = 0;
		for (int i = 2000; i < year; i++) {
			if (isLeapYear(i)) {
				count++;
			}
		}
		return count;
	}

	public int getDayofMonthGap(int year, int month) {
		int monthGap = month - 1;
		int dayOfMonthGap = 0;
		int[] maxDays = new int[12];
		
		if(isLeapYear(year)) {
			maxDays = LEAP_MAX_DAYS;
		} else {
			maxDays = MAX_DAYS;
		}
		
		for(int i = 0; i < monthGap; i++) {
			dayOfMonthGap += maxDays[i];
		}		
		
		return dayOfMonthGap;
	}

	public int getFirstWeekday(int year, int month) {
		// 년도 정보랑 월 정보를 가지고 요일을 만들어야한다.
		// 2000년 1월 1일이 토요일이다. dayIndex로는 6이다.
		// 1월 1일이 토요일이면 31일이 지난
		// 2월 1일은 (31 % 7 == 3 ) -> dayIndex 로는 2이다.
		// 3월 1일은 (29 % 7 == 1 ) -> dayIndex 로는 2월 dayIndex + 1 == 3이다.

		// year(2022) - 2000 = yearGap == (22 * 365 + (countLeapYear) ) (day of year)
		// month - 1 == 0 (1월), month - 1 == 1(2월) if(month == 0) {+0} else{ day of year
		// + MAX_DAYS[month-1]}
		// return dayIndex = ((total day % 7 ) + 6) % 7;

		int dayIndex = 0;
		int yearGap, countLeapYearGap, dayOfYearGap, dayOfMonthGap, totalDayGap;

		yearGap = (year - 2000);
		countLeapYearGap = getCountLeapYearGap(year);
		dayOfYearGap = (yearGap * 365) + countLeapYearGap;
		dayOfMonthGap = getDayofMonthGap(year, month);
		totalDayGap = dayOfYearGap + dayOfMonthGap;
		dayIndex = (totalDayGap + 6) % 7;

		return dayIndex;
	}

	public void printCalendar(int year, int month/* , String weekday */) {
		System.out.println();
		System.out.printf("     <<%4d년 %2d월>>     \n", year, month);
		System.out.println("SU  MO  TU  WE  TH  FR  SA");
		System.out.println(" -----------------------------------");

		int maxDay = getMaxDaysOfMonth(year, month);
		int dayIndex = getFirstWeekday(year, month);
		int delim = 7 - dayIndex;

		// Print blank space
		for (int i = 0; i < dayIndex; i++) {
			System.out.print("      ");
		}
		for (int i = 1; i < maxDay + 1; i++) {
			if (i < 10) {
				System.out.printf("%5d", i);
			} else {
				System.out.printf("%4d", i);
			}
			if (i % 7 == delim) {
				System.out.println();
			}
		}
		System.out.println();
	}
}
