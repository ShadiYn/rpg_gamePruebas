package rpg_game_windwalk;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class key_handler implements KeyListener {
	
	public boolean arribaPulsado, abajoPulsado,izqPulsado,derPulsado;

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_W) {
			arribaPulsado=true;
		}
		if(key == KeyEvent.VK_S) {
			abajoPulsado=true;
	
		}
		if(key == KeyEvent.VK_A) {
			izqPulsado = true;
		}
		if(key == KeyEvent.VK_D) {
			derPulsado=true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_W) {
			arribaPulsado =false;
		}
		if(key == KeyEvent.VK_S) {
			abajoPulsado =false;
	
		}
		if(key == KeyEvent.VK_A) {
			izqPulsado = false;
		}
		if(key == KeyEvent.VK_D) {
			derPulsado =false;
		}
	}

}
