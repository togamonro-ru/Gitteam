package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dto.BookDTO;

public class BookDAO {
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
	
	public static int deleteBook(BookDTO book) {
		loadDriver();
		String sql = "DELETE FROM book WHERE ISBN = ?";
		int result = 0;

		try (
				Connection con = DriverManager.getConnection(URL, USER, PW);	// DB接続
				PreparedStatement pstmt = con.prepareStatement(sql);			// 構文解析
				){
			
			pstmt.setInt(1,book.getIsbn());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			System.out.println(result + "件削除しました。");
		}
		return result;
	}
}
