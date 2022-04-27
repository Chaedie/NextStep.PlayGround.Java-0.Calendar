package chaedie.calendar;

//import java.util.Calendar;
import java.util.Scanner;

public class Calendar {

	private final int[] MAX_DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public int getMaxDaysOfMonth(int month) {
		return MAX_DAYS[month - 1];

	}

	public void printSampleCalendar() {
		System.out.println(" 일  월  화  수  목  금  토");
		System.out.println("---------------------------");
		System.out.println("  1   2   3   4   5   6   7");
		System.out.println("  8   9 10 11 12 13 14");
		System.out.println("15 16 17 18 19 20 21");
		System.out.println("22 23 24 25 26 27 28");
	}

	public static void main(String[] args) {

		Calendar cal = new Calendar();
		// 숫자 입력받아 몇개의 월을 받을건지선택 -> 월 최대 일수 출력 반복
		System.out.println("반복 횟수를 입력하세요. ");
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] iMonths = new int[n];
		
		// 숫자를 입력받아 해당하는 달의 최대 일수를 출력하는 프로그램
		System.out.print("\n원하는 달을 선택하세요 : \n");
		for (int i = 0; i < n; i++) {
			iMonths[i] = scan.nextInt();
		}
		for (int i = 0; i < n; i++) {
			System.out.printf("%d월의 마지막 날은 %d 입니다. \n", iMonths[i], cal.getMaxDaysOfMonth(iMonths[i]));
		}

//		cal.printSampleCalendar();
		scan.close();

	}
}
