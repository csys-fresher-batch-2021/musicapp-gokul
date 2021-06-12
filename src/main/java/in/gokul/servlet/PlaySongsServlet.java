package in.gokul.servlet;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.gokul.exception.ServicesException;
import in.gokul.services.SongServices;


/**
 * Servlet implementation class PlaySongsServlet
 */
@WebServlet("/PlaySongsServlet")
public class PlaySongsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlaySongsServlet() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String songName=request.getParameter("songName");
		
		try {
			byte[] song = 	SongServices.getSongSource(songName);		
			OutputStream obj = response.getOutputStream();
			obj.write(song);
		} catch (ServicesException |IOException e) {
			String errorMessage = "unable to retireve song ";
			response.sendRedirect("playSongs.jsp?errorMessage=" + errorMessage);

		}
	}


}
