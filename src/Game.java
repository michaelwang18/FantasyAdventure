import java.util.Dictionary;

public class Game {
    private int coins;
    private int lives;
    private int energy;
    private boolean fainted;
    private Player player;

    Dialogue town;

    public Game(){start(); lives = 3; energy = 10;}




    public void start(){

        System.out.println("Welcome Game");
        //We deal with this later
        //Create Intro "survey" and create player

        for (int day = 1; lives > 0; day++){
            System.out.println(Utility.color("Day " + day, Color.WHITE_BOLD_BRIGHT));
            town.start();
            



        }


    }

    private void initilizeChoices(){
        Object[] storeOptions = {};
        Object[] battleOptions = {new Battle(player,EntityList.getGPMonster()),new Battle(player,EntityList.getSDMonster()),new Battle(player,EntityList.getBTMonster())};
        Object[] options = {new Dialogue("TownHunt","Where would you like to hunt!\n1) Great Plains \n2) Scorching Desert\n3) Bleak Tundras",battleOptions),
                new Dialogue("Shop","What store would you like to visit?\n1) General Store\n2) Apothecary\n3) Blacksmith",storeOptions)}; //Add Fishing when richards done
        town = new Dialogue("TownStart","Your in town, what would you like to do? " +
                "\n1) Go Hunt" +
                "\n2) Visit Stores" +
                "\n3) Go Fish",options);

    }






}
