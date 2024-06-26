import java.util.*;

public class Shop {
    static Scanner scan = new Scanner(System.in);
    static ArrayList<String> materials = new ArrayList<>();
    static ArrayList<String> consumables = new ArrayList<>();

    static ArrayList<Consumable> potions = new ArrayList<>();

    public Shop(Player p1) {}

    public void menu(Player player) {
        String option = "";
        while (!option.equals("3")) {
            System.out.println("What do you wish to do?\n1) Sell\n2) Buy\n3)Leave");
            option = String.valueOf(Utility.tryInput(scan.nextLine(),3));
            if (!option.equals("3")) {
                if (option.equals("1")) {
                    sell(player);
                } else if (option.equals("2")) {
                    System.out.println("That's like tryna sell a farmers his own crops, makes me no profit");
                } else {
                    System.out.println("This is not a valid option!");
                }
            }
        }
    }

    public void buy() { //selling potions with stats at max of .25

        System.out.print("What do you wish to buy? They're tasty and they do their job. What else could you ask for.(Choose by entering the number in front of the item) :");
        int choice = scan.nextInt();
        choice--;
        scan.nextLine();
        System.out.println("This isn't even one of the options. You sure you should be traveling the road? I think it's time to head back home.");
    }

    public void sell(Player p1) {
        Inventory bag = p1.getBag();
        boolean confirm = false;
        boolean hasSell = false;
        Dictionary<Integer, Item> itemsOwned = new Hashtable<>();
        for (int i = 1; i < bag.getAllItems().size();i++) {
            if (bag.getItem(i).getOwned() > 0) {
                hasSell = true;
            }
        }
        if (hasSell){
            while(!confirm) {
                itemsOwned = new Hashtable<>();
                int count = 1;
                for (int i = 1; i < bag.getAllItems().size(); i++) {
                    if (bag.getItem(i).getOwned() > 0) {
                        //print the amount owned and how much to sell for
                        itemsOwned.put(count, bag.getItem(i));
                        count++;
                    }
                }
                for (int i = 1; i <= itemsOwned.size(); i++) {
                    Item item = itemsOwned.get(i);
                    System.out.println(i + ") " + item.getSymbol() + Color.WHITE_BOLD_BRIGHT + " " + item.getName() + " " + Color.GREEN_BOLD_BRIGHT + "$ " + item.getValue() + Color.CYAN_BOLD + " Owned: (" + item.getOwned() + ")" + Color.RESET);
                }
                System.out.println("What would you like to sell? [You have " + p1.getCoins() + " \uD83E\uDE99] \nx) to exit");
                String select = scan.nextLine();
                if (select.toLowerCase().equals("x")) {confirm = true;} else {
                    int choice = Integer.parseInt(select);
                    System.out.println("How many would you like to sell? (1 - " + itemsOwned.get(choice).getOwned() + ")");
                    int sellCount = Utility.tryInput(scan.nextLine(), itemsOwned.get(choice).getOwned());
                    System.out.println("Are you sure you want to sell " + sellCount + " " + itemsOwned.get(choice).getName() + " for " + (itemsOwned.get(choice).getValue() * sellCount) + " coins?\n1) Yes\n2) No");
                    int complete = Utility.tryInput(scan.nextLine(), 2);
                    if (complete == 1) {
                        itemsOwned.get(choice).setOwned(itemsOwned.get(choice).getOwned() - sellCount);
                        p1.setCoins(p1.getCoins() + (sellCount * itemsOwned.get(choice).getValue()));
                        hasSell = false;
                        for (int i = 1; i < bag.getAllItems().size(); i++) {
                            if (bag.getItem(i).getOwned() > 0) {
                                hasSell = true;
                                System.out.println("You now have " + p1.getCoins() + " \uD83E\uDE99!");
                            }

                        }
                        if (hasSell) {
                            System.out.println("Would you like to continue selling?\n1)Yes\n2)No");
                            int continu = Utility.tryInput(scan.nextLine(), 2);
                            if (continu == 2) {
                                System.out.println("Thank you for the business!");
                                confirm = true;
                            }
                            if (continu == 1) {
                                System.out.println("Until next time.");
                            }
                        } else {
                            System.out.println("Seems like you don't much to sell no more, ill see you next time.");
                            confirm = true;
                        }
                    }
                }
            }
        } else {
            System.out.println("You don't got things to sell");
        }
    }
}