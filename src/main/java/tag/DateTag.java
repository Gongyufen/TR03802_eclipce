package tag;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class DateTag extends SimpleTagSupport{
	private String pattern;
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
	public String getPattern() {
		return pattern;
	}
	@Override
	public void doTag() throws JspException, IOException {
		// TODO Auto-generated method stub
		super.doTag();
		 //输出标签体的内容 
		this.getJspBody().invoke(null);
		Date now=new Date();
		//格式化日期
		DateFormat fmt=new SimpleDateFormat(this.pattern);
		String str=fmt.format(now);
		//获取out对象，类型为JSPWriter
		JspWriter out=this.getJspContext().getOut();
		//输出到浏览器
		out.print(str);
	}
}
