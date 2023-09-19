package Lab6StarterCode;

import mayflower.*;
public class GravityActor extends Actor
{
    public boolean isBlocked()
    {
        return this.isTouching(Block.class);
    }
    public boolean isFalling()
    {
        boolean ret;
        setLocation(getX(), getY() + 1);
        ret = isTouching(Block.class);
        setLocation(getX(), getY() - 1);
        return !ret;
    }
    public void act()
    {
        setLocation(getX(), getY() + 1);
        if(this.isBlocked() == true)
        {
           setLocation(getX(), getY() - 1); 
        }
    }
}
