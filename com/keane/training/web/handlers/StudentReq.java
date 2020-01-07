package com.keane.training.web.handlers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.keane.mvc.HttpRequestHandler;
import com.keane.training.dao.StudentDAO;
import com.keane.training.domain.Request;


public class StudentReq implements HttpRequestHandler {
	static Logger log = Logger.getLogger(StudentReq.class);

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		StudentDAO dao = new StudentDAO();
		Request user = new Request();
		user.setCid(Integer.parseInt(request.getParameter("cid")));
		user.setSid(Integer.parseInt(request.getParameter("sid")));
		user.setIid(Integer.parseInt(request.getParameter("iid")));
		user.setRequest(request.getParameter("request"));
		
		


		try {
					int finalRes = StudentDAO.ComplaintStudent(user);
				if (finalRes > 0) {

					RequestDispatcher dispatcher = request
							.getRequestDispatcher("..\\pages\\StudentHome.jsp");
					request.setAttribute("success",
							"Request sent");
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





