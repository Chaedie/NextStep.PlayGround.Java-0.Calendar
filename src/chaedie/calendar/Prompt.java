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
		
		/* TODO 및 초안
		 *DONE	1. 일정등록 (하나완성)
		 *DONE	HashMap 사용해서 key : 날짜, value : 일정 으로 하면될것같다.
		 *DONE	이럴경우 key에 value가 여러개가 될수있는지는 모르겠다. 아마도 덮어써질듯.
		 *DONE	일단 하나라도 가능하게 구현해보자. 
		 *DONE  HashMap의 Key : String, Value : ArrayList[]로 2개이상 구현완료.
		 *DONE 2. 일정 검색
		 *DONE	검색 또한 key값 입력하면 value 출력하게 만들면 쉽게 구현가능하다.
		 * 3. 달력 보기
		 *	달력에서 확인하는건 추후 생각해볼 문제
		 */

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
			if ( userInput != "q") {
				System.out.println();
				System.out.println("1. 일정 등록, 2. 일정 검색, 3. 달력 보기, h. 도움말, q. 종료");
				System.out.println(PROMPT);
				userInput = scan.nextLine();
			}

//			System.out.print("원하는 년도을 선택하세요. (exit : -1) \n");
//			System.out.print("YEAR> ");
//			int year = scan.nextInt();
//			// 종료
//			if (year == -1) {
//				printBye();
//				break;
//			}
//
//			System.out.print("원하는 달을 선택하세요. (exit : -1) \n");
//			System.out.print("MONTH> ");
//			int month = scan.nextInt();
//			// 종료
//			if (month == -1) {
//				printBye();
//				break;
//			}
//			// 예외처리
//			if (month > 12 || month < -1 || month == 0) {
//				System.out.println("Wrong value \n");
//				continue;
//			}
//			int year, month;
//			year = 2022;
//			month = 4;
//			cal.printCalendar(year, month);
//			break;
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
