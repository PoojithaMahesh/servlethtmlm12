package studentwithhtmlm12.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import studentwithhtmlm12.dto.Student;

public class StudentDao {
public EntityManager getEntityManager() {
	return Persistence.createEntityManagerFactory("vinod").createEntityManager();
}

public void saveStudent(Student student) {
	EntityManager entityManager=getEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	entityTransaction.begin();
	entityManager.persist(student);
	entityTransaction.commit();
}

public List<Student> getAllStudents() {
	EntityManager entityManager=getEntityManager();
	Query  query=entityManager.createQuery("Select s from Student s");
	return query.getResultList();
}

public Student findStudentById(int id) {
	EntityManager entityManager=getEntityManager();
	Student dbStudent=entityManager.find(Student.class, id);
	if(dbStudent!=null) {
//		Studeny is preseny
		return dbStudent;
	}else {
		return null;
	}
}








}
