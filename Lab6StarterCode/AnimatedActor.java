package Lab6StarterCode;
import mayflower.*;

public class AnimatedActor extends GravityActor
{
    private Animation animation;
    private Timer animationTimer = new Timer(1000);
    
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
        super.act();
    }
}
