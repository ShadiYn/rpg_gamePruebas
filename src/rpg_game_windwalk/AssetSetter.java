package rpg_game_windwalk;

import object.OBJ_boot;
import object.OBJ_chest;
import object.OBJ_door;
import object.OBJ_key;

public class AssetSetter {

	GamePanel gp;
	
	public AssetSetter(GamePanel gp) {
		this.gp = gp;
	}
	
	public void setObject() {
		//instancioar diferente sobjetos para ponerlos en los mapa
		gp.obj[0]= new OBJ_key();
		gp.obj[0].worldX = 23 * gp.tileSize;
		gp.obj[0].worldY = 7 * gp.tileSize;  // Cambia 'WorldY' a 'worldY'
		
		gp.obj[1]= new OBJ_key();
		gp.obj[1].worldX = 23 * gp.tileSize;
		gp.obj[1].worldY = 40 * gp.tileSize; // Cambia 'WorldY' a 'worldY'

		gp.obj[2]= new OBJ_key();
		gp.obj[2].worldX = 38 * gp.tileSize;
		gp.obj[2].worldY = 8 * gp.tileSize; // Cambia 'WorldY' a 'worldY'

		gp.obj[3]= new OBJ_door();
		gp.obj[3].worldX = 10 * gp.tileSize;
		gp.obj[3].worldY = 11* gp.tileSize;
		
		gp.obj[5]= new OBJ_door();
		gp.obj[5].worldX = 12 * gp.tileSize;
		gp.obj[5].worldY = 22* gp.tileSize;
		
		gp.obj[6]= new OBJ_chest();
		gp.obj[6].worldX = 10 * gp.tileSize;
		gp.obj[6].worldY = 7 * gp.tileSize;
		
		gp.obj[7]= new OBJ_boot();
		gp.obj[7].worldX =  22* gp.tileSize;
		gp.obj[7].worldY =  19* gp.tileSize;
		
		
		
	}
	
}
