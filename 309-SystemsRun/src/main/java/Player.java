import processing.core.PImage;

public class Player implements Drawable, Controllable {

    // Public Instance
    public float speedX = 1;
    public float speedY = 1;

    // Private Instance
    private float speedVelY = 0;
    private ItemLane targetLane;
    private World world;
    private float x, y;
    private PImage img;

    public Player(World world, float x, float y) {

        this.world = world;
        this.x = x;
        this.y = y;

        img = Draw.loadImage("src/images/cat.png");
        world.addObject(this);
        Controller.addListener(this);
    }

    public void draw() {

        move();
        Draw.drawImage(img, x, y, Draw.getZDepth(y));
    }

    public void addSocial(float delta) {
        // TODO: Increase bar
    }

    public void addSleep(float delta) {
        // TODO: Increase bar
    }

    public void addGrade(float delta) {
        // TODO: Increase bar
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
}
