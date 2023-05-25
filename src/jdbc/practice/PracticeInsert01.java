package jdbc.practice;

import java.sql.*;
import java.util.*;

public class PracticeInsert01 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("부서명>");
		String name = scan.nextLine();
		System.out.print("매니저아이디>");
		String m_id = scan.nextLine();
		System.out.print("로케이션아이디>");
		String l_id = scan.nextLine();
		
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";		
		String uid = "HR";
		String upw = "HR";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO DEPTS (DEPARTMENT_ID, DEPARTMENT_NAME, MANAGER_ID, LOCATION_ID) \r\n"
				+ "VALUES (depts_seq.nextval, ?, ?, ?)";
		
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, uid, upw);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, m_id); //자동형변환
			pstmt.setInt(3, Integer.parseInt(l_id)); //int타입으로 변환
			
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
