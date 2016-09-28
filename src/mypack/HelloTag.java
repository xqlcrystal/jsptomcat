package mypack;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.TagSupport;

public class HelloTag extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public int doEndTag() throws JspException{
		
		try {
			pageContext.getOut().print("Hello");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new JspTagException(e.getMessage());
		}
		
		return EVAL_PAGE;
	}
}
