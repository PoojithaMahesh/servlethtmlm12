package studentwithhtmlm12;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentwithhtmlm12.dao.StudentDao;
import studentwithhtmlm12.dto.Student;

public class UpdateServlet extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int id=Integer.parseInt(req.getParameter("id"));
	String name=req.getParameter("name");
	String email=req.getParameter("email");
	String password=req.getParameter("password");
	String address=req.getParameter("address");
	long phone=Long.parseLong(req.getParameter("phone"));
	
	Student student=new Student();
	student.setAddress(address);
	student.setEmail(email);
	student.setName(name);
	student.setPassword(password);
	student.setPhone(phone);
	
	StudentDao dao=new StudentDao();
    Student dbStudent=dao.updateStudent(id,student);
	if(dbStudent!=null) {
		PrintWriter printWriter=resp.getWriter();
		printWriter.print("Data updated successfully");
	}else {
		PrintWriter printWriter=resp.getWriter();
		printWriter.print("Sorry id is not present to update the data");
	}
	
	
	
	
	
	
	
	
	
	
}

}
