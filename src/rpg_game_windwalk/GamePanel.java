package rpg_game_windwalk;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;


import javax.swing.JPanel;

import Entity.Player;
import tile.tileManeger;
import object.SuperObject;


public class GamePanel extends JPanel implements Runnable {

	// scren settings 
	 public final int originalTileSize = 16; // 16x16 tiles
	 public final int scale =3;
	
	public final int tileSize = originalTileSize * scale; // entonces el tamaño seria mas grande de 48x48
	
	public final int maxScreenCol = 16;
	public final int maxScreenRow = 12;
	public final int screenWidth = tileSize * maxScreenCol; //768px
	public final int screenHeight = tileSize*maxScreenRow; //576px
	
	//wold settings
	
	public final int maxWorldCol =50;
	public final int maxworldRow = 50;
	
	
	
	//FPS
	int fps = 60;
	
	key_handler KeyH = new key_handler();
	sound music = new sound();
	sound Sfx = new sound();

	 public collisionCheck Colchech = new collisionCheck(this);
	public AssetSetter Asetter = new AssetSetter(this);
	 public Player player = new Player(this,KeyH);
	tileManeger Tm = new tileManeger(this);
	public SuperObject obj[] = new SuperObject[10]; //solo mostra 10 objetos al mismo tiempo.
	public UI ui = new UI(this);
	Thread gameThread;

	 
	
	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(KeyH);
		this.setFocusable(true);
		
		
	
	}
	
	public void setupGame() {
		
		Asetter.setObject();
		playMusic(0);
	}
	
	public void StartGameThread() {
		gameThread = new Thread(this); //se refiere a esta clase osea la de game panel
		gameThread.start(); //llamra autpomaticamnte al metodo de run
	}

	@Override
	public void run() {
		double drawInterval =1000000000/fps; 
		double nextDrawTime = System.nanoTime()+ drawInterval;
		
		
		
		while(gameThread != null) {
			
		
			//1000 milisec 1 seg
			//pero con los nanoTime es mucho mas preciso
			//esd ecir mientras exista se repetirá
			//System.out.println("game running loop");
			
			update();
			
			
			
			repaint();
			
			//update information: character posicion, dibujar en la pantalla con la info actualizada	
		
		
				try {
					double remainingTime = nextDrawTime - System.nanoTime();
					remainingTime = remainingTime/1000000; //ay que convertirlo a milisec porque hcimos los calculos en nanosec y el metodo solo acepta milisec entonces por eso lo convertimos
					
					if(remainingTime <0) {
						remainingTime =0;
					}
					
					Thread.sleep((long)remainingTime);
					
					nextDrawTime += drawInterval;
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		
	}
	
	public void update() {
		
	player.update();
		
	}
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		
		//primero se dibujan los tileds y luego el personaje, son como los layers
		//maps
		Tm.draw(g2);
		
		//objetos 
		//escanea si hay algun objeto esta en el array
		for(int i =0; i<obj.length;i++) {
			if(obj[i]!= null) {
				obj[i].draw(g2, this);
			}
		}
		//player
		player.draw(g2);
		//ui
		ui.draw(g2);
		g2.dispose();
	}
	
	public void playMusic (int i) {
		music.setFile(i);
		music.play();
		music.loop();
	
	}
	
	public void stopMusic() {
		music.stop();
	}
	
	public void playerFX(int i) {
		Sfx.setFile(i);
		Sfx.play();
	}
	
	
	
	
	
	
	
}  
