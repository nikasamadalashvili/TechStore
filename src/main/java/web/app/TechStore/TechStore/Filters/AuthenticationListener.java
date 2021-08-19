package web.app.TechStore.TechStore.Filters;

import web.app.TechStore.TechStore.DomainModels.Users;
import web.app.TechStore.TechStore.Enums.RoleClaimType;
import web.app.TechStore.TechStore.Utils.TechStoreAuthenticationCookieModel;

import javax.inject.Inject;
import javax.json.bind.JsonbBuilder;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Optional;

@WebFilter(filterName = "TimeOfDayFilter", urlPatterns = {"/*"})
public class AuthenticationListener implements Filter {
    @Inject
    private EntityManager entityManager;

    private static final HashMap<String, Integer> urlAndRolesMapping = new HashMap<String, Integer>() {{
       put("/creditCard-add", RoleClaimType.CREDIT_CARD.getValue());
       put("/profile", RoleClaimType.PROFILE.getValue());
       put("/shopping-cart", RoleClaimType.SHOPPING_CARD.getValue());
       put("/creditCard-view", RoleClaimType.CREDIT_CARD.getValue());
    }};

    private static final HashSet<String> nonAuthenticatedUserUrls = new HashSet<String>() {{
       add("/mobiles");
       add("/mobile-details");
       add("/sign-in");
       add("/sign-up");
       add("/");
    }};



    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String requestURI = request.getRequestURI();
        Cookie userCookie = null;
        if (request.getCookies() != null
                    && Arrays.stream(request.getCookies()).anyMatch(o -> o.getName().equals("UserName"))) {
            Query query = entityManager.createQuery("select u from Users u where u.username = :username");
            Optional<Cookie> techStoreAuthentication = Arrays.stream(request.getCookies())
                    .filter(cookie -> cookie.getName().equals("UserName"))
                    .findFirst();
            userCookie = techStoreAuthentication.get();
            query.setParameter("username", userCookie.getValue());
            Users user = (Users) query.getSingleResult();
            request.setAttribute("SignedUser", user);
        }
        if (urlAndRolesMapping.containsKey(requestURI)) {
            if (request.getCookies() != null) {
                Users user = (Users) request.getAttribute("SignedUser");
                if (user == null || userCookie == null || !hasRight(user, userCookie, requestURI))
                    response.sendRedirect(request.getContextPath() + "/sign-in");
                else {
                    filterChain.doFilter(servletRequest, servletResponse);
                }
            } else {
                response.sendRedirect(request.getContextPath() + "/sign-in");
            }
        }
        else {
            if (request.getCookies() != null && (requestURI.equals("/sign-in") || requestURI.equals("/sign-up"))
                    && Arrays.stream(request.getCookies()).anyMatch(o -> o.getName().equals("UserName"))) {
                response.sendRedirect(request.getContextPath() + "/mobiles");
            }
            else {
                filterChain.doFilter(servletRequest, servletResponse);
            }
        }
    }

    private boolean hasRight(Users user, Cookie userCookie, String url){
        //TechStoreAuthenticationCookieModel cookieModel = JsonbBuilder.create().fromJson(userCookie.getValue(), TechStoreAuthenticationCookieModel.class);

        long result = user.getRolesByRoleId().getRoleClaim() & urlAndRolesMapping.get(url);

        return user != null && result > 0;
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
