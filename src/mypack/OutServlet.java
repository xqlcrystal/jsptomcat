package mypack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.sun.org.apache.xml.internal.serialize.Printer;

public class OutServlet extends GenericServlet {

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		String meString=(String)request.getAttribute("msg");
		
		PrintWriter writer=response.getWriter();
		
		writer.println(meString);
		writer.close();

	}

}
