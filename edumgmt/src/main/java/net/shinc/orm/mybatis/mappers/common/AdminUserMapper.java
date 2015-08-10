package net.shinc.orm.mybatis.mappers.common;

import java.util.List;

import net.shinc.orm.mybatis.bean.common.AdminUser;
import net.shinc.orm.mybatis.bean.common.Company;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

public interface AdminUserMapper {
    int deleteByPrimaryKey(Integer id);

    public int insert(AdminUser record);

    int insertSelective(AdminUser record);

    public List<AdminUser> getAdminUserList(Company company,  PageBounds pb);
    
    public List<AdminUser> getAdminUserList(Company company);
    
    public int getAdminUserListCount();
    
    public AdminUser selectByPrimaryKey(Integer id);
    
    public AdminUser getAdminUserById(Integer id);
    
    public AdminUser getAdminUserByNickName(String nickname);
    
    public List<AdminUser> getAdminUserSelective(AdminUser adminUser);

    int updateByPrimaryKeySelective(AdminUser record);

    int updateByPrimaryKey(AdminUser record);
    
    public int addAdminUser(AdminUser adminUser);
    
    public List<AdminUser> getAdminUserListByPosition(Integer positionId,PageBounds pb);
    
    public List<AdminUser> getAdminUserByCompany(Integer companyId,PageBounds pb);
    
}
