package dto;

public class BookDTO {
	private int id;
	private String name;
	private int isbn;
	
	public BookDTO(int id, String name, int isbn) {
		super();
		this.id = id;
		this.name = name;
		this.isbn = isbn;
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

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
}
