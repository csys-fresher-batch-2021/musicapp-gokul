package in.gokul.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.gokul.dto.PlaySongsDto;
import in.gokul.exception.ServicesException;
import in.gokul.services.SongServices;

/**
 * Servlet implementation class AddSongsSourceServlet
 */
@WebServlet("/AddSongsSourceServlet")
public class AddSongsSourceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddSongsSourceServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String songName = request.getParameter("songName").toUpperCase();
		String songSource = request.getParameter("songSource");
		String imageSource = request.getParameter("imageSource");
		try {

			PlaySongsDto details = new PlaySongsDto(songName, songSource, imageSource);
			if (!SongServices.isSongSourceAvailable(songName)) {
				if (SongServices.isSongAvailableInSongsDatabase(songName)) {

					if ((SongServices.addSongSource(details))) {

						response.sendRedirect("adminWorks.jsp?info=" + "Succesfully added");
					} else {
						response.sendRedirect("adminWorks.jsp?errorMessage=" + "Cannot add Song");

					}
				} else {
					response.sendRedirect("adminWorks.jsp?errorMessage=" + "Song not available in songs database");

				}
			} else {
				response.sendRedirect("adminWorks.jsp?errorMessage=" + "Song source already exists");
			}

		} catch (ServicesException e) {
			String errorMessage = "unable to add Song";
			response.sendRedirect("adminWorks.jsp?errorMessage=" + errorMessage);
		}

	}

}
