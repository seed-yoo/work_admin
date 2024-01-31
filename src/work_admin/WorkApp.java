package work_admin;

import java.util.Scanner;

public class WorkApp {


	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		while (true) { // 종료 설정 없음
			System.out.println("-------------");
			System.out.println("관리자님 환영합니다");
			System.out.println("-------------");
			System.out.println("      목록      ");
			System.out.println("1. 직원리스트");
			System.out.println("2. 직원 근태수정");
			System.out.println("3. 부서리스트");
			System.out.println("4. 부서 수정");
			System.out.println("5. 종료");
			System.out.print(">>");
			int a = sc.nextInt();
			if (a == 1) {
				// 직원 리스트 출력
				
			} else if (a == 2) {
				// 근태현황 수정 출력

			} else if (a == 3) {
				// 부서리스트 출력

			} else if (a == 4) {
				// 부서 수정

			} else {
				System.out.println("잘못 입력하셨습니다");
				System.out.println("다시 입력해주세요");

			}

		}
		
		
		
		
		
		
	}

}
