package in.gokul.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.gokul.model.User;
import in.gokul.services.NewUserRegistrationService;

/**
 * Servlet implementation class NewUserRegistrationServlet
 */
@WebServlet("/NewUserRegistrationServlet")
public class NewUserRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NewUserRegistrationServlet() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userName = request.getParameter("username");
		String emailId = request.getParameter("emailId");
		String password = request.getParameter("password");
		
		String gender = request.getParameter("gender");



		try {
			Long mobilenum = Long.parseLong(request.getParameter("mobilenum"));
			Integer age = Integer.parseInt(request.getParameter("age"));
			User user = new User(userName, emailId, mobilenum, password, gender, age);
			if (NewUserRegistrationService.isValidDetails(userName, emailId, mobilenum.toString(), password, gender,
					age)) {

				if (NewUserRegistrationService.addUser(user)) {
					response.sendRedirect("Login.jsp?info=" + "succesfullyRegistered");
				}
			} else {
				String errorMessage = "Invalid Registration Credentials";
				response.sendRedirect("NewUserRegistration.jsp?errorMessage=" + errorMessage);

			}

		} catch ( IOException e) {

			e.printStackTrace();
			String errorMessage = e.getMessage();
			response.sendRedirect("NewUserRegistration.jsp?errorMessage=" + errorMessage);

		}
		catch (NumberFormatException e) {
			response.sendRedirect("NewUserRegistration.jsp?errorMessage=" + e.getMessage());

		
		}
	}

}
