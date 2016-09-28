package mypack;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadServlet extends HttpServlet {

	private String filepath;
	private String tempFilePath;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/plain");
		
		PrintWriter writer=resp.getWriter();
		
		try {
			DiskFileItemFactory factory=new DiskFileItemFactory();
			factory.setSizeThreshold(4*1024);
			factory.setRepository(new File(tempFilePath));
			
			ServletFileUpload upload=new ServletFileUpload(factory);
			upload.setFileSizeMax(128*1024*1024);
			
			List items=upload.parseRequest(req);
			
			Iterator iterator=items.iterator();
			while (iterator.hasNext()) {
				FileItem item=(FileItem)iterator.next();
				
				if(item.isFormField()){
					processFormField(item,writer);
				}else {
					processUploadFile(item,writer);
				}
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		writer.close();
	}

	private void processUploadFile(FileItem item, PrintWriter writer) throws Exception {
		String filename=item.getName();
		int index=filename.lastIndexOf("\\");
		filename=filename.substring(index+1,filename.length());
		long filesize=item.getSize();
		
		if(filename.equals("") || filesize==0)return;
		File uploadfile=new File(filepath+"/"+filename);
		item.write(uploadfile);
		writer.println(filename+" is saved.\r\n");
		writer.println("The size of "+filename+" is "+filesize+"\r\n");
		
	}

	private void processFormField(FileItem item, PrintWriter writer) {
		
		String name=item.getFieldName();
		String value=item.getString();
		writer.println(name+":"+value+"\r\n");
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		filepath=config.getInitParameter("filepath");
		tempFilePath=config.getInitParameter("tempFilePath");
		
		filepath=getServletContext().getRealPath(filepath);
		tempFilePath=getServletContext().getRealPath(tempFilePath);
		
	}

}
