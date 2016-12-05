import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.text.*;;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ruchir
 */
public class GameGUI  {

    private javax.swing.JButton loginButton;
    private javax.swing.JButton teacherButton;
    private javax.swing.JLabel jLabel1;
    javax.swing.JPanel jPane;
    private javax.swing.JPanel pane1;
    private javax.swing.JPanel pane2;
    private javax.swing.JTextField studentIDTextField;
    private JFrame window;
    public GameGUI() {
    	
        initComponents();
	}
    public GameGUI(int x) {
    	
    	window.setContentPane(jPane);
		window.pack();
		window.setSize(820,580);
		window.setTitle("Treasure Hunt");
        initComponents();
	}
   
	public void initComponents() {
		jPane = new javax.swing.JPanel(new GridLayout(1,1));
		pane1=new javax.swing.JPanel();
		pane2=new javax.swing.JPanel();
		
        jLabel1 = new javax.swing.JLabel("Student Name:");
        studentIDTextField = new javax.swing.JTextField(15);
        loginButton = new javax.swing.JButton("Student Login");
        teacherButton = new javax.swing.JButton("Teacher Area");
        
        loginButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
	
				String name=studentIDTextField.getText();
				StudentsTableController  studentsTableController = new StudentsTableController();
				List<Student> students = studentsTableController.CheckStudentExists(name);
				if(students.size() == 0){
					JOptionPane.showMessageDialog(jPane, "Student does not exist!", "ERROR", 1);
				}else{
					Student s = students.get(0);
				//	window.remove(jPane);
					
					Path p = new Path(s);
					window.setContentPane(p);
					window.pack();
					window.setSize(820,580);
					window.setTitle("Treasure Hunt11");
				}
			}
		});
     
        
        teacherButton.addActionListener(new ActionListener(){
		
        	public void actionPerformed(ActionEvent e) {
				StudentsGUI teacherView = new StudentsGUI(window);
				window.setContentPane(teacherView);
				window.pack();
				window.setSize(820,580);
				window.setTitle("Treasure Hunt");
			}
		});
		
        
       
		
		pane1.add(jLabel1);
		pane1.add(studentIDTextField);
		pane1.add(loginButton);
		pane2.add(teacherButton);
		jPane.add(pane1);
		jPane.add(pane2);
		
		
		
	}
	
		
	
	public static void main(String[] args){
	
		
		GameGUI game=new GameGUI();
		
		game.window=new JFrame();
		game.window.setContentPane(game.jPane);
		game.window.setSize(580,500);
	//	game.window.pack();
		game.window.setVisible(true);
		game.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}
	

}
