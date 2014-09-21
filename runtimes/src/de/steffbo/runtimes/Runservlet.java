package de.steffbo.runtimes;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.steffbo.runtimes.util.RtHelp;

/**
 * Servlet implementation class Runservlet
 */
@WebServlet("/Run")
public class Runservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Runservlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		System.out.println("calling servlet ... " + new Date().toGMTString());

		float distance = Float.parseFloat(request.getParameter("distance"));
		Duration duration = RtHelp
				.getDuration(request.getParameter("duration"));
		long durationInS = duration.getSeconds();

		long avg = (long) (durationInS / distance);
		Duration avgDuration = Duration.parse("PT" + String.valueOf(avg) + "S");

		PrintWriter writer = response.getWriter();
		writer.printf("Distance: %.2f \n", distance);
		writer.printf("Duration: %s \n", duration);
		writer.printf("Average KM Time: %d", avgDuration.toMinutes());

		writer.flush();
		writer.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

}
