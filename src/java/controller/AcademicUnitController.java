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

@WebServlet("/AcademicUnitController")
public class AcademicUnitController extends HttpServlet {

    private AcademicUnitDao academicUnitDao;

    @Override
    public void init() throws ServletException {
        academicUnitDao = new AcademicUnitDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doDelete(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String academicUnitName = request.getParameter("academicUnitName");
        EAcademicUnit academicUnitType = EAcademicUnit.valueOf(request.getParameter("academicUnitType"));
        String parent = request.getParameter("parentId");
        AcademicUnit theAcademicUnit = new AcademicUnit();
        if (!parent.isEmpty()) {
            Long parentId = Long.parseLong(parent);
            theAcademicUnit.setAcademicUnitId(parentId);
        }else{
            theAcademicUnit = null;
        }

        AcademicUnit academicUnit = new AcademicUnit(academicUnitName, academicUnitType, theAcademicUnit);
        academicUnitDao.createAcademicUnit(academicUnit);

        PrintWriter out = response.getWriter();
        out.println("Academic Unit inserted successfully!");
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long academicUnitId = Long.parseLong(request.getParameter("academicUnitId"));

        AcademicUnit academicUnit = new AcademicUnit();
        academicUnit.setAcademicUnitId(academicUnitId);
        academicUnitDao.DeleteAcademicUnit(academicUnit);

        PrintWriter out = response.getWriter();
        out.println("Academic Unit deleted successfully!");
    }
}
