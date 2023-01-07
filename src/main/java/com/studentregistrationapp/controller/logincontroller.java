package com.studentregistrationapp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.studentregistrationapp.model.DAOimpl;


@WebServlet("/verifylogin")
public class logincontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public logincontroller() {
        super();
        // TODO Auto-generated constructor stub
    }
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		DAOimpl dao = new DAOimpl();
		dao.connectDB();
		
		boolean status = dao.verifyCredentials(email, password);
		if (status==true) {
			HttpSession session = request.getSession(true);
			session.setAttribute("email", email);
			session.setMaxInactiveInterval(10);
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/new_registration.jsp");
			rd.forward(request, response);
			
		}else {
			
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
			request.setAttribute("error","Timed Out");
		}
		
		
		
		
	}

}
