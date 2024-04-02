import java.util.ArrayList;

public class Player extends Entity{
    int coins;
    int progression;
    private Equipment armour;
    private ArrayList<Consumable> Handbag = new ArrayList<>();
    private Inventory bag = new Inventory();
    boolean alive;


    public Player(String name, int health, int attack, int defense, int speed, int coins){
        super(name, health, attack, defense, speed);
        this.coins = coins;
        armour = new Equipment("Clothes","Whatever Emoji",1,1,1,1,1);
        alive = true;
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

}
