import java.util.ArrayList;
import java.util.Random;

/*
 * Keep track of objects, score, game ticks, etc.
 */

public class World {
	private ArrayList<Drawable> objects = new ArrayList<Drawable>();
	private ArrayList<ItemLane> lanes = new ArrayList<ItemLane>();
	Random rand = new Random();
	
	public World() { // TEST ITEMS
		
		ItemLane lane1 = new ItemLane(this, 30, 0, 20, 100);
		lane1.debugtoggleDisplay();
		lanes.add(lane1);
		
		ItemLane lane2 = new ItemLane(this, 50, 0, 50, 100);
		lane2.debugtoggleDisplay();
		lanes.add(lane2);
		
		ItemLane lane3 = new ItemLane(this, 70, 0, 80, 100);
		lane3.debugtoggleDisplay();
		lanes.add(lane3);
		
		Player player = new Player(this, 50, 50);
		player.putInLane(lane2);
		
	}
	
	public void update() {
		drawAllWorldObjects();
		moveAllLanes();
		if(rand.nextInt(10) == 0) {
			spawnItem();
		}
		
	}
	
	public void spawnItem() {
		lanes.get(rand.nextInt(lanes.size())).spawnItem();
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
	
	public ItemLane getLeftLane(ItemLane lane) {
		int index = lanes.indexOf(lane);
		return index > 0 ? lanes.get(index - 1) : lane;
	}
	
	public ItemLane getRightLane(ItemLane lane) {
		int index = lanes.indexOf(lane);
		return index < lanes.size() - 1 ? lanes.get(index + 1) : lane; 
	}
}
