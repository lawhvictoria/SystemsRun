import java.util.ArrayList;

/*
 * Handle user input
 */

public class Controller {
	
	private static ArrayList<Controllable> controllers = new ArrayList<Controllable>();
	
	public static void addListener(Controllable listener) {
		controllers.add(listener);
	}
	
	public static void keyUpdate(char key, boolean down) {
		for(Key control : Key.values()) {
			if(control.key == key) {
				notifyListeners(control, down);
			}
		}
	}
	
	private static void notifyListeners(Key key, boolean down) {
		for(Controllable listener : controllers) {
			listener.keyUpdate(key, down);
		}
	}
}

