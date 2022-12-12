package controllers;

import service.VoteService;
import service.fabric.VoteServiceSingleton;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;


@WebServlet (name="VoteServle", urlPatterns = "/vote")
public class VoteServlet extends HttpServlet {
    private final String Name_Singer="singerName";
    private final String Name_Jenre ="jenreName";
    private final String Information="information";
    private final VoteService voteService;

    public VoteServlet() {
        this.voteService = VoteServiceSingleton.getInstance();
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("txt/html; charset=UTF8");

        Map<String, String[]> mpReq=req.getParameterMap();
        String[] IdSiger=mpReq.get("singerName");
        String[] IdJenre=mpReq.get("jenreName");

        if(IdSiger==null){
            throw new IllegalArgumentException(" Id исполнителя не введен");
        }
        if(!Objects.equals(IdSiger, 1-9)){
            throw new IllegalArgumentException("Введенный вами Id не является цифрой");
        }
        if(IdSiger.length<1){
            throw new IllegalArgumentException("Выбирите только одного исполнителя");
        }


        if(IdJenre==null){
            throw new IllegalArgumentException(" Id жанра не введен");
        }
        if(!Objects.equals(IdJenre, 1-9)){
            throw new IllegalArgumentException("Введенный вами Id не является цифрой");
        }
        if(IdJenre.length<3 && IdJenre.length>5){
            throw new IllegalArgumentException("Выбирите от 3 до 5 наименований жанров");
        }
    }
}



