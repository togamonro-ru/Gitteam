package dto;

public class BookAccountDTO {
	private int id;
	private String name;
	private String mail;
	private int phon;
	private String salt;
	private String password;
	
	public BookAccountDTO(int id, String name, String mail, int phon, String salt, String password) {
		super();
		this.id = id;
		this.name = name;
		this.mail = mail;
		this.phon = phon;
		this.salt = salt;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public int getPhon() {
		return phon;
	}

	public void setPhon(int phon) {
		this.phon = phon;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
