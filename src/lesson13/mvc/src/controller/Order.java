package controller;

import models.BaseModel;
import models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/order")
public class Order extends HttpServlet {

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

    @Override
    public void destroy() {
        super.destroy();
        try {
            baseModel.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            throw new ServletException("Пользователь не авторизован");
        }

        try {
            if (baseModel.isEmptyCart(user.getId())) {
                resp.getWriter().append("Пустая корзина! Не заказать");
                return;
            }
            if (baseModel.checkout(user.getId())) {
                resp.getWriter().append("Заказ оформлен");
            } else {
                resp.getWriter().append("Заказ не оформлен");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
