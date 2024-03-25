public class Entity {

    String name;
    private int baseHealth;
    private int baseAttack;
    private int baseDefense;
    private int baseSpeed;

    public Entity (String name, int health, int attack, int defense, int speed){
        baseHealth = health;
        baseAttack = attack;
        baseDefense = defense;
        baseSpeed = speed;
        this.name = name;
    }

    public int getBaseAttack() {
        return baseAttack;
    }

    public int getBaseDefense() {
        return baseDefense;
    }

    public int getBaseHealth() {
        return baseHealth;
    }

    public int getBaseSpeed() {
        return baseSpeed;
    }

    public void setBaseAttack(int baseAttack) {
        this.baseAttack = baseAttack;
    }

    public void setBaseDefense(int baseDefense) {
        this.baseDefense = baseDefense;
    }

    public void setBaseHealth(int baseHealth) {
        this.baseHealth = baseHealth;
    }

    public void setBaseSpeed(int baseSpeed) {
        this.baseSpeed = baseSpeed;
    }

    public String getName() {
        return name;
    }
}
