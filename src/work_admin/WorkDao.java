package work_admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class WorkDao {

	// 필드
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://192.168.0.59:3306/work_db";
	private String id = "work";
	private String pw = "work";

	// 메소드 - 일반
	private void getConnection() {

		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName(driver);

			// 2. Connection 얻어오기
			conn = DriverManager.getConnection(url, id, pw);

		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}

	} // getConnection()

	private void close() {
		// 5. 자원정리
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}

	}

	// 유저 리스트
	public List<UserVo> userList() {

		// 리스트 준비
		List<UserVo> userList = new ArrayList<UserVo>();

		this.getConnection();

		try {

			// 3. SQL문 준비 / 바인딩 / 실행
			// - sql문 준비
			String query = "";
			query += " select user_id, ";
			query += "        pw, ";
			query += "        department_id, ";
			query += "        user_name, ";
			query += "        user_address, ";
			query += "        user_hp, ";
			query += "        user_email, ";
			query += "        hire_date ";
			query += " from user ";

			// - 바인딩
			pstmt = conn.prepareStatement(query);

			// - 실행
			rs = pstmt.executeQuery();

			// 검색결과에서 데이터 꺼내기
			while (rs.next()) {

				String user_id = rs.getString("user_id");
				int department_id = rs.getInt("department_id");
				String pw = rs.getString("pw");
				String user_name = rs.getString("user_name");
				String user_address = rs.getString("user_address");
				String user_hp = rs.getString("user_hp");
				String user_email = rs.getString("user_email");
				String hire_date = rs.getString("hire_date");

				// Vo묶기
				UserVo userVo = new UserVo(user_id, department_id, pw, user_name, user_address, user_hp, user_email,
						hire_date);

				// 리스트에 추가
				userList.add(userVo);
			}

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}

		this.close();

		return userList;
	}

	// 부서 리스트
	public List<DepartmentVo> departmentList() {

		// 리스트 준비
		List<DepartmentVo> departmentList = new ArrayList<DepartmentVo>();

		this.getConnection();

		try {

			// 3. SQL문 준비 / 바인딩 / 실행
			// - sql문 준비
			String query = "";
			query += " select department_id, ";
			query += "        user_id, ";
			query += "        department_name ";
			query += " from department ";

			// - 바인딩
			pstmt = conn.prepareStatement(query);

			// - 실행
			rs = pstmt.executeQuery();

			// 검색결과에서 데이터 꺼내기
			while (rs.next()) {

				int department_id = rs.getInt("department_id");
				String user_id = rs.getString("user_id");
				String department_name = rs.getString("department_name");

				// Vo묶기
				DepartmentVo departmentVo = new DepartmentVo(department_id, user_id, department_name);

				// 리스트에 추가
				departmentList.add(departmentVo);
			}

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}

		this.close();

		return departmentList;
	}

	// 부서 등록
	public int departmentInsert(DepartmentVo departmentVo) {

		int count = -1;

		this.getConnection();

		try {

			// 3. SQL문 준비 / 바인딩 / 실행
			// - sql문 준비
			String query = "";
			query += " insert into department ";
			query += " value (?, ?, ?) ";

			// - 바인딩
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, departmentVo.getDepartment_id());
			pstmt.setString(2, departmentVo.getUser_id());
			pstmt.setString(3, departmentVo.getDepartment_name());

			// - 실행
			count = pstmt.executeUpdate();

			// 4.결과처리
			System.out.println(count + "건 등록 되었습니다.");

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}

		this.close();

		return count;
	}

	// 부서 수정
	public int departmentUpdate(DepartmentVo departmentVo) {

		int count = -1;

		this.getConnection();
		// 0. import java.sql.*;

		try {

			// 3. SQL문 준비 / 바인딩 / 실행
			// - sql문 준비
			String query = "";
			query += " update department ";
			query += " set user_id = ?, ";
			query += " 	   department_name = ? ";
			query += " where department_id = ? ";
			// - 바인딩
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, departmentVo.getUser_id());
			pstmt.setString(2, departmentVo.getDepartment_name());
			pstmt.setInt(3, departmentVo.getDepartment_id());
			// - 실행
			count = pstmt.executeUpdate();

			// 4.결과처리
			System.out.println(count + "건 수정 되었습니다.");

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
		this.close();
		return count;

	}

}
