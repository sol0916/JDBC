package jdbc.practice;

import java.sql.*;
import java.util.*;

public class PracticeUpdate01 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("변경할 부서아이디>");
		String find = scan.nextLine();
		System.out.print("변경된 부서명>");
		String change = scan.nextLine();
		
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
			pstmt.setString(1, change);
			pstmt.setInt(2, Integer.parseInt(find));
			
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
