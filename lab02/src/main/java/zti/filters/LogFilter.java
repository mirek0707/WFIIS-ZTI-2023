package zti.filters;

import java.io.IOException;
import java.util.Date;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
//import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class LogFilter
 */
//@WebFilter("/LogFilter")
public class LogFilter implements Filter {

    protected FilterConfig config;
    private ServletContext context;
    private String filterName;

    /**
     * Default constructor.
     */
    public LogFilter() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see Filter#destroy()
     */
    public void destroy() {
        // TODO Auto-generated method stub
    }

    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // TODO Auto-generated method stub
        // place your code here
        HttpServletRequest req = (HttpServletRequest) request ;
        context.log( " Zdalny serwer: " + req.getRemoteHost() + " - wywolal "
                + req.getRequestURL() + " w dniu " + new Date() + "." +
                "(Raport wygenerowany przez " + filterName + ".)" );
        // pass the request along the filter chain
        chain.doFilter(request, response);
    }

    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig fConfig) throws ServletException {
        // TODO Auto-generated method stub
        this.config = fConfig;
        context = config.getServletContext();
        filterName = config.getFilterName();
    }

}