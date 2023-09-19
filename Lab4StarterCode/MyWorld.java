package Lab4StarterCode;

import mayflower.*;


public class MyWorld extends World {
    private Cat cat;
    private DogAnimatedActor dog;
    private JackAnimatedActor jack;
    private NinjaAnimatedActor ninja;
    public MyWorld() 
    {
        setBackground("img/BG/BG.png");
        
        cat = new Cat();
        addObject(cat, 100, 100);
        dog = new DogAnimatedActor();
        addObject(dog, 150, 150);
        jack = new JackAnimatedActor();
        addObject(jack, 200, 200);
        ninja = new NinjaAnimatedActor();
        addObject(ninja, 250, 250);
    }
    
    public void act()
    {
    }
    
}