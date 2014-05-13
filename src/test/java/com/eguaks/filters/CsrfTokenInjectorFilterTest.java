package com.eguaks.filters;

import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerResponse;
import com.sun.jersey.spi.container.ContainerResponseWriter;
import com.sun.jersey.spi.container.WebApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

/**
 * Created by JohnSigvald on 10/05/2014.
 */

@RunWith(MockitoJUnitRunner.class)
public class CsrfTokenInjectorFilterTest {

    @Mock
    private ContainerRequest request;

    @Mock
    private WebApplication app;

    @Mock
    private ContainerResponseWriter responseWriter;

    private ContainerResponse response;
    private CsrfTokenInjectorFilter filter;

    @Before
    public void setUp(){
        filter = new CsrfTokenInjectorFilter();
    }


    @Test
    public void filter_GetMethodUsed_ResponseHasXTokenHeader(){
        response = new ContainerResponse(app, request, responseWriter);

        when(request.getMethod()).thenReturn("GET");

        ContainerResponse actualResponse = filter.filter(request, response);
        String token = (String)actualResponse.getHttpHeaders().getFirst("X-Token");
        assertNotNull(token);
        assertTrue(token.length() > 0);

    }
}
