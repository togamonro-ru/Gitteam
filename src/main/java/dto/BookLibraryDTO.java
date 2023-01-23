package dto;

public class BookLibraryDTO {
	private String bookname;
	private String writer;
	private String publisher;
	private String isbn;
	
	public BookLibraryDTO(String bookname, String writer, String publisher, String isbn) {
		super();
		this.bookname = bookname;
		this.writer = writer;
		this.publisher = publisher;
		this.isbn = isbn;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
}
