package com.eguaks.filters;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by jsska on 30.04.2014.
 */
public class CsrfVerificationFilter implements Filter {
    private static final String TOKEN_NAME = "c_token";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpReq = (HttpServletRequest)request;
        HttpServletResponse httpResp = (HttpServletResponse)response;


        List<Cookie> cookies = Arrays.asList(httpReq.getCookies());

        Optional<Cookie> cookieOptional = cookies
                .stream()
                .filter(cookie -> cookie.getName().equalsIgnoreCase(TOKEN_NAME))
                .findFirst();

        if(cookieOptional.isPresent() && cookieOptional.get().getName().equalsIgnoreCase(TOKEN_NAME)){
            Cookie tokenFromCookie = cookieOptional.get();
            chain.doFilter(request, response);
        }

        else {
            httpResp.sendError(HttpServletResponse.SC_UNAUTHORIZED);
        }

    }

    @Override
    public void destroy() {

    }
}
