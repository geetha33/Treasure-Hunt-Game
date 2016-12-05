import java.io.File;
import java.io.IOException;

import sun.audio.*;

import java.io.*;
import java.net.MalformedURLException;
import java.util.Scanner;

import javax.media.CannotRealizeException;
import javax.media.Manager;
import javax.media.NoPlayerException;
import javax.media.Player;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;

public class playAudio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f=new File("image/blues.wav");
		//File f1=new File("audio/Go_left.wav");


		 // Create a Player object that realizes the audio
		 Player p = null;
		 Player p1=null;
		try {
			p = Manager.createRealizedPlayer(f.toURI().toURL());
			//p1=Manager.createRealizedPlayer(f.toURI().toURL());
			
		} catch (NoPlayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CannotRealizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		  // Start the music
		  p.start();
		  try {
			Thread.sleep(p.getMediaNanoseconds()/1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!");
			e.printStackTrace();
		}
		  //while(p.)
		  p.close();
		  //p1.start();


		  // Create a Scanner object for taking input from cmd
		 /* Scanner s=new Scanner(System.in);


		  // Read a line and store it in st
		  String st=s.nextLine();


		   // If user types 's', stop the audio
		   if(st.equals("s"))
		   {
		   p.close();
		   }*/
		 
	}
}
