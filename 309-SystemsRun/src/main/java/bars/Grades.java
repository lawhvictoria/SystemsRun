package bars;

public class Grades extends BarMenu{
	int maxHealth = 30;
	int health = 30;
	int healthDecrease = 1;
	int healthBarWidth = 60;

	@Override
	public void display() {
	    maxHealth = 1 * maxHealth;
	}
	
	void decreaseHealth(){
		  health -= healthDecrease;
	}
}
