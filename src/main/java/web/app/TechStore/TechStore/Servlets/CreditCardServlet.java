package web.app.TechStore.TechStore.Servlets;

import web.app.TechStore.TechStore.Services.CreditCardService;
import web.app.TechStore.TechStore.Services.models.CreditCardRequest;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "creditCard-add", value="/creditCard-add")
public class CreditCardServlet extends HttpServlet {

    @Inject
    private CreditCardService cardService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        CreditCardService service = (CreditCardService) req.getServletContext().getAttribute("cardService");
//        CreditCardRequest cardRequest = CreditCardRequest.builder()
//                .userId(4L)
//                .build();
//        CreditCardResponse response = service.getCreditCardInfo(cardRequest);
//        req.setAttribute("ccnumber",response.getCardNumber());
//        req.setAttribute("cvv",response.getCvv());
//        req.setAttribute("expdata",response.getExpiryDate());
        req.setAttribute("viewName","creditcard-add.jsp");
        req.getRequestDispatcher("/main.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CreditCardRequest cardRequest = CreditCardRequest.builder()
                .cardNumber(req.getParameter("ccnumber"))
                .cvv(req.getParameter("cvv"))
                .expiryDate(req.getParameter("expdata"))
                .userId(4L)
                .build();

        boolean hasAdded = cardService.addCreditCard(cardRequest);
        if(hasAdded) {
                req.setAttribute("can",hasAdded);
                resp.sendRedirect("/profile");
        } else {
            req.setAttribute("can",hasAdded);
           resp.sendRedirect("/creditCard-add");
        }
    }
}
