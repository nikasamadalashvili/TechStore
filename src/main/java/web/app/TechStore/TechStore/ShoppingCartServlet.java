package web.app.TechStore.TechStore;

import web.app.TechStore.TechStore.service.ShoppingCartService;
import web.app.TechStore.TechStore.service.models.AddShoppingCartObjectRequest;
import web.app.TechStore.TechStore.service.models.AddShoppingCartObjectResponse;
import web.app.TechStore.TechStore.service.models.ShoppingCartObjectsByUserRequest;
import web.app.TechStore.TechStore.service.models.ShoppingCartObjectsByUserResponse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ShoppingCart", value = "/shopping-cart")
public class ShoppingCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        ShoppingCartService shoppingCartService = (ShoppingCartService) req.getServletContext().getAttribute("shoppingCartService");
        ShoppingCartObjectsByUserResponse shoppingCartObjectsByUserResponse =
                shoppingCartService.getShoppingCartObjectsByUserId(new ShoppingCartObjectsByUserRequest(Long.parseLong(req.getParameter("id"))));
        req.setAttribute("cartProducts", shoppingCartObjectsByUserResponse.getShoppingCartObjects());
        req.setAttribute("viewName", "shoppingCart.jsp");
        req.getRequestDispatcher("main.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        long userID = Long.parseLong(req.getParameter("userId"));
        long productID = Long.parseLong(req.getParameter("productId"));
        Integer productQuantity = Integer.parseInt(req.getParameter("productQuantity"));
        ShoppingCartService shoppingCartService = (ShoppingCartService) req.getServletContext().getAttribute("shoppingCartService");
        AddShoppingCartObjectResponse addShoppingCartObjectResponse =
                shoppingCartService.addShoppingCardObject(new AddShoppingCartObjectRequest(productID,userID,productQuantity));
        resp.sendRedirect("");
    }
}
