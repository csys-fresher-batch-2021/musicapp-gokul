package in.gokul.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.gokul.model.Song;
import in.gokul.services.SongServices;

/**
 * Servlet implementation class DeleteSongsServlet
 */
@WebServlet("/DeleteSongsServlet")
public class DeleteSongsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteSongsServlet() {
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
			String songName = request.getParameter("songName").toUpperCase();
			String movieName = request.getParameter("movieName").toUpperCase();
			String languageName = request.getParameter("languageName").toUpperCase();

			Song info = new Song(songName, movieName, languageName);

			if ((SongServices.deleteSong(info))) {

				response.sendRedirect("displaySongs.jsp?info=" + "Succesfully deleted !");
			} else {
				response.sendRedirect("displaySongs.jsp?errorMessage=" + "Cannot delete Songs ");

			}
		} catch (IOException e) {

			response.sendRedirect("displaySongs.jsp?errorMessage=" + "Cannot delete Songs");
			e.printStackTrace();
		}
	}

}
