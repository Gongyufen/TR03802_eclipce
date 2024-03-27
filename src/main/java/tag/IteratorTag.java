package tag;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;


public class IteratorTag extends SimpleTagSupport{
	private Collection collection;
	private String item;
	public Collection getCollection() {
		return collection;
		}
		public void setCollection(Collection collection) {
		this.collection = collection;
		}
		public String getItem() {
		return item;
		}
		public void setItem(String item) {
		this.item = item;
		}
		@Override
		public void doTag() throws JspException, IOException {
		super.doTag();
		//循环遍历集合
		for(Object obj : this.collection) {
		//将 obj 存到作用域中
		this.getJspContext().setAttribute(this.item, obj);
		//将标签体打印输出
		this.getJspBody().invoke(null);
				}
			}
		}
