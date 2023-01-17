package controllers;

import dto.*;
import service.api.IStatisticService;
import service.fabric.StatisticServiceSingleton;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

@WebServlet(name = "StatisticServlet", urlPatterns = "/statistics")
public class StatisticServlet extends HttpServlet {

    private IStatisticService service;

    public StatisticServlet() {
        this.service = StatisticServiceSingleton.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        TopDTO result = service.getResult();

        PrintWriter writer = resp.getWriter();

        Map<SingerDTO, Long> topSinger = result.getTopSinger();

        topSinger.forEach((k, v) -> writer.write("<p>" + k.getSingerName() + " - " + v + "</p>"));

        List<ResultTopJenres<JenreDTO>> topJenres = result.getTopJenre();

        topJenres.forEach(i -> writer.write("<p>" + i.getKey().getJenreName() + " - " + i.getCount() + "</p>"));

        List<InformationTop> aboutRows = result.getTopInformation();

        aboutRows.forEach(i -> writer.write("<p>" + i.getLdInit() + " - " + i.getInformation() + "</p>"));
    }
}
