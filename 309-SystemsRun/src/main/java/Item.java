import processing.core.PImage;

/*
 * Item base class.
 */

public abstract class Item implements Drawable{
	private float x, y;
	public PImage img;
	
	private World world;
	
	public Item(String imgRef, World world) {		
		this(imgRef);	
		addItem(world);		
	}
	
	public Item(String imgRef) {
		
		img = Draw.loadImage(imgRef);
	}
	
	public void draw() {
		
		Draw.drawImage(img, x, y, Draw.getZDepth(y));
	}
	
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
	}
	
	public float getX() {
		return x;
	}
	
	public float getY() {
		return y;
	}
	
}
