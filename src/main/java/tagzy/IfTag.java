package tagzy;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class IfTag extends SimpleTagSupport{
	private boolean dd;
	public boolean isDd() {
		return dd;
	}
	public void setDd(boolean dd) {
		this.dd = dd;
	}
	@Override
	public void doTag() throws JspException, IOException {
		// TODO Auto-generated method stub
		super.doTag();
		if(dd){
			this.getJspContext().getOut().print("yes");
		}else {
			this.getJspContext().getOut().print("no");
		}
	}
}
