package org.levi.shiro.demo.mapper;

import org.levi.shiro.demo.bean.PermissionBean;
import org.springframework.stereotype.Repository;
@Repository
public interface PermissionBeanMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PermissionBean record);

    int insertSelective(PermissionBean record);

    PermissionBean selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PermissionBean record);

    int updateByPrimaryKey(PermissionBean record);
}