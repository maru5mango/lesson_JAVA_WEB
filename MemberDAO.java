package sec01.ex01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
	private static final String driver = "oracle.jdbc.driver.OracleDriver";
	private static final String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String user = "";//SQL DB 아이디
	private static final String pwd = "";//SQL DB 비밀번호
	private Connection con;
	private Statement stmt;

	public List<MemberVO> listMembers() {
		List<MemberVO> list = new ArrayList<MemberVO>();
		try {
			connDB(); //driver, url, user, pwd로 데이터 베이스를 연결한다.
			String query = "select * from t_member ";
// 			prepareStatement()를 이용하면SQL문을 미리 컴파일하여 사용하므로 속도가 더 빠르다.
// 			pstmt=con.prepareStatement(query);
// 			ResultSet rs= pstmt.executeQuery();
			ResultSet rs = stmt.executeQuery(query);// SQL문으로 회원 정보를 조회한다.
			while (rs.next()) {
				//조회한 결과의 각 칼럼값을 받아온다.
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");
				MemberVO vo = new MemberVO();
				//각 칼럼 값을 MemberVO객체의 속성에 설정한다.
				vo.setId(id);
				vo.setPwd(pwd);
				vo.setName(name);
				vo.setEmail(email);
				vo.setJoinDate(joinDate);
				list.add(vo);
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;// 조회한 레코드의 개수만큼 MemberVO객체를 저장한 arraylist를 반환한다.
	}

	private void connDB() {
		try {
			Class.forName(driver);
			System.out.println("Oracle 드라이버 로딩 성공");
			con = DriverManager.getConnection(url, user, pwd);
			System.out.println("Connection 생성 성공");
			stmt = con.createStatement();
			System.out.println("Statement 생성 성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
