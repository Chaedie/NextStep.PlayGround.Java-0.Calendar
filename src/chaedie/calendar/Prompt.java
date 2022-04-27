package chaedie.calendar;

import java.util.Scanner;

public class Prompt {

	public void runPrompt() {
		Scanner scan = new Scanner(System.in);
		Calendar cal = new Calendar();

		while (true) {
			System.out.print("원하는 년도을 선택하세요 : \n");
			System.out.print("YEAR> ");
			int year = scan.nextInt();

			System.out.print("원하는 달을 선택하세요 : \n");
			System.out.print("MONTH> ");
			int month = scan.nextInt();

			System.out.print("원하는 요일을 선택하세요\n");
			System.out.print("(SU, MO, TU, WE, TH, FR, SA) \n");
			System.out.print("DAY> ");
			String weekday = scan.next();

			// 예외처리
			if (month == -1) {
				System.out.print("Bye ~");
				break;
			}

			if (month > 12 || month < -1 || month == 0) {
				System.out.println("Wrong value \n");
				continue;
			}

			cal.printCalendar(year, month, weekday.toUpperCase());
		}
		scan.close();

	}

	public static void main(String[] args) {
		// 셸 실행
		Prompt p = new Prompt();
		p.runPrompt();

	}
}
