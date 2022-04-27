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

	public int parseWeekDay(String weekday) {
		int dayIndex = 0;
		switch (weekday) {
		case "MO":
			dayIndex = 1;
			break;
		case "TU":
			dayIndex = 2;
			break;
		case "WE":
			dayIndex = 3;
			break;
		case "TH":
			dayIndex = 4;
			break;
		case "FR":
			dayIndex = 5;
			break;
		case "SA":
			dayIndex = 6;
			break;
		default:
			dayIndex = 0;
		}

		return dayIndex;
	}

	public void printCalendar(int year, int month, String weekday) {

		System.out.println();
		System.out.printf("     <<%4d년 %2d월>>     \n", year, month);
		System.out.println("SU  MO  TU  WE  TH  FR  SA");
		System.out.println(" -----------------------------------");

		int maxDay = getMaxDaysOfMonth(year, month);
		int dayIndex = parseWeekDay(weekday);

		for (int i = 0; i < dayIndex; i++) {
			System.out.print("      ");
		}
		for (int i = 1; i < maxDay + 1; i++) {
			if (i < 10) {
				System.out.printf("%5d", i);
			} else {
				System.out.printf("%4d", i);
			}
			if (i % 7 == (7 - dayIndex)) {
				System.out.println();
			}
		}
		System.out.println();
	}
}
