package chaedie.calendar;

import java.util.Scanner;

public class Prompt {

	public void printBye() {
		System.out.print("Bye ~ \n");
	}

	public void runPrompt() {
		Scanner scan = new Scanner(System.in);
		Calendar cal = new Calendar();

		while (true) {
			System.out.print("원하는 년도을 선택하세요. (exit : -1) \n");
			System.out.print("YEAR> ");
			int year = scan.nextInt();
			// 종료
			if (year == -1) {
				printBye();
				break;
			}

			System.out.print("원하는 달을 선택하세요. (exit : -1) \n");
			System.out.print("MONTH> ");
			int month = scan.nextInt();
			// 종료
			if (month == -1) {
				printBye();
				break;
			}

//			System.out.print("원하는 요일을 선택하세요. (exit : -1) \n");
//			System.out.print("(SU, MO, TU, WE, TH, FR, SA) \n");
//			System.out.print("DAY> ");
//			String weekday = scan.next();
//			// 종료
//			if (weekday == "-1") {
//				printBye();
//				break;
//			}

			if (month > 12 || month < -1 || month == 0) {
				System.out.println("Wrong value \n");
				continue;
			}

			cal.printCalendar(year, month/*, weekday.toUpperCase()*/);
		}
		scan.close();

	}

	public static void main(String[] args) {
		// 셸 실행
		Prompt p = new Prompt();
		p.runPrompt();

	}
}
