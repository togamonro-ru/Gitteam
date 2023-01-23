package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookLibraryDAO;
import dto.BookLibraryDTO;

/**
 * Servlet implementation class Register_servlet
 */
@WebServlet("/Register_servlet")
public class Register_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		String book_name = request.getParameter("bookname");
		String writer = request.getParameter("writer");
		String publisher = request.getParameter("publisher");
		String isbn_number = request.getParameter("isbnnumber");
		
		BookLibraryDTO library = new BookLibraryDTO(book_name, writer, publisher, isbn_number);
		
		int result = BookLibraryDAO.registerBook(library);
		
		if(result == 1) {
			String view = "WEB-INF/view/success2.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
		}else {
			String view = "WEB-INF/view/fail.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
