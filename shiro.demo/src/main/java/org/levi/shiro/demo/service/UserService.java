package org.levi.shiro.demo.service;

import org.levi.shiro.demo.bean.UserBean;

public interface UserService {

	/**
	 * 根据用户名查找用户
	 * @param username
	 * @return
	 */
	UserBean getUserByName(String username);
	
}
