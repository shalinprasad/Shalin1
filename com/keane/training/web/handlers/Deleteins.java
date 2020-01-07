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
import com.keane.training.domain.Institute;


public class Deleteins implements HttpRequestHandler {
	static Logger log = Logger.getLogger(Deleteins.class);

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		AdminDAO dao = new AdminDAO();
		Institute user = new Institute();
		user.setIid(Integer.parseInt(request.getParameter("iid")));


		try {
			
//		
	
				int finalres1 = AdminDAO.DeleteInstitute(user);
				if (finalres1>0) {

					RequestDispatcher dispatcher = request
							.getRequestDispatcher("..\\pages\\Adminhome.jsp");
					request.setAttribute("success",
							"Deleted successful...!!");
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





