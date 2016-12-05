
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.sound.sampled.*;

public class AudioPlayer02 extends JFrame {
	
	static AudioFormat audioFormat;
	static AudioInputStream audioInputStream;
	static SourceDataLine sourceDataLine;
	static boolean stopPlayback = false;

	public static void playAudio(String s1) {
		try {
			File soundFile = new File(s1);
			audioInputStream = AudioSystem.getAudioInputStream(soundFile);
			audioFormat = audioInputStream.getFormat();
			System.out.println(audioFormat);

			DataLine.Info dataLineInfo = new DataLine.Info(
					SourceDataLine.class, audioFormat);

			sourceDataLine = (SourceDataLine) AudioSystem.getLine(dataLineInfo);

			new PlayThread().start();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
	}

	static class PlayThread extends Thread {
		byte tempBuffer[] = new byte[10000];

		public void run() {
			try {
				sourceDataLine.open(audioFormat);
				sourceDataLine.start();

				int cnt;

				while ((cnt = audioInputStream.read(tempBuffer, 0,
						tempBuffer.length)) != -1 && stopPlayback == false) {
					if (cnt > 0) {

						sourceDataLine.write(tempBuffer, 0, cnt);
					}
				}
				sourceDataLine.drain();
				sourceDataLine.close();

				stopPlayback = false;
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(0);
			}
		}
	}

}
