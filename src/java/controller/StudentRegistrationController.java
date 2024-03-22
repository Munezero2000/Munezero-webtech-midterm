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
import dao.StudentRegistrationDao;
import model.Student;
import model.Semester;
import model.AcademicUnit;
import model.StudentRegistration;

@WebServlet("/StudentRegistrationController")
public class StudentRegistrationController extends HttpServlet {

    private StudentRegistrationDao registrationDao;

    @Override
    public void init() throws ServletException {
        registrationDao = new StudentRegistrationDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doDelete(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long studentId = Long.parseLong(request.getParameter("studentId"));
        Long semesterId = Long.parseLong(request.getParameter("semesterId"));
        Long departmentId = Long.parseLong(request.getParameter("departmentId"));
        Date registrationDate = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            registrationDate = dateFormat.parse(request.getParameter("registrationDate"));
        } catch (ParseException e) {
        }

        Student student = new Student();
        student.setStudentId(studentId);

        Semester semester = new Semester();
        semester.setSemesterId(semesterId);

        AcademicUnit department = new AcademicUnit();
        department.setAcademicUnitId(departmentId);

        StudentRegistration registration = new StudentRegistration();
        registration.setStudent(student);
        registration.setSemester(semester);
        registration.setDepartment(department);
        registration.setRegistrationDate(registrationDate);
        registrationDao.createStudentRegistration(registration);

        PrintWriter out = response.getWriter();
        out.println("Student registration inserted successfully!");
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Delete Student Registration
        Long registrationId = Long.parseLong(request.getParameter("registrationId"));
        StudentRegistration registration = new StudentRegistration();
        registration.setRegistrationId(registrationId);
        registrationDao.DeleteStudentRegistration(registration);

        PrintWriter out = response.getWriter();
        out.println("Student registration deleted successfully!");
    }
}
