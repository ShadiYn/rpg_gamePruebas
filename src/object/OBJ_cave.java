package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_cave extends SuperObject {
	
	public OBJ_cave() {
		
		name="Cave";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/cave.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
