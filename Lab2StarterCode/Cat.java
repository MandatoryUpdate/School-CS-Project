package Lab2StarterCode;
import mayflower.*;
public class Cat extends Actor
{
    private int score;
    private int lives;
    public Cat()
    {
        setImage("img/cat.png");
        score = 0;
        lives = 2;
    }
    
    public void act()
    {
        int x = getX();
        int y = getY();
        int w = getWidth();
        int h = getHeight();
        if(Mayflower.isKeyDown(Keyboard.KEY_D) && (x + h) < 800)
        {
            setLocation(x + 5, y);
        }
        
        if(Mayflower.isKeyDown(Keyboard.KEY_A) && x > 0)
        {
            setLocation(x - 5, y);
        }
        
        if(Mayflower.isKeyDown(Keyboard.KEY_W) && y > 0)
        {
            setLocation(x, y - 5);
        }
        
        if(Mayflower.isKeyDown(Keyboard.KEY_S) && (y + h) < 600)
        {
            setLocation(x, y + 5);
        }
        
        updateText();
    }
    
    public void increaseScore(int amount)
    {
        score+=amount;
    }
    
    public int getScore()
    {
        return score;
    }
    
    public void decreaseLives(int amount)
    {
        lives-=amount;
    }
    
    public int getLives()
    {
        return lives;
    }
    
    private void updateText()
    {
        World w = getWorld();
        w.removeText(10, 30);
        w.showText("Score: " + score + " Lives: " + lives, 10, 30, Color.BLACK);
    }
    
    public void setPosition(int x, int y)
    {
        setLocation(x, y);
    }
}
