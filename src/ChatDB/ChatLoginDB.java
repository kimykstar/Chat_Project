package ChatDB;
import java.sql.*;

public class ChatLoginDB {
	private Connection conn = null;
	private ResultSet rs;
	private Statement stmt;
	
	public ChatLoginDB() {
		try {
			// Driver Loading
			// Class클래스의 forName메소드는 String형태로 준 인자의 클래스 객체를 반환한다.
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost/loginfo";
			// Connect with DB 
			// DriverManager.getConnection(url, userName, password);
			conn = DriverManager.getConnection(url, "root", "rladudrhks");
			stmt = conn.createStatement();
			System.out.println("DB연결 성공");
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public String getLoginfo(String id) {
		String info = null;
		String sql = "SELECT pw FROM profile WHERE id=" + "\'" + id + "\'";
		try {
			rs = stmt.executeQuery(sql);
			// rs.next를 이용해 콘솔을 이동시켜야 한다. 처음엔 Column명 이전에 콘솔이 존재한다.
			if(rs.next()) {
				info = rs.getString(1);
			}
		} catch (SQLException e) {
			System.out.println("아이디가 없습니다.");
		}
		return info;
	}
	
	// Join method
	public void insertProfile(String name, String id, String pw, String address, String number) {
		String values = "\'" + name + "\', \'" + id + "\', \'" + pw + "\', \'" +address + "\', \'" + number + "\'";
		String sql = "INSERT INTO profile (name, id, pw, address, number) VALUES (" + values + ")";
		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("INSERT SUCCESS!");
	}
	
	public static void main(String[] args) {
		ChatLoginDB db = new ChatLoginDB();
//		db.insertProfile("김영관", "ykstar78", "1111", "안산시 단원구 해양5로 17 그랑시티자이 2차아파트 201동 902호", "01038305274");
		String info = db.getLoginfo("ykstar78");
		System.out.println(info);
	}
}
