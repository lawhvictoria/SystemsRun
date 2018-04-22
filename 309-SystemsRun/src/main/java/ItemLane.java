import java.awt.Point;
import java.util.ArrayList;

/*
 * Be able to add item to this lane
 * start and end point
 * items float from start to end point
 * be able to check collision with item and player
 */
public class ItemLane {

	public float startX, startY, endX, endY;
	public ArrayList<Item> items;
	public float speed = .1f;
	
	private boolean debugShowDisplay = false;
	
	public ItemLane(float startX, float startY, float endX, float endY) {
		
		this.startX = startX;
		this.startY = startY;
		this.endX = endX;
		this.endY = endY;
		
		items = new ArrayList<Item>();
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
			Draw.drawRect(startX, startY, 5, 5);
			Draw.drawRect(endX, endY, 5, 5);
		}
		
	}
	
	public void debugtoggleDisplay() {
		debugShowDisplay = !debugShowDisplay;
	}
}















