package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.CourseDao;
import dao.CourseDefinitionDao;
import java.io.IOException;
import java.io.PrintWriter;
import model.Course;
import model.AcademicUnit;
import model.CourseDefinition;
import model.Semester;

@WebServlet("/CourseController")
public class CourseController extends HttpServlet {

    private CourseDao courseDao;

    @Override
    public void init() throws ServletException {
        courseDao = new CourseDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doDelete(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String courseCode = request.getParameter("courseCode");
        String courseName = request.getParameter("courseName");
        Long semesterId = Long.parseLong(request.getParameter("semesterId"));
        Long departmentId = Long.parseLong(request.getParameter("departmentId"));
        String courseDescription = request.getParameter("courseDescription");

        Semester semester = new Semester();
        semester.setSemesterId(semesterId);

        AcademicUnit department = new AcademicUnit();
        department.setAcademicUnitId(departmentId);

        Course course = new Course();
        course.setCourseCode(courseCode);
        course.setCourseName(courseName);
        course.setSemester(semester);
        course.setDepartment(department);
        Course theCourse = courseDao.createCourse(course);
        if (theCourse != null) {
            CourseDefinition courseDefinition = new CourseDefinition();
            courseDefinition.setDescription(courseDescription);
            courseDefinition.setCourse(theCourse);
            CourseDefinitionDao  courseDefinitionDao = new CourseDefinitionDao();
            courseDefinitionDao.createCourseDefinition(courseDefinition); 
        }

        PrintWriter out = response.getWriter();
        out.println("Course inserted successfully!");
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long courseId = Long.parseLong(request.getParameter("courseId"));

        Course course = new Course();
        course.setId(courseId);
        courseDao.DeleteCourse(course);

        PrintWriter out = response.getWriter();
        out.println("Course deleted successfully!");
    }
}
