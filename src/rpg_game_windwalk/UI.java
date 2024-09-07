package rpg_game_windwalk;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import object.OBJ_key;

public class UI {
	
	//HANDLE ALL SCREEN UI
	GamePanel gp;
	Font arial_40, arial_80B;
	BufferedImage KeyImage;
	public boolean messageOn=false;
	public String message ="";
	int messageCounter=0;
	public boolean gameFinished = false;
	
	
	public UI(GamePanel gp) {
		this.gp = gp;
		arial_40 = new Font("Arial", Font.PLAIN,40);
		arial_80B = new Font("Arial", Font.BOLD,80);

		OBJ_key key = new OBJ_key();
		KeyImage = key.image;
	}
	public void showMessage(String text) {
		message = text;
			messageOn=true;
	}
	
	
	public void draw(Graphics2D g2) {
		
		if(gameFinished ==true) {
			
			g2.setFont(arial_40);
			g2.setColor(Color.white);
			
			String text;
			int textLenght;
			int x;
			int y;
			
			text = "Has conseguido el cofre!";
			textLenght = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
			
			x=gp.screenWidth/2 - textLenght/2;
			y=gp.screenHeight/2 - (gp.tileSize*3);
			
			g2.drawString(text, x, y);
			g2.setFont(arial_80B);
			g2.setColor(Color.yellow);
			
			text = "Felicidades!";
			textLenght = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
			x=gp.screenWidth/2 - textLenght/2;
			y=gp.screenHeight/2 + (gp.tileSize*2);
	        g2.drawString(text, x, y);  // Ensure the congratulatory message is drawn
	        gp.gameThread = null;

			
		}else {
			//primero la fuente, luego el estilo y el tamaño
			g2.setFont(arial_40);
			g2.setColor(Color.white);
			g2.drawImage(KeyImage,gp.tileSize/2, gp.tileSize/2,gp.tileSize,gp.tileSize,null);
			
			g2.drawString(""+ gp.player.hasKey, 74 ,65 );
			//mensaje
			if(messageOn == true) {
				g2.setFont(g2.getFont().deriveFont(30F));
				g2.drawString(message,250, 50);
				
				
				messageCounter++;
				
				if(messageCounter > 120) {
					messageCounter=0;
					messageOn = false;
				}
			
			}
		}
		
	}

}
