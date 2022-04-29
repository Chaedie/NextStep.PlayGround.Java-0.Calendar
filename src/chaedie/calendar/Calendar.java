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

		if (isLeapYear(year)) {
			maxDays = LEAP_MAX_DAYS;
		} else {
			maxDays = MAX_DAYS;
		}

		for (int i = 0; i < monthGap; i++) {
			dayOfMonthGap += maxDays[i];
		}

		return dayOfMonthGap;
	}

	public int getFirstWeekday(int year, int month) {
		// 2000년 기준으로 해서 그 이후로만 계산가능 ㅋㅋ
		int dayIndex = 0;
		int yearGap, countLeapYearGap, dayOfYearGap, dayOfMonthGap, totalDayGap;

		yearGap = (year - 2000);
		countLeapYearGap = getCountLeapYearGap(year);
		dayOfYearGap = (yearGap * 365) + countLeapYearGap;
		dayOfMonthGap = getDayofMonthGap(year, month);
		totalDayGap = dayOfYearGap + dayOfMonthGap;
		dayIndex = (totalDayGap + 6) % 7;

		// TODO : 2000이라는 기준년도,
		// 2000년 1월 1일의 기준 요일 명시 없이
		// (totalDayGap + 6)로 숫자로 하드코딩한거
		// 변수로 설명해야 올바른 방법이다.

		// 추가로, 함수가 너무 많고 복잡한데
		// 줄일거 줄이는게 맞아 보인다.
		// 삼항연산자 사용하면 많이 줄어든다.

		// 추가로, 컴퓨터에서 달력의 첫날은 1970년 1월 1일이다.
		// 달력 구현할땐 앞으로 70년 1월 1일을 기준으로 하면 된다.

		return dayIndex;
	}

	public void printCalendar(int year, int month/* , String weekday */) {
		System.out.println();
		System.out.printf("     <<%4d년 %2d월>>     \n", year, month);
		System.out.println("SU  MO  TU  WE  TH  FR  SA");
		System.out.println(" -----------------------------------");

		int maxDay = getMaxDaysOfMonth(year, month);
		int dayIndex = getFirstWeekday(year, month);
		int delim = (7 - dayIndex) % 7;

		// Print blank space
		for (int i = 0; i < dayIndex; i++) {
			System.out.print("      ");
		}
		for (int i = 1; i < maxDay + 1; i++) {
			// TODO Date class 이용해서 직접 parse 한 부분 없애기
			Schedule schedule = new Schedule();
			schedule.schedulesOfDay = schedule.schedules.get(Integer.toString(year) + Integer.toString(month) + Integer.toString(i));
			if (schedule.schedulesOfDay == null) {
				if (i < 10) {
					System.out.printf("%5d", i);
				} else {
					System.out.printf("%4d", i);
				}
			} else {
				if (i < 10) {
					System.out.printf("%4d.", i);
				} else {
					System.out.printf("%3d.", i);
				}
			}
			if (i % 7 == delim) {
				System.out.println();
			}
		}
		System.out.println();
	}

}
