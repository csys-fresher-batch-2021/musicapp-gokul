package in.gokul.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.gokul.dto.LikedSongsDto;
import in.gokul.services.SongServices;

/**
 * Servlet implementation class LikedSongsServlet
 */
@WebServlet("/LikedSongsServlet")
public class LikedSongsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LikedSongsServlet() {
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
			String songName = request.getParameter("songName");
			String userName = request.getParameter("userName");
			LikedSongsDto details = new LikedSongsDto(userName, songName);
			if ((!SongServices.isUserAlreadyLiked(details)) && (SongServices.addLikedSongs(details))) {
				response.sendRedirect("displaySongs.jsp?info=" + " Liked, Done!");

			} else {
				response.sendRedirect("displaySongs.jsp?errorMessage=" + "Already Liked this song");

			}
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

}
