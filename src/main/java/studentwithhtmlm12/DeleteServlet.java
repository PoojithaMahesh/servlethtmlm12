package studentwithhtmlm12;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentwithhtmlm12.dao.StudentDao;
import studentwithhtmlm12.dto.Student;

public class DeleteServlet extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int id=Integer.parseInt(req.getParameter("id"));
	StudentDao dao=new StudentDao();
	Student dbStudent=dao.deleteStudent(id);
	if(dbStudent!=null) {
		PrintWriter printWriter=resp.getWriter();
		printWriter.print("DATA DELETED SUCCESSFULLY");
	}else {
		PrintWriter printWriter=resp.getWriter();
		printWriter.print("SORRY ID IS NOT PRESENT TO DELETE");
	}
}
}
