package com.eguaks.core;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by jsska on 22.05.2014.
 */
public class CSRFInjectionFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        if (req != null && resp != null && chain != null) {
            HttpServletRequest request = (HttpServletRequest) req;
            HttpServletResponse response = (HttpServletResponse) resp;
            /**
             * Inject the generated token if the request is a GET request
             * */
            if (request.getSession() != null && request.getSession().isNew() && request.getMethod().equalsIgnoreCase("get")) {
                String token = (String) request.getSession().getValue("OWASP_CSRFTOKEN");
                if (token != null) {
                    response.setHeader("X-OWASP_CSRFTOKEN", token);
                    chain.doFilter(req, resp);
                }
            }
            else {
                chain.doFilter(req, resp);
            }


        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
