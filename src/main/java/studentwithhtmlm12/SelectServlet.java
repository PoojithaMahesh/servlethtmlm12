package studentwithhtmlm12;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentwithhtmlm12.dao.StudentDao;
import studentwithhtmlm12.dto.Student;

public class SelectServlet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int id=Integer.parseInt(req.getParameter("id"));
	
	StudentDao dao=new StudentDao();
	Student student=dao.findStudentById(id);
	
	if(student!=null) {
		PrintWriter printWriter=resp.getWriter();
		printWriter.print(student);
	}else {
		PrintWriter printWriter=resp.getWriter();
		printWriter.print("Sorry Id is not present");
	}
	
}
}
