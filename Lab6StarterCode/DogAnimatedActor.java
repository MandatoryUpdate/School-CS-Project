package Lab6StarterCode;

import mayflower.*;

public class DogAnimatedActor extends AnimatedActor
{
    private Animation walk;
    public DogAnimatedActor() 
    {
        String[] images = new String[10];
        for(int i = 0 ; i < images.length ; i++)
        {
            images[i] = "img/dog/Walk (" + (i + 1) + ").png";
        }
        walk = new Animation(images, 50);
        walk.setScale(100, 87);
        walk.setTransparency(80);
        setAnimation(walk);
    }
    public void act()
    {
        super.act();
    }
}