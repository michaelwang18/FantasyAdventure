import java.util.Scanner;

public class Blacksmith {

    private final Scanner sc;

    private Player player;
    private String setNum = "1";

    public Blacksmith(Player player) {
        sc = new Scanner(System.in);
        this.player = player;
    }

    public void craftSet() {
        boolean quit = false;

        while (!quit) {
            System.out.println("\n\n\n\n");
            printSets();
            setsInfo();
            switch (setNum) {
                case "1":
                    if (checkReq(4) >= 2 && checkReq(7) >= 1 && checkReq(8) >= 1 && checkReq(10) >= 1 && checkReq(12) >= 1 && player.getCoins() >= 50) {
                        System.out.println("You have crafted The Bone Set!");
                        takeItem(4, 2);
                        takeItem(7, 1);
                        takeItem(8, 1);
                        takeItem(10, 1);
                        takeItem(12, 1);
                        player.setCoins(player.getCoins() - 50);
                        player.equip(((Equipment) player.getBag().getItem(31)));
                    } else {
                        System.out.println("You do not have the required items!");
                    }
                    break;
                case "2":
                    if (checkReq(3) >= 1 && checkReq(11) >= 1 && checkReq(5) >= 3 && checkReq(6) >= 2 && checkReq(12) >= 1 && player.getCoins() >= 50) {
                        System.out.println("You have crafted The Hide Set!");
                        takeItem(3, 1);
                        takeItem(11, 1);
                        takeItem(5, 3);
                        takeItem(6, 2);
                        takeItem(12, 1);
                        player.setCoins(player.getCoins() - 50);
                        player.equip(((Equipment) player.getBag().getItem(32)));
                    } else {
                        System.out.println("You do not have the required items!");
                    }
                    break;
                case "3":
                    if (checkReq(14) >= 1 && checkReq(16) >= 1 && checkReq(18) >= 2 && checkReq(19) >= 1 && checkReq(21) >= 1 && player.getCoins() >= 80) {
                        System.out.println("You have crafted The Elemental Set!");
                        takeItem(14, 1);
                        takeItem(16, 1);
                        takeItem(18, 2);
                        takeItem(19, 1);
                        takeItem(21, 1);
                        player.setCoins(player.getCoins() - 80);
                        player.equip(((Equipment) player.getBag().getItem(33)));
                    } else {
                        System.out.println("You do not have the required items!");
                    }
                    break;
                case "4":
                    if (checkReq(15) >= 2 && checkReq(22) >= 1 && checkReq(20) >= 1 && checkReq(17) >= 1 && checkReq(13) >= 1 && player.getCoins() >= 85) {
                        System.out.println("You have crafted The Crystal Armor!");
                        takeItem(15, 2);
                        takeItem(22, 1);
                        takeItem(20, 1);
                        takeItem(17, 1);
                        takeItem(13, 1);
                        player.setCoins(player.getCoins() - 85);
                        player.equip(((Equipment) player.getBag().getItem(34)));
                    } else {
                        System.out.println("You do not have the required items!");
                    }
                    break;
                case "5":
                    if (checkReq(26) >= 3 && checkReq(24) >= 1 && checkReq(28) >= 1 && checkReq(29) >= 1 && checkReq(30) >= 1 && player.getCoins() >= 150) {
                        System.out.println("You have obtained the Shadowed Curse of the Umbral Knight!");
                        takeItem(26, 3);
                        takeItem(24, 1);
                        takeItem(28, 1);
                        takeItem(29, 1);
                        takeItem(30, 1);
                        player.setCoins(player.getCoins() - 150);
                        player.equip(((Equipment) player.getBag().getItem(35)));
                    } else {
                        System.out.println("You do not have the required items!");
                    }
                    break;
                case "6":
                    if (checkReq(25) >= 2 && checkReq(26) >= 3 && checkReq(24) >= 2 && checkReq(27) >= 1 && checkReq(29) >= 1 && player.getCoins() >= 125) {
                        System.out.println("You have become the Untouchable");
                        takeItem(25, 2);
                        takeItem(26, 3);
                        takeItem(24, 2);
                        takeItem(27, 1);
                        takeItem(29, 1);
                        player.setCoins(player.getCoins() - 125);
                        player.equip(((Equipment) player.getBag().getItem(36)));
                    } else {
                        System.out.println("You do not have the required items!");
                    }
                    break;
                case "7":
                    if (checkReq(23) >= 2 && checkReq(26) >= 3 && checkReq(24) >= 2 && checkReq(27) >= 1 && checkReq(28) >= 1 && player.getCoins() >= 125) {
                        System.out.println("You have crafted the Impenetrable Scales!");
                        takeItem(23, 2);
                        takeItem(26, 3);
                        takeItem(24, 2);
                        takeItem(27, 1);
                        takeItem(28, 1);
                        player.setCoins(player.getCoins() - 125);
                        player.equip(((Equipment) player.getBag().getItem(37)));
                    } else {
                        System.out.println("You do not have the required items!");
                    }
                    break;
                case "q":
                    quit = true;
                    setNum = "q";
                    break;
                default:
                    System.out.println("Invalid option!");
                    break;
            }

        }
    }

