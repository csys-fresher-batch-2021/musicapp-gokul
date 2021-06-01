package in.gokul.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.gokul.services.AdminLoginServices;

import in.gokul.validation.UserValidator;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		try {
			String adminName = request.getParameter("adminName");
			String password = request.getParameter("password");
			boolean isValidLogin = false;
			if (UserValidator.isValidUserName(adminName)) {
				isValidLogin = AdminLoginServices.adminLoginService(adminName, password);
			}
			if (isValidLogin) {
				HttpSession session = request.getSession();
				session.setAttribute("ROLE", "ADMIN");
				session.setAttribute("Name", adminName);
				session.setMaxInactiveInterval(300); 
				RequestDispatcher dispatcher = request.getRequestDispatcher("adminWorks.jsp");
				dispatcher.forward(request, response);
			} else {
				String errorMessage = "Invalid login credentials";
				response.sendRedirect("adminLogin.jsp?errorMessage=" + errorMessage);
			}
		} catch (ServletException | IOException e) {

			e.printStackTrace();
		}

	}
}
