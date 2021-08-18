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

    private static final HashMap<String, RoleClaimType> urlAndRolesMapping = new HashMap<String, RoleClaimType>() {{
       put("/creditCard-add", RoleClaimType.CREDIT_CARD);
       put("/creditCard-add", RoleClaimType.SHOPPING_CARD);
       put("/profile", RoleClaimType.SHOPPING_CARD);
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
        if (urlAndRolesMapping.containsKey(requestURI)) {
            if (request.getCookies() != null) {
                Optional<Cookie> techStoreAuthentication = Arrays.stream(request.getCookies())
                        .filter(cookie -> cookie.getName().equals("UserName"))
                        .findFirst();
                if (!techStoreAuthentication.isPresent() || hasRight(techStoreAuthentication.get(), requestURI))
                    response.sendRedirect(request.getContextPath() + "/sign-in");
                else {
                    filterChain.doFilter(servletRequest, servletResponse);
                }
            } else {
                response.sendRedirect(request.getContextPath() + "/sign-in");
            }
        }
        else {
            if (request.getCookies() != null && (requestURI.equals("/sign-in") || requestURI.equals("/sign-up"))) {
                response.sendRedirect(request.getContextPath() + "/mobiles");
            }
            else {
                filterChain.doFilter(servletRequest, servletResponse);
            }
        }
    }

    private boolean hasRight(Cookie userCookie, String url){
        //TechStoreAuthenticationCookieModel cookieModel = JsonbBuilder.create().fromJson(userCookie.getValue(), TechStoreAuthenticationCookieModel.class);
        Query query = entityManager.createQuery("select u from Users u where u.username = :username");
        query.setParameter("username", userCookie.getValue());
        Users user = (Users) query.getSingleResult();

        long result = user.getRolesByRoleId().getRoleClaim() & urlAndRolesMapping.get(url).ordinal();

        return user == null && result > 0;
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
