package zti.zti_lab01;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import zti.javaClasses.Person;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ZadDomMVC", value = "/ZadDomMVC")
public class ZadDomMVC extends HttpServlet {

    public void requestSelectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out= response.getWriter();
        out.println("<h1>Dane uzyskane z bazy danych</h1>") ;
        try{
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://mouse.db.elephantsql.com:5432/tlzubtbb";
            String username = "tlzubtbb" ;
            String password = "3P_TmVOlgGSZqsJ5a9aoZazd5aACIcFs" ;
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM public.person";
            ResultSet rs = stmt.executeQuery( sql );
            StringBuilder result = new StringBuilder();
            List<Person> table = new ArrayList<Person>();
            while(rs.next()) {
                int id = rs.getInt("id");
                String firstName = rs.getString("fname");
                String lastName = rs.getString("lname");
                String city = rs.getString("city");
                table.add(new Person(lastName, firstName, city, id));
            }
            rs.close();
            stmt.close();
            conn.close();

            request.setAttribute("table", table);
            getServletContext().getRequestDispatcher("/mvc2/Wyswietlanie.jsp").forward(request, response);
        }
        catch(Exception e)
        {
            out.println (e);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("In the servlet. . .");
        ServletContext sc = getServletConfig().getServletContext();
        RequestDispatcher rd = null;
        String site  = "";
        if (request.getParameterMap().containsKey("site")) {
            site = request.getParameter("site");
            System.out.println("Site parameter " + site );
        } else {
            rd = sc.getRequestDispatcher("/mvc2/Home.jsp");
            rd.forward(request, response);
            return;
        }
        if ( site.equals("Wyswietlanie")) {
            System.out.println("In the servlet. . . Wyswietlanie");
            requestSelectAll(request, response);
            return;
        } else if ( site.equals("Dodawanie")) {
            System.out.println("In the servlet. . . Dodawanie");
            rd = sc.getRequestDispatcher("/mvc2/Dodawanie.jsp");
            rd.forward(request, response);
            return;
        } else {
            System.out.println("In the servlet. . . Home");
            rd = sc.getRequestDispatcher("/mvc2/Home.jsp");
            rd.forward(request, response);
            return;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out= response.getWriter();
        String action = "";
        if (request.getParameterMap().containsKey("action")) {
            action = request.getParameter("action");
            System.out.println("Action parameter " + action );
        }
        if (action.equals("dodawanie")) {
            String fname = request.getParameter("fname");
            String lname = request.getParameter("lname");
            String city = request.getParameter("city");
            try {
                Class.forName("org.postgresql.Driver");
                String url = "jdbc:postgresql://mouse.db.elephantsql.com:5432/tlzubtbb";
                String username = "tlzubtbb" ;
                String password = "3P_TmVOlgGSZqsJ5a9aoZazd5aACIcFs" ;
                Connection conn = DriverManager.getConnection(url, username, password);
                Statement stmt = conn.createStatement();
                String sql = "INSERT INTO person(fname, lname, city) VALUES ('" + fname + "', '" + lname + "', '" + city + "');";
                stmt.executeQuery( sql );
                stmt.close();
                conn.close();
                return;
            } catch(Exception e)
            {
                out.println (e);
            }
            ServletContext sc = getServletConfig().getServletContext();
            RequestDispatcher rd = sc.getRequestDispatcher("/mvc2/Home.jsp");
            rd.forward(request, response);
        }

    }
}
