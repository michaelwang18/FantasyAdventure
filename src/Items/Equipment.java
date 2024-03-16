import java.util.ArrayList;

public class Equipment extends Item {

    private int attack;
    private int defense;
    private int health;

    public Equipment(String name, String symbol, int value, int attack, int defense, int health) {
        super(name, symbol, value);
        this.attack = attack;
        this.defense = defense;
        this.health = health;
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


}
