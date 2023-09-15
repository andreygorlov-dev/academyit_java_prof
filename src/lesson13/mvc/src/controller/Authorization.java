package controller;

import models.BaseModel;
import models.User;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/authorization")
public class Authorization extends HttpServlet {

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
            resp.getWriter().append("NoAuthorized");
        } else {
            resp.getWriter().append("Authorized");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");

        JSONParser parser = new JSONParser();
        try {
            JSONObject jsonObject = (JSONObject) parser.parse(req.getParameter("data"));
            User user = baseModel.getUser((String) jsonObject.get("login"), (String) jsonObject.get("password"));
            if (user == null) {
                resp.getWriter().append("NoAuthorized");
            } else {
                HttpSession session = req.getSession();
                session.setAttribute("user", user);
                resp.getWriter().append("Authorized");
            }
        } catch (ParseException | SQLException e) {
            e.printStackTrace();
        }
    }
}
