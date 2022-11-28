package com.soljit.touzene.demo.filter;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthorizationFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequestServlet = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
        String authorization = httpRequestServlet.getHeader("Authorization");
        System.out.println("--> " + authorization);
        if (authorization == null) {
            this.writeResponse(httpResponse, HttpServletResponse.SC_UNAUTHORIZED, "Token Required");
        } else {
            httpRequestServlet.setAttribute("authorization", authorization);
            String[] split = authorization.split(".");
           //TODO validate token. Ref https://help.salesforce.com/s/articleView?id=sf.remoteaccess_asset_token_using_validating.htm&type=5
            filterChain.doFilter(httpRequestServlet, servletResponse);
        }
    }
    private void writeResponse(HttpServletResponse httpResponse, int code, String message) throws IOException {
        httpResponse.setContentType("application/json");
        httpResponse.setStatus(code);
        httpResponse.getOutputStream().write(("{\"code\":" + code + ",").getBytes());
        httpResponse.getOutputStream().write(("\"message\":\"" + message + "\"}").getBytes());
        httpResponse.getOutputStream().flush();
    }
}
