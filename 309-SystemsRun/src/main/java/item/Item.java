package item;
import control.Player;
import control.World;
import gui.Draw;
import gui.Drawable;
import processing.core.PImage;

/*
 * Item base class.
 */
public abstract class Item implements Drawable {

    // Constants
    public static final float Y_DESPAWN_RANGE = 100;

    // Public Instance
    protected float deltaSocial;
    protected float deltaGrade;
    protected float deltaSleep;
    protected PImage img;

    // Private Instance
    private float x;
    private float y;
    private World world;

    public Item(String imgRef, World world) {

        this(imgRef);
        addItem(world);
    }

    public Item(String imgRef) {
        img = Draw.loadImage(imgRef);
    }

//    @Override
    public void draw() {
        Draw.drawImage(img, x, y, Draw.getZDepth(y));
    }

    public void onPlayerContact(Player player) {
        player.addSocial(deltaSocial);
        player.addSleep(deltaSleep);
        player.addGrade(deltaGrade);
        itemEffect(player);
    }

    public abstract void itemEffect(Player player);

    public void addItem(World world) {

        this.world = world;
        world.addObject(this);
    }

    public void removeItem() {
        world.removeObject(this);
    }

    public void setX(float xD) {
        x = xD;
    }

    public void setY(float yD) {

        y = yD;

        if (y > Y_DESPAWN_RANGE) {
            removeItem();
        }
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
    
}
