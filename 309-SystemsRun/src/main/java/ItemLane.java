import java.util.ArrayList;
import java.util.Random;

/*
 * Be able to add item to this lane
 * start and end point
 * items float from start to end point
 * be able to check collision with item and player
 */
public class ItemLane {

	public float startX, startY, endX, endY;
	public ArrayList<Item> items;
	public float speed = .5f;
	
	private boolean debugShowDisplay = false;
	private Random rand = new Random();
	private World world;
	
	public ItemLane(World world, float startX, float startY, float endX, float endY) {
		
		this.world = world;
		this.startX = startX;
		this.startY = startY;
		this.endX = endX;
		this.endY = endY;
		
		items = new ArrayList<Item>();
	}
	
	public void spawnItem() {
		
		Item item;
		
		switch(rand.nextInt(3)) {
		case 0:
			item = new BeerItem(world);
			break;
		
		case 1:
			item = new BeerItem(world);
			break;
		case 2:	
			item = new BeerItem(world);
			break;
		default:
			item = new BeerItem(world);
		}
		
		addItem(item);
			
		
	}
	
	public void moveItems() {
		moveItems(speed);
	}
	
	public void addItem(Item item) {
		item.setX(startX);
		item.setY(startY);
		items.add(item);
		
	}
	
	public void moveItems(float speed) {
		
		for(Item item : items) {
			float mag = (float) Math.sqrt((Math.pow(endX - startX, 2) + Math.pow(endY - startY, 2)));
			
			item.setX(item.getX() + speed * (endX - startX) / mag);
			item.setY(item.getY() + speed * (endY - startY) / mag);
		}
			
		if(debugShowDisplay) {
			Draw.drawRect(startX, startY+2, 5, 5, 0, 255, 0);
			Draw.drawRect(endX, endY-2, 5, 5, 255, 0, 0);
		}
		
	}
	
	public void debugtoggleDisplay() {
		debugShowDisplay = !debugShowDisplay;
	}
	
	// Get the x value for a lane at the specified y
	public float getXAtY(float y) {
		float mag = (float) Math.sqrt((Math.pow(endX - startX, 2) + Math.pow(endY - startY, 2)));
		float yL = endY - startY;
		float xL = (float)Math.sqrt(Math.pow(mag, 2) - Math.pow(yL, 2));
		
		float angle = (float) Math.atan(xL/yL);
		
		return startX + (float)Math.tan(angle) * (y-startY) * Math.signum(endX - startX);
	}
}















