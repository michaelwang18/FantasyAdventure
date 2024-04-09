import java.util.Dictionary;

public class Monster extends Entity{
    private int[] drops;
    private int exp;


    public Monster (String name, int health, int attack, int defense, int speed, int[] drops, int experience){
        super( name,  health,  attack,  defense,  speed);
        this.drops = drops;
        exp = experience;
    }

    public int getExp() {
        return exp;
    }

    public void defeat(Player player){
        getDrops(player, (int) (Math.random()*3));
        System.out.println("You gained " + exp + " EXP!\n");
    }

    public void getDrops(Player player,int numLoot){
        for (int i = 0; i < numLoot; i++){
            int itemIdx = drops[ (int) (Math.random()*drops.length)];
            Item item = player.getBag().getItem(itemIdx);
            item.setOwned(item.getOwned()+1);
            System.out.println("You got a " + item.getName() + " (Owned: " + item.getOwned() + ")");
        }
    }

    /* Region 1 */
    public static Entity troll() {
        int[] drops = {3, 4, 5};
        return new Monster("Troll", 100, 30, 30, 25, drops, 50);
    }

    public static Entity direBoar(){
        int[] drops = {6,6,8,8,7};
        return new Monster("Dire Boar",70,30,25,45,drops,50);
    } //example

    public static Entity rockGolem() {
        int[] drops = {10};
        return new Monster("Rock Golem", 100, 30, 50, 10, drops, 75);
    }

    public static Entity evilMage() {
        int[] drops = {11, 11, 12};
        return new Monster("Evil Mage", 70, 50, 30, 30, drops, 75);
    }

    /* Region 2 */

    public static Entity yetiLord() {
        int[] drops = {13, 14, 14};
        return new Monster("Yeti Lord", 120, 40, 30, 40, drops, 80);
    }

    public static Entity lavaTitan() {
        int[] drops = {15, 15, 16};
        return new Monster("Lava Titan", 150, 40, 50, 25, drops, 90);
    }

    public static Entity thunderMoose() {
        int[] drops = {17, 18, 18};
        return new Monster("Thunder Moose", 100, 45, 20, 60, drops, 95);
    }

    public static Entity hydra() {
        int[] drops = {19, 20};
        return new Monster("Hydra", 130, 50, 20, 60, drops, 100);
    }

    public static Entity zephyrion() {
        int[] drops = {22, 21};
        return new Monster("Zephyrion", 150, 45, 30, 60, drops, 150);
    }

    /* Region 3 */

    public static Entity shadowSerpent() {
        int[] drops = {23, 23, 24, 26};
        return new Monster("Shadow Serpent", 150, 50, 40, 60, drops, 150);
    }

    public static Entity abyssalKnight() {
        int[] drops = {25, 25, 26};
        return new Monster("Abyssal Knight", 175, 60, 40, 50, drops, 150);
    }

    public static Entity wraith() {
        int[] drops = {27, 28, 26};
        return new Monster("Wraith", 200, 60, 50, 50, drops, 175);
    }

    public static Entity voidSpecter() {
        int[] drops = {29, 24, 26, 26};
        return new Monster("Void Specter", 180, 50, 50, 50, drops, 160);
    }

    public static Entity undeadGuardian() {
        int[] drops = {30, 30, 28, 26};
        return new Monster("Undead Guardian", 185, 60, 45, 65, drops, 175);
    }


    public static Entity getArea1Monster(){
        Entity[] list = {direBoar(), troll(), rockGolem(), evilMage() };
        return list[(int) (Math.random()*list.length)];
    }
    public static Entity getArea2Monster(){ //THESE ARE EXAMPLES
        Entity[] list = {yetiLord(), lavaTitan(), thunderMoose(), hydra(), zephyrion()};
        return list[(int) (Math.random()*list.length)];
    }
    public static Entity getArea3Monster(){
        Entity[] list = {shadowSerpent(), abyssalKnight(), wraith(), voidSpecter(), undeadGuardian()};
        return list[(int) (Math.random()*list.length)];
    }






}
