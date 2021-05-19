package in.gokul.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.gokul.Exception.UserException;
import in.gokul.services.AdminServices;


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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String adminName = request.getParameter("adminName");
		String password = request.getParameter("password");
	    PrintWriter out=response.getWriter();
		boolean isValidLogin;
	
			isValidLogin = AdminServices.adminLogin(adminName, password);
		 
	        if (isValidLogin) {
	        	   out.println("hello");
			HttpSession session = request.getSession();
			session.setAttribute("ROLE", "ADMIN");
			response.sendRedirect("languages.jsp");
		} else {
			String errorMessage = "Invalid login credentials";
			response.sendRedirect("adminLogin.jsp?errorMessage=" + errorMessage);
		}
	
	}
	}


