package chaedie.calendar;

import java.util.Scanner;

public class Prompt {

	private final String PROMPT = "> ";

	public void printBye() {
		System.out.print("Bye ~ \n");
	}

	public void runPrompt() {
		Scanner scan = new Scanner(System.in);
		Calendar cal = new Calendar();
		String userInput = null;
		String scheduleDateStr = null;
		String scheduleStr = null;

		System.out.println("+----------------------+\r\n" + "|  1. 일정 등록           \r\n" + "|  2. 일정 검색           \r\n"
				+ "|  3. 달력 보기\r\n" + "|  h. 도움말 q. 종료\r\n" + "+----------------------+");
		System.out.println(PROMPT);
		userInput = scan.nextLine();

		while (userInput != "q") {

			switch (userInput) {
			case "1":
				// input
				System.out.println("[일정 등록] 날짜를 입력하세요. (xxxx-xx-xx)");
				System.out.println(PROMPT);
				scheduleDateStr = scan.nextLine();

				System.out.println("[일정 등록] 일정을 입력하세요. ");
				System.out.println(PROMPT);
				scheduleStr = scan.nextLine();

				cal.setSchedule(scheduleDateStr, scheduleStr);
				System.out.println("일정이 등록되었습니다.");

				break;
			case "2":
				System.out.println("[일정 검색] 날짜를 입력하세요. (xxxx-xx-xx)");
				System.out.println(PROMPT);
				scheduleDateStr = scan.nextLine();

				cal.getSchedule(scheduleDateStr);
				break;
			case "3":
				int year, month;
				year = 2022;
				month = 4;
				cal.printCalendar(year, month); // TODO printCal 안에 일정에 점찍기 기능 추가
				break;
			case "h":
				break;
			case "q":
				break;
			}
			if (userInput != "q") {
				System.out.println();
				System.out.println("1. 일정 등록, 2. 일정 검색, 3. 달력 보기, h. 도움말, q. 종료");
				System.out.println(PROMPT);
				userInput = scan.nextLine();
			}
		}
		printBye();
		scan.close();
	}

	public static void main(String[] args) {
		// 셸 실행
		Prompt p = new Prompt();
		p.runPrompt();
	}
}
