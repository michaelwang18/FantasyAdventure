import java.util.Dictionary;

public class Monster extends Entity{
    int[] drops;
    int exp;


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
            Item item = player.getBag().get(itemIdx);
            item.setOwned(item.getOwned()+1);
            System.out.println("You got a " + item.getName() + " (Owned: " + item.getOwned() + ")");
        }


    }

}