    public void setsInfo() {


            System.out.print("Which player set would you like to know more about? (1-7 sets, q to quit) ");
            String  pageNumber = sc.nextLine();

            switch (pageNumber) {
                case "1":
                    printPageOne();
                    break;
                case "2":
                    printPageTwo();
                    break;
                case "3":
                    printPageThree();
                    break;
                case "4":
                    printPageFour();
                    break;
                case "5":
                    printPageFive();
                    break;
                case "6":
                    printPageSix();
                    break;
                case "7":
                    printPageSeven();
                    break;
                case "q":
                    setNum = "q";
                    break;
                default:
                    System.out.println("Invalid option!");
                    break;


        }
    }

    public void printPageOne() {
        System.out.println("The Bone Set \uD83E\uDDB4");
        System.out.println(Color.CYAN_BOLD_BRIGHT +"A collection of bones forged into a power armor and weapon set with the help of a mage's scroll. " + Color.RESET);
        System.out.println("Crafting requirements: ");
        System.out.println("2 Troll Tusks");
        System.out.println("1 Boar Horn");
        System.out.println("1 Boar Tusk");
        System.out.println("1 Rock");
        System.out.println("1 Scroll of the Overworld");
        System.out.println("50 Coins");
        setNum = "1";
    }

    public void printPageTwo() {
        System.out.println("\n\nThe Hide Set");
        System.out.println(Color.CYAN_BOLD_BRIGHT + "A strong, sturdy set of armor made from enchanted animal hide. Nothing too special." + Color.RESET);
        System.out.println("Crafting requirements: ");
        System.out.println("1 Troll Club");
        System.out.println("1 Mage Staff");
        System.out.println("3 Troll Hide");
        System.out.println("2 Boar Hide");
        System.out.println("1 Scroll of the Overworld");
        System.out.println("50 Coins\n\n");
        setNum = "2";
    }

    public void printPageThree() {
        System.out.println("The Elemental Set");
        System.out.println(Color.CYAN_BOLD_BRIGHT + "A powerful set that grants you strength from all the elements." + Color.RESET);
        System.out.println("Crafting requirements: ");
        System.out.println("1 Snowflake");
        System.out.println("1 Molten Ore");
        System.out.println("2 Thunder Hooves");
        System.out.println("1 Hydra Tail");
        System.out.println("1 Breath of the Wind Dragon");
        System.out.println("80 Coins");
        setNum = "3";
    }

    public void printPageFour() {
        System.out.println("The Crystal Armor");
        System.out.println(Color.CYAN_BOLD_BRIGHT + "An incredibly difficult set to pierce through. It's put together using crystals dropped from powerful mobs."+ Color.RESET);
        System.out.println("Crafting requirements: ");
        System.out.println("2 Ruby");
        System.out.println("1 Wind Crystal");
        System.out.println("1 Aquamarine");
        System.out.println("1 Lightning Spark");
        System.out.println("1 Yeti Claw");
        System.out.println("85 Coins");
        setNum = "4";
    }

    public void printPageFive() {
        System.out.println("Shadowed Curse of the Umbral Knight");
        System.out.println(Color.CYAN_BOLD_BRIGHT + "An extremely powerful set that grants you all the powers of the Umbral Knight. One must get through the deepest, darkest layer to obtain this set"+ Color.RESET);
        System.out.println("Crafting requirements: ");
        System.out.println("3 Umbral Stones");
        System.out.println("2 Deep Sea Pearls");
        System.out.println("1 Dark Soul");
        System.out.println("1 Shadow Orb");
        System.out.println("1 Shadow Blade");
        System.out.println("150 Coins");
        setNum = "5";
    }

    public void printPageSix() {
        System.out.println("The Untouchable");
        System.out.println(Color.CYAN_BOLD_BRIGHT + "The quickest set achievable. Extremely difficult for enemies to hit you. Obtained by defeating the quickest mobs in the deepest layer");
        System.out.println("Crafting requirements: ");
        System.out.println("2 Abyssal Boots");
        System.out.println("3 Umbral Stones");
        System.out.println("2 Deep Sea Pearls");
        System.out.println("1 Nightmare Shard");
        System.out.println("1 Shadow Orb");
        System.out.println("125 Coins");
        setNum = "6";
    }

    public void printPageSeven() {
        System.out.println("Impenetrable Scales");
        System.out.println(Color.CYAN_BOLD_BRIGHT + "The most durable set achievable. Grants you vasts amount of health and armor.");
        System.out.println("Crafting requirements: ");
        System.out.println("2 Serpent Scales");
        System.out.println("3 Umbral Stones");
        System.out.println("2 Deep Sea Pearls");
        System.out.println("1 Nightmare Shard");
        System.out.println("1 Dark Soul");
        System.out.println("125 Coins");
        setNum = "7";
    }

    /* Private Helper Methods */

    private void printSets() {
        System.out.println("List of Sets: ");
        System.out.println("1. The Bone Set");
        System.out.println("2. The Hide Set");
        System.out.println("3. The Elemental Set");
        System.out.println("4. The Crystal Armor");
        System.out.println("5. Shadowed Curse of the Umbral Knight");
        System.out.println("6. The Untouchable");
        System.out.println("7. Impenetrable Scales");
    }

    private void takeItem(int idx, int amount){
        player.getBag().add(idx, - amount);
    }

    private int checkReq(int idx){
        return player.getBag().getAmount(idx);
    }

}
