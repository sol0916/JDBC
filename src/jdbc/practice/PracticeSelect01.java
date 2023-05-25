package jdbc.practice;

import java.sql.*;
import java.sql.Date;
import java.util.*;

public class PracticeSelect01 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("급여>");
		int find = scan.nextInt();
		
			
		//데이터 베이스 연결 정보
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String uid = "HR";
		String upw = "HR";
		
		//쿼리문
		String sql = "SELECT * FROM EMPLOYEES WHERE SALARY > ? ORDER BY SALARY DESC";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; //select문에서만 사용
		
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver"); //드라이버 로딩
			conn = DriverManager.getConnection(url, uid, upw); //java, oracle 연결			
	
			pstmt = conn.prepareStatement(sql); //커넥션 객체에서 state 객체 생성			
			pstmt.setInt(1, find); 
			
			rs = pstmt.executeQuery(); //sql문 실행 결과를 담고 있음
			 
			while(rs.next()) {
				
				int eid = rs.getInt("EMPLOYEE_ID");
				String name = rs.getString("FIRST_NAME");
				int salary = rs.getInt("SALARY");
				Date date = rs.getDate("HIRE_DATE");
				
				
				System.out.println(eid);
				System.out.println(name);
				System.out.println(salary);
				System.out.println(date);
				System.out.println("--------------------");
				
			}
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
