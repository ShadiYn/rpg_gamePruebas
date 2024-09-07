package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_house extends SuperObject {
	
	public OBJ_house() {
		name="house";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/house.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
