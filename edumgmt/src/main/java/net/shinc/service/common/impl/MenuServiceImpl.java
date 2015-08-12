package net.shinc.service.common.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import net.shinc.orm.mybatis.bean.common.AdminUser;
import net.shinc.orm.mybatis.bean.common.Authority;
import net.shinc.orm.mybatis.bean.common.Menu;
import net.shinc.service.common.AdminUserService;
import net.shinc.service.common.MenuService;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * @ClassName MenuServiceImpl 
 * @Description 目录菜单接口的实现
 * @author guoshijie 
 * @date 2015年7月27日 下午5:15:24
 */
@Service
public class MenuServiceImpl implements MenuService {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private AdminUserService adminUserService;
	
	@Autowired
	private ApplicationContext applicationContext;
	
	
	@Override
	public List<Menu> getMenu(AdminUser adminUser) {
		if(null != adminUser.getMenuMap() && adminUser.getMenuMap().size() > 0 ) {
			return adminUser.getMenuMap();
		}
		List<Authority> authList = adminUserService.getAuthList(adminUser);
		try {
			Resource resource = applicationContext.getResource("classpath:config/menu.xml");
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(resource.getInputStream());
			NodeList nl = doc.getElementsByTagName("menu");
			
			Map<String, Menu> map = new LinkedHashMap<String, Menu>();
			for (int i = 0; i < nl.getLength(); i++) {
				Element element = (Element) nl.item(i);
				String level = element.getElementsByTagName("level").item(0).getFirstChild().getNodeValue();
				String parent = element.getElementsByTagName("parent").item(0).getFirstChild().getNodeValue();
				String value = element.getElementsByTagName("value").item(0).getFirstChild().getNodeValue();
				String url = element.getElementsByTagName("url").item(0).getFirstChild().getNodeValue();
				for (Authority auth : authList) {
					if ("1".equals(level) && parent.equals(value) && auth.getAuthority().equals(value)) {
						map.put(parent, new Menu(auth.getRemark(), url, auth.getAuthority()));
						break;
					}
					if (!value.equals(parent) && auth.getAuthority().equals(value)) {
						if (null != map.get(parent)) {
							Menu menu = map.get(parent);
							List<Menu> sub = menu.getSub();
							if (null == sub) {
								sub = new ArrayList<Menu>();
							}
							sub.add(new Menu(auth.getRemark(), url, auth.getAuthority()));
							menu.setSub(sub);
						}
					}
				}
			}
			List<Menu> list = iteratorMap(map);
			adminUser.setMenuMap(list);
			return list;
		} catch (Exception e) {
			logger.error("目录文件读取失败==>" + ExceptionUtils.getStackTrace(e));
		} 
		return null;
	}
	
	public List<Menu> iteratorMap(Map<String, Menu> map) {
		if(null != map && map.size() > 0){
			List<Menu> list = new ArrayList<Menu>();
			Set<String> keySet = map.keySet();
			for (String string : keySet) {
				Menu menu = map.get(string);
				list.add(menu);
			}
			return list;
		}
		return null;
	}
}
