package in.gokul.servlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import in.gokul.dto.SongsDto;
import in.gokul.exception.ServicesException;
import in.gokul.services.SongServices;

/**
 * Servlet implementation class AddSongsSourceServlet
 */
@MultipartConfig
@WebServlet("/AddSongsSourceServlet")
public class AddSongsSourceServlet extends HttpServlet {
	private static final String JSP = "adminWorks.jsp?errorMessage=";
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String songName = request.getParameter("songName").toUpperCase();

		SongsDto songDetails = null;
		try {

			if (!SongServices.isSongSourceAvailable(songName)) {
				if (SongServices.isSongAvailableInSongsDatabase(songName)) {

					final Part songPart = request.getPart("songSource");
					final Part imagePart = request.getPart("imageSource");
					final String songFileName = getFileName(songPart);
					final String imageFileName = getFileName(imagePart);
					String fileLocation = getServletContext().getInitParameter("upload.location");
					if (fileLocation == null || "null".equals(fileLocation)) {
						fileLocation = "D:/uploads";
					}
					File songUploads = new File(fileLocation + File.separator + songFileName);
					File imageUploads = new File(fileLocation + File.separator + imageFileName);

					songDetails = copyFiles(response, songName, songDetails, songPart, imagePart, songUploads,
							imageUploads);

					if ((SongServices.addSongSource(songDetails))) {

						response.sendRedirect("adminWorks.jsp?info=" + "Succesfully added");
					} else {
						response.sendRedirect(JSP + "Cannot add Song");

					}
				} else {
					response.sendRedirect(JSP + "Song not available in songs database");

				}
			} else {
				response.sendRedirect(JSP + "Song source already exists");
			}

		} catch (ServicesException e) {
			String errorMessage = "unable to add Song";
			response.sendRedirect(JSP + errorMessage);
		}

	}

	/**
	 * copies the uploaded file into specific location
	 * 
	 * @param response
	 * @param songName
	 * @param songDetails
	 * @param songPart
	 * @param imagePart
	 * @param songUploads
	 * @param imageUploads
	 * @return
	 * @throws IOException
	 */
	private SongsDto copyFiles(HttpServletResponse response, String songName, SongsDto songDetails, final Part songPart,
			final Part imagePart, File songUploads, File imageUploads) throws IOException {
		try (InputStream songStream = songPart.getInputStream(); InputStream imageStream = imagePart.getInputStream()) {

			Files.copy(songStream, songUploads.toPath(), StandardCopyOption.REPLACE_EXISTING);
			Files.copy(imageStream, imageUploads.toPath(), StandardCopyOption.REPLACE_EXISTING);
			songDetails = new SongsDto(songName, songStream, imageStream, songUploads, imageUploads);

		} catch (Exception e) {

			response.sendRedirect(JSP + "Unable to save the uploaded file");
		}
		return songDetails;
	}

	/**
	 * gets the file name
	 * 
	 * @param part
	 * @return
	 */
	private String getFileName(final Part part) {
		final String partHeader = part.getHeader("content-disposition");
		for (String content : partHeader.split(";")) {
			if (content.trim().startsWith("filename")) {
				return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
			}
		}
		return null;
	}
}
