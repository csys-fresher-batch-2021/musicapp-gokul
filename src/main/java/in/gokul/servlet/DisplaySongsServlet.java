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

import in.gokul.services.DisplaySongsService;

/**
 * Servlet implementation class DisplaySongsServlet
 */
@WebServlet("/DisplaySongsServlet")
public class DisplaySongsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplaySongsServlet() {
        super();
  
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Song> list = DisplaySongsService.getAllSongsService();

		
			Gson gson = new Gson();
			String json = gson.toJson(list);
			

			// Step 3: Write the json in response and flush it
			PrintWriter out = response.getWriter();
			out.print(json);
			out.flush();

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	}


