import processing.core.PImage;

/*
 * Item base class.
 */

public abstract class Item implements Drawable{
	public float x, y;
	public PImage img;
	
	private World world;
	
	public Item(String imgRef) {
		
		img = Draw.loadImage(imgRef);
	}
	
	public void draw() {
		
		Draw.drawImage(img, x, y);		
	}
	
	public void addItem(World world) {
		
		this.world = world;
		world.addObject(this);
	}
	
	public void removeItem() {
		
		world.removeObject(this);
	}
}
