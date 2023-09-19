package Lab6StarterCode;

import mayflower.*;

public class Cat extends MovableAnimatedActor
{
    private Animation walk;
    private Animation idle;
    private Animation leftWalk;
    private Animation idleLeft;
    private Animation leftFall;
    private Animation rightFall;
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
        walk.setBounds(18, 5, 54,80);
        
        String[] images2 = new String[10];
        for(int i = 0 ; i < images2.length ; i++)
        {
            images2[i] = "img/cat/Idle (" + (i + 1) + ").png";
        }
        idle = new Animation(images2, 50);
        idle.setScale(100, 87);
        idle.setBounds(18, 5, 54, 80);
        
        leftWalk = new Animation(images, 50);
        leftWalk.mirrorHorizontally();
        leftWalk.setScale(100, 87);
        leftWalk.setBounds(28, 5, 54, 80);
        
        idleLeft = new Animation(images2, 50);
        idleLeft.mirrorHorizontally();
        idleLeft.setScale(100, 87);
        idleLeft.setBounds(28, 5, 54, 80);
        
        String[] images3 = new String[8];
        for(int i = 0 ; i < images3.length ; i++)
        {
            images3[i] = "img/cat/Fall (" + (i + 1) + ").png";
        }
        
        rightFall = new Animation(images3, 50);
        rightFall.setScale(100, 87);
        rightFall.setBounds(18, 5, 54, 80);
        
        leftFall = new Animation(images3, 50);
        leftFall.mirrorHorizontally();
        leftFall.setScale(100, 87);
        leftFall.setBounds(24, 5, 54, 80);
        
        walk.setTransparency(0);
        super.setRightWalkAnimation(walk);
        super.setIdleAnimation(idle);
        super.setLeftWalkAnimation(leftWalk);
        super.setIdleLeftAnimation(idleLeft);
        super.setRightFallAnimation(rightFall);
        super.setLeftFallAnimation(leftFall);
    }
    public void act()
    {
        super.act();
    }
}
