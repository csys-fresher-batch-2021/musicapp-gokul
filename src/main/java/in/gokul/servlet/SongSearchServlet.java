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

import in.gokul.model.Song;
import in.gokul.services.SongServices;

/**
 * Servlet implementation class SongSearchServlet
 */
@WebServlet("/SongSearchServlet")
public class SongSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SongSearchServlet() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



		String songName=request.getParameter("songName").toUpperCase();
	
		Song song=new Song(songName);
		List<Song>searchedSongList=SongServices.searchSong(song);
		
		Gson gson = new Gson();
		String json = gson.toJson(searchedSongList);
		
		
		PrintWriter out = response.getWriter();
		out.print(json);
		out.flush();


		
	
	
	}



}
