package assignment9;

import java.util.LinkedList;

public class Snake {

	private static final double SEGMENT_SIZE = 0.02;
	private static final double MOVEMENT_SIZE = SEGMENT_SIZE ;
	private LinkedList<BodySegment> segments;
	private double deltaX;
	private double deltaY;
	
	public Snake() {
		segments= new LinkedList<BodySegment>();
		deltaX = 0.0;
		deltaY = 0.0;
		segments.add(0,new BodySegment(0.5,0.5,SEGMENT_SIZE));
		
	}
	
	public void changeDirection(int direction) {
		if(direction == 1) { //up
			deltaY = MOVEMENT_SIZE;
			deltaX = 0;
		} else if (direction == 2) { //down
			deltaY = -MOVEMENT_SIZE;
			deltaX = 0;
		} else if (direction == 3) { //left
			deltaY = 0;
			deltaX = -MOVEMENT_SIZE;
		} else if (direction == 4) { //right
			deltaY = 0;
			deltaX = MOVEMENT_SIZE;
		}
	}
	
	public int getSize() {
		return segments.size();
	}
	
	public BodySegment getSegment(int index) {
		return segments.get(index);
	}
	
	public void addSegment(double x, double y) {
		segments.add(new BodySegment(x, y, SEGMENT_SIZE));
	}
	
	/**
	 * Moves the snake by updating the position of each of the segments
	 * based on the current direction of travel
	 */
	public void move() {
		
		for (int i = segments.size() - 1; i > 0; i--) {
			BodySegment prev = segments.get(i - 1);
			segments.set(i, new BodySegment(prev.getX(), prev.getY(), SEGMENT_SIZE));
		}
		
		BodySegment head = segments.get(0);
		double newX = head.getX() + deltaX;
		double newY = head.getY() + deltaY;
		head= new BodySegment(newX,newY,SEGMENT_SIZE);
		segments.set(0, head);
	}
	
	/**
	 * Draws the snake by drawing each segment
	 */
	public void draw() {
		for(int i=0;i<segments.size();i++) {
			segments.get(i).draw();
			
			
		}
	}
	
	/**
	 * The snake attempts to eat the given food, growing if it does so successfully
	 * @param f the food to be eaten
	 * @return true if the snake successfully ate the food
	 */
	public boolean eatFood(Food f) {
		double headX = segments.get(0).getX();
		double headY = segments.get(0).getY();
		double foodX = f.getX();
		double foodY = f.getY();

		double distance = Math.sqrt(Math.pow(headX - foodX, 2) + Math.pow(headY - foodY, 2));
		if (distance < 0.02) {
			return true;
		}
		return false;
	}
	/**
	 * Returns true if the head of the snake is in bounds
	 * @return whether or not the head is in the bounds of the window
	 */
	public boolean isInbounds() {
		if(segments.get(0).getX()<=0 || segments.get(0).getX()>=1 || segments.get(0).getY()<=0 || segments.get(0).getY()>=1) {
		return false;}
		return true;
	}
}
