package GameState;

import TileMap.Background;
import java.awt.*;

import com.sun.glass.events.KeyEvent;

public class OptionState extends GameState{
	
	private Background bg;
	
	private String[] options = {"Main menu"};
	
	private int currentChoice = 0;
	private Font font;
	
	public OptionState(GameStateManager gsm) {
		
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
			gsm.setState(GameStateManager.previousState);
		}
	}
	
public void draw(java.awt.Graphics2D g) {
		
		bg.draw(g);
		
		g.setColor(Color.WHITE);
		g.setFont(font);
		g.drawString("COMANDI: ", 20, 30);
		g.drawString("D per andare avanti", 20, 55);
		g.drawString("A per andare indietro", 20, 70);
		g.drawString("W per saltare", 20, 85);
		g.drawString("Click destro per attaccare", 20, 100);
		g.drawString("Click sinistro per parare", 20, 115);
		g.drawString("E per sparare fuoco", 20, 130);
		
		
		g.setFont(font);
		for(int i=0; i<options.length; i++) {
			if(i==currentChoice) {
				g.setColor(Color.RED);
			}
			g.drawString(options[i], 122, 220);
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
