package org.levi.shiro.demo.base;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.levi.shiro.demo.bean.UserBean;
import org.levi.shiro.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class MyDatabaseRealm extends AuthorizingRealm {
	
	@Autowired
	private UserService userService;
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		if(token == null) {
			throw new AuthenticationException("用户名密码为空，登陆失败！");
		}
		String username = (String)token.getPrincipal();
		UserBean existUser = userService.getUserByName(username);
		char [] credentials = (char[]) token.getCredentials();
		String currentUserPassword = String.valueOf(credentials);
		if(existUser != null && currentUserPassword.equals(existUser.getPassword())) {
			SimpleAuthenticationInfo currentAuthenInfo = new SimpleAuthenticationInfo(token.getPrincipal(), token.getCredentials(),"myRealm");
			return currentAuthenInfo;
		}else {
			throw new AuthenticationException("用户名或密码错误，登陆失败！");
		}
	}

}
