package control;
import java.util.ArrayList;

// Handle User Input
public class Controller {

    private static ArrayList<Controllable> controllers = new ArrayList<Controllable>();

    private Controller() {}
    
    public static void addListener(Controllable listener) {
        controllers.add(listener);
    }

    public static void keyUpdate(char key, boolean down) {
        for (Key control : Key.values()) {
            if (control.getKey() == key) {
                notifyListeners(control, down);
            }
        }
    }
    
    public static void clickUpdate(int x, int y) {
          notifyListeners(App.toWorldX(x), App.toWorldY(y));
    }

    private static void notifyListeners(Key key, boolean down) {
        for (Controllable listener : controllers) {
            listener.keyUpdate(key, down);
        }
    }
    
    private static void notifyListeners(float x, float y) {
        for (Controllable listener : controllers) {
             listener.clickUpdate(x,  y);
        }
    }
    
    
}
