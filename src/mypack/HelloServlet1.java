package mypack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;



public class HelloServlet1 extends GenericServlet {

private String username;
	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		

		username=request.getParameter("username");
		
		if(username!=null){
			username=new String(username.getBytes("ISO-8859-1"),"GB2312");
		}
		
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		response.setContentType("text/html;charset=GB2312");
		
		
		PrintWriter out=response.getWriter();
		out.println("<html><head><title>HelloServlet</title>");
		out.println("<body>");
		out.println("ÄãºÃ="+username);
		out.println("</body></html>");
		out.close();
	}

}
