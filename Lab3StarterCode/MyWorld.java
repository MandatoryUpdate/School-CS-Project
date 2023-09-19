package Lab3StarterCode;

import mayflower.*;

public class MyWorld extends World
{
    // Constructor
    public MyWorld()
    {
        setBackground("img/BG/BG.png");

        Cat cat = new Cat();
        addObject(cat, 100, 100);
        NinjaGirl ninjaGirl = new NinjaGirl();
        addObject(ninjaGirl, 150, 150);
    }

    public void act()
    {
    }
}
