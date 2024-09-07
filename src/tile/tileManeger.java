package tile;

import java.awt.Graphics2D;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import javax.imageio.ImageIO;

import rpg_game_windwalk.GamePanel;

public class tileManeger {

	GamePanel gp ;
	public Tile[] tile;
	public int tileMapNum[][];
	
	public tileManeger(GamePanel gp) {
		this.gp = gp;
		
		tile = new Tile[60];
		tileMapNum = new int[gp.maxWorldCol][gp.maxworldRow];
		getTileImage();
		loadMap("/maps/world02.txt");
	}
	
	public void getTileImage () {
		try {
			tile[0] = new Tile();
			tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass.png"));
		
			tile[1] = new Tile();
			tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/wall.png"));
			tile[1].Collision=false;
		
			tile[2] = new Tile();
			tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass.png"));
			tile[2].Collision=false;

			tile[3] = new Tile();
			tile[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass.png"));
		
			tile[4] = new Tile();
			tile[4].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass.png"));
			tile[4].Collision=false;

			tile[5] = new Tile();
			tile[5].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass.png"));
			
			tile[6] = new Tile();
			tile[6].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass.png"));

			tile[7] = new Tile();
			tile[7].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass.png"));

			tile[8] = new Tile();
			tile[8].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass.png"));

			tile[9] = new Tile();
			tile[9].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass.png"));

			tile[10] = new Tile();
			tile[10].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass.png"));
			
			tile[11] = new Tile();
			tile[11].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass_topcornerLeft.png"));
			
			tile[12] = new Tile();
			tile[12].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass_top.png"));
			
			tile[13] = new Tile();
			tile[13].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass_topCornerRight.png"));
			
			tile[14] = new Tile();
			tile[14].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass_left.png"));
			
			tile[15] = new Tile();
			tile[15].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass_right.png"));
			
			tile[16] = new Tile();
			tile[16].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass_botCornerLeft.png"));
			
			tile[17] = new Tile();
			tile[17].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass_bottom.png"));
			
			tile[18] = new Tile();
			tile[18].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass_botCornerRight.png"));
			
			tile[19] = new Tile();
			tile[19].image = ImageIO.read(getClass().getResourceAsStream("/tiles/WaterCornerBotLeft.png"));
			
			tile[20] = new Tile();
			tile[20].image = ImageIO.read(getClass().getResourceAsStream("/tiles/WaterCornerBotRight.png"));
			
			tile[21] = new Tile();
			tile[21].image = ImageIO.read(getClass().getResourceAsStream("/tiles/waterCornerLeft.png"));
			
			tile[22] = new Tile();
			tile[22].image = ImageIO.read(getClass().getResourceAsStream("/tiles/WatercornerRightWater.png"));
			
			tile[23] = new Tile();
			tile[23].image = ImageIO.read(getClass().getResourceAsStream("/tiles/WaterDown.png"));
			
			tile[24] = new Tile();
			tile[24].image = ImageIO.read(getClass().getResourceAsStream("/tiles/waterLeft.png"));
			
			tile[25] = new Tile();
			tile[25].image = ImageIO.read(getClass().getResourceAsStream("/tiles/waterRight.png"));
			
			tile[26] = new Tile();
			tile[26].image = ImageIO.read(getClass().getResourceAsStream("/tiles/waterTile.png"));
			
			tile[27] = new Tile();
			tile[27].image = ImageIO.read(getClass().getResourceAsStream("/tiles/waterTile2.png"));
			
			tile[28] = new Tile();
			tile[28].image = ImageIO.read(getClass().getResourceAsStream("/tiles/WaterUp.png"));
			
			tile[29] = new Tile();
			tile[29].image = ImageIO.read(getClass().getResourceAsStream("/tiles/tree.png"));
			
			tile[30] = new Tile();
			tile[30].image = ImageIO.read(getClass().getResourceAsStream("/tiles/earth.png"));
			
			tile[31] = new Tile();
			tile[31].image = ImageIO.read(getClass().getResourceAsStream("/tiles/wall.png"));
			
			tile[32] = new Tile();
			tile[32].image = ImageIO.read(getClass().getResourceAsStream("/tiles/botCornerLeft.png"));
			
			tile[33] = new Tile();
			tile[33].image = ImageIO.read(getClass().getResourceAsStream("/tiles/botcornerRight.png"));
			
			tile[34] = new Tile();
			tile[34].image = ImageIO.read(getClass().getResourceAsStream("/tiles/cornerTopLeft.png"));
			
			tile[35] = new Tile();
			tile[35].image = ImageIO.read(getClass().getResourceAsStream("/tiles/topcornerRight.png"));
			
			
			
			
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void loadMap(String filePath) {
		try {
			InputStream is = getClass().getResourceAsStream(filePath);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
		
			int col =0;
			int row =0;
			while(col < gp.maxWorldCol && row < gp.maxworldRow) {
				String line = br.readLine();//leer una linea de txto.
				while(col < gp.maxWorldCol) {
					String numbers[] = line.split(" ");
					int num = Integer.parseInt(numbers[col]);
					
					tileMapNum[col][row]= num;
					col++;
					
					
				}
				if(col == gp.maxWorldCol) {
					col =0;
					row++;
				}
			}
			br.close();
			
		}catch(Exception e) {
			
		}
	}
	
	public void draw(Graphics2D g2) {
		//automatizar la creacion para el mapiña
		
		int worldcol =0;
		int worldrow =0;
		

		
		while(worldcol < gp.maxWorldCol && worldrow < gp.maxworldRow) {
			
			int tileNum = tileMapNum[worldcol][worldrow];
			
			int worldX = worldcol * gp.tileSize;
			int worldY	 = worldrow *gp.tileSize;
			int screenX = worldX - gp.player.worldX + gp.player.screenX;
			int screenY = worldY - gp.player.worldY + gp.player.screenY;

			if(worldX + gp.tileSize > gp.player.worldX - gp.player.screenX && 
				worldX - gp.tileSize < gp.player.worldX + gp.player.screenX
				&& worldY + gp.tileSize > gp.player.worldY - gp.player.screenY && 
				worldY - gp.tileSize < gp.player.worldY + gp.player.screenY){
				
				
				g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize,null);

				
			}
			
			
			
				worldcol++;
			
			if(worldcol == gp.maxWorldCol) {
				worldcol =0;
				worldrow++;
			}
		}
		
	}
	
}
