package dao;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.BookLibraryDTO;

public class BookLibraryDAO {
	private static Connection getConnection() throws URISyntaxException, SQLException {
		
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		URI dbUri = new URI(System.getenv("DATABASE_URL"));
	    String username = dbUri.getUserInfo().split(":")[0];
	    String password = dbUri.getUserInfo().split(":")[1];
	    String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();
	   
	
	    return DriverManager.getConnection(dbUrl, username, password);
	}
	
	// 引数の Student インスタンスを元にデータを1件INSERTするメソッド
	public static int registerBook(BookLibraryDTO book) {
		String sql = "INSERT INTO book_library(bookname,writer,publisher,isbn) VALUES( ?, ?, ?, ?)";
		int result = 0;
		
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(1, book.getBookname());
			pstmt.setString(2,book.getWriter());
			pstmt.setString(3, book.getPublisher());
			pstmt.setString(4,book.getIsbn());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} finally {
			System.out.println(result + "件更新しました。");
		}
		return result;
	}
	
public static List<BookLibraryDTO> selectAlllibrary() {
		
		List<BookLibraryDTO> result = new ArrayList<>();
		String sql = "SELECT * FROM book_library";
		
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			try (ResultSet rs = pstmt.executeQuery()){
				while(rs.next()) {
					
					String book_name=rs.getString("bookname");
					String writer=rs.getString("writer");
					String publisher=rs.getString("publisher");
					String isbn_number=rs.getString("isbn");
					BookLibraryDTO employee=new BookLibraryDTO(book_name,writer,publisher,isbn_number );
					
					
					result.add(employee);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return result;
	}







	
}
