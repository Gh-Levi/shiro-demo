package org.levi.shiro.demo.mapper;

import org.apache.ibatis.annotations.Param;
import org.levi.shiro.demo.bean.UserBean;
import org.springframework.stereotype.Repository;
@Repository
public interface UserBeanMapper {
	
    int deleteByPrimaryKey(Integer id);

    int insert(UserBean record);

    int insertSelective(UserBean record);

    UserBean selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserBean record);

    int updateByPrimaryKey(UserBean record);
    
    UserBean selectByUserName(@Param("username")String username);
}