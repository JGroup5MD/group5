package controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name="Test1", urlPatterns = "/Test2")
public class Test2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        HttpSession session=req.getSession();

        String firstName=req.getParameter("FIRST_NAME");
        String lastName=req.getParameter("LAST_NAME");

        PrintWriter writer = resp.getWriter();

        String FISTName=(String)session.getAttribute(firstName);
        String LASTName=(String)session.getAttribute(lastName);

        if(firstName!=null&&lastName!=null){
            session.setAttribute("FIRST_NAME", firstName);
            session.setAttribute("LAST_NAME", lastName);
        } else{
            throw new IllegalArgumentException("вы ни чего не передали в качестве параметров");
        }

        writer.write("Hello " + FISTName + " " + LASTName);
    }
}

