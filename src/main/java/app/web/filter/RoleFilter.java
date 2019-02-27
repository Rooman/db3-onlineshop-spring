package app.web.filter;

import app.entity.Session;
import app.entity.UserRole;
import app.service.SecurityService;
import app.web.WebHelper;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public abstract class RoleFilter implements Filter {

    private SecurityService securityService;
    private UserRole userRole;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;


        String token = new WebHelper().getTokenFromCookies(httpServletRequest.getCookies());
        if (securityService.hasRoleAccess(Collections.singletonList(token), userRole)) {
            Session session = securityService.getSession(token);
            httpServletRequest.setAttribute("session", session);
            chain.doFilter(request, response);
        } else {
            httpServletResponse.sendRedirect("/login");
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        ServletContext servletContext = filterConfig.getServletContext();
        WebApplicationContext webApplicationContext = (WebApplicationContext) servletContext.getAttribute("WebApplicationContext.ROOT");
        securityService = webApplicationContext.getBean(SecurityService.class);
    }

    @Override
    public void destroy() {

    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }
}