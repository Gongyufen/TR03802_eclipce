package tag;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class RepeatTag extends SimpleTagSupport{
	private int cnt=1;
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public int getCnt() {
		return cnt;
	}
	@Override
	public void doTag() throws JspException, IOException {
		// TODO Auto-generated method stub
		super.doTag();
		//定义一个输出流，用于存储标签体的内容
		StringWriter sw=new StringWriter();
		//将标签体的内容保存到sw输出流
		this.getJspBody().invoke(sw);
		//获取sw输出流中内容
		String s=sw.toString();
		//将s循环cnt次
		String result="";
		for(int i=0;i<this.cnt;i++) {
			result+=s;
		}
		//输出结果
		this.getJspContext().getOut().print(result);
	}
}
