package rpg_game_windwalk;

import Entity.Entity;

public class collisionCheck {
    GamePanel gp;

    public collisionCheck(GamePanel gp) {
        this.gp = gp;
    }

    public void checkTile(Entity entity) {
        int entityLeftWorldX = entity.worldX + entity.solidArea.x;
        int entityRightWorldX = entity.worldX + entity.solidArea.x + entity.solidArea.width;
        int entityTopWorldY = entity.worldY + entity.solidArea.y;
        int entityBotWorldY = entity.worldY + entity.solidArea.y + entity.solidArea.height;

        int entityLeftCol = entityLeftWorldX / gp.tileSize;
        int entityRightCol = entityRightWorldX / gp.tileSize;
        int entityTopRow = entityTopWorldY / gp.tileSize;
        int entityBotRow = entityBotWorldY / gp.tileSize;

        int tileNum1, tileNum2;

        switch (entity.direction) {
            case "arriba":
                entityTopRow = (entityTopWorldY - entity.speed) / gp.tileSize;
                tileNum1 = gp.Tm.tileMapNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.Tm.tileMapNum[entityRightCol][entityTopRow];
                if (gp.Tm.tile[tileNum1].Collision || gp.Tm.tile[tileNum2].Collision) {
                    entity.CollisionOn = true;
                }
                break;

            case "abajo":
                entityBotRow = (entityBotWorldY + entity.speed) / gp.tileSize;
                tileNum1 = gp.Tm.tileMapNum[entityLeftCol][entityBotRow];
                tileNum2 = gp.Tm.tileMapNum[entityRightCol][entityBotRow];
                if (gp.Tm.tile[tileNum1].Collision || gp.Tm.tile[tileNum2].Collision) {
                    entity.CollisionOn = true;
                }
                break;

            case "izquierda":
                entityLeftCol = (entityLeftWorldX - entity.speed) / gp.tileSize;
                tileNum1 = gp.Tm.tileMapNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.Tm.tileMapNum[entityLeftCol][entityBotRow];
                if (gp.Tm.tile[tileNum1].Collision || gp.Tm.tile[tileNum2].Collision) {
                    entity.CollisionOn = true;
                }
                break;

            case "derecha":
                entityRightCol = (entityRightWorldX + entity.speed) / gp.tileSize;
                tileNum1 = gp.Tm.tileMapNum[entityRightCol][entityTopRow];
                tileNum2 = gp.Tm.tileMapNum[entityRightCol][entityBotRow];
                if (gp.Tm.tile[tileNum1].Collision || gp.Tm.tile[tileNum2].Collision) {
                    entity.CollisionOn = true;
                }
                break;
        }
    }
    
    public int checkObject(Entity entity, boolean player) {

    	int index = 999;
    	
    	for(int i = 0; i < gp.obj.length;i++) {
    		//si no es nulo
    		if(gp.obj[i]!= null) {
    			
    			//obtener el solid area del entity y del bjeto
    			
    			entity.solidArea.x = entity.worldX + entity.solidArea.x;
    			entity.solidArea.y = entity.worldY + entity.solidArea.y;
    			//obtener el solid aea del objeto
    			gp.obj[i].solidArea.x = gp.obj[i].worldX +  gp.obj[i].solidArea.x;
    			gp.obj[i].solidArea.y = gp.obj[i].worldY + gp.obj[i].solidArea.y;
    		
    			
    			switch(entity.direction) {
    			case "arriba":
    				entity.solidArea.y -= entity.speed;
    				if(entity.solidArea.intersects(gp.obj[i].solidArea)) {
	    				
    					
    					if(gp.obj[i].collision == true) {
	    					entity.CollisionOn = true;
	    					}
	    					if(player == true) {
	    						index = i;
	    					}
    				
    			}
    				break;
    				
    			case "abajo":
    				entity.solidArea.y += entity.speed;
    				if(entity.solidArea.intersects(gp.obj[i].solidArea)) {
    					if(gp.obj[i].collision == true) {
	    					entity.CollisionOn = true;
	    					}
	    					if(player == true) {
	    						index = i;
	    					}
    				
    				
    				}
    				break;
    				
    			case "izquierda":
    				entity.solidArea.x -= entity.speed; 
    				if(entity.solidArea.intersects(gp.obj[i].solidArea)) {
    					if(gp.obj[i].collision == true) {
	    					entity.CollisionOn = true;
	    					}
	    					if(player == true) {
	    						index = i;
	    					}
    				
    				}
    				break;
    				
    			case "derecha":
    				entity.solidArea.x += entity.speed;
    				if(entity.solidArea.intersects(gp.obj[i].solidArea)) {
    					if(gp.obj[i].collision == true) {
	    					entity.CollisionOn = true;
	    					}
	    					if(player == true) {
	    						index = i;
	    					}
    				
    				}
    				break;
    				
    		}
    			entity.solidArea.x = entity.solidAreaDefaultX;
    			entity.solidArea.y = entity.solidAreaDefaultY;
    			gp.obj[i].solidArea.x = gp.obj[i].solidAreaDefaultX;
    			gp.obj[i].solidArea.y = gp.obj[i].solidAreaDefaultY;
    		
    		
    		}
    	}
    	return index;
    	
    }
}
