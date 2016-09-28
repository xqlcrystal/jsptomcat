package mypack;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ContextTestServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext context=getServletContext();
		
		System.out.println("Email:"+context.getInitParameter("emailofwebmaster"));
		System.out.println("Path"+context.getRealPath("/WEB-INFO"));
		System.out.println("Path"+context.getMimeType("/WEB-INFO/web.xml"));
	}

}
