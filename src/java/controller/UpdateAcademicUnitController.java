package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.AcademicUnitDao;
import java.io.IOException;
import java.io.PrintWriter;
import model.AcademicUnit;
import model.EAcademicUnit;

@WebServlet("/UpdateAcademicUnitController")
public class UpdateAcademicUnitController extends HttpServlet {

    private AcademicUnitDao academicUnitDao;
    
    @Override
    public void init() throws ServletException {
        academicUnitDao = new AcademicUnitDao(); 
    }
    
     protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         doPut(request, response);
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Update Academic Unit
        Long academicUnitId = Long.parseLong(request.getParameter("academicUnitId"));
        String academicUnitName = request.getParameter("academicUnitName");
        EAcademicUnit academicUnitType = EAcademicUnit.valueOf(request.getParameter("academicUnitType"));
        Long parentId =  Long.parseLong(request.getParameter("parentId"));
        AcademicUnit theAcademicUnit = new AcademicUnit();
        theAcademicUnit.setAcademicUnitId(parentId);
        AcademicUnit academicUnit = new AcademicUnit(academicUnitId, academicUnitName, academicUnitType, theAcademicUnit);
        academicUnitDao.updateAcademicUnit(academicUnit);

        PrintWriter out = response.getWriter();
        out.println("Academic Unit updated successfully!");
    }

}
