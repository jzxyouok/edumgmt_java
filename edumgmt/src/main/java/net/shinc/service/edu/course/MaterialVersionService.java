package net.shinc.service.edu.course;

import java.util.List;

import net.shinc.orm.mybatis.bean.edu.MaterialVersion;

/**
  * @ClassName: MaterialVersionService
  * @Description: 教材版本 服务接口
  * @author hushichong
  * @date 2015年9月15日 下午1:03:21
 */
public interface MaterialVersionService {

	public Integer addMaterialVersion(MaterialVersion materialVersion);
	
	public Integer updateMaterialVersion(MaterialVersion materialVersion);
	
	public Integer deleteMaterialVersionById(Integer id);
	
	public MaterialVersion getMaterialVersionById(Integer id);
	
	public List<MaterialVersion> getMaterialVersionList(MaterialVersion materialVersion);
	
}
