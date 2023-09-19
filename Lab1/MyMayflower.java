package Lab1;
import mayflower.*;
public class MyMayflower extends Mayflower
{
    //Constructor
    public MyMayflower()
    {
        super("Lab 1", 800, 600);
    }
    
    public void init()
    {
        Mayflower.setFullScreen(false);
        World w = new MyWorld();
        Mayflower.setWorld(w);
    }
}
