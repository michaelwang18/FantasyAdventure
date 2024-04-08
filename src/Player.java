import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Scanner;

public class Player extends Entity{
    private int coins;
    private int progression;
    private int exp;
    private int level;
    private Equipment armour;
    private Weapon sword;
    private ArrayList<Consumable> Handbag = new ArrayList<>(0);
    private Inventory bag = new Inventory();
    private boolean alive;
    private Scanner scan;


    public Player(String name, int health, int attack, int defense, int speed, int coins){
        super(name, health, attack, defense, speed);
        this.coins = coins;
        armour = new Equipment("Clothes","",0,0,0,0,0);
        alive = true;
        scan = new Scanner(System.in);
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public void equip(Equipment newSet){

    }
    public Equipment getArmour() {
        return armour;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public Inventory getBag() {
        return bag;
    }

    public ArrayList<Consumable> getHandbag() {
        return Handbag;
    }
    
    public void setHandbag(Consumable comsumable) {
        Handbag.add(comsumable);
    }

    public void obtainExp(int experience){
        exp += experience;
        if (exp >= (10 + level * 2)){
            level++;
            exp -= (15 + level * 2);
            System.out.println("You leveled up!" + Color.WHITE_BOLD_BRIGHT +"LEVEL " + (level-1) + " > " + level + "\nAll base stats increased" + Color.GREEN_BOLD_BRIGHT);
            System.out.println("❤\uFE0F " + getBaseHealth() + " -> " + (getBaseHealth() + 10));
            setBaseHealth(getBaseHealth() + 10);

            System.out.println("\uD83D\uDDE1\uFE0F " + getBaseAttack() + " -> " + (getBaseAttack() + 5));
            setBaseAttack(getBaseAttack() + 5);

            System.out.println("\uD83D\uDC5F " + getBaseSpeed() + " -> " + (getBaseSpeed() + 5));
            setBaseSpeed(getBaseSpeed() + 5);

            System.out.println("\uD83D\uDEE1\uFE0F " + getBaseDefense() + " -> " + (getBaseDefense() + 5));
            setBaseDefense(getBaseDefense() + 5);
            System.out.println(Color.RESET + "Your identity becomes better defined through... \n1) Strength(Attack UP)\n2) Resilience(Defense UP)\n3) Vitality(Health Up)\n4) Agility(Speed Up)" + Color.GREEN_BOLD_BRIGHT);
            int choice = Utility.tryInput(scan.nextLine(),4);
            if (choice == 1){
                System.out.println("\uD83D\uDDE1\uFE0F " + getBaseAttack() + " -> " + (getBaseAttack() + 5));
                setBaseAttack(getBaseAttack() + 5);
            }
            if (choice == 2){
                System.out.println("\uD83D\uDEE1\uFE0F " + getBaseDefense() + " -> " + (getBaseDefense() + 5));
                setBaseDefense(getBaseDefense() + 5);
            }
            if (choice == 3){
                System.out.println("❤\uFE0F " + getBaseHealth() + " -> " + (getBaseHealth() + 10));
                setBaseHealth(getBaseHealth() + 10);
            }
            if (choice == 4){
                System.out.println("\uD83D\uDC5F " + getBaseSpeed() + " -> " + (getBaseSpeed() + 5));
                setBaseSpeed(getBaseSpeed() + 5);
            }


            obtainExp(0); //to loop until your outa exp if you get a crap load
        }
    }

    public int getLevel() {
        return level;
    }
}
