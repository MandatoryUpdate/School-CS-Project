package Lab2StarterCode;
import mayflower.*;
public class Dog extends Actor
{
    public Dog()
    {
        setImage("img/dog.png");
    }
    
    public void act()
    {
        if(isTouching(Cat.class))
        {        
            Object a = getOneIntersectingObject(Cat.class);
            Cat c = (Cat) a;
            World w = getWorld();
            if(c.getLives() > 1)
            {
                c.decreaseLives(1);
                c.setPosition(400, 300);
            }
            else if(c.getLives() == 1)
            {
                c.decreaseLives(1);
                w.removeObject(c);
            }
            w.showText("Score: " + c.getScore() + " Lives: " + c.getLives(), 10, 30, Color.BLACK);
        }
    }
}