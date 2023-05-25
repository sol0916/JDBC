package jdbc.demo;

import java.util.*;
import java.sql.*;

public class DemoUpdate01 {

	public static void main(String[] args) {
		
		//부서아이디, 부서이름을 입력받아서 해당 부서의 이름을 변경하는 update 구문
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("부서아이디>");
		String d_id = scan.nextLine();
		//System.out.print("부서이름>");
		//String name = scan.nextLine();
		System.out.print("변경할부서이름>");
		String changeName = scan.nextLine();
		
		//데이터베이스 연결정보
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String uid = "HR";
		String upw = "HR";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE DEPTS SET DEPARTMENT_NAME = ? WHERE DEPARTMENT_ID = ?";
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection(url, uid, upw);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, changeName);
			//pstmt.setString(2, name);
			pstmt.setString(2, d_id);
			
			int result = pstmt.executeUpdate();
			System.out.println("성공실패?:"+result);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			try {
				conn.close();
				pstmt.close();				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
