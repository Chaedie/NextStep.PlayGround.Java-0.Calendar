package chaedie.calendar;

//import java.util.Calendar;
import java.util.Scanner;

public class Calendar {

	private final int[] MAX_DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public int getMaxDaysOfMonth(int month) {
		return MAX_DAYS[month - 1];

	}

	public void printSampleCalendar(int month) {
		Calendar cal = new Calendar();

		System.out.println();
		System.out.println(" 일  월  화  수  목  금  토");
		System.out.println("---------------------------");
		System.out.println("  1   2   3   4   5   6   7");
		System.out.println("  8   9 10 11 12 13 14");
		System.out.println("15 16 17 18 19 20 21");
		System.out.println("22 23 24 25 26 27 28");
		if (cal.getMaxDaysOfMonth(month) == 30) {
			System.out.println("29 30");

		} else if (cal.getMaxDaysOfMonth(month) == 31) {
			System.out.println("29 30 31");
		}
		System.out.println();
	}

	public static void main(String[] args) {

		// 프롬프트 추가
		String PROMPT = "cal> ";
		Scanner scan = new Scanner(System.in);
		Calendar cal = new Calendar();

		while (true) {
			System.out.print("원하는 달을 선택하세요 : \n");
			System.out.print(PROMPT);
			int iMonth = scan.nextInt();

			// 예외처리
			if (iMonth == -1) {
				System.out.print("Bye ~");
				break;
			}

			if (iMonth > 12 || iMonth < -1 || iMonth == 0) {
				System.out.println("Wrong value \n");
				continue;
			}

			cal.printSampleCalendar(iMonth);
		}
		scan.close();

	}
}
