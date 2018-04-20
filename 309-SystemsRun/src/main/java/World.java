import java.util.ArrayList;

/*
 * Keep track of objects, score, game ticks, etc.
 */

public class World {
	private ArrayList<WorldObject> objects = new ArrayList<WorldObject>();
	
	public void addObject(WorldObject obj) {
		objects.add(obj);
	}
	
	public void removeObject(WorldObject obj) {
		objects.remove(obj);
	}
}
