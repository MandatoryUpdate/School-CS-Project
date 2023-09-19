package Lab4StarterCode;
import mayflower.*;

public class NinjaAnimatedActor extends AnimatedActor
{
    private Animation walk;
    public NinjaAnimatedActor() 
    {
        String[] images = new String[10];
        for(int i = 0 ; i < images.length ; i++)
        {
            images[i] = "img/ninjagirl/Run__00"+ i +".png";
        }
        walk = new Animation(images, 50);
        walk.setScale(100, 87);
        walk.setTransparency(60);
        setAnimation(walk);
    }
    public void act()
    {
        super.act();
    }
}