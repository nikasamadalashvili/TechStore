package web.app.TechStore.TechStore;

import web.app.TechStore.TechStore.service.CreditCardService;
import web.app.TechStore.TechStore.service.models.CreditCardRequest;
import web.app.TechStore.TechStore.service.models.CreditCardResponse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "creditCard-view", value = "/creditCard-view")
public class CreditCardViewServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CreditCardService service = (CreditCardService) req.getServletContext().getAttribute("cardService");
        CreditCardRequest cardRequest = CreditCardRequest.builder()
                .userId(4L)
                .build();

        CreditCardResponse response = service.getCreditCardInfo(cardRequest);
        req.setAttribute("ccnumber",response.getCardNumber());
        req.setAttribute("cvv",response.getCvv());
        req.setAttribute("expdata",response.getExpiryDate());
        req.setAttribute("viewName","credit-card-view.jsp");
        req.getRequestDispatcher("/main.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CreditCardService service = (CreditCardService) req.getServletContext().getAttribute("cardService");
        CreditCardRequest cardRequest = CreditCardRequest.builder()
                .userId(4L)
                .build();
        service.deleteCreditCard(cardRequest);
        resp.sendRedirect("/profile");
    }
}
