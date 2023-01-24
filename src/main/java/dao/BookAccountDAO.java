package dao;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.BookAccountDTO;
import util.GenerateHashedPw;
import util.GenerateSalt;

public class BookAccountDAO {
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
	public static int acountadd(BookAccountDTO account) {
		String sql = "INSERT INTO  bookaccount VALUES(default, ?, ?, ?,?,?)";
		int result = 0;
		String salt = GenerateSalt.getSalt(32);
		
	
		String hashedPw = GenerateHashedPw.getSafetyPassword(account.getPassword(), salt);
		
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(1, account.getName());
			pstmt.setString(2,account.getMail());
			pstmt.setInt(3, account.getPhon());
	
			pstmt.setString(4,salt);
			pstmt.setString(5, hashedPw);
			

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
	public static String getSaltk(String mail) {
		String sql = "SELECT salt FROM  bookaccount WHERE mail = ?";
		
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(1, mail);

			try (ResultSet rs = pstmt.executeQuery()){
				
				if(rs.next()) {
					String salt = rs.getString("salt");
					return salt;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static BookAccountDTO login(String mail, String hashedPw) {
		String sql = "SELECT * FROM  bookaccount WHERE mail = ? AND password = ?";
		
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(1, mail);
			pstmt.setString(2, hashedPw);

			try (ResultSet rs = pstmt.executeQuery()){
				
				if(rs.next()) {
				 String id = rs.getString("id");
				 String name = rs.getString("name");
					String Mail = rs.getString("mail");
					String phon = rs.getString("phon");
					String salt= rs.getString("salt");
					
					String password = rs.getString("password");
				
					int Id = Integer.parseInt(id);
					
					int Phon = Integer.parseInt(phon);
				
					return new BookAccountDTO(Id, name, Mail,Phon,salt,null);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return null;
	
}
		
	}
