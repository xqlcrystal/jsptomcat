package mypack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		resp.setContentType("text/html");
		PrintWriter writer=resp.getWriter();
		writer.println("<html><head><title>MainServlet</title></head>");
		writer.println("<body>");
		ServletContext context=getServletContext();
		
		RequestDispatcher headdispatcher=context.getRequestDispatcher("/header.htm");
		RequestDispatcher grRequestDispatcher=context.getRequestDispatcher("/greet");
		RequestDispatcher bootdispatcher=context.getRequestDispatcher("/footer.htm");
		
		headdispatcher.include(req, resp);
		
		grRequestDispatcher.include(req, resp);
		
		bootdispatcher.include(req, resp);
		
		
		
		
		
		writer.println("</body></html>");
		
		writer.close();
	}

}
