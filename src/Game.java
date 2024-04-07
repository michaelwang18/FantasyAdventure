import java.sql.SQLOutput;
import java.util.Dictionary;
import java.util.Scanner;

public class Game {
    private int coins;
    private int lives;
    private int energy;
    private boolean fainted;
    private Player player;

    Scanner scan;

    Dialogue town;

    public Game(){ lives = 3; energy = 10; scan = new Scanner(System.in); start();}

    public void start(){

        System.out.println("What is your name?");
        String name = scan.nextLine();
        System.out.println(name + " is it?\n1) Yes\n2) No");
        int confirm = Utility.tryInput(scan.nextLine(),2);
        while (confirm != 1){
            System.out.println("Lets try that again. What is your name?");
            name = scan.nextLine();
            System.out.println(name + " is it?\n1) Yes\n2) No");
            confirm = Utility.tryInput(scan.nextLine(),2);
        }
         player =  new Player(name,150,35,20,30,0);
        if (player == null){
            System.out.println("Test");
        }
        initilizeChoices();
        //We deal with this later
        //Create Intro "survey" and create player

        for (int day = 1; lives > 0; day++){
            System.out.println(Utility.color("Day " + day, Color.WHITE_BOLD_BRIGHT));

            town.start(player);

        }


    }


    private void initilizeChoices(){
        System.out.println(player.getName());
        Object[] storeChoices = {new Shop(player),new Shop(player), new Shop(player)};
        Battle[] huntChoices = {new Battle(player,Monster.getArea1Monster()),new Battle(player,Monster.getArea2Monster()),new Battle(player,Monster.getArea3Monster()) };
        Dialogue shop = new Dialogue("Shop","What store would you like to visit?\n1) General Store\n2) Apothecary\n3) Blacksmith",storeChoices);
        Dialogue hunt = new Dialogue("TownHunt","Where would you like to hunt!\n1) Great Plains \n2) Scorching Desert\n3) Bleak Tundras",huntChoices);

        Object[] options = {hunt,shop}; //Add Fishing when richards done
        town = new Dialogue("TownStart","You're in town, what would you like to do? " +
                "\n1) Go Hunt" +
                "\n2) Visit Stores" +
                "\n3) Go Fishing",options);

    }






}
