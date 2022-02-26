package com.pengo.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

/**
 * @author pengo
 * @description:
 * @date 2022/2/25 22:32
 */
@WebServlet(urlPatterns = "/pref")
public class LanguageServlet extends HttpServlet {
    private static final Set<String> LANGUAGES = Set.of("en", "zh");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String lang = req.getParameter("lang");
        if (LANGUAGES.contains(lang)) {
            Cookie cookie = new Cookie("lang", lang);
            cookie.setPath("/");
            cookie.setMaxAge(86400);
            resp.addCookie(cookie);
        }
        System.out.println(parseLanguageFromCookie(req));
        resp.sendRedirect("/");
    }

    private String parseLanguageFromCookie(HttpServletRequest req) {
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("lang")) {
                return cookie.getValue();
            }
        }
        return "en";
    }
}
