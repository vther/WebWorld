package com.dh.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

/**
 * Servlet implementation class ServeltContext_Test
 */
@WebServlet("/ServeltContext_Test")
public class ServeltContext_Test extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletContext servletContext = this.getServletContext();
		servletContext.setAttribute("key", "This is a attribute");
		// System.out.println(servletContext.getAttribute("key"));

		// 获取文件真实路径,参数path代表资源文件的虚拟路径，它应该以正斜线(/)开始，“/“表示当前web应用的根目录
		System.out.println(servletContext.getRealPath("/"));// D:\IDE\apache-tomcat-7.0.27-myeclipse\webapps\WebWorld\
		System.out.println(servletContext.getRealPath("/aHelloWorld.html"));// D:\IDE\apache-tomcat-7.0.27-myeclipse\webapps\WebWorld\aHelloWorld.html

		//
		System.out.println(servletContext.getContextPath());// /WebWorld

		System.out.println(servletContext.getServerInfo());// Apache
															// Tomcat/7.0.27

		System.out.println(servletContext.getServletContextName());// WebWorld

		/*
		 * Enumeration<String> en = servletContext.getAttributeNames(); while
		 * (en.hasMoreElements()) { String key = en.nextElement();
		 * System.out.println(key + ":" + servletContext.getAttribute(key)); }
		 */

		// 该方法相当于InputStream input=new FileInputStream(new
		// File(servletContext.getRealPath(path)))
		InputStream inputStream = servletContext.getResourceAsStream("/aHelloWorld.html");
		System.out.println(IOUtils.toString(inputStream));

		Set<String> paths = servletContext.getResourcePaths("/WEB-INF");
		System.out.println(paths);// [/WEB-INF/lib/, /WEB-INF/classes/,
									// /WEB-INF/web.xml]

		response.getWriter().append("Served at: ").append(request.getContextPath());

		// 1，使用ClassLoader对象获取工程下文件
		// InputStream input = classLoader.getResourceAsStream("/test.txt");
		InputStream input = this.getClass().getClassLoader().getResourceAsStream("test.txt");// 此时加不加斜杠效果一致
		System.out.println(IOUtils.toString(input));
		// 2，使用ClassLoader对象获取包下文件
		InputStream input2 = this.getClass().getClassLoader().getResourceAsStream("/com/dh/servlet/test2.txt");
		System.out.println(IOUtils.toString(input2));
		// 3，使用Class对象获取工程下文件
		InputStream input3 = this.getClass().getResourceAsStream("/test.txt");// 这种方式必须加斜杠
		System.out.println(IOUtils.toString(input3));
		// 4，使用Class对象获取包下文件
		InputStream input4 = this.getClass().getResourceAsStream("test2.txt");// 这种方式不加斜杠
		System.out.println(IOUtils.toString(input4));
		/*
		 * 在使用Class对象获取类路径下资源时，要注意以下几点： (1) Class对象的getResourceAsStream(String
		 * path)方法中， 如果path参数不是以”/”开头，即表示采用的是相对路径，相对当前类所在的类路径，
		 * 这里相对的是ClassServlet所在的类路径：
		 * D:\apache-tomcat-7.0.42\webapps\WebWorld\WEB-INF\classes\cn\dh\
		 * servlet。文件test.txt并不在该路径下，所以必然会因为找不到该文件而出现空指针异常。 (2)
		 * 如果path参数是以“/”开头，则表示是在classes根路径，即D:\apache-tomcat-7.0.42\webapps\
		 * WebWorld\WEB-INF\classes,，下查找text.txt文件。文件test.txt确实是在classes的根路径下，
		 * 所以可以找到。 (3) 如果test.txt文件处于src目录下的cn.itcast.web.servlet包下，
		 * 那么在ClassServlet类中使用Class类来获取test.txt文件的输入流，可以采用如下方式： InputStream
		 * input=clazz.getResourceAsStream(“/cn/itcast/web/servlet/test.txt”)，
		 * 或者InputStream input=clazz.getResourceAsStream(“test.txt”)，因为test.
		 * txt与ClassServlet在同包下，所以可以采用相对路径。
		 */
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
