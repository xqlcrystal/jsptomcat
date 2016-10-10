package mypack;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.javafx.stage.EmbeddedWindow;

public class DirTestServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ServletContext context=getServletContext();
		
		resp.setContentType("text/html;charset=GB2312");
		
		PrintWriter writer=resp.getWriter();
		
		Enumeration<String> enumeration=context.getAttributeNames();
		while (enumeration.hasMoreElements()) {
			String attrname = (String) enumeration.nextElement();
			writer.println("<br>"+attrname+":"+context.getAttribute(attrname));
			
		}
		writer.close();
		
		File workdir=(File)context.getAttribute("javax.servlet.context.tempdir");
		
		FileOutputStream fileOutputStream=new FileOutputStream(workdir+"/"+"temp.txt");
		fileOutputStream.write("Hello world".getBytes());
		fileOutputStream.close();
	}

}
