package net.shinc.service.common;

import java.util.List;

import net.shinc.orm.mybatis.bean.common.AdminUser;
import net.shinc.orm.mybatis.bean.common.Menu;

/**
 * @ClassName MenuService 
 * @Description TODO
 * @author guoshijie 
 * @date 2015年7月27日 下午5:16:54
 */
public interface MenuService {

	/**
	 * 获取管理员的目录菜单
	 * @param adminUser
	 * @return
	 */
	public List<Menu> getMenu(AdminUser adminUser);
}
