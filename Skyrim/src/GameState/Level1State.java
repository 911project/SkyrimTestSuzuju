package GameState;

import TileMap.*;
import java.awt.*;



import Main.GamePanel;
import Entity.*;
import java.awt.event.KeyEvent;

public class Level1State extends GameState {
	
	private TileMap tileMap;
	private Background bg;
	private Player player;
	
	
	public Level1State(GameStateManager gsm) {
		
		this.gsm = gsm;	
		init();
		
	}
	
	
	public void init() {
		
		tileMap = new TileMap(30);
		tileMap.loadTiles("/Tilesets/grasstileset.gif");
		tileMap.loadMap("/Maps/level1-1.map");
		tileMap.setPosition(0, 0);
		bg = new Background("/Backgrounds/grassbg1.gif", 0.1);
		player = new Player(tileMap);
		player.setPosition(100, 160);
		
		
	}
	
	
	public void update() {		
		
		player.update();
		tileMap.setPosition(GamePanel.HEIGHT / 2 - player.getx(), GamePanel.HEIGHT / 2 -player.gety());		
		
		
	}
	
	public void draw(Graphics2D g) {
			
		
		bg.draw(g);
		
		tileMap.draw(g);
		
		player.draw(g);
	}
	
	public void keyPressed(int k) {
		
		if(k==KeyEvent.VK_A) player.setLeft(true);
		if(k==KeyEvent.VK_D) player.setRight(true);
		if(k==KeyEvent.VK_S) player.setDown(true);
		if(k==KeyEvent.VK_W) player.setUp(true);
		if(k==KeyEvent.VK_W) player.setJumping(true);
		if(k==KeyEvent.VK_J) player.setScratching();
		if(k==KeyEvent.VK_K) player.setFiring();
		
		if(k==KeyEvent.VK_ESCAPE) {

			gsm.setState(gsm.PAUSESTATE);
			
		}
		
	}
	
	public void keyReleased(int k) {
		
		if(k==KeyEvent.VK_A) player.setLeft(false);
		if(k==KeyEvent.VK_D) player.setRight(false);
		if(k==KeyEvent.VK_S) player.setDown(false);
		if(k==KeyEvent.VK_W) player.setUp(false);
		if(k==KeyEvent.VK_W) player.setJumping(false);
		
	}


	
	
	
}
