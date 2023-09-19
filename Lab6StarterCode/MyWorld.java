package Lab6StarterCode;

import mayflower.*;


public class MyWorld extends World {
    private Cat cat;
    private DogAnimatedActor dog;
    private JackAnimatedActor jack;
    private NinjaAnimatedActor ninja;
    private Block block;
    private Block block2;
    public MyWorld() 
    {
        setBackground("img/BG/BG.png");
        Mayflower.showBounds(true);
        cat = new Cat();
        addObject(cat, 400, 100);
        dog = new DogAnimatedActor();
        addObject(dog, 150, 150);
        jack = new JackAnimatedActor();
        addObject(jack, 200, 200);
        ninja = new NinjaAnimatedActor();
        addObject(ninja, 250, 250);
        block = new Block();
        block2 = new Block();
        addObject(block, 400, 500);
        addObject(block2, 528, 372);
    }
    
    public void act()
    {
    }
    
}