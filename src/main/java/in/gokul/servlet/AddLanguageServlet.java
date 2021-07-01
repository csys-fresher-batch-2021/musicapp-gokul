package in.gokul.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.gokul.model.Language;

import in.gokul.services.AddLanguagesService;
import in.gokul.services.AdminServices;
import in.gokul.validation.LanguageValidator;

/**
 * Servlet implementation class AdminWorksServlet
 */
@WebServlet("/AddLanguageServlet")
public class AddLanguageServlet extends HttpServlet {
	private static final String LANGUAGE_ERROR_MESSAGE = "adminWorks.jsp?addLanguageErrorMessage=";
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddLanguageServlet() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String language = request.getParameter("addLanguage").toUpperCase();
			Language inputlanguage = new Language(language);
			if ((LanguageValidator.isValidLanguage(language)) && (LanguageValidator.validlengthforLanguage(language))) {
				if ((!(AdminServices.isLanguageAlreadyAvailable(inputlanguage)))) {
					if (AddLanguagesService.addLanguage(inputlanguage)) {
						String info = "Language " + language + " added Succesfully";
						response.sendRedirect("adminWorks.jsp?addLanguageInfo=" + info);
					} else {
						response.sendRedirect(LANGUAGE_ERROR_MESSAGE + "Cannot add Language");
					}
				} else {
					response.sendRedirect(LANGUAGE_ERROR_MESSAGE + "Already Exists");
				}
			}

			else {
				response.sendRedirect(LANGUAGE_ERROR_MESSAGE + "Invalid Details");
			}
		} catch (IOException e) {
			e.printStackTrace();

		}
	}

}