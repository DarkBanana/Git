package cn.cjpt.mes.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.cjpt.mes.process.context.Config;
import cn.cjpt.mes.process.result.ResultUtil;
import cn.cjpt.mes.service.SysService;

/**
 * 
 * 2017年2月19日 下午7:11:10
 * 
 * @author yxf
 */
@Controller
public class LoginController {

	@Autowired
	private SysService sysService;

	/**
	 * 用户登陆提交方法
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */

	// 登陆提交地址，和applicationContext-shiro.xml中配置的loginurl一致
	@RequestMapping("login")
	public String login(HttpServletRequest request, Model model) throws Exception {

		// 如果登陆失败从request中获取认证异常信息，shiroLoginFailure就是shiro异常类的全限定名
		String exceptionClassName = (String) request.getAttribute("shiroLoginFailure");
		// 根据shiro返回的异常类路径判断，抛出指定异常信息
		if (exceptionClassName != null) {
			String msg = null;
			if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
				msg = "账号不存在";
				model.addAttribute("userNameError", msg);
			} else if (IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
				msg = "用户名或密码错误";
				model.addAttribute("pswError", msg);
			} else if ("randomCodeError".equals(exceptionClassName)) {
				msg = "验证码错误";
				model.addAttribute("codeError", msg);
			} else {
				throw new Exception();// 最终在异常处理器生成未知错误
			}
		}

		// 登陆失败还到login页面
		return "/base/login";
	}
}
