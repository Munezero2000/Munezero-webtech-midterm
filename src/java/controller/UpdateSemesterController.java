package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import dao.SemesterDao;
import model.Semester;

@WebServlet("/UpdateSemesterController")
public class UpdateSemesterController extends HttpServlet {

    private SemesterDao semesterDao;
    
    @Override
    public void init() throws ServletException {
        semesterDao = new SemesterDao(); 
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPut(request, response);
    }
    
    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long semesterId = Long.parseLong(request.getParameter("semesterId"));
        String semesterName = request.getParameter("semesterName");
        Date startingDate = null;
        Date endDate = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            startingDate = dateFormat.parse(request.getParameter("startingDate"));
            endDate = dateFormat.parse(request.getParameter("endDate"));
        } catch (ParseException e) {
        }

        Semester semester = new Semester(semesterId, semesterName, startingDate, endDate);
        semesterDao.updateSemester(semester); 

        PrintWriter out = response.getWriter();
        out.println("Semester updated successfully!");
    }
}
