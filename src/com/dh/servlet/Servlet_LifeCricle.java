/**
 * 
 */
package com.dh.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author l00347069
 *
 */
public class Servlet_LifeCricle implements Servlet {

	/*
	 * 该方法是销毁方法，在Servlet实例被销毁之前，Tomcat服务器调用该方法，在Servlet的一生中只调用一次。
	 */
	@Override
	public void destroy() {
		System.out.println("--------------------destroy");
	}

	/*
	 * 该方法返回一个ServletConfig对象，通过这个对象可以获取到Servlet的相关配置信息。返回的这个对象是由服务器创建，通过init()
	 * 方法传入到Servlet中，然后再传递给getServletConfig()方法。
	 */
	@Override
	public ServletConfig getServletConfig() {
		System.out.println("--------------------getServletConfig");
		return null;
	}

	/*
	 * 返回一个字符串，其中包含了Servlet的相关信息，例如，作者、版本和版权等信息。
	 */
	@Override
	public String getServletInfo() {
		System.out.println("--------------------getServletConfig");
		return null;
	}

	/*
	 * 初始化方法，当服务器创建了Servlet实例，就会立即调用该方法，完成初始化操作，该方法在Servlet的一生中也只被调用一次。
	 */
	@Override
	public void init(ServletConfig servletConfig) throws ServletException {
		System.out.println("--------------------init,servletConfig:" + servletConfig);
		// 获取ServletName
		System.out.println(servletConfig.getServletName());
		// 获取web.xml中的init-param
		System.out.println(servletConfig.getInitParameter("username"));
		System.out.println(servletConfig.getInitParameter("password"));
		// 获取所有的初始化参数名称
		Enumeration<String> e = servletConfig.getInitParameterNames();
		while (e.hasMoreElements()) {// 遍历所有初始化参数名称
			String key = e.nextElement();
			System.out.println("initParam name:" + key + ":" + servletConfig.getInitParameter(key));
		}

	}

	/*
	 * 该方法是处理请求的方法，当服务器接受到客户端访问Servlet的请求时，就会调用该方法。
	 * 服务器会创建一个表示客户端请求的ServletRequest对象和一个用于响应客户端的ServletResponse对象作为参数传递给service
	 * ()方法。 在service()方法中，可以通过ServletRequest对象获得客户端的相关请求信息，在对请求进行处理之后，
	 * 可以调用ServletResponse对象设置响应信息。 该方法在Servlet的一生中会被调用多次。
	 */
	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		System.out.println("--------------------service,req:" + req + ",resp:" + resp);
	}

}
