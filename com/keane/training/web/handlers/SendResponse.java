package com.keane.training.web.handlers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.keane.mvc.HttpRequestHandler;
import com.keane.training.dao.InstituteDAO;
import com.keane.training.domain.Request;

public class SendResponse implements HttpRequestHandler{
	static Logger log = Logger.getLogger(SendResponse.class);

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		InstituteDAO dao = new InstituteDAO();
		Request user = new Request();
		user.setIid(Integer.parseInt(request.getParameter("iid")));
		user.setSid(Integer.parseInt(request.getParameter("sid")));
		user.setRes(request.getParameter("response"));
		

		try {
			
				int finalRes = InstituteDAO.InsertResponse(user);
				if (finalRes > 0) {

					RequestDispatcher dispatcher = request
							.getRequestDispatcher("..\\pages\\InstituteHome.jsp");
					request.setAttribute("success",
							"Response sent to student");
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
