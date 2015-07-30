package net.shinc.common;

import java.util.Map;


/**
 * Restful服务接口返回数据
 * @author zhangtaichao 2015年7月15日
 *
 */
public interface IRestMessage {
	
	public String getCode();
	
	public void setCode(String code);
	
	public String getMessage();
	
	public void setMessage(String message);
	
	public Map<String,Object> getUserInfo();
	
	public void setUserInfo(Map<String,Object> map);
	
	public String getDetail();
	
	public void setDetail(String detail);
	
	public Object getResult();
	
	public void setResult(Object o);

}
