package rpg_game_windwalk;

import javax.swing.JFrame;

public class main_menu {

	public static void main(String[] args) {

		JFrame window = new JFrame();
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("WindWalker");
		
		GamePanel gamePanel = new GamePanel();
		window.add(gamePanel);
		window.pack();
		
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		gamePanel.setupGame();
		gamePanel.StartGameThread();
			
	}

}
