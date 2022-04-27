package chaedie.calendar;

import java.util.Scanner;

public class Prompt {

	private final static String PROMPT = "cal> ";

	public void runPrompt() {
		Scanner scan = new Scanner(System.in);
		Calendar cal = new Calendar();

		while (true) {
			System.out.print("원하는 달을 선택하세요 : \n");
			System.out.print(PROMPT);
			int month = scan.nextInt();

			// 예외처리
			if (month == -1) {
				System.out.print("Bye ~");
				break;
			}

			if (month > 12 || month < -1 || month == 0) {
				System.out.println("Wrong value \n");
				continue;
			}

			cal.printCalendar(2022, month);
		}
		scan.close();

	}

	public static void main(String[] args) {
		// 셸 실행
		Prompt p = new Prompt();
		p.runPrompt();

	}
}
