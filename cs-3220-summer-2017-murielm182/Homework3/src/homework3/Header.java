package homework3;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Header extends SimpleTagSupport {
	
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		out.println("<img src='https://st.depositphotos.com/1378583/1543/v/950/depositphotos_15435871-stock-illustration-green-home-tea-logo.jpg 'class='logo'  >");      
		out.println("<h1>Tea House</h1>");



	}

}

