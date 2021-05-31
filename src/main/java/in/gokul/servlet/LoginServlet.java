package in.gokul.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.gokul.exception.ServicesException;
import in.gokul.services.UserLoginServices;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException,IOException{

		try {
			String userName = request.getParameter("userName");
			String password = request.getParameter("password");

			if (UserLoginServices.login(userName, password)) {
				HttpSession session = request.getSession();
				session.setAttribute("ROLE", "USER");
				response.sendRedirect("languages.jsp?info=" + "succesfullyloggedin");
			} else {
				String errorMessage = "Invalid Login Credentials";
				response.sendRedirect("Login.jsp?errorMessage=" + errorMessage);

			}
		} catch (IOException|RuntimeException e) {
			e.printStackTrace();
			String errorMessage = e.getMessage();
			response.sendRedirect("Login.jsp?errorMessage=" + errorMessage);
		
		
		}
	}

}
