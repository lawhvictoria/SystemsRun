package control;
import gui.Draw;
import gui.Drawable;
import gui.PImage2;
import item.Item;

public class Player implements Drawable, Controllable {

    // Public Instance
    public float speedX = 1;
    public float speedY = 1;

    // Private Instance
    private float speedVelY = 0;
    private ItemLane targetLane;
    private World world;
    private float x;
    private float y;
    private PImage2 img;

    public Player(World world, float x, float y) {

        this.world = world;
        this.x = x;
        this.y = y;

        img = new PImage2(4, "src/images/running0.png", 
                             "src/images/running1.png", 
                             "src/images/running2.png", 
                             "src/images/running3.png");
           
        world.addObject(this);
        Controller.addListener(this);
    }

    public void draw() {

        move();
        Draw.drawImage(img.getImage(), x, y, Draw.getZDepth(y));
    }

    public void addSocial(float delta) {
        speedX *= 1;
    }

    public void addSleep(float delta) {
        speedX *= 1;
    }

    public void addGrade(float delta) {
        speedX *= 1;
    }

    public void move() {

        float targetX = targetLane.getXAtY(y);

        if (Math.abs(x - targetX) < 2) {
            x = targetX;

            Item hit;
            if ((hit = targetLane.checkCollision(y, 2)) != null) {
                hit.onPlayerContact(this);
                targetLane.removeItem(hit);
                world.removeObject(hit);

            }
        } else if (x < targetX) {
            x += speedX;
        } else if (x > targetX) {
            x -= speedX;
        }

        if (y <= Math.min(targetLane.startY, targetLane.endY) || y >= Math.max(targetLane.startY, targetLane.endY)) {
            y -= speedVelY;
            speedVelY = 0;
        }

        y += speedVelY;
    }

    public void keyUpdate(Key key, boolean down) {

        switch (key) {
        case LEFT:
            if (down && Math.abs(x - targetLane.getXAtY(y)) < 2) {
                putInLane(world.getLeftLane(targetLane));
            }
            break;

        case RIGHT:
            if (down && Math.abs(x - targetLane.getXAtY(y)) < 2) {
                putInLane(world.getRightLane(targetLane)); // Only allow movement after player is in the lane
            }
            break;

        case UP:
            speedVelY = down ? -speedY : 0;
            break;

        case DOWN:
            speedVelY = down ? speedY : 0;
            break;
        }
    }

    public void putInLane(ItemLane lane) {
        targetLane = lane;
    }
    
    public void clickUpdate(float x, float y) {
        speedX *= 1;
    };
}
