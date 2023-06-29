package zti.filters;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
//import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class XhtmlFilter
 */
//@WebFilter(filterName = "XhtmlFilter", urlPatterns = {"*.xhtml"})
public class XhtmlFilter implements Filter {

    /**
     * Default constructor.
     */
    public XhtmlFilter() {
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
        //((HttpServletResponse)response).sendError(404);
        //((HttpServletResponse)response).sendRedirect("errors-page/Error404.html");
        // pass the request along the filter chain
        // chain.doFilter(request, response);

        HttpServletRequest req = (HttpServletRequest) request ;
        // ((HttpServletResponse)response).setStatus(404) ;
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println ("<html>");
        out.println ("<head><title>Error 404</title></head>");
        out.println ("<body>");
        out.println ("<h1>Przepraszamy !!!</h1>");
        out.println ("<h2> Wywolana strona: <span style='color:red'> " + req.getRequestURL() + "</span> jest niedostepna w serwisie ! ") ;
        out.println ("</body></html>");
    }

    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig fConfig) throws ServletException {
        // TODO Auto-generated method stub
    }

}