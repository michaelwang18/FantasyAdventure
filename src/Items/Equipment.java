import java.util.ArrayList;

public class Equipment extends Item {

    private int attack;
    private int defense;
    private int health;
    private int speed;

    public Equipment(String name, String symbol, int value, int attack, int defense, int health, int speed) {
        super(name, symbol, value);
        this.attack = attack;
        this.defense = defense;
        this.health = health;
        this.speed = speed;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getHealth() {
        return health;
    }

    public int getSpeed() {
        return speed;
    }


    @Override
    public String toString() {
        return super.toString() + "Attack: " + attack  + "Defense: " + defense  + "Health: " + health  + "Speed: " + speed ;
    }
}
