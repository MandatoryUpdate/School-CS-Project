package Lab6StarterCode;
import  mayflower.*;
public class MovableAnimatedActor extends AnimatedActor
{
    private Animation walkRight;
    private Animation idle;
    private Animation idleLeft;
    private String currentAction;
    private Animation walkLeft;
    private Animation leftFall;
    private Animation rightFall;
    private String direction;
    public MovableAnimatedActor()
    {
        walkRight = null;
        idle = null;
        currentAction = null;
        walkLeft = null;
        idleLeft = null;
        direction = "right";
    }
    public void setAnimation(Animation a)
    {
        super.setAnimation(a);
    }
    public void setRightWalkAnimation(Animation ani)
    {
        walkRight = ani;
    }
    public void setIdleAnimation(Animation ani)
    {
        idle = ani;
    }
    public void setIdleLeftAnimation(Animation ani)
    {
        idleLeft = ani;
    }
    public void setLeftWalkAnimation(Animation ani)
    {
        walkLeft = ani;
    }
    public void setRightFallAnimation(Animation ani)
    {
        rightFall = ani;
    }
    public void setLeftFallAnimation(Animation ani)
    {
        leftFall = ani;
    }
    public void act()
    {
        String newAction = null;
        int x = getX();
        int y = getY();
        int w = getWidth();
        int h = getHeight();
        
        if(currentAction == null)
            newAction = "idle";       
            
        if(isFalling() == true)
        {
            if(direction.equals("right"))
            {
                newAction = "fallingRight";
            }
            else if(direction.equals("left"))
            {
                newAction = "fallingLeft";
            }
        }
        else if(Mayflower.isKeyDown(Keyboard.KEY_RIGHT) && (x + h) < 800)
        {
            setLocation(x + 5, y);
            newAction = "walkRight";
            direction = "right";
            if(this.isBlocked())
            {
                setLocation(x - 1, y);
            }
        }
        
        else if(Mayflower.isKeyDown(Keyboard.KEY_LEFT) && x > -10)
        {
            setLocation(x - 5, y);
            newAction = "walkLeft";
            direction = "left";
            if(this.isBlocked())
            {
                setLocation(x + 1, y);
            }
        }
        
        else if(Mayflower.isKeyDown(Keyboard.KEY_UP) && y > 0)
        {
            setLocation(x, y - 25);
            newAction = "walkUp";
            if(this.isBlocked())
            {
                setLocation(x, y + 1);
            }
        }
        
        else if(Mayflower.isKeyDown(Keyboard.KEY_DOWN) && (y + h) < 590)
        {
            setLocation(x, y + 5);
            newAction = "walkDown";
            if(this.isBlocked())
            {
                setLocation(x, y - 1);
            }
        }
        else
        {
            newAction = "idle";
            if(direction != null && direction.equals("left"))
            {
                newAction = "idleLeft";
            }
        }
        
        if(newAction != null && !newAction.equals(currentAction))
        {
            if(newAction.equals("idle"))
            {
                setAnimation(idle);
            }
            else if(newAction.equals("idleLeft"))
            {
                setAnimation(idleLeft);
            }
            if(newAction.equals("walkRight"))
                setAnimation(walkRight);
            if(newAction.equals("walkLeft"))
                setAnimation(walkLeft);
            if(newAction.equals("fallingLeft"))
            {
                setAnimation(leftFall);
            }
            if(newAction.equals("fallingRight"))
            {
                setAnimation(rightFall);
            }
            currentAction = newAction;
        }
        
        super.act();
    }
}
