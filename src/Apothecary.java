import java.util.concurrent.Callable;
import java.util.Scanner;

public class Apothecary  {

    Player p1;

    static Scanner scan = new Scanner(System.in);
    Consumable potion1;
    Consumable potion2;
    Consumable potion3;

    public Apothecary(Player p1) {
        this.p1 = p1;
    }


    public void speech() {
         potion1 = potionMaking();
         potion2 = potionMaking();
         potion3 = potionMaking();
        Consumable chosenPotion;
        int choice = 0;

        while (choice != 2) {
            System.out.println("All the potions cost 50 coins, and 20 to refresh the selection ");
            System.out.println("1) " + potion1 + "\n2)  " + potion2 + "\n3)  " + potion3 + "\n4) Refresh Potions (20 coins)\nWhich potion would you like to buy: ");
            int potion = Utility.tryInput(scan.nextLine(), 4);
            chosenPotion = potion1;


            if (potion == 1) {
                chosenPotion = potion1;
            } else if (potion == 2) {
                chosenPotion = potion2;
            } else if (potion == 3){
                chosenPotion = potion3;
            } else if (potion == 4){
                if (p1.getCoins() >= 20){
                    System.out.println("Take a gander at these new potions");
                    potion1 = potionMaking();
                    potion2 = potionMaking();
                    potion3 = potionMaking();
                } else {
                    System.out.println("You don't got enough coins, get outta here ");
                    choice = 2;
                }


                 chosenPotion = potion1;
            }

            if (potion != 4 && chosenPotion.getValue() > 50) {
                System.out.print("You don't got enough coins. Would you like to see if you have enough for a different potion?\n1) Yes\n2) No");
                choice = Utility.tryInput(scan.nextLine(), 2);
            } else if (potion != 4){
                p1.setCoins(p1.getCoins() - chosenPotion.getValue());
                p1.getHandbag().add(chosenPotion);
                System.out.println("You have bought a " + chosenPotion);
                choice = 2;
            }
        }
    }

    private Consumable potionMaking() {
        String symbolV = null;
        String nameV = null;
        int valueV = 10;
        double attackV = ((int)((Math.random() * 75) + 0)) /100.0;
        double defenseV =  ((int)((Math.random() * 75) + 0)) /100.0;
        double healthV = ((int)((Math.random() * 75) + 0)) /100.0;
        double speedV = ((int)((Math.random() * 75) + 0)) /100.0;

        String type = determineTypeOfPotion(attackV, defenseV, healthV, speedV);

        if (type.equals("Attack")) {
            symbolV = "💪";
            nameV = "Attack Potion";
        } else if (type.equals("Defense")) {
            symbolV = "🦾";
            nameV = "Defense Potion";
        } else if (type.equals("Health")) {
            symbolV = "❤️";
            nameV = "Health Potion";
        } else if (type.equals("Speed")) {
            symbolV = "👟";
            nameV = "Speed Potion";
        } else if (type.equals("Neutral")) {
            symbolV = "🏳️‍🌈";
            nameV = "Stat Boost Potion";
        }

        return new Consumable(nameV, symbolV, 50, attackV, defenseV, healthV, speedV);
    }

    private String determineTypeOfPotion(double attackV, double defenseV, double healthV, double speedV) {
        if (attackV > defenseV && attackV > healthV && attackV > speedV) {
            return "Attack";
        } else if (defenseV > attackV && defenseV > healthV && defenseV > speedV) {
            return "Defense";
        } else if (healthV > attackV && healthV > defenseV && healthV > speedV) {
            return "Health";
        } else if (speedV > attackV && speedV > defenseV && speedV > healthV) {
            return "Speed";
        } else {
            return "Neutral";
        }
    }
}
