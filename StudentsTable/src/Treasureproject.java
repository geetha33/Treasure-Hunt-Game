

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.util.List;

import javax.swing.*;

public class Treasureproject extends JPanel {
	private JPanel cards;
	private JPanel initialpanel;
	private JPanel TeacherLoginPanel;
	private JPanel studententryPanel;
	private JPanel progressviewpanel;
	private JPanel studentsscorePanel;
	private JPanel StudentLoginPanel;
	private Path GamethemePanel;
	private JPanel theme1Panel;
	private JPanel theme2Panel;
	private JPanel buttonpanel;
	private JPanel initialbuttonpanel;
	private JPanel Teacherbuttonpanel;
	private JPanel Themebuttonpanel;
	private JPanel namethemepanel;
	private JPanel nameinstructionpanel;
	private JLabel jLabel1;
	private JTextField studentIDTextField;
	private CardLayout cl;
	
	private Student s;
	
final static String INITIALPANEL = "Initial";
	final static String TEACHERLOGINPANEL = "Teacherpanel";
	final static String STUDENTENTRYPANEL = "Studententrypanel";
	final static String PROGRESSVIEWPANEL = "Progressviewpanel";
	final static String STUDENTSCOREPANEL = "studentsscorePanel";
	final static String STUDENTSLOGINPANEL = "StudentLoginPanel";
	final static String GAMETHEMEPANEL = "GamethemePanel";
	final static String THEME1PANEL = "theme1Panel";
	final static String THEME2PANEL = "theme2Panel";
	
	public Treasureproject() {

		initialpanel = new JPanel(new FlowLayout()) {
			Image background = new javax.swing.ImageIcon("image/Garden2.png")
			.getImage();

			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D myGraphics = (Graphics2D) g;
				myGraphics.drawImage(background, 0, 0, getWidth(), getHeight(),
						null);
			}

		};
		//initialpanel.setLayout(new BoxLayout(initialpanel,BoxLayout.LINE_AXIS));
		jLabel1 = new javax.swing.JLabel("Student Name:");
		jLabel1.setForeground(Color.white);
        studentIDTextField = new JTextField(40);
        studentIDTextField.setHorizontalAlignment(10);
        //studentIDTextField.setAlignmentX(RIGHT_ALIGNMENT);
        //studentIDTextField.setSize(100,100);
        //studentIDTextField.setHorizontalAlignment(JTextField.CENTER);
        //studentIDTextField.setAlignmentY(4);
        //studentIDTextField.setPreferredSize(new Dimension(1,1));
        
		initialpanel.add(jLabel1);
		initialpanel.add(studentIDTextField);
		JButton teacherlogin = new JButton() {

			Image image = new javax.swing.ImageIcon("image/teacher.png")
			.getImage();

			public void paint(Graphics g) {

				super.paint(g);

				g.drawImage(image, 0, 0, getWidth(), getHeight(), null);

			}

		};

		teacherlogin.setPreferredSize(new Dimension(300, 100));

		teacherlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl = (CardLayout) (cards.getLayout());
				cl.show(cards, TEACHERLOGINPANEL);

			}
		});

		JButton studentlogin = new JButton() {

			Image image = new javax.swing.ImageIcon("image/student.png")
			.getImage();

			public void paint(Graphics g) {

				super.paint(g);

				g.drawImage(image, 0, 0, getWidth(), getHeight(), null);

			}

		};

		studentlogin.setPreferredSize(new Dimension(300, 100));
		studentlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String name=studentIDTextField.getText();
				StudentsTableController  studentsTableController = new StudentsTableController();
				List<Student> students = studentsTableController.CheckStudentExists(name);
				if(students.size() == 0){
					JOptionPane.showMessageDialog(initialpanel, "Student does not exist!", "ERROR", 1);
				}else{
					 s = students.get(0);
					GamethemePanel = new Path(s);
					cl = (CardLayout) (cards.getLayout());
					cl.show(cards, STUDENTSLOGINPANEL);
					StudentLoginPanel.setFocusable(true);
					StudentLoginPanel.requestFocusInWindow();
				}
				
				

			}
		});

		initialpanel.add(teacherlogin);
		initialpanel.add(studentlogin);

		TeacherLoginPanel = new JPanel(new FlowLayout()) {
			Image background = new javax.swing.ImageIcon("image/student.jpeg")
			.getImage();

			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D myGraphics = (Graphics2D) g;

				myGraphics.drawImage(background, 0, 0, getWidth(), getHeight(),
						null);
			}

		};

		TeacherLoginPanel.addKeyListener(new KeyAdapter() {

			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == 37) {

					cl = (CardLayout) (cards.getLayout());
					cl.show(cards, INITIALPANEL);
					TeacherLoginPanel.setFocusable(true);
					TeacherLoginPanel.requestFocusInWindow();

				}
			}
		});

		
		

		StudentsGUI teacherView = new StudentsGUI();
		teacherView.homeButton.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	cl = (CardLayout) (cards.getLayout());
					cl.show(cards, INITIALPANEL);
	                
	            }
	        });
		TeacherLoginPanel.add(teacherView);
		//TeacherLoginPanel.add(studentscores);
		
		StudentLoginPanel = new JPanel(new BorderLayout()) {
			 
			Image background = new javax.swing.ImageIcon("image/Jungle2.png")
			.getImage();

			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D myGraphics = (Graphics2D) g;
				myGraphics.drawImage(background, 0, 0, getWidth(), getHeight(),
						null);
				AudioPlayer02.playAudio("audio/Initial_Audio.wav");
			}

		};
	//	GamethemePanel=new JPanel();
		StudentLoginPanel.addKeyListener(new KeyAdapter() {

			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() != 10) {
					System.out.println("ABC");
					cl = (CardLayout) (cards.getLayout());
					
					cl.show(cards, GAMETHEMEPANEL);
					GamethemePanel.setFocusable(true);
					GamethemePanel.requestFocusInWindow();
					AudioPlayer02.playAudio("audio/instructions.wav");
					// AudioPlayer02.playAudio("audio/Go_right.wav");

				} else {
					System.exit(0);
				}
			}

		});
		
		GamethemePanel = new Path(s);

		cards = new JPanel(new CardLayout());
		cards.add(initialpanel, INITIALPANEL);
		cards.add(TeacherLoginPanel, TEACHERLOGINPANEL);
		// cards.add(studententryPanel,STUDENTENTRYPANEL);
		// cards.add(progressviewpanel,PROGRESSVIEWPANEL);
		// cards.add(studentsscorePanel,STUDENTSCOREPANEL);
		cards.add(StudentLoginPanel, STUDENTSLOGINPANEL);
		cards.add(GamethemePanel, GAMETHEMEPANEL);

		JFrame window = new JFrame("Treasure Hunt");

		window.setContentPane(cards);

		window.setSize(820, 580);

		window.setTitle("Treasure Hunt");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);

	}

	public static void main(String[] args) {

		new Treasureproject();
	}
}
