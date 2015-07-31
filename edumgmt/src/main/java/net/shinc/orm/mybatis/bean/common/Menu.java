package net.shinc.orm.mybatis.bean.common;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.List;

/**
 * @ClassName Menu 
 * @Description 目录菜单类
 * @author guoshijie 
 * @date 2015年7月31日 上午9:57:45
 */
public class Menu implements Serializable{

	private static final long serialVersionUID = -4234248111333800717L;

	private String title;
	
	private String url;
	
	private String tag;
	
	private List<Menu> sub;
	
	public Menu() {
		super();
	}
	
	public Menu(String title, String url, String tag) {
		super();
		this.title = title;
		this.url = url;
		this.tag = tag;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public List<Menu> getSub() {
		return sub;
	}

	public void setSub(List<Menu> sub) {
		this.sub = sub;
	}
	
	@Override
	public String toString() {
		return MessageFormat.format("title:{0}\turl:{1}\ttag{2}\tsub:{3}", this.title,this.url,this.tag,this.sub);
	}
	
}
