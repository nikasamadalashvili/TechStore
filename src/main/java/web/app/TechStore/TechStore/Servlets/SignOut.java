package web.app.TechStore.TechStore.Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebServlet(value = "/sign-out")
public class SignOut extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = Arrays.stream(req.getCookies()).filter(o -> o.getName().equals("UserName"))
                .findFirst().get();
        cookie.setValue("");
        cookie.setPath("/");
        cookie.setMaxAge(0);
        resp.addCookie(cookie);
        resp.sendRedirect(req.getContextPath() + "/mobiles");
    }
}
