package mypack;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
		
		ServletContext context = sce.getServletContext();

		Counter counter = (Counter) context.getAttribute("counter");

		if (counter != null) {

			try {
				String filepath = context.getRealPath("/count");
				filepath += "/count.txt";
				PrintWriter writer = new PrintWriter(filepath);
				writer.println(counter.getCount());
				writer.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext context = sce.getServletContext();

		try {
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(context.getResourceAsStream("/count/count.txt")));
			int count = Integer.parseInt(reader.readLine());
			reader.close();

			Counter counter = new Counter(count);
			context.setAttribute("counter", counter);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
