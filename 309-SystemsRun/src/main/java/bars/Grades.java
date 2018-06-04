package bars;

public class Grades extends BarMenu{
	int maxHealth = 30;
	int health = 30;
	int healthDecrease = 1;
	int healthBarWidth = 60;
	public Grades() {
		
    }

	@Override
	public void display() {
	    System.out.println("Unsupported");
	}
	
	void decreaseHealth(){
		  health -= healthDecrease;
	}
}
