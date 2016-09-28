package mypack;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CounterServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext context=getServletContext();
		
		Counter counter=(Counter)context.getAttribute("counter");
		
		if(counter==null){
			counter=new Counter();
			context.setAttribute("counter", counter);
		}
		
		counter.add(1);
		
		System.out.println("System:"+counter.getCount());
	}
}
