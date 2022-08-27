package ChatDB;
import java.sql.*;

public class ChatLoginDB {
	private Connection conn = null;
	private ResultSet rs;
	private Statement stmt;
	
	public ChatLoginDB() {
		try {
			// Driver Loading
			// ClassŬ������ forName�޼ҵ�� String���·� �� ������ Ŭ���� ��ü�� ��ȯ�Ѵ�.
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost/loginfo";
			// Connect with DB 
			// DriverManager.getConnection(url, userName, password);
			conn = DriverManager.getConnection(url, "root", "rladudrhks");
			stmt = conn.createStatement();
			System.out.println("DB���� ����");
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public String getLoginfo(String id) {
		String info = null;
		String sql = "SELECT pw FROM profile WHERE id=" + "\'" + id + "\'";
		try {
			rs = stmt.executeQuery(sql);
			// rs.next�� �̿��� �ܼ��� �̵����Ѿ� �Ѵ�. ó���� Column�� ������ �ܼ��� �����Ѵ�.
			if(rs.next()) {
				info = rs.getString(1);
			}
		} catch (SQLException e) {
			System.out.println("���̵� �����ϴ�.");
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
//		db.insertProfile("�迵��", "ykstar78", "1111", "�Ȼ�� �ܿ��� �ؾ�5�� 17 �׶���Ƽ���� 2������Ʈ 201�� 902ȣ", "01038305274");
		String info = db.getLoginfo("ykstar78");
		System.out.println(info);
	}
}
