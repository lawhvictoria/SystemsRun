import java.awt.Point;
import java.util.ArrayList;

/*
 * Keep track of objects, score, game ticks, etc.
 */

public class World {
	private ArrayList<Drawable> objects = new ArrayList<Drawable>();
	private ArrayList<ItemLane> lanes = new ArrayList<ItemLane>();
	
	public World() { // TEST ITEMS
		
		ItemLane lane1 = new ItemLane(30, 0, 20, 99);
		lane1.addItem(new BeerItem(this));
		lane1.debugtoggleDisplay();
		lanes.add(lane1);
		
		ItemLane lane2 = new ItemLane(50, 0, 50, 99);
		lane2.addItem(new BeerItem(this));
		lane2.debugtoggleDisplay();
		lanes.add(lane2);
		
		ItemLane lane3 = new ItemLane(70, 0, 80, 99);
		lane3.addItem(new BeerItem(this));
		lane3.debugtoggleDisplay();
		lanes.add(lane3);
		
	}
	
	public void update() {
		drawAllWorldObjects();
		moveAllLanes();
	}
	
	public void moveAllLanes() {
		for(ItemLane lane : lanes) {
			lane.moveItems();
		}
	}
	
	public void drawAllWorldObjects() {
		for(Drawable obj : objects) {
			obj.draw();
		}
	}
	
	public void addObject(Drawable obj) {
		objects.add(obj);
	}
	
	public void removeObject(Drawable obj) {
		objects.remove(obj);
	}
}
