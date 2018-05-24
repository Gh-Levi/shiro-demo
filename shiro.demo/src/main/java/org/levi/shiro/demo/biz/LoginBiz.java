package org.levi.shiro.demo.biz;

public interface LoginBiz {
	
	/**
	 * @param username
	 * @param password
	 * @return
	 */
	boolean doLogin(String username, String password);
}
