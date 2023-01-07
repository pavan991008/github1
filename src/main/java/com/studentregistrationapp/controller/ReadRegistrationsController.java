package com.studentregistrationapp.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.studentregistrationapp.model.DAOimpl;


@WebServlet("/listall")
public class ReadRegistrationsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ReadRegistrationsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession(false);
		session.setMaxInactiveInterval(10);
		if(session.getAttribute("email")!= null) {
		DAOimpl dao = new DAOimpl();
		dao.connectDB();
	    ResultSet result = dao.listAllRegistrations();
	    request.setAttribute("result" ,result);
	    RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/search_result.jsp");
	    rd.forward(request, response);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
