package tagzy;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ColorTag extends SimpleTagSupport{
	private String value;
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	@Override
	public void doTag() throws JspException, IOException {
		// TODO Auto-generated method stub
		super.doTag();
		StringWriter sw=new StringWriter();
		this.getJspBody().invoke(sw);
		String s=sw.toString();
		int ss=Integer.parseInt(s);
		String color;
		if(this.value!=null && !this.value.isEmpty()) {
			color=this.value;
		}else if(ss<0) {
			color="red";
		}else if(ss<1000) {
			color="green";
		}else {
			color="blue";
		}
		String context="<span style=\"color:"+color+"\">"+s+"</span>";
		this.getJspContext().getOut().print(context);
	}
}
