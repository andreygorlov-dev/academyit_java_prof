package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.BaseModel;
import models.User;


@WebServlet("/cart")
public class Cart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BaseModel baseModel;

	@Override
	public void init() throws ServletException {
		super.init();
		try {
			baseModel = BaseModel.newInstance();
		} catch (ClassNotFoundException | SQLException throwables) {
			throwables.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		try {
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");
			request.setAttribute("goods", baseModel.getCart(user.getId()));
			request.getRequestDispatcher("WEB-INF\\views\\cart.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if(id != null) {
			try {
				if(baseModel.addItem(Integer.parseInt(id), user.getId())) {
					response.getWriter().print("Success!");
				}else {
					response.getWriter().print("Error!");
				}
			} catch (NumberFormatException | SQLException | IOException e) {
				e.printStackTrace();
			}
		}
	}


	@Override
	public void destroy() {
		super.destroy();
		try {
			baseModel.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}
}
