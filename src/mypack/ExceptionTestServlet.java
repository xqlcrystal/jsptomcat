package mypack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.UnavailableException;

public class ExceptionTestServlet extends GenericServlet {

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String condition=request.getParameter("condition");
		
		if(condition==null) condition="OK";
		if(condition.equals("1")){
			throw new ServletException("condition1");
		}else if (condition.equals("2")) {
			throw new UnavailableException("condition2",2);
		}else if (condition.equals("3")) {
			throw new UnavailableException("condition3");
		}
		
		PrintWriter writer=response.getWriter();
		writer.println("It is ok");
		writer.close();
	}

}
