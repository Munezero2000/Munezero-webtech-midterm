package controller;
        
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.StudentDao;
import java.io.IOException;
import java.io.PrintWriter;
import model.Student;

@WebServlet("/StudentController")
public class StudentController extends HttpServlet {

    private StudentDao studentDao;
    
    @Override
    public void init() throws ServletException {
        studentDao = new StudentDao(); 
    }
    
           @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doDelete(request, response);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Delete Student
        Long studentId = Long.parseLong(request.getParameter("studentId"));
        
        Student student = new Student();
        student.setStudentId(studentId);
        studentDao.DeleteStudent(student); 
        
        PrintWriter out = response.getWriter();
        out.println("Student deleted successfully!");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Insert Student
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String dateOfBirth = request.getParameter("dateOfBirth");

        Student student = new Student(firstName, lastName, dateOfBirth);
        studentDao.createStudent(student); // Assuming you have a method to add a student in your DAO

        PrintWriter out = response.getWriter();
        out.println("Student inserted successfully!");
    }

}
