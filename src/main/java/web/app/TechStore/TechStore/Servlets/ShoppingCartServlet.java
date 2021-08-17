package web.app.TechStore.TechStore.Servlets;

import web.app.TechStore.TechStore.Services.ShoppingCartService;
import web.app.TechStore.TechStore.Services.models.*;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ShoppingCart", value = "/shopping-cart")
public class ShoppingCartServlet extends HttpServlet {

    @Inject
    private ShoppingCartService shoppingCartService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ShoppingCartObjectsByUserResponse shoppingCartObjectsByUserResponse =
                shoppingCartService.getShoppingCartObjectsByUserId(new ShoppingCartObjectsByUserRequest(4l));
        req.setAttribute("cartProducts", shoppingCartObjectsByUserResponse.getShoppingCartObjects());
        req.setAttribute("totalCost", shoppingCartObjectsByUserResponse.getTotalCost());
        req.setAttribute("viewName", "shoppingCart.jsp");
        req.getRequestDispatcher("main.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        long userID = 4l;
        long productID = Long.parseLong(req.getParameter("productId"));
        Integer productQuantity = Integer.parseInt(req.getParameter("productQuantity"));
        AddShoppingCartObjectResponse addShoppingCartObjectResponse =
                shoppingCartService.addShoppingCardObject(new AddShoppingCartObjectRequest(productID,userID,productQuantity));
        resp.sendRedirect("/shopping-cart");

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doDelete(req, resp);
        long shoppingCartObjectId = Long.parseLong(req.getParameter("shoppingCartObjectId"));
        DeleteShoppingCartObjectResponse deleteShoppingCartObjectResponse =
                shoppingCartService.deleteShoppingCartObject(new DeleteShoppingCartObjectRequest(shoppingCartObjectId));
        resp.sendRedirect("/shopping-cart");
    }
}
