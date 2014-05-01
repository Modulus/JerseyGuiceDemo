package com.eguaks.filters;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.HttpCookie;
import java.security.SecureRandom;

/**
 * Created by jsska on 30.04.2014.
 */
public class CsrfCreationFilter implements Filter {

    static SecureRandom random = new SecureRandom();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletResponse httpResp = (HttpServletResponse)response;


        Long randomNumber = random.nextLong();

        HttpCookie httpCookie = new HttpCookie("c_token", randomNumber.toString());

        Cookie cookie = new Cookie(httpCookie.getName(), httpCookie.getValue());


        httpResp.addCookie(cookie);

        chain.doFilter(request, response);


    }

    @Override
    public void destroy() {

    }
}
