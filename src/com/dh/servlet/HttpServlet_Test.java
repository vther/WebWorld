package com.dh.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HttpServlet_Test
 */
@WebServlet(urlPatterns = { "/HttpServlet_Test" }, initParams = {
		@WebInitParam(name = "key_test", value = "value_test", description = "description_test") })
public class HttpServlet_Test extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response) 有此方法的时候不会调用doGet，doPost protected void
	 *      service(HttpServletRequest request, HttpServletResponse response)
	 *      throws ServletException, IOException { }
	 */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());

		System.out.println(request.getContentLength());//-1
		System.out.println(request.getContextPath());///WebWorld
		System.out.println(request.getServletPath());///HttpServlet_Test
		System.out.println(request.getRequestURL());//http://localhost:8080/WebWorld/HttpServlet_Test
		System.out.println(request.getRequestURI());//WebWorld/HttpServlet_Test
		System.out.println(request.getServerName());//localhost
		System.out.println(request.getServerPort());//8080
		System.out.println(request.getHeader("Accept"));//text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8
		System.out.println(request.getHeader("Accept-Encoding"));//gzip, deflate, sdch
		System.out.println(request.getHeader("Accept-Language"));//zh-CN,zh;q=0.8
		System.out.println(request.getHeader("Cache-Control"));//no-cache
		System.out.println(request.getHeader("Connection"));//keep-alive
		System.out.println(request.getHeader("Host"));//localhost:8080
		System.out.println(request.getHeader("User-Agent"));//Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/44.0.2403.155 Safari/537.36
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
