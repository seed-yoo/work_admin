package work_admin;

import java.util.List;
import java.util.Scanner;

public class WorkApp {

	public static void department_admin(DepartmentVo departmentVo, Scanner sc) {
		int num;
		System.out.println();
		while (true) {
			System.out.println("부서관리메뉴");
			System.out.println("1. 등록");
			System.out.println("2. 수정");
			System.out.println("3. 삭제");
			System.out.println("4. 돌아가기");
			System.out.println();
			
			num = sc.nextInt();
			if(num == 1) {
				System.out.print("부서번호를 입력해주세요 >>");
				int dno = sc.nextInt();
				sc.nextLine();
				System.out.print("유저아이디를 입력해주세요 >>");
				String uid = sc.nextLine();
				System.out.print("부서이름을 입력해주세요 >>");
				String dname = sc.nextLine();
				
				departmentVo = new DepartmentVo(dno, uid, dname);
				WorkDao workDao = new WorkDao();
				workDao.departmentInsert(departmentVo);
				
			}else if(num == 2) {
				System.out.print("수정 할 부서번호를 입력해주세요 >>");
				int dno = sc.nextInt();
				sc.nextLine();
				System.out.print("수정 할 유저아이디를 입력해주세요 >>");
				String uid = sc.nextLine();
				System.out.print("수정 할 부서이름을 입력해주세요 >>");
				String dname = sc.nextLine();
				
				departmentVo = new DepartmentVo(dno, uid, dname);
				WorkDao workDao = new WorkDao();
				workDao.departmentUpdate(departmentVo);
				
			}else if ( num == 3) {
				System.out.print("삭제 할 부서번호를 입력해주세요 >>");
				int dno = sc.nextInt();
				sc.nextLine();
				String uid = null;
				String dname = null;
				
				departmentVo = new DepartmentVo(dno, uid, dname);
				WorkDao workDao = new WorkDao();
				workDao.departmentUpdate(departmentVo);
				
			}else if (num == 4) {
				System.out.println("나가기");
				break;
			}else {
				System.out.println("잘못입력하였습니다. 다시 입력하세요.");
				
			}
		}
	}
	public static void main(String[] args) {

		WorkDao workDao = new WorkDao();
		DepartmentVo departmentVo = new DepartmentVo();
		
		Scanner sc = new Scanner(System.in);

		while (true) { // 종료 설정 없음
			System.out.println("*관리자 프로그램*");
			System.out.println("=========메뉴=========");
			System.out.println("1. 직원리스트");
			System.out.println("2. 직원 근태수정");
			System.out.println("3. 부서리스트");
			System.out.println("4. 부서 관리");
			System.out.println("5. 종료");
			System.out.println("=====================");
			System.out.println();
			System.out.print("메뉴를 입력해주세요 >>");
			
			
			int a = sc.nextInt();
			if (a == 1) {
				// 직원 리스트 출력
//				List<UserVo> userList = workDao.userList();
//				for (UserVo vo : userList) {
//					System.out.println(vo.getUser_id() + ", " + vo.getPw() + ", " + vo.getDepartment_id());
//				}
				
			} else if (a == 2) {
				// 근태현황 수정 출력

			} else if (a == 3) {
				// 부서리스트 출력
				List<DepartmentVo> departmentList = workDao.departmentList();
				System.out.println("-------------------------------------------------------");
				System.out.println("           부서번호  |          유저아이디|          부서이름");
				System.out.println("-------------------------------------------------------");
				for (DepartmentVo vo : departmentList) {
					System.out.println("		" + vo.getDepartment_id() + " | 	  	  " + vo.getUser_id() + "|		"  + vo.getDepartment_name());
				}
				System.out.println("-------------------------------------------------------");
				System.out.println();
				
			} else if (a == 4) {
				// 부서 관리
				department_admin(departmentVo, sc);
			} else if (a == 5) {
				// 종료
				System.out.println("프로그램종료");
				break;
			} else {
				System.out.println("잘못 입력하셨습니다");
				System.out.println("다시 입력해주세요");

			}

		}
		
		sc.close();
		
	}

}
