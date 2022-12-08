package web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name= "Result", urlPatterns = "/result")
public class ResultServlet extends HttpServlet {


    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        PrintWriter writer = resp.getWriter();

        writer.write("<p>" + VoteForm.singerVotesCounter() + "</p>");
        writer.write("<p>" + VoteForm.genereVotesCounter() + "</p>");
        writer.write("<p>" + VoteForm.aboutCounter() + "</p>");

        }

    }

