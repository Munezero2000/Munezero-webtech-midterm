package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import dao.TeacherDao;
import model.EQualification;
import model.Teacher;
import model.Course;

@WebServlet("/UpdateTeacherController")
public class UpdateTeacherController extends HttpServlet {

    private TeacherDao teacherDao;

    @Override
    public void init() throws ServletException {
        teacherDao = new TeacherDao(); 
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPut(request, response);
    }
    
    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Update Teacher
        Long teacherId = Long.parseLong(request.getParameter("teacherId"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        EQualification qualification =EQualification.valueOf(request.getParameter("qualification"));
        Long courseId = Long.parseLong(request.getParameter("courseId"));
        Course course = new Course();
        course.setId(courseId);
        
        Teacher teacherToUpdate = new Teacher(teacherId, firstName, lastName, qualification, course);
        teacherDao.updateTeacher(teacherToUpdate); 

        PrintWriter out = response.getWriter();
        out.println("Teacher updated successfully!");
    }
}
