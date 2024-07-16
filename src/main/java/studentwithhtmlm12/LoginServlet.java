package studentwithhtmlm12;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentwithhtmlm12.dao.StudentDao;
import studentwithhtmlm12.dto.Student;

public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		StudentDao dao=new StudentDao();
		List<Student> students=dao.getAllStudents();
		boolean value=false;
		Student studentwhowantstologin=null;
		for(Student student:students) {
			if(student.getEmail().equals(email)) {
				studentwhowantstologin=student;
				value=true;
				break;
			}
		}
		
		
		if(value) {
//			value=true
//			email is present
			
			if(password.equals(studentwhowantstologin.getPassword())) {
//				login success
				PrintWriter printWriter=resp.getWriter();
				printWriter.print("LOGIN SUCCESS");
			}else {
//				invalid password
				PrintWriter printWriter=resp.getWriter();
				printWriter.print("LOGIN FAILURE ITS AN INVALID PASSWORD");
			}
			
			
			
		}else {
//			email is not present it is invalid
			PrintWriter printWriter=resp.getWriter();
			printWriter.print("SORRY FAILED TO LOGIN INVALID EMAIL");
		}
		
		
		
		
		
		
		
	}

}
