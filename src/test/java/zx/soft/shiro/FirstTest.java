package zx.soft.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;

public class FirstTest {

	@Test
	public void testHelloWorld() {
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
		SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);

		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("jimbo","123");

		try{
			//身份验证
			subject.login(token);
			System.out.println("login success!!");
		}catch(AuthenticationException e){
			//身份验证失败
		}
		Assert.assertEquals(true, subject.isAuthenticated());
		subject.logout();
	}
}
