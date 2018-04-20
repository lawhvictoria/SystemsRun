import java.util.ArrayList;

/*
 * Keep track of objects, score, game ticks, etc.
 */

public class World {
	private ArrayList<Drawable> objects = new ArrayList<Drawable>();
	
	public World() { // TEST ITEMS
		BeerItem item1 = new BeerItem();
		item1.x = 10;
		item1.y = 20;
		item1.addItem(this);
		
		BeerItem item2 = new BeerItem();
		item2.x = 60;
		item2.y = 70;
		item2.addItem(this);
	}
	
	public void update() {
		drawAllWorldObjects();
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
