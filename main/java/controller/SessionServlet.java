package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.JavaBean;


@WebServlet("/SessionServlet")
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession httpSession = request.getSession();
		if(httpSession.getAttribute("isLoggedIn") != null) {
			RequestDispatcher rd = request.getRequestDispatcher("./Profile.jsp");
			rd.forward(request, response);
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("./index.jsp");
			rd.forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		
		String userName = request.getParameter("username");
		String userpass = request.getParameter("password");
		
		JavaBean javaBean = new JavaBean();
		javaBean.setUserName(userName);
		javaBean.setUserPass(userpass);
		
		
		
		if(userName.equals("admin") && userpass.equals("123") || userName.equals("frida") && userpass.equals("abc")) {
			
//			System.out.println(userBean.getUserName());
			request.setAttribute("JavaBean", javaBean);
			
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("isLoggedIn", javaBean);
			RequestDispatcher rd = request.getRequestDispatcher("./Profile.jsp");
			rd.forward(request, response);
		}
		else {
			out.println("<p>Wrong username or password</p>");
			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
			rd.include(request, response);
		}

	}
}
