package com.keane.training.web.handlers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.keane.mvc.HttpRequestHandler;
import com.keane.training.dao.InstituteDAO;
import com.keane.training.domain.Article;


public class ArticleUpload implements HttpRequestHandler{
	static Logger log = Logger.getLogger(InstituteReg.class);

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		InstituteDAO dao = new InstituteDAO();
		Article user = new Article();
		user.setAid(Integer.parseInt(request.getParameter("aid")));
		user.setIid(Integer.parseInt(request.getParameter("iid")));
		
		user.setArticle(request.getParameter("article"));
		


		try {
			int finalRes = InstituteDAO.UpdateArticle(user);
			if (finalRes > 0) {


					RequestDispatcher dispatcher = request
							.getRequestDispatcher("..\\pages\\InstituteHome.jsp");
					request.setAttribute("success",
							"Article uploaded...!!!");
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



