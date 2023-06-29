package zti.zti_lab01;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DemoServlet", value = "/DemoServlet")
public class DemoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
        out.println ("\nWelcome, First Servlet");
        out.println ("localhost:8081/ZTI_lab01_war_exploded/Servlet01");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
