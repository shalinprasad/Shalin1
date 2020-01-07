package com.keane.training.web.handlers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.keane.mvc.HttpRequestHandler;
import com.keane.training.dao.InstituteDAO;
import com.keane.training.domain.Faculty;

public class FacultyData implements HttpRequestHandler{
	static Logger log = Logger.getLogger(InstituteReg.class);

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		InstituteDAO dao = new InstituteDAO();
		Faculty user = new Faculty();
		user.setFid(Integer.parseInt(request.getParameter("fid")));
		user.setDept(request.getParameter("fdept"));
		user.setFname(request.getParameter("fname"));
		user.setIid(Integer.parseInt(request.getParameter("iid")));
			
		try {
			
				int finalRes = InstituteDAO.FacultyInfo(user);
				if (finalRes > 0) {

					RequestDispatcher dispatcher = request
							.getRequestDispatcher("..\\pages\\InstituteHome.jsp");
					request.setAttribute("success",
							"Faculty detail inserted....");
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
