package in.gokul.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import in.gokul.dto.PlaylistDto;
import in.gokul.exception.DbException;
import in.gokul.services.PlaylistServices;
import in.gokul.validation.PlaylistValidator;

/**
 * Servlet implementation class GetSongsFromPlaylistServlet
 */
@WebServlet("/GetSongsFromPlaylistServlet")
public class GetSongsFromPlaylistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetSongsFromPlaylistServlet() {
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
			String userName = request.getParameter("userName");
			String playlistname = request.getParameter("playlist");
			if (PlaylistValidator.isValidPlaylistName(playlistname.trim())) {
				PlaylistDto dto = new PlaylistDto(playlistname, userName);
				Set<PlaylistDto> list = PlaylistServices.getPlaylistSongs(dto);

				Gson gson = new Gson();
				String json = gson.toJson(list);
				PrintWriter out = response.getWriter();
				out.print(json);
				out.flush();
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("playlist.jsp");
				dispatcher.forward(request, response);
				String errorMessage = "Playlist not available";
				response.sendRedirect("playlist.jsp?errorMessage=" + errorMessage);

			}

		} catch (IOException | DbException e) {

			e.printStackTrace();
			response.sendRedirect("playlist.jsp?errorMessage=" + "couldn't get the Playlist");
		}
	}

}
