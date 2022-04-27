package chaedie.calendar;
import java.util.Scanner;

public class sum {
	public static void main(String[] args) {
		//입력 : 키보드로 두 수의 입력을 받는다.
		//출력 : 화면에 두 수의 합을 출력한다.
		
		Scanner scanner = new Scanner(System.in);
		int a;
		int b;
		
		System.out.println("두 수를 입력해주세요.");
		a = scanner.nextInt();
		b = scanner.nextInt();
		
		System.out.printf("%d와 %d의 합은 %d입니다.", a, b, a+b);
		scanner.close();
	}
}
