package Lab4StarterCode;

import mayflower.*;

public class JackAnimatedActor extends AnimatedActor
{
    private Animation walk;
    public JackAnimatedActor() 
    {
        String[] images = new String[7];
        for(int i = 0 ; i < images.length ; i++)
        {
            images[i] = "img/jack/Walk (" + (i + 1) + ").png";
        }
        walk = new Animation(images, 50);
        walk.setScale(100, 87);
        walk.setTransparency(75);
        setAnimation(walk);
    }
    public void act()
    {
        super.act();
    }
}
