package org.levi.shiro.demo.service;

import org.levi.shiro.demo.bean.UserBean;

public interface UserService {

	/**
	 * �����û��������û�
	 * @param username
	 * @return
	 */
	UserBean getUserByName(String username);
	
}
