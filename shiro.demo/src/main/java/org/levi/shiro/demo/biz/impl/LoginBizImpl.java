package org.levi.shiro.demo.biz.impl;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.levi.shiro.demo.base.SpringContextUtil;
import org.levi.shiro.demo.biz.LoginBiz;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
@Service
public class LoginBizImpl implements LoginBiz {
	
	private static Logger log  = LoggerFactory.getLogger(LoginBizImpl.class);
	
	public boolean doLogin(String username, String password) {

		org.apache.shiro.mgt.SecurityManager securityManager = SpringContextUtil.getBean("securityManager");
		SecurityUtils.setSecurityManager(securityManager);
		Subject currentUser = SecurityUtils.getSubject();
		//Session session = currentUser.getSession();
		if (!currentUser.isAuthenticated()) {
			UsernamePasswordToken token = new UsernamePasswordToken(username, password);
			token.setRememberMe(true);
			try {
				currentUser.login(token);
				return true;
			} catch (UnknownAccountException uae) {
				log.info("There is no user with username of " + token.getPrincipal());
			} catch (IncorrectCredentialsException ice) {
				log.info("Password for account " + token.getPrincipal() + " was incorrect!");
			} catch (LockedAccountException lae) {
				log.info("The account for username " + token.getPrincipal() + " is locked.  "
						+ "Please contact your administrator to unlock it.");
			}
			catch (AuthenticationException ae) {
				// unexpected condition? error?
			}
		}
		return false;
	}

}
