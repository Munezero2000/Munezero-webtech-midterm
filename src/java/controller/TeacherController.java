package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import dao.TeacherDao;
import model.Teacher;
import model.Course;
import model.EQualification;

@WebServlet("/TeacherController")
public class TeacherController extends HttpServlet {

    private TeacherDao teacherDao;

    @Override
    public void init() throws ServletException {
        teacherDao = new TeacherDao(); 
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doDelete(request, response);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Delete Teacher
        Long teacherId = Long.parseLong(request.getParameter("teacherId"));
        
        Teacher teacher = new Teacher();
        teacher.setId(teacherId);
        teacherDao.DeleteTeacher(teacher); 
        
        PrintWriter out = response.getWriter();
        out.println("Teacher deleted successfully!");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Insert Teacher
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        EQualification qualification = EQualification.valueOf(request.getParameter("qualification"));
        Long courseId = Long.parseLong(request.getParameter("courseId"));
        
        Course course =new Course();
        course.setId(courseId);
        Teacher teacher = new Teacher(firstName, lastName, qualification, course);
        teacherDao.createTeacher(teacher); 

        PrintWriter out = response.getWriter();
        out.println("Teacher inserted successfully!");
    }
}
