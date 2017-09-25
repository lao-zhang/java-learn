package weekend;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.HTMLDocument.HTMLReader.FormAction;

public class RegServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//设置编码，但该函数在get方法中不适用，要自己对每个字符串转换
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		String name = request.getParameter("userName");
		String userName = new String(name.getBytes("ISO-8859-1"),"utf-8");
		String password = request.getParameter("userPassword");
		 String againPassword = request.getParameter("again_userPassword");
		 String sex = request.getParameter("sex");
		 String age = request.getParameter("age");
		 String email = request.getParameter("email");
		 String sheng = request.getParameter("sheng");
		 String [] feature=request.getParameterValues("feature");
		String author=request.getParameter("author");
		 PrintWriter out=response.getWriter();
		 //判断两次密码是否相符
		if(!password.equals(againPassword)){
			System.out.println("两次密码不匹配，请重新输入");
			response.getWriter().append("两次密码不匹配，请重新输入");
			response.sendRedirect("/webtry/findout.html");		//重定向到登陆页面
			return;
		}
		else
		{
			out.println("<html>");
			out.println("<head><title>RegServlet</title></head>");
			out.println("<body><h1>个人详细信息如下：</h1	>");
			out.println("<h4 >");
			out.println("姓名："+name+"<br>");
			out.println("密码："+password+"<br>");
			out.println("性别："+sex+"<br>");
			out.println("年龄："+age+"<br>");
			out.println("email："+email+"<br>");
			out.println("地址："+sheng+"<br>");
			out.println("爱好：");
			for(int i=0;i<feature.length;i++)
			{
				out.println(feature[i]);
				if(i<feature.length-1)
					out.print("、");
			}
			out.println("<br>");
			out.println("个人简介："+author+"<br>");
			out.println("</h4></body></html>"); 
			out.close();
		}
		 
		
		 
	}

	 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}