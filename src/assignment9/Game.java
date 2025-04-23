package assignment9;

import java.awt.event.KeyEvent;

import edu.princeton.cs.introcs.StdDraw;

public class Game {
	private Snake s1;
	private Food f1;
	
	public Game() {
		StdDraw.enableDoubleBuffering();
		StdDraw.setXscale(0, 1);                    
		StdDraw.setYscale(0, 1);
		s1= new Snake();
		f1= new Food();
		
	}
	
	public void play() {
		while (s1.isInbounds()) { //TODO: Update this condition to check if snake is in bounds
			int dir = getKeypress();
			//Testing only: you will eventually need to do more work here
			//System.out.println("Keypress: " + dir);
			
			
			/*
			 * 1. Pass direction to your snake

			 * 2. Tell the snake to move
			 * 3. If the food has been eaten, make a new one
			 * 4. Update the drawing
			 */
			
			s1.changeDirection(dir);
			s1.move();
			updateDrawing();
			if (s1.eatFood(f1)==true) {
				int index= s1.getSize()-1;
				double newX = s1.getSegment(index).getX() + 0.02;
				double newY = s1.getSegment(index).getY() + 0.02;
				s1.addSegment(newX, newY);
				s1.isInbounds();
				f1= new Food();
				
				


				
				
				
				
			}
			
			
		}
	}
	
	private int getKeypress() {
		if(StdDraw.isKeyPressed(KeyEvent.VK_W)) {
			return 1;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_S)) {
			return 2;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_A)) {
			return 3;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_D)) {
			return 4;
		} else {
			return -1;
		}
	}
	
	/**
	 * Clears the screen, draws the snake and food, pauses, and shows the content
	 */
	private void updateDrawing() {
		StdDraw.clear();
		s1.draw();
		f1.draw();
		StdDraw.show();
		StdDraw.pause(50);
		
		
		/*
		 * 1. Clear screen
		 * 2. Draw snake and food
		 * 3. Pause (50 ms is good)
		 * 4. Show
		 */
	}
	
	public static void main(String[] args) {
		Game g = new Game();
		g.play();
	}
}
