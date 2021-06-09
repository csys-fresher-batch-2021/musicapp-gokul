package in.gokul.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import in.gokul.dto.PlaylistDto;
import in.gokul.exception.DbException;
import in.gokul.services.PlaylistServices;

/**
 * Servlet implementation class GetAllPlaylistServlet
 */
@WebServlet("/GetAllPlaylistServlet")
public class GetAllPlaylistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetAllPlaylistServlet() {
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

			List<PlaylistDto> list = PlaylistServices.getAllPlaylist(userName);
			Gson gson = new Gson();
			String json = gson.toJson(list);

			PrintWriter out = response.getWriter();
			out.print(json);
			out.flush();
		} catch (IOException|DbException e) {
			String errorMessage = "Cannot fetch all Playlist ";
			response.sendRedirect("playlist.jsp?errorMessage=" + errorMessage);
		}

	}

}
