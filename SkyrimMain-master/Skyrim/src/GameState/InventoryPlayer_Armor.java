//INVENTARIO DEL PLAYER, GIOCO SI METTE IN PAUSA

package GameState;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import TileMap.Background;
import TileMap.*;

public class InventoryPlayer_Armor extends GameState{

	private Background bg;
	
	
	private String[] options = {"Armature", "Spade", "Pozioni", "Esci"};
	private int currentChoice = 0;
	private Font font;
	
	
	public InventoryPlayer_Armor(GameStateManager gsm) {
		
		this.gsm = gsm;		
			
		bg = new Background("/Backgrounds/optionbg3.gif", 1);		
		
		font  = new Font("Arial", Font.PLAIN, 15);	
		
		
	}
	
	
	

	public void init() {
		
	}
	
	public void update() {
		bg.update();
	}
	
	
	
	private void select() {
		if(currentChoice == 0) {
				
			
			
		}
		else if(currentChoice == 1) {
			
		}
		else if(currentChoice == 2) {
					
				}
		else if(currentChoice == 3) {
			gsm.setState(GameStateManager.LEVEL1STATE);
		}

	}
	
public void draw(java.awt.Graphics2D g) {
		
		bg.draw(g);
		
		g.setColor(Color.WHITE);
		g.setFont(font);
		g.drawString("INVENTARIO: ", 20, 30);
		
		
		
		g.setFont(font);
		for(int i=0; i<options.length; i++) {
			if(i==currentChoice) {
				g.setColor(Color.RED);
			}else {
				g.setColor(Color.WHITE);
			}
			g.drawString(options[i], 25, 65 + 15*i);
		}
	}
	
		
		
	
	
	public void keyPressed(int k) {
		
		if(k==KeyEvent.VK_ENTER) {
			select();
		}
		if(k == KeyEvent.VK_UP) {
			currentChoice --;
			if(currentChoice == -1) {
				currentChoice = options.length - 1;
			}
		}
		if(k == KeyEvent.VK_DOWN) {
			currentChoice ++;
			if(currentChoice == options.length) {
				currentChoice = 0;
			}
		}

	}
	
	public void keyReleased(int k) {
		

	} 
	
}
