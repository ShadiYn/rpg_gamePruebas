package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_boot extends SuperObject {
	public OBJ_boot() {
		
		name="boot";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/boot.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
