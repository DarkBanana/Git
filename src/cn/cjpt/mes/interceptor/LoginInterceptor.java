package cn.cjpt.mes.interceptor;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.cjpt.mes.pojo.vo.ActiveUser;
import cn.cjpt.mes.process.context.Config;
import cn.cjpt.mes.process.result.ResultUtil;

/**
 * 用户认证 拦截器 公开地址都可以访问，需要登录的进行拦截
 * 
 * @author yxf 2017年1月23日 下午3:44:07
 */
public class LoginInterceptor implements HandlerInterceptor {

	// 在执行handler之前来执行的
	// 用于用户认证校验、用户权限校验
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		// 校验用户身份是否合法
		HttpSession session = request.getSession();
		ActiveUser activeUser = (ActiveUser) session
				.getAttribute(Config.ACTIVEUSER_KEY);
		if (activeUser != null) {
			// 用户已经登陆，放行
			return true;
		}
		// 用户 没有登录
		// 校验用户访问是否是公开资源 地址
		List<String> open_urls = new ArrayList<>();
		open_urls.add("login.action"); // 登录页面
		open_urls.add("ValidateCode.action"); // 获取验证码
		open_urls.add("loginsubmit.action");

		// 用户访问的url
		String url = request.getRequestURI();
		for (String open_url : open_urls) {
			if (url.indexOf(open_url) >= 0) {
				// 如果访问的是公开 地址则放行
				return true;
			}
		}

		// 拦截用户操作，跳转到登陆页面
		// request.getRequestDispatcher("/WEB-INF/jsp/base/login.jsp").forward(request,
		// response);

		// 抛出异常，异常代码106（需要登陆后继续操作）
		ResultUtil.throwExcepion(ResultUtil.createWarning(Config.MESSAGE, 106,
				null));

		return false;
	}

	// 在执行handler返回modelAndView之前来执行
	// 如果需要向页面提供一些公用 的数据或配置一些视图信息，使用此方法实现 从modelAndView入手
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("HandlerInterceptor1...postHandle");

	}

	// 执行handler之后执行此方法
	// 作系统
	// 统一异常处理，进行方法执行性能监控，在preHandle中设置一个时间点，在afterCompletion设置一个时间，两个时间点的差就是执行时长
	// 实现 系统 统一日志记录
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("HandlerInterceptor1...afterCompletion");
	}

}
