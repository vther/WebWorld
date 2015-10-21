package com.dh.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

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
		
		//response.sendError(404, "您查找的资源不存在");
		
	     response.setHeader("Content-Type","text/html;charset=utf-8");//，设置Content-Type响应头；
	     response.addHeader("xxx","XXX");
	     response.addHeader("xxx","SSS"); //这里的xxx是表示某一响应头；
	     response.setIntHeader("Context-Length",888);//通知客户端响应内容长度为888个字节； 
	     response.setDateHeader("expires",System.currentTimeMillis()+1000*60*60*24);//，设置过期时间为一天；

	     // 重定向
	     response.setHeader("Location", "/Example02/TargetServlet");
		 response.setStatus(302);
		 // 或者
		 response.sendRedirect("/Example02/index.jsp");
		 
		 // 定时刷新，其实就是定时N秒后重定向：设置名为Refresh的响应头
		 response.setHeader("Refresh", "5;url=/Example03/SecondServlet");

		 //使用Cache-Control,pragma,expires三个响应头禁用浏览器缓存
	     response.setHeader("Cache-Control", "no-cache");
	     response.setHeader("pragma", "no-cache");
	     response.setDateHeader("expires", -1);
         response.getWriter().print("GoodBye");
         
        //需要注意的是response的getWriter()方法和getOutputStream()方法不能同时使用，即字符流和字节流不能同时出现，否则会抛出异常，
        //首先给出图片的路径
		String path="D:/风景.jpg";
		//将图片写入到文件输入流中
		FileInputStream input=new FileInputStream(path);
		//使用帮助类将输入流转换成字节数组
		byte btyes[]=IOUtils.toByteArray(input);
		//使用response的getOutputStream()方法将该字节数组响应给浏览器
		response.getOutputStream().write(btyes);


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
