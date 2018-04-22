import processing.core.PImage;

public class Player implements Drawable, Controllable{
	
	private World world;
	private float x, y;
	private PImage img;
	
	public float speedX = 1;
	public float speedY = 1;
	
	private float speedVelX = 0;
	private float speedVelY = 0;
	
	public Player(World world, float x, float y) {
		this.world = world;
		this.x = x;
		this.y = y;
		img = Draw.loadImage("src/images/cat.png");
		world.addObject(this);
		Controller.addListener(this);
	}
	
	public void draw() {
		move();
		Draw.drawImage(img, x, y, Draw.getZDepth(y));
	}
	
	
	public void move() {
		x += speedVelX;
		y += speedVelY;
	}

	public void keyUpdate(Key key, boolean down) {
		switch(key) {
		case LEFT:
			speedVelX = down ? speedVelX - speedX : 0;
			break;
		case RIGHT:
			speedVelX = down ? speedVelX + speedX : 0;
			break;
			
		case UP:
			speedVelY = down ? speedVelX - speedY : 0;
			break;
		case DOWN:
			speedVelY = down ? speedVelX + speedY : 0;
			break;
		}
		
	}

	
}
