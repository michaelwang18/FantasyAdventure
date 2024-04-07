public class Consumable extends Item {


    private double attack;
    private double defense;
    private double health;
    private double speed;

    public Consumable(String name, String symbol, int value, double attack, double defense, double health, double speed) {
        super(name, symbol, value);
        this.attack = attack;
        this.defense = defense;
        this.health = health;
        this.speed = speed;
    }

    public double getAttack() {
        return attack;
    }

    public double getDefense() {
        return defense;
    }

    public double getHealth() {
        return health;
    }

    public double getSpeed() {
        return speed;
    }


    @Override
    public String toString() {
        return super.toString() + "Attack: " + attack  + "Defense: " + defense  + "Health: " + health  + "Speed: " + speed ;
    }

    public String encode() {
        return getName() + "," + getSymbol() + "," + getValue() + "," + attack + "," + defense + "," + health + "," + speed;
    }

    public static Consumable decode(String mesh) {
        String[] split = mesh.split(",");
        return new Consumable(split[0],split[1],Integer.parseInt(split[2]),Double.parseDouble(split[3]),Double.parseDouble(split[4]),Double.parseDouble(split[5]),Double.parseDouble(split[6]));
    }



}
