package dao;

public class BookAccountDAO {
	private static final String URL = "jdbc:mysql://localhost:3306/jdbcsample?serverTimezone=Asia/Tokyo";
	private static final String USER = "AppUser";
	private static final String PW = "morijyobi";

	private static void loadDriver() {
		try {
			// JDBCドライバのロード
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}