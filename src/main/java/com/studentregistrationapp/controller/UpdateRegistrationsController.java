package com.studentregistrationapp.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studentregistrationapp.model.DAOimpl;

@WebServlet("/Update")
public class UpdateRegistrationsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UpdateRegistrationsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String city = request.getParameter("city");
		
		request.setAttribute("email",email);
		request.setAttribute("mobile",mobile);
		request.setAttribute("city",city);
		
		
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/update_registrations.jsp");
		rd.forward(request, response);
	}
    

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String city = request.getParameter("city");
		
		DAOimpl dao = new DAOimpl();
		dao.connectDB();
		
		dao.UpdateRegistration(email,mobile,city);
		
		ResultSet result = dao.listAllRegistrations();
	    request.setAttribute("result" ,result);
	    RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/search_result.jsp");
	    rd.forward(request, response);
		
		
	}

}
