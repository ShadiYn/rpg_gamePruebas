package rpg_game_windwalk;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL; 

public class sound {
    
    Clip clip;
    
    URL soundUrl[] = new URL[30]; 
    
    public sound() {
    	soundUrl[0] = getClass().getResource("/sound/theme.wav");
    	soundUrl[1] = getClass().getResource("/sound/key_sound.wav");
    	soundUrl[2] = getClass().getResource("/sound/power_up.wav");
    	soundUrl[3] = getClass().getResource("/sound/desbloquear.wav");
    	soundUrl[4] = getClass().getResource("/sound/fanfare.wav");

    	
    }
    
    public void setFile(int i) {
    	try {
    		//formato para abrir un archiv de audio en java
    		AudioInputStream ais = AudioSystem.getAudioInputStream(soundUrl[i]);
    		clip = AudioSystem.getClip();
    		clip.open(ais);
    		
    	}catch(Exception e) {
    		
    	}
    }
    
    public void play() {
    	clip.start();
    	
    }
    public void loop() {
    	
    	clip.loop(clip.LOOP_CONTINUOUSLY);
    }

public void stop() {
	clip.stop();
}


}


