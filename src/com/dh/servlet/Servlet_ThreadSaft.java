package com.dh.servlet;

import java.io.IOException;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

/**
 * Servlet线程安全
 * 一个Servlet对应一个Servlet实例，也就是说Servlet是单例的，那么就有可能会出现一个Servlet同时处理多个不同的请求，
 * 这时就可能会出现线程不安全问题。如何防止出现线程安全问题，有以下三种方法：  
 * 不要在Servlet中创建成员变量，可以创建局部变量； 
 * 如果要创建成员变量，必须保证是无状态的成员变量；  
 * 如果创建的有状态的成员变量，状态必须是只读的。
 * 
 */
@WebServlet("/Servlet_ThreadSaft")
public class Servlet_ThreadSaft extends GenericServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see GenericServlet#GenericServlet()
	 */
	public Servlet_ThreadSaft() {
		super();
	}

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
	}

}
