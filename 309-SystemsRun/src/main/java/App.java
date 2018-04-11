import processing.core.PApplet;


public class App extends PApplet
{
    public static void main( String[] args )
    {
    		PApplet.main("App");
    }
    
    public void settings(){
        size(300,300);
    }

    public void setup(){
        fill(120,50,240);
    }

    public void draw(){
        ellipse(width/2,height/2,100,100);
    }
}
