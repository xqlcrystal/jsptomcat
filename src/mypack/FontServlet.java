package mypack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FontServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String word=req.getParameter("word");
		if(word==null)word="hello";
		
		String color=getInitParameter("color");
		String size=getInitParameter("size");
		
		System.out.println("Servlet:"+getServletName());
		
		PrintWriter out=resp.getWriter();
		
		out.println("<html><head><title>FontSize</title></head>");
		out.println("<body>");
		out.println("<font size='"+size+"' color='"+color+"'>"+word+"</font>");
		
		out.println("</body></html>");
		out.close();
	}

}
