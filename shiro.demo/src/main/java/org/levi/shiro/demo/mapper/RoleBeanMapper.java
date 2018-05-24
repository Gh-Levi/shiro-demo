package org.levi.shiro.demo.mapper;

import org.levi.shiro.demo.bean.RoleBean;
import org.springframework.stereotype.Repository;
@Repository
public interface RoleBeanMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RoleBean record);

    int insertSelective(RoleBean record);

    RoleBean selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RoleBean record);

    int updateByPrimaryKey(RoleBean record);
}