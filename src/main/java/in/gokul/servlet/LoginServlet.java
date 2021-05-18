package in.gokul.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.gokul.services.UserServices;

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
			throws ServletException, IOException {

		try {
			String userName = request.getParameter("userName");
			String password = request.getParameter("password");

			if (UserServices.login(userName, password)) {
				response.sendRedirect("languages.jsp?info=" + "succesfullyloggedin");
			} else {
				String errorMessage = "Invalid Login Credentials";
				response.sendRedirect("Login.jsp?errorMessage=" + errorMessage);

			}
		} catch (RuntimeException e) {
			String errorMessage = e.getMessage();
			response.sendRedirect("Login.jsp?errorMessage=" + errorMessage);
			e.printStackTrace();
		}
	}

}
