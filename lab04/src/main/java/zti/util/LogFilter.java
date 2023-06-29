package zti.util;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.core.MultivaluedMap;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.ext.Provider;

import java.io.IOException;

@Provider
//@Logged
public class LogFilter implements ContainerRequestFilter, ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext reqContext) throws IOException {
        System.out.println("-- req info --");
        UriInfo uriInfo = reqContext.getUriInfo();
        log(uriInfo, reqContext.getHeaders());
    }

    @Override
    public void filter(ContainerRequestContext reqContext,
                       ContainerResponseContext resContext) throws IOException {
        System.out.println("-- res info --");
        UriInfo uriInfo = reqContext.getUriInfo();
        log(uriInfo, resContext.getHeaders());
    }

    private void log(UriInfo uriInfo, MultivaluedMap<String, ?> headers) {
        System.out.println("Path: " + uriInfo.getPath());
        headers.entrySet().forEach(h -> System.out.println(h.getKey() + ": " + h.getValue()));
    }
}