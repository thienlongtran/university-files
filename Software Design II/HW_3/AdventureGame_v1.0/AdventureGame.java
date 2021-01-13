import java.util.*;

/*****************************************************************
 * AdventureGame main program:
 * 
 * Description:
 * Reads in the dungeon configuration from standard input.
 * 
 * Usage:
 * cat d1.txt - | java AdventureGame
 ***************************************************************/


public class AdventureGame
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        //Game's Configuration Data (depending on OS/BROWSER ENV)
        String systemSettings = "";
        for (String specification : args)
        {
            systemSettings+= specification;
        }
        //Call to factory class to construct the correct config object for us.
        Config config = ConfigFactory.createConfig(systemSettings);
        
        //Read in the size of the map
        int width = StdIn.readInt();
        int height = StdIn.readInt();
        
        //Construct the dungeon layout
        Dungeon dungeon = new Dungeon(config, width, height);
        
        //Read in the initial location of the hero
        //#TODO add which room the hero starts in
        int heroX = StdIn.readInt();
        int heroY = StdIn.readInt();
        Hero hero = new Hero(config, heroX, heroY);
        
        //Setup all the cells in the dungeon
        for (int y=0; y<height; y++)
        {
            for (int x=0; x<width; x++)
            {
                dungeon.set(x, y, StdIn.readString());
            }//end inner-for
        }//end outer-for

        String choice;
        System.out.println("Would you like to start a new game or load a previous save?");
        System.out.println("Type 'new' for new game or 'load' to load a previous game.");
        while(!input.hasNext()){
            //Do nothing until user answers prompt
        }

        while(true){
            choice = input.nextLine();
            //Initialize new game
            if(choice.equals("new")){
                //#TODO read item string, change param for STRING, parse from map
                dungeon.addHero(hero);
                dungeon.addItem(Item.KEY,1,1);
                dungeon.addMonster(new Monster(config,1,2));
                dungeon.addMonster(new Monster(config,1,3));
                dungeon.addMonster(new Monster(config,10,7));
                break;
            }
            else if(choice.equals("load")){
                dungeon = DungeonSerializer.deserializeDungeon();
                break;
            }
            else{
                System.out.println("Not a valid input. Try again.");
            }
    }

        GameTUI tui = new GameTUI(config,dungeon);
        tui.run();
        
    }//end main
    
}//end Game
