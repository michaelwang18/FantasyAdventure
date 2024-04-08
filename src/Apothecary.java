import java.util.concurrent.Callable;
import java.util.Scanner;

public class Apothecary  {

    static Scanner scan = new Scanner(System.in);

    public Apothecary(Player p1) {
        speech(p1);
    }


    public void speech(Player p1) {
        Consumable potion1 = potionMaking();
        Consumable potion2 = potionMaking();
        Consumable potion3 = potionMaking();
        Consumable chosenPotion;
        int choice = 0;

        while (choice != 2) {
            System.out.print("1) First Potion " + potion1 + "\n2) Second Potion " + potion2 + "\n3) Third Potion " + potion3 + "\nWhich potion would you like to buy: ");
            int potion = Utility.tryInput(scan.nextLine(), 3);

            if (potion == 1) {
                chosenPotion = potion1;
            } else if (potion == 2) {
                chosenPotion = potion2;
            } else {
                chosenPotion = potion3;
            }

            if (chosenPotion.getValue() > p1.getCoins()) {
                System.out.print("You don't got enough coins. Would you like to see if you have enough for a different potion?\n1) Yes\n2) No");
                choice = Utility.tryInput(scan.nextLine(), 2);
            } else {
                p1.setCoins(p1.getCoins() - chosenPotion.getValue());
                p1.setHandbag(chosenPotion);
                System.out.println("You have bought a " + chosenPotion);
                choice = 2;
            }
        }
    }

    private Consumable potionMaking() {
        String symbolV = null;
        String nameV = null;
        int valueV = (int) ((Math.random() * 10) + 1);
        int attackV = (int) ((Math.random() * 75) + 26);
        int defenseV = (int) ((Math.random() * 75) + 26);
        int healthV = (int) ((Math.random() * 75) + 26);
        int speedV = (int) ((Math.random() * 75) + 26);

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

        return new Consumable(nameV, symbolV, valueV, attackV, defenseV, healthV, speedV);
    }

    private String determineTypeOfPotion(int attackV, int defenseV, int healthV, int speedV) {
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
