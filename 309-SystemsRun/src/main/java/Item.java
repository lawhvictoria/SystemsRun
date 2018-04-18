import processing.core.PImage;

/*
 * Item base class.
 */

public abstract class Item implements Drawable, WorldObject{
	public float x, y;
	public PImage img;
	
	public Item(String imgRef) {
		img = Draw.loadImage(imgRef);
	}
	
	public void draw() {
		Draw.drawImage(img, x, y);	
	}
}
