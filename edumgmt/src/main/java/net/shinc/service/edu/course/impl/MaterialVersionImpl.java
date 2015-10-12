package net.shinc.service.edu.course.impl;

import java.util.List;

import net.shinc.orm.mybatis.bean.edu.MaterialVersion;
import net.shinc.orm.mybatis.mappers.edu.MaterialVersionMapper;
import net.shinc.service.edu.course.MaterialVersionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName: MaterialVersionService
 * @Description: 书商服务接口实现
 * @author hushichong
 * @date 2015年9月15日 下午1:03:21
 */
@Service
public class MaterialVersionImpl implements MaterialVersionService {
	
	@Autowired
	private MaterialVersionMapper materialVersionMapper;

	@Override
	public Integer addMaterialVersion(MaterialVersion materialVersion) {
		return materialVersionMapper.insert(materialVersion);
	}

	@Override
	public Integer updateMaterialVersion(MaterialVersion materialVersion) {
		return materialVersionMapper.update(materialVersion);
	}

	@Override
	public Integer deleteMaterialVersionById(Integer id) {
		return materialVersionMapper.deleteById(id);
	}

	@Override
	public MaterialVersion getMaterialVersionById(Integer id) {
		return (MaterialVersion)materialVersionMapper.findById(id);
	}

	@Override
	public List<MaterialVersion> getMaterialVersionList(MaterialVersion materialVersion) {
		return materialVersionMapper.findAll(materialVersion);
	}

	

}
