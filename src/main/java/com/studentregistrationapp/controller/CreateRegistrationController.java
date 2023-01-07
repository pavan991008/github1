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


@WebServlet("/saveReg")
public class CreateRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CreateRegistrationController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/new_registration.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		try {
			HttpSession session = request.getSession(false);
			session.setMaxInactiveInterval(10);
			if(session.getAttribute("email")!= null) {
			String name = request.getParameter("name");
			String city = request.getParameter("city");
			String email = request.getParameter("email");
			String mobile = request.getParameter("mobile");
			
			DAOimpl service = new DAOimpl();
			service.connectDB();
			
			service.saveRegistration(name, city, email, mobile);
			
			request.setAttribute("msg", "Record has been saved..!!");
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/new_registration.jsp");
			rd.forward(request, response);
			
			}else {
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
			}
			
		
		}catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("error","Session timed out..Please login again");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
		}

}
