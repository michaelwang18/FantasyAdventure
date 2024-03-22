public class Player extends Entity{
    int coins;
    int progression;
    Equipment armour;


    public Player(String name, int health, int attack, int defense, int speed, int coins){
        super(name, health, attack, defense, speed);
        this.coins = coins;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public void equip(Equipment newSet){

    }



}
