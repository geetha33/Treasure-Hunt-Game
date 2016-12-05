import javax.persistence.*;

import java.util.*;

public class StudentsService {
	 private EntityManager manager;
	 
	 public StudentsService(EntityManager manager) {
		 this.manager = manager;
	 }
	 
    // method to create a new record
	 public Student createStudent(String StudentId, String StudentName, int score, String theme) {
		 Student student = new Student();
		 student.setStudentName(StudentName);
 	     student.setStudentId(StudentId);
 	     student.setScore(score);
 	     student.settheme(theme);
 	     manager.persist(student);
 	     return student;
     }
    
    // method to read a record
     public Student readStudent(String studentId) {
    	 Student student = manager.find(Student.class, studentId);
    	 return student;   	 
     }

     // method to read all records
     public List<Student> readAll() {
    	 TypedQuery<Student> query = manager.createQuery("SELECT e FROM student e", Student.class);
    	 List<Student> result =  query.getResultList();

    	 return result;   	 
     }
     
     public List<Student> getStudent(String studentName) {
    	// Query query = entityManager.getCriteriaBuilder().createQuery("from SecureMessage sm where sm.someField=:arg1");
    	
    	 Query query = manager.createQuery("SELECT e FROM student e where e.student_name=:studentName ");
    	 query.setParameter("studentName", studentName);
    		List<Student> result = query.getResultList();
    	//Student result = manager.find(Student.class, studentName);
    	 return result;   	 
     }
     
    // method to update a record
     public Student updateStudent(String studentId, String studentName, int score, String theme) {
    	 Student student = manager.find(Student.class, studentId);
    	 if (student != null) {
    		 student.setStudentName(studentName);
    		 student.setScore(score);
    		 student.settheme(theme);
    	}
    	 return student;
     }
     
    // method to delete a record
    public void deleteStudent(String studentID) {
    	 Student student = manager.find(Student.class, studentID);
    	 if (student != null) {
    		 manager.remove(student);
    	 }
    }
}
