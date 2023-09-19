package Lab5StarterCode;

import mayflower.*;
public class MyWorld extends World {
    private Cat cat;
    private DogAnimatedActor dog;
    private JackAnimatedActor jack;
    private NinjaAnimatedActor ninja;
    private String[][] tiles;
    public MyWorld() 
    {
        setBackground("img/BG/BG.png");
        tiles = new String[6][8];
        //dog = new DogAnimatedActor();
        //addObject(dog, 150, 150);
        //jack = new JackAnimatedActor();
        //addObject(jack, 200, 200);
        //ninja = new NinjaAnimatedActor();
        //addObject(ninja, 250, 250);
        System.out.println("World generation");
        buildWorld();
        System.out.println("Yarn generation");
        addRandomObjects();
        System.out.println("Character 1 generation");
        addMainCharacter();
        System.out.println("Mushroom generation)");
        addRandomObjects2();
        System.out.println("Character 2 generation");
        addMainCharacter2();
    }
    
    public void buildWorld()
    {
        for(int i = 0 ; i < tiles.length ; i++)
        {
            for(int j = 0 ; j < tiles[0].length ; j++)
            {
                tiles[i][j] = " ";
                if(i >= 5){
                    System.out.println(j + " " + i);
                    tiles[i][j] = "ground";
                    addObject(new Block(), j * 100, i * 100);
                    }
            }
            System.out.println();
        }
    }
    
    public void addRandomObjects()
    {
        for(int i = 0 ; i < tiles.length - 1; i++)
        {
            for(int j = 0 ; j < tiles[0].length ; j++)
            {
                int l = (int)(Math.random() * tiles.length);
                if(l < 3)
                {
                    System.out.println(j + " " + i);
                    tiles[i][j] = "yarn";
                    addObject(new Yarn(), j*100, i*100);
                }
            }
            System.out.println();
        }
    }
    
    public void addRandomObjects2()
    {
        for(int i = 0 ; i < tiles.length - 1; i++)
        {
            for(int j = 0 ; j < tiles[0].length ; j++)
            {
                int l = (int)(Math.random() * tiles.length);
                if(l < 3 && tiles[i][j].equals(" "))
                {
                    System.out.println(j + " " + i);
                    tiles[i][j] = "mushroom";
                    addObject(new Mushroom(), j*100, i*100);
                }
            }
            System.out.println();
        }
    }
    
    public void addMainCharacter()
    {
        cat = new Cat();
        int row = (int)(Math.random() * tiles.length);
        int col = (int)(Math.random() * tiles[0].length);
        boolean added = false;
        while(added == false)
        {
            System.out.println(col + " " + row);
            if(tiles[row][col].equals(" "))
            {
                addObject(cat, col  * 100, row  * 100);
                tiles[row][col] = "cat";
                added = true;
            }
            else 
            {
                row = (int)(Math.random() * tiles.length);
                col = (int)(Math.random() * tiles[0].length);
            }
            
        }
        System.out.println();
    }
    
    public void addMainCharacter2()
    {
        ninja = new NinjaAnimatedActor();
        boolean added = false;
        while(added == false)
        {
            int row = (int)(Math.random() * tiles.length);
            int col = (int)(Math.random() * tiles[0].length);
            System.out.println(col + " " + row);
            if(tiles[row][col].equals(" "))
            {
                addObject(ninja, col  * 100, row  * 100);
                tiles[row][col] = "ninjaGirl";
                added = true;
            }
            else 
            {
                row = (int)(Math.random() * tiles.length);
                col = (int)(Math.random() * tiles[0].length);
            }
        }
        System.out.println();
    }
    
    public void act()
    {
    }
    
}