import javax.persistence.*;
import java.io.*;

@Entity(name = "student")
public class Student implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.TABLE)
  @Column
  private String student_id;
 
  @Column(name = "student_name")
  private String student_name;
  
  @Column
  private int score;
  
  @Column
  private String theme;
  
  public String getStudentName() {
    return student_name;
  }

  public void setStudentName(String name) {
    this.student_name = name;
  }

  public String getStudentId() {
    return student_id;
  }

  public void setStudentId(String num) {
    this.student_id  = num;
  }
  
  public int getScore() {
	    return score;
   }

   public void setScore(int num) {
	    this.score = num;
	}
   
   public String getTheme() {
	    return theme;
	}
   
   public void settheme(String date) {
	    this.theme = date;
	}

   // return number of columns in the table
   public int getNumberOfColumns() {
	   return 4;
   }
   
   // return the data in column i
   public String getColumnData(int i) throws Exception {
	   if (i == 0)
		   return getStudentId();
	   else if (i == 1)
		   return getStudentName();
	   else if (i == 2) 
		   return Integer.toString(getScore());
	   else if (i == 3)
		   return getTheme();
	   else
		   throw new Exception("Error: invalid column index in student table");    
   }
   
   // return the name of column i
   public String getColumnName(int i) throws Exception {
	   String colName = null;
	   if (i == 0) 
		   colName = "student_id";
	   else if (i == 1)
		   colName = "student_name";
	   else if (i == 2)
		   colName = "score";
	   else if (i == 3)
		   colName = "theme";
	   else 
		   throw new Exception("Access to invalid column number in student table");
	   
	   return colName;
   }
   
   // set data column i to value
   public void setColumnData(int i, Object value) throws Exception {
	   if (i == 0) 
		   student_id = (String) value;
	   else if (i == 1) 
		   student_name = (String) value;
	   else if (i == 2) 
		   score =  Integer.parseInt((String) value);
	   else if (i == 3)
		   theme = (String) value;
	   else
		   throw new Exception("Error: invalid column index in student table");    
   }
   
  @Override
  public String toString() {
    return "Student [Student Name =" + student_name + ", "
    	    + " Student Id =" + student_id + ","
    	    + " Score =" + score + ","
    	    + " Theme =" + theme + ","
    	    + "]";
  }

}
