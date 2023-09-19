package Lab5StarterCode;
import mayflower.*;

public class AnimatedActor extends Actor
{
    private Animation animation;
    private Timer animationTimer = new Timer(100000000);
    
    public void setAnimation(Animation a)
    {
        animation = a;
    }
    public void act()
    {
        if(animationTimer.isDone() && animation != null)
        {
            animationTimer.reset();
            setImage(animation.getNextFrame());
        }
    }
}
