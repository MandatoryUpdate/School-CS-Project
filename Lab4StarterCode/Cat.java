package Lab4StarterCode;

import mayflower.*;

public class Cat extends AnimatedActor
{
    private Animation walk;
    public Cat() 
    {
        String[] images = new String[10];
        for(int i = 0 ; i < images.length ; i++)
        {
            images[i] = "img/cat/Walk (" + (i + 1) + ").png";
        }
        walk = new Animation(images, 50);
        walk.setScale(100, 87);
        walk.setTransparency(0);
        setAnimation(walk);
    }
    public void act()
    {
        super.act();
    }
}
