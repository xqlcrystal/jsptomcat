package mypack;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LifeServlet extends  GenericServlet{

	
	private int initvar=0;
	private int servicevar=0;
	private int destoryvar=0;
	private String name;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		
		initvar++;
		name=config.getServletName();
		System.out.println(name+">init();Servlet ��ʼ����"+initvar+"��");
	}
	
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		servicevar++;
		System.out.println(name+">service();Servlet ������"+servicevar+"��");
	}
	
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		destoryvar++;
		System.out.println(name+">destroy();Servlet ������"+destoryvar+"��");
	}
	
	
	
	
}
