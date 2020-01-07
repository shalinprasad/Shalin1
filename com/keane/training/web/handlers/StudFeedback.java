package com.keane.training.web.handlers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.keane.mvc.HttpRequestHandler;
import com.keane.training.dao.StudentDAO;
import com.keane.training.domain.Feedback;

public class StudFeedback implements HttpRequestHandler {
	static Logger log = Logger.getLogger(StudFeedback.class);

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		StudentDAO dao = new StudentDAO();
		Feedback user = new Feedback();
		user.setCid(Integer.parseInt(request.getParameter("cid")));
		user.setSid(Integer.parseInt(request.getParameter("sid")));
		user.setIid(Integer.parseInt(request.getParameter("iid")));
		user.setFeedback(request.getParameter("feedback"));
		
		


		try {
					int finalRes = StudentDAO.InsertFeedback(user);
				if (finalRes > 0) {

					RequestDispatcher dispatcher = request
							.getRequestDispatcher("..\\pages\\StudentHome.jsp");
					request.setAttribute("success",
							"Feedback sent");
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




