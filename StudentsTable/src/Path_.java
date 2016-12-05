import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Path_ extends JPanel implements ActionListener, KeyListener {

	private BufferedImage fruit1;
	private BufferedImage fruit2;
	private BufferedImage fruit3;
	private BufferedImage fruit4;
	private BufferedImage fruit5;
	private BufferedImage fruit6;
	private BufferedImage path;
	/*private int xfruit1 = 150;
	private int yfruit1 = 500;
	private int xfruit2 = 70;
	private int yfruit2 = 200;
	private int xfruit3 = 520;
	private int yfruit3 = 200;
	private int xfruit4 = 650;
	private int yfruit4 = 350;
	private int xfruit5 = 1100;
	private int yfruit5 = 450;
	private int xfruit6 = 1100;*/
	int score =0;
	private int xfruit1 = 90;
	private int yfruit1 = 350;
	private int xfruit2 = 45;
	private int yfruit2 = 150;
	private int xfruit3 = 320;
	private int yfruit3 = 200;
	private int xfruit4 = 500;
	private int yfruit4 = 300;
	private int xfruit5 = 700;
	private int yfruit5 = 350;
	private int xfruit6 = 700;
	private int yfruit6 = 0;
	Random rand = new Random();
	int value = rand.nextInt(4);
	Timer t = new Timer(12, this);
	int cx = 0, cy = 500, px = 0, py = 0, velx = 0, vely = 0;
	private List<Integer> mapXPos = new ArrayList<Integer>(Arrays.asList(90, 90, 50, 50, 340, 340, 510, 510,700,700));
	private List<Integer> mapYPos = new ArrayList<Integer>(Arrays.asList(490, 355, 355, 165, 165, 297, 297, 370, 370, 0));
	int mapListindex = 0;
	private Image child;
	boolean backgroundFlag = true;
	Student student; 
	
	public Path_(Student s) {
		student = s;
		child=new ImageIcon("resources/image/graphics-walking-50.gif").getImage();
		
		try {
			path = ImageIO.read(new File("resources/image/lawn.jpg"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		if (value == 0) {
			try {
				fruit1 = ImageIO.read(new File("resources/image/Mango.png"));
				fruit2 = ImageIO.read(new File("resources/image/Banana.png"));
				fruit3 = ImageIO.read(new File("resources/image/Grapes.png"));
				fruit4 = ImageIO.read(new File("resources/image/Pine_Apple.png"));
				fruit5 = ImageIO.read(new File("resources/image/Strawberry.png"));
				fruit6 = ImageIO.read(new File("resources/image/apple.png"));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

		if (value == 1) {
			try {
				fruit1 = ImageIO.read(new File("resources/image/Banana.png"));
				fruit2 = ImageIO.read(new File("resources/image/Mango.png"));
				fruit3 = ImageIO.read(new File("resources/image/apple.png"));
				fruit4 = ImageIO.read(new File("resources/image/Grapes.png"));
				fruit5 = ImageIO.read(new File("resources/image/Strawberry.png"));
				fruit6 = ImageIO.read(new File("resources/image/Pine_Apple.png"));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

		if (value == 2) {
			try {
				fruit1 = ImageIO.read(new File("resources/image/Pine_Apple.png"));
				fruit2 = ImageIO.read(new File("resources/image/Banana.png"));
				fruit3 = ImageIO.read(new File("resources/image/Grapes.png"));
				fruit4 = ImageIO.read(new File("resources/image/Mango.png"));
				fruit5 = ImageIO.read(new File("resources/image/apple.png"));
				fruit6 = ImageIO.read(new File("resources/image/Strawberry.png"));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

		if (value == 3) {
			try {
				fruit1 = ImageIO.read(new File("resources/image/Grapes.png"));
				fruit2 = ImageIO.read(new File("resources/image/apple.png"));
				fruit3 = ImageIO.read(new File("resources/image/Banana.png"));
				fruit4 = ImageIO.read(new File("resources/image/Pine_Apple.png"));
				fruit5 = ImageIO.read(new File("resources/image/Strawberry.png"));
				fruit6 = ImageIO.read(new File("resources/image/Mango.png"));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

		if (value == 4) {
			try {
				fruit1 = ImageIO.read(new File("resources/image/Strawberry.png"));
				fruit2 = ImageIO.read(new File("resources/image/Pine_Apple.png"));
				fruit3 = ImageIO.read(new File("resources/image/apple.png"));
				fruit4 = ImageIO.read(new File("resources/image/Grapes.png"));
				fruit5 = ImageIO.read(new File("resources/image/Mango.png"));
				fruit6 = ImageIO.read(new File("resources/image/Banana.png"));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
		t.start();
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		requestFocusInWindow();
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawImage(path, 0, 0, getWidth(), getHeight(), null);
		/*g.drawImage(fruit1,90,350,80,80,null);
		g.drawImage(fruit2,45,150,80,80,null);
		g.drawImage(fruit3,320,200,80,80,null);
		g.drawImage(fruit4,500,300,80,80,null);
		g.drawImage(fruit5,700,350,80,80,null);
		g.drawImage(fruit6,700,0,80,80,null);*/
		g.drawImage(fruit1, xfruit1, yfruit1, 70, 70, null);
		g.drawImage(fruit2, xfruit2, yfruit2, 70, 70, null);
		g.drawImage(fruit3, xfruit3, yfruit3, 70, 70, null);
		g.drawImage(fruit4, xfruit4, yfruit4, 70, 70, null);
		g.drawImage(fruit5, xfruit5, yfruit5, 70, 70, null);
		g.drawImage(fruit6, xfruit6, yfruit6, 70, 70, null);

		g.drawImage(child, (int) cx, (int) cy, this);
	}

	private boolean checkValidStep(String moveDir){
		boolean valid= false;
		switch(moveDir){
		case "UP":
			valid = mapYPos.get(mapListindex) < cy;
			break;
		case "DOWN":
			valid = mapYPos.get(mapListindex) > cy;
			break;
		case "LEFT":
			valid = mapXPos.get(mapListindex) < cx;
			break;
		case "RIGHT":
			valid = mapXPos.get(mapListindex) > cx;
			break;
		}
		return valid;
	}
	
	public void actionPerformed(ActionEvent e) {

		System.out.println("Action performed....."+ cx + " " + cy);
		this.requestFocusInWindow();
		//validate();
		repaint();
		cx = cx + velx;
		cy = cy + vely;
		
		velx=0;
		vely=0;
	}

	public void up() {
		
		if(checkValidStep("UP")){
			vely = -4;
			velx = 0;
			pathCollision();
		}
	}

	public void down() {
		
		if(checkValidStep("DOWN")){
			vely=4;
			velx=0;
			pathCollision();
		}
	}

	public void left() {
		
		if(checkValidStep("LEFT")){
			vely=0;
			velx=-4;
			pathCollision();
		}
	}

	public void right() {
		
		if(checkValidStep("RIGHT")){
			vely=0;
			velx=4;
			pathCollision();
		
		}
	}

	public void pathCollision() {
		Rectangle r = new Rectangle(cx, cy, 15, 15);
		//System.out.println(r.getBounds());
		Rectangle pathR = new Rectangle(mapXPos.get(mapListindex), mapYPos.get(mapListindex), 10, 10);
		if (r.intersects(pathR)){
			mapListindex++;
			velx = 0;
			vely = 0;
		}
		if(mapListindex==10){
			//todo: display winner or game over
			t.stop();
			StudentsTableController  studentsTableController = new StudentsTableController();
			String[] array = new String[4];
		   	array[0] = student.getStudentId();
		   	array[1] = student.getStudentName();
		   	array[2] = String.valueOf(score);
	    	array[3] = student.getTheme();
			studentsTableController.updateRow(array);
			
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int code = e.getKeyCode();
		if (code == KeyEvent.VK_UP) {
			up();
			collision();
		}
		if (code == KeyEvent.VK_DOWN) {
			down();
			collision();
		}
		if (code == KeyEvent.VK_LEFT) {
			left();
			collision();
		}
		if (code == KeyEvent.VK_RIGHT) {
			right();
			collision();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		velx = 0;
		vely = 0;

	}

	Rectangle fruit1_r = new Rectangle(xfruit1, yfruit1, 50, 50);
	Rectangle fruit2_r = new Rectangle(xfruit2, yfruit2, 50, 50);
	Rectangle fruit3_r = new Rectangle(xfruit3, yfruit3, 50, 50);
	Rectangle fruit4_r = new Rectangle(xfruit4, yfruit4, 50, 50);
	Rectangle fruit5_r = new Rectangle(xfruit5, yfruit5, 50, 50);
	Rectangle fruit6_r = new Rectangle(xfruit6, yfruit6, 50, 50);
	
	public void collision() {
		Rectangle r = new Rectangle(cx, cy, 25, 25);
		 System.out.println(r.getBounds());
		
		if (fruit1 != null){
			if(r.intersects(fruit1_r)) {
				velx = 0;
				vely = 0;
				score +=10;
				JOptionPane.showMessageDialog(this, "fruit1"+score);//, "FruitInfo", 2, (Icon) image_a);
				fruit1=null;
				fruit1_r = null;
			}
		} else if (fruit2 != null) { 
			if (r.intersects(fruit2_r)) {
				score +=10;
				velx = 0;
				vely = 0;
				JOptionPane.showMessageDialog(this, "fruit2"+score);//, "FruitInfo", 2, (Icon) image_a);
				fruit2=null;
				fruit2_r=null;
			}
		} else if (fruit3 != null) { 
			if (r.intersects(fruit3_r)) {
				score +=10;
				velx = 0;
				vely = 0;
				JOptionPane.showMessageDialog(this, "fruit3"+score);//, "FruitInfo", 2, (Icon) image_a);
				fruit3 = null;
				fruit3_r = null;
			}
		} else if (fruit4 != null) { 
			if (r.intersects(fruit4_r)) {
				score +=10;
				velx = 0;
				vely = 0;
				JOptionPane.showMessageDialog(this, "fruit4"+score);//, "FruitInfo", 2, (Icon) image_a);
				fruit4 = null;
				fruit4_r = null;
			}
		} else if (fruit5 != null) { 
			if (r.intersects(fruit5_r)) {
				score +=10;
				velx = 0;
				vely = 0;
				JOptionPane.showMessageDialog(this, "fruit5"+score);//, "FruitInfo", 2, (Icon) image_a);
				fruit5 = null;
				fruit5_r = null;
			}
		} else if (fruit6 != null) { 
			if (r.intersects(fruit6_r)) {
				score +=10;
				velx = 0;
				vely = 0;
				JOptionPane.showMessageDialog(this, "fruit6"+score);//, "FruitInfo", 2, (Icon) image_a);
				fruit6 = null;
				fruit6_r = null;
			}
		}
	}
	
	/*public static void main(String[] args) {

		Path p = new Path();
		JFrame window = new JFrame("Treasure Hunt");
		
		window.setContentPane(p);
		window.pack();
	//	window.setSize(1500, 1500);
		window.setSize(820,580);
		window.setTitle("Treasure Hunt");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}*/
}