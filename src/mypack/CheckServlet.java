package mypack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CheckServlet extends GenericServlet {

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String msg=null;
		if(username==null){
			msg="Please input user name.";
		}else {
			msg="Hello."+username;
		}
		
		request.setAttribute("msg", msg);
		
		ServletContext context=getServletContext();
		RequestDispatcher dispatcher=context.getRequestDispatcher("/output");
		
		
		PrintWriter writer=response.getWriter();
		writer.println("before dispatcher");
		System.out.println("before dispatcher");
		writer.close();
		dispatcher.forward(request, response);
		
		writer.println("after dispatcher");
		
	}

}
