package org.levi.shiro.demo.service.impl;

import org.levi.shiro.demo.bean.UserBean;
import org.levi.shiro.demo.mapper.UserBeanMapper;
import org.levi.shiro.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserBeanMapper userBeanMapper;
	
	public UserBean getUserByName(String username) {
		
		return userBeanMapper.selectByUserName(username);
	}

}
