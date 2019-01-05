
package com.hhpsoftware.servlet;

 import java.io.IOException;
 import javax.servlet.ServletException;
 import javax.servlet.http.HttpServlet;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;
 
import com.hhpsoftware.bean.LoginBean;
import com.hhpsoftware.dao.LoginDao;
 
public class LoginServlet extends HttpServlet 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String userName = request.getParameter("name");
		String password = request.getParameter("password");
 
		LoginBean loginBean = new LoginBean(); 
 
		loginBean.setName(userName); 
		loginBean.setPassword(password);
 
		LoginDao loginDao = new LoginDao(); 
 
		String userValidate = loginDao.authenticateUser(loginBean); 
		System.out.println("welcome");
		if(userValidate.equals("SUCCESS")) 
		{
			request.setAttribute("name", userName); 
			request.getRequestDispatcher("/index.html").forward(request, response);
		}
		else
		{
			request.setAttribute("errMessage", userValidate); 
			request.getRequestDispatcher("/Login.jsp").forward(request, response);
		}
	}
}