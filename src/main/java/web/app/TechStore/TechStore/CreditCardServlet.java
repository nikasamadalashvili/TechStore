package web.app.TechStore.TechStore;

import web.app.TechStore.TechStore.service.CreditCardService;
import web.app.TechStore.TechStore.service.models.CreditCardRequest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "creditCard-add", value="/creditCard-add")
public class CreditCardServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       req.getRequestDispatcher("/creditcard-add.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CreditCardService cardService = (CreditCardService) req.getServletContext().getAttribute("cardService");

        CreditCardRequest cardRequest = CreditCardRequest.builder()
                .cardNumber(req.getParameter("ccnumber"))
                .cvv(req.getParameter("cvv"))
                .expiryDate(req.getParameter("expdata"))
                .userId(4L)
                .build();

        boolean hasAdded = cardService.addCreditCard(cardRequest);
//        if(hasAdded == true) {
//                req.setAttribute("can",hasAdded);
//                req.getRequestDispatcher("/profile").forward(req,resp);
//        } else {
//            req.setAttribute("can",hasAdded);
//            req.getRequestDispatcher("/creditCard-add").forward(req, resp);
//        }
    }
}
