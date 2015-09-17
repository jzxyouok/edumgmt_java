package net.shinc.service.edu.business;

import java.util.List;

import net.shinc.orm.mybatis.bean.edu.Parter;

/**
 * @ClassName: ParterService
 * @Description: 书商服务接口
 * @author hushichong
 * @date 2015年9月15日 下午1:03:21
 */
public interface ParterService {

	public Integer addParter(Parter parter);

	public Integer updateParter(Parter parter);

	public Integer deleteParterById(Integer id);

	public Parter getParterById(Integer id);

	public List<Parter> getParterList(Parter parter);

	/**
	 * @Title: isHasBook
	 * @Description: 该书商是否有书
	 * @param parter
	 * @return List<Parter>
	 */
	public boolean isHasBook(Parter parter);
}
