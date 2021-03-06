package chaedie.calendar;

import java.util.Scanner;

public class Prompt {

	private final String PROMPT = "> ";

	public void printBye() {
		System.out.print("Bye ~ \n");
	}

	public void printMenu() {
		System.out.println("+----------------------+");
		System.out.println("|  1. 일정 등록           ");
		System.out.println("|  2. 일정 검색           ");
		System.out.println("|  3. 달력 보기");
		System.out.println("|  h. 도움말 q. 종료");
		System.out.println("+----------------------+");
		System.out.println(PROMPT);
	}

	public void runPrompt() {
		printMenu();

		Scanner scan = new Scanner(System.in);
		Calendar cal = new Calendar();
		Schedule schedule = new Schedule();
		String userInput = null;
		String scheduleDateStr = null;
		String scheduleStr = null;

		userInput = scan.nextLine();

		while (!userInput.equals("q")) {

			switch (userInput) {
			case "1":
				cmdRegister(scan, schedule, scheduleDateStr, scheduleStr);
				break;
			case "2":
				cmdSearch(scan, schedule, scheduleDateStr, scheduleStr);
				break;
			case "3":
				cmdCal(scan, cal);
				break;
			case "h":
				printMenu();
				break;
			case "q":
				break;
			}
			if (!userInput.equals("q")) {
				System.out.println();
				System.out.println("1. 일정 등록, 2. 일정 검색, 3. 달력 보기, h. 도움말, q. 종료");
				System.out.println(PROMPT);
				userInput = scan.nextLine();
			}
		}
		printBye();
		scan.close();
	}

	private void cmdCal(Scanner scan, Calendar cal) {
		System.out.print("원하는 년도을 선택하세요. (exit : -1) \n");
		System.out.print("YEAR> ");
		int year = scan.nextInt();
		// 종료
		if (year == -1) {
			printBye();
			return;
		}

		System.out.print("원하는 달을 선택하세요. (exit : -1) \n");
		System.out.print("MONTH> ");
		int month = scan.nextInt();
		// 종료
		if (month == -1) {
			printBye();
			return;
		}
		// 예외처리
		if (month > 12 || month < -1 || month == 0) {
			System.out.println("Wrong value \n");
			return;
		}

		cal.printCalendar(year, month); // TODO printCal 안에 일정에 점찍기 기능 추가
		scan.nextLine();
		
	}

	private void cmdSearch(Scanner scan, Schedule schedule, String scheduleDateStr, String scheduleStr) {
		System.out.println("[일정 검색] 날짜를 입력하세요. (xxxx-xx-xx)");
		System.out.println(PROMPT);
		scheduleDateStr = scan.nextLine();
		
		
		schedule.getSchedule(scheduleDateStr);
	}

	private void cmdRegister(Scanner scan, Schedule schedule, String scheduleDateStr, String scheduleStr) {
		// input
		try {
			System.out.println("[일정 등록] 날짜를 입력하세요. (xxxx-xx-xx)");
			System.out.println(PROMPT);
			scheduleDateStr = scan.nextLine();
			schedule.parseDate(scheduleDateStr);
		} catch (Exception e) {
			System.err.println("잘못된 입력입니다.");
			System.err.println("날짜를 확인해주세요. (xxxx-xx-xx)");
			return;
		}
		System.out.println("[일정 등록] 일정을 입력하세요. ");
		System.out.println(PROMPT);
		scheduleStr = scan.nextLine();

		if (schedule.setSchedule(scheduleDateStr, scheduleStr)) {
			System.out.println("일정이 등록되었습니다.");	
		}			
	}

	public static void main(String[] args) {
		// 셸 실행
		Prompt p = new Prompt();
		p.runPrompt();
	}
}
