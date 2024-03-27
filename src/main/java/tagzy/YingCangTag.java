package tagzy;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class YingCangTag extends SimpleTagSupport{
	@Override
	public void doTag() throws JspException, IOException {
		// TODO Auto-generated method stub
		StringWriter sw=new StringWriter();
		this.getJspBody().invoke(sw);
		String s=sw.toString();
		String ss = s.replaceAll("(\\d{3})\\d{4}(\\d{3})", "$1****$2");
		this.getJspContext().getOut().print(ss);
	}
}
