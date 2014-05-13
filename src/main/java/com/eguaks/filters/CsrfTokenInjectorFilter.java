package com.eguaks.filters;

import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerResponse;
import com.sun.jersey.spi.container.ContainerResponseFilter;

/**
 * Created by JohnSigvald on 10/05/2014.
 */
public class CsrfTokenInjectorFilter implements ContainerResponseFilter {

    @Override
    public ContainerResponse filter(ContainerRequest containerRequest, ContainerResponse containerResponse) {
        if(containerRequest.getMethod().equals("GET")){
            containerResponse.getHttpHeaders().add("X-Token", "Muahahaha");
            return containerResponse;
        }
        else return containerResponse;
    }
}
