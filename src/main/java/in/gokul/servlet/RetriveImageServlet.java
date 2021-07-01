package in.gokul.servlet;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.gokul.exception.ServicesException;
import in.gokul.services.StyleServices;

/**
 * Servlet implementation class RetriveImageServlet
 */
@WebServlet("/RetriveImageServlet")
public class RetriveImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RetriveImageServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String imageName = request.getParameter("imageName");
		try {
			byte[] image = StyleServices.retireveImage(imageName);
			OutputStream obj = response.getOutputStream();
			obj.write(image);
			obj.flush();
		} catch (ServicesException |IOException e) {
			String errorMessage = "unable to retireve image";
			response.sendRedirect("index.jsp?errorMessage=" + errorMessage);

		}
	}



}
