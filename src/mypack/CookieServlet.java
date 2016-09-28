package mypack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieServlet extends HttpServlet {

	
	int count=0;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/plain");
		
		Cookie cookie=null;
		
		PrintWriter writer=resp.getWriter();
		Cookie[] cookies=req.getCookies();
		
		if(cookies!=null){
			for (int i = 0; i < cookies.length; i++) {
				writer.println("cookie name:"+cookies[i].getName());
				writer.println("cookie value:"+cookies[i].getValue());
				writer.println("Max age:"+cookies[i].getMaxAge());
				
				if(cookies[i].getName().equals("username")){
					cookie=cookies[i];
				}
			}
		}
		else {
			writer.println("No cookie");
		}
		
		resp.addCookie(new Cookie("cookiename"+count, "cookievalue"+count));
		
		count++;
		
		
		
		if(cookie==null){
			cookie=new Cookie("username", "Tom");
			cookie.setMaxAge(60*60);
			resp.addCookie(cookie);
		}else if (cookie.getValue().equals("Tom")) {
			cookie.setValue("Jack");
			resp.addCookie(cookie);
		}else if (cookie.getValue().equals("Jack")) {
			cookie.setMaxAge(0);
			resp.addCookie(cookie);
			
		}
				
		writer.close();		
	}

}
