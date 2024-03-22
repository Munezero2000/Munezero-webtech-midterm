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

@WebServlet("/UpdateStudentRegistrationController")
public class UpdateStudentRegistrationController extends HttpServlet {

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
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Update Student Registration
        Long registrationId = Long.parseLong(request.getParameter("registrationId"));
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

        StudentRegistration registrationToUpdate = new StudentRegistration();
        registrationToUpdate.setRegistrationId(registrationId);
        registrationToUpdate.setStudent(student);
        registrationToUpdate.setSemester(semester);
        registrationToUpdate.setDepartment(department);
        registrationToUpdate.setRegistrationDate(registrationDate);

        registrationDao.updateStudentRegistration(registrationToUpdate);

        PrintWriter out = response.getWriter();
        out.println("Student registration updated successfully!");
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
