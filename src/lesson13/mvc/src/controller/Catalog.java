package controller;

import models.BaseModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/catalog")
public class Catalog extends HttpServlet {

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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setAttribute("goods", baseModel.getItems());
            req.getRequestDispatcher("WEB-INF\\views\\catalog.jsp").forward(req, resp);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
