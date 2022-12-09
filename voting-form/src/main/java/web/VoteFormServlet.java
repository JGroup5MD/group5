package web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name= "VoteForm", urlPatterns = "/vote")
public class VoteFormServlet extends HttpServlet {

    private String SINGER_PARAMETER_HEADER = "SINGER";
    private String GENERE_PARAMETER_HEADER = "GENERE";
    private String ABOUT_PARAMETER_HEADER = "ABOUT_ME";
    private String[] singerName;
    private String[] genereList;
    ExamVote examVote = new ExamVote();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();


        singerName = req.getParameterValues(SINGER_PARAMETER_HEADER);

        genereList = req.getParameterValues(GENERE_PARAMETER_HEADER);
        String[] aboutText = req.getParameterValues(ABOUT_PARAMETER_HEADER);

        if (examVote.isExamVote()) {
            new Checker(singerName, genereList, aboutText);
        } else writer.write("Введены некорректные данные");
    }

    public String[] getSingerName() {
        return singerName;
    }

    public String[] getGenereList() {
        return genereList;
    }
}
