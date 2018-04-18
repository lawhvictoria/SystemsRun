/*
 * Any objects (items, players, etc.) should implement this interface.
 * 
 */

public interface WorldObject {
	
	
	/*
	 * What the object should do on a game update tick
	 */
	void onGameTick();
}
