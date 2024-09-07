package Entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import rpg_game_windwalk.GamePanel;
import rpg_game_windwalk.key_handler; // Assuming the class name is KeyHandler

public class Player extends Entity {

    GamePanel gp;
    key_handler kh;
    public final int screenX;
    public final int screenY;
    public int hasKey =0;
    
    public Player(GamePanel gp, key_handler kh) {
        this.gp = gp;
        this.kh = kh;
        
        screenX = gp.screenWidth/2 - gp.tileSize/2;
        screenY = gp.screenHeight/2 - gp.tileSize/2 ;
        
        solidArea = new Rectangle(8,16,32,32);//pasa 4 parametros para el constructor
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        
        setDefaultValues();
        getPlayerImage();
    }
    
    public void setDefaultValues() {
        worldX = gp.tileSize * 23;
        worldY = gp.tileSize * 21;
        speed = 4;
        direction = "arriba";
    }
    
    public void getPlayerImage() {
    	try {
    		
    		up1 = ImageIO.read(getClass().getResourceAsStream("/player/characterup1.png"));
    		up2 = ImageIO.read(getClass().getResourceAsStream("/player/characterup2.png"));
    		down1 = ImageIO.read(getClass().getResourceAsStream("/player/characterdown1.png"));
    		down2 = ImageIO.read(getClass().getResourceAsStream("/player/characterdown2.png"));
    		left1 = ImageIO.read(getClass().getResourceAsStream("/player/characterLeft1.png"));
    		left2 = ImageIO.read(getClass().getResourceAsStream("/player/characterLeft2.png"));
    		right1 = ImageIO.read(getClass().getResourceAsStream("/player/characterRight1.png"));
    		right2 = ImageIO.read(getClass().getResourceAsStream("/player/characterRight2.png"));

    		
    		
    	}catch(IOException e) {
    		e.printStackTrace();
    	}
    }
    
    public void update() {
        if (kh.arribaPulsado || kh.abajoPulsado || kh.izqPulsado || kh.derPulsado) {

            if (kh.arribaPulsado) {
                direction = "arriba";
            }
            if (kh.abajoPulsado) {
                direction = "abajo";
            }
            if (kh.izqPulsado) {
                direction = "izquierda";
            }
            if (kh.derPulsado) {
                direction = "derecha";
            }

            // Verifica colisiones antes de mover
            CollisionOn = false;
            gp.Colchech.checkTile(this);
            
            //chequear la colision de objeto
            
           int objIndex =  gp.Colchech.checkObject(this, true);
           pickUpObject(objIndex);
            // Si no hay colisión, mueve al jugador
            if (!CollisionOn) {
                switch (direction) {
                    case "arriba":
                        worldY -= speed;
                        break;
                    case "abajo":
                        worldY += speed;
                        break;
                    case "izquierda":
                        worldX -= speed;
                        break;
                    case "derecha":
                        worldX += speed;
                        break;
                }
            }

            // Actualiza el contador de sprite
            spriteCounter++;
            if (spriteCounter > 15) {
                spriteNum = spriteNum == 1 ? 2 : 1;
                spriteCounter = 0;
            }
        }
    }
    
    public void pickUpObject(int i) {
    	
    	if(i != 999) {
    		String objName = gp.obj[i].name;
    		
    		switch(objName) {
    		case"key":
    			gp.playerFX(1);
    			hasKey++;
    			gp.obj[i] = null; //esto hace que al tocar el objeto simplemente desaparezca
    			gp.ui.showMessage("Has obtenido una llave");
    			break;
    			
    		case "door":
    			if(hasKey >0) {
        			gp.playerFX(3);
    				gp.obj[i] = null; //comprueba si tiene llave enbtonces la puerta desaparecerá
    				hasKey--;
        			gp.ui.showMessage("Puerta Abierta");

    			}else {
    				gp.ui.showMessage("Necesitas una llave");
    			}
    			break;
    		case "boot":
    			gp.playerFX(2);
    			
    			//para hacer que tras 40 segundos
    			//el pesnaje vuelva a la velocidad normal tenemos que usar threads
    			
    			speed+=2;
    			gp.obj[i]=null;
    			
    			new Thread(() -> {
    				try {
    					Thread.sleep(5000);
    					
    				}catch (InterruptedException  e) {
    					e.printStackTrace();
    				}
    				speed -=2;
    			}).start();
    			gp.ui.showMessage("Botas obtenidas");

    			break;
    			
    		case "chest":
    			gp.ui.gameFinished=true;
    			gp.stopMusic();
    			gp.playerFX(4);
    			break;
    		}
    	}
    }
    
    public void draw(Graphics2D g2) {
        BufferedImage image = null;
        
        switch(direction) {
        
        case "arriba":
        	if(spriteNum ==1) {
        		image = up1;
        	}
        	if(spriteNum == 2) {
        		image = up2;
        	}
        	
        	break;
        case "abajo":
        	if(spriteNum == 1) {
        		image = down1;	
        	}
        	if(spriteNum == 2) {
        		image = down2;
        	}
        	
        	break;
        case "izquierda":
        	if(spriteNum == 1) {
            	image = left1;

        	}
        	if(spriteNum == 2) {
        		image = left2;
        	}
        	break;
        case "derecha":
        	if(spriteNum == 1) {
            	image = right1;

        	}
        	if(spriteNum == 2) {
        		image = right2;
        	}
        		break;
        
        }
        g2.drawImage(image,screenX,screenY, gp.tileSize, gp.tileSize,null);
        
    }
}
