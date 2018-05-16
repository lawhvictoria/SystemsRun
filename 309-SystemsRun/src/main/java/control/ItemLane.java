package control;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import gui.Draw;
import item.BedItem;
import item.BeerItem;
import item.BookItem;
import item.CompileErrorItem;
import item.ForkBombItem;
import item.Item;
import item.KillChildItem;
import item.PipeItem;
import item.PopQuizItem;
import item.SegFaultItem;

public class ItemLane {

    // Public Instance
    public float startX;
    public float startY;
    public float endX;
    public float endY;
    public List<Item> items;
    public float speed = .3f;

    // Private Instance
    private boolean debugShowDisplay = false;
    private Random rand = new Random();
    private World world;

    public ItemLane(World world, float startX, float startY, float endX, float endY) {

        this.world = world;
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;

        items = new ArrayList<Item>();
    }

    public void spawnItem() {

        Item item;

        switch (rand.nextInt(9)) {
        case 0:
            item = new PopQuizItem(world);
            break;

        case 1:
            item = new SegFaultItem(world);
            break;

        case 2:
            item = new ForkBombItem(world);
            break;
            
        case 3:
        		item = new BeerItem(world);
        		break;

        case 4:
    			item = new BedItem(world);
    			break;
    			
        case 5:
			item = new BookItem(world);
			break;
			
        case 6:
			item = new CompileErrorItem(world);
			break;
			
        case 7:
			item = new PipeItem(world);
			break;
			
        case 8:
			item = new KillChildItem(world);
			break;
    		
        default:
            item = new BedItem(world);
        }

        addItem(item);
    }

    public void moveItems() {
        moveItems(speed);
    }

    public void addItem(Item item) {

        item.setX(startX);
        item.setY(startY);
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public void moveItems(float speed) {

        for (Item item : items) {
            float mag = (float) Math.sqrt((Math.pow(endX - startX, 2) + Math.pow(endY - startY, 2)));

            item.setX(item.getX() + speed * (endX - startX) / mag);
            item.setY(item.getY() + speed * (endY - startY) / mag);
        }

        if (debugShowDisplay) {
            Draw.drawRect(startX, startY + 2, 5, 5, 0, 255, 0);
            Draw.drawRect(endX, endY - 2, 5, 5, 255, 0, 0);
        }
    }

    public void debugtoggleDisplay() {
        debugShowDisplay = !debugShowDisplay;
    }

    // Get the x value for a lane at the specified y
    public float getXAtY(float y) {

        float mag = (float) Math.sqrt((Math.pow(endX - startX, 2) + Math.pow(endY - startY, 2)));
        float yL = endY - startY;
        float xL = (float) Math.sqrt(Math.pow(mag, 2) - Math.pow(yL, 2));

        float angle = (float) Math.atan(xL / yL);

        return startX + (float) Math.tan(angle) * (y - startY) * Math.signum(endX - startX);
    }

    public Item checkCollision(float y, float range) {

        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getY() > y - range && items.get(i).getY() < y + range) {
                return items.get(i);
            }
        }

        return null;
    }
}
