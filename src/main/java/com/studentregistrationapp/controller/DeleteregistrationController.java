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

/**
 * Servlet implementation class DeleteregistrationController
 */
@WebServlet("/delete")
public class DeleteregistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DeleteregistrationController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String email = request.getParameter("email");
		DAOimpl service = new DAOimpl();
		service.connectDB();
		
		service.deleteRegistration(email);
		
		ResultSet result = service.listAllRegistrations();
	    request.setAttribute("result" ,result);
	    RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/search_result.jsp");
	    rd.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
