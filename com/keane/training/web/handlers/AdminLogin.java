package com.keane.training.web.handlers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.keane.mvc.HttpRequestHandler;
import com.keane.training.dao.AdminDAO;
import com.keane.training.domain.Admin;


public class AdminLogin implements HttpRequestHandler {
	static Logger log = Logger.getLogger(Login.class);

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		AdminDAO dao = new AdminDAO();
		Admin user = new Admin();
		user.setAid(Integer.parseInt(request.getParameter("aid")));

		user.setApass(request.getParameter("apass"));

		

		try {
		
			List finalres=new ArrayList();
				 finalres = AdminDAO.LoginAdmin(user);
				if (!(finalres.isEmpty())) {

					RequestDispatcher dispatcher = request
							.getRequestDispatcher("..\\pages\\Adminhome.jsp");
					request.setAttribute("success",
							"User succesfully registered with the system");
					request.setAttribute("details", user);
					dispatcher.forward(request, response);
				}
			}
		 catch (Exception e) {
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("error.jsp");
			request.setAttribute("Err", e.getMessage());
			dispatcher.forward(request, response);
		}
	}


}
