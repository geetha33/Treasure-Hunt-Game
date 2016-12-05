import java.util.List;

import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.table.TableModel;

/**
* Glue between the view (CourseListGUI) and the model (CourseListTableModel). 
* No database specific code here. Contains a reference to both the TableModel and the graphical user interface.
*
*/
public class StudentsTableController implements ListSelectionListener, TableModelListener  {
	private StudentsTableModel tableModel;
	private StudentsGUI gui;
	
	public StudentsTableController(StudentsGUI gui) {
		this.gui = gui;   
         // create the tableModel using the data in the cachedRowSet
    	tableModel = new StudentsTableModel(); 
    	tableModel.addTableModelListener(this);
	}
	
	public StudentsTableController() {
		tableModel = new StudentsTableModel(); 
    	tableModel.addTableModelListener(this);
	}
	
	// new code
	public  TableModel getTableModel() {
		return tableModel;
	}
	
	public void valueChanged(ListSelectionEvent e) {
		ListSelectionModel selectModel = (ListSelectionModel) e.getSource();
		int firstIndex = selectModel.getMinSelectionIndex();
		
		// read the data in each column using getValueAt and display it on corresponding textfield
		gui.setStudentIDTextField( (String) tableModel.getValueAt(firstIndex, 0));
		gui.setStudentNameTextField( (String) tableModel.getValueAt(firstIndex, 1));
		gui.setScoreTextField( (String) tableModel.getValueAt(firstIndex, 2));
		gui.setThemeNameTextField( (String) tableModel.getValueAt(firstIndex, 3));
		
	}
	
	public void addRow(String[] array) {
		tableModel.addRow(array);			
	}

	public void deleteRow(String studentId) {
		tableModel.deleteRow(studentId);			
	}
	
	public void updateRow(String[] array) {
		tableModel.updateRow(array);			
	}
	
	public List<Student> CheckStudentExists(String studentName) {
		return tableModel.getStudent(studentName);
		
	}

	public void tableChanged(TableModelEvent e)
	{
	   try {
	    	// get the index of the inserted row
	        //tableModel.getRowSet().moveToCurrentRow();
	    	int firstIndex =  e.getFirstRow();
	    	
	    	// create a new table model with the new data
	        tableModel = new StudentsTableModel(tableModel.getList(), tableModel.getEntityManager());
	        tableModel.addTableModelListener(this);
	    
	        // update the JTable with the data
	        if(gui != null){
		    	gui.updateTable();
		    
		        // read the data in each column using getValueAt and display it on corresponding textfield
				gui.setStudentIDTextField( (String) tableModel.getValueAt(firstIndex, 0));
				gui.setStudentNameTextField( (String) tableModel.getValueAt(firstIndex, 1));
				gui.setScoreTextField( (String) tableModel.getValueAt(firstIndex, 2));
				gui.setThemeNameTextField( (String) tableModel.getValueAt(firstIndex, 3));
	        }
		
	} catch(Exception exp) {
		exp.getMessage();
		exp.printStackTrace();
	}
}

}

