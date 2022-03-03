package com.pengo.web.mvc.base;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author pengo
 * @description:
 * @date 2022/2/26 22:35
 */
@WebServlet(urlPatterns = "/user")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        School school = new School("No.1 Middle School", "101 South Street");
        User user = new User(123, "bob", school);
        req.setAttribute("user", user);
        req.getRequestDispatcher("/WEB-INF/user.jsp").forward(req, resp);
    }
}
