package web.app.TechStore.TechStore.Servlets;

import web.app.TechStore.TechStore.DomainModels.Users;
import web.app.TechStore.TechStore.Services.CreditCardService;
import web.app.TechStore.TechStore.Services.models.CreditCardRequest;
import web.app.TechStore.TechStore.Services.models.CreditCardResponse;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "creditCard-view", value = "/creditCard-view")
public class CreditCardViewServlet extends HttpServlet {

    @Inject
    private CreditCardService cardService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Users user = (Users) req.getAttribute("SignedUser");
        CreditCardRequest cardRequest = CreditCardRequest.builder()
                .userId(user.getUserId())
                .build();

        CreditCardResponse response = cardService.getCreditCardInfo(cardRequest);
        req.setAttribute("ccnumber",response.getCardNumber());
        req.setAttribute("cvv",response.getCvv());
        req.setAttribute("expdata",response.getExpiryDate());
        req.setAttribute("viewName","credit-card-view.jsp");
        req.getRequestDispatcher("/main.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Users user = (Users) req.getAttribute("SignedUser");
        CreditCardRequest cardRequest = CreditCardRequest.builder()
                .userId(user.getUserId())
                .build();
        cardService.deleteCreditCard(cardRequest);
        resp.sendRedirect("/profile");
    }
}
