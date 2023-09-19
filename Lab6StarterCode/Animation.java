package Lab6StarterCode;
import mayflower.*;

public class Animation
{
    private MayflowerImage[] frames;
    private int framerate;
    private int currentFrame;
    
    public Animation(String[] array, int fR)
    {
        frames = new MayflowerImage[array.length];
        framerate = fR;
        currentFrame = 0;
        for(int i = 0 ; i < array.length ; i++)
        {
            frames[i] = new MayflowerImage(array[i]);
        }
    }
    
    public int getFrameRate()
    {
        return framerate;
    }
    
    public void setScale(int x, int y)
    {
        for(MayflowerImage frame : frames)
        {
            frame.scale(x, y);
        }
    }
    
    public void setTransparency(int p)
    {
        for(MayflowerImage frame : frames)
        {
            frame.setTransparency(p);
        }
    }
    
    public void mirrorHorizontally()
    {
        for(MayflowerImage frame : frames)
        {
            frame.mirrorHorizontally();
        }
    }
    
    public void setBounds(int x, int y, int w, int h)
    {
        for(MayflowerImage frame : frames)
        {
            frame.crop(x, y, w, h);
        }
    }
    
    public MayflowerImage getNextFrame()
    {
        MayflowerImage frame = frames[currentFrame];
        if(currentFrame >= frames.length-1){
            currentFrame = 0;
        }
        else{
            currentFrame++;
        }
        
        return frame;
    }
    
    
}