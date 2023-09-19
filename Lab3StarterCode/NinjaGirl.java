package Lab3StarterCode;
import mayflower.*;

public class NinjaGirl extends Actor
{
    private MayflowerImage[] frames;
    private int currentFrame;
    private Timer animationTimer;
    public NinjaGirl()
    {
        //Create a MayflowerImage object from the specified image file
        MayflowerImage p = new MayflowerImage ("img/ninjagirl/Run__000.png");
        // Scale this image to 30% of the origianl size
        p.scale(0.3);
        //Set this Actor's image to the MayflowerImage object p
        setImage(p);
        currentFrame = 0;
        frames = new MayflowerImage[10];
        animationTimer = new Timer(100000000);
        for(int i = 0 ; i < 10 ; i++)
        {
            frames[i] = new MayflowerImage("img/ninjagirl/Run__00"+ i +".png");
            frames[i].scale(87, 100);
            frames[i].setTransparency(50);
        }
    }
    
    public void act()
    {
        if(animationTimer.isDone())
        {
            animationTimer.reset();
            setImage(frames[currentFrame]);
            currentFrame = (currentFrame + 1)%10;
        }
    }
}
