package controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;
@WebServlet(name="Test1", urlPatterns = "/Test1")
public class Test1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        String firstName=req.getParameter("FIRST_NAME");
        String lastName=req.getParameter("LAST_NAME");

        PrintWriter writer = resp.getWriter();

        Cookie FirstName = new Cookie("firstName", req.getParameter("firstName"));
        FirstName.setMaxAge(Math.toIntExact(TimeUnit.DAYS.toSeconds(1)));
        Cookie LastName = new Cookie("lastName", req.getParameter("lastName"));
        LastName.setMaxAge(Math.toIntExact(TimeUnit.DAYS.toSeconds(1)));

        if (firstName==null|| firstName.length()>0) {
            resp.addCookie(FirstName);
        }
        if(lastName==null||lastName.length()>0){
            resp.addCookie(LastName);
        }

        if (firstName==null && FirstName.getValue().isBlank()){
            throw  new IllegalArgumentException("в первые параметры и в куки вы ни чего не передали");
        }
        if(lastName==null && LastName.getValue().isBlank()){
            throw  new IllegalArgumentException("в вторые параметры и в куки вы ни чего не передали");
        }
        writer.write("Hello " + FirstName.getValue() + " " + LastName.getValue());
    }
}

