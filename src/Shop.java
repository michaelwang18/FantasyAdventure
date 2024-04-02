import java.util.*;

public class Shop {
    Scanner scan = new Scanner(System.in);
    ArrayList<String> materials = new ArrayList<>();
    ArrayList<String> consumables = new ArrayList<>();

    ArrayList<Consumable> potions = new ArrayList<>();
    Player p1;

    public Shop(Player p1) {
        this.p1 = p1;
        //menu();
    }

    public void menu() {
        String option = "";
        while (!option.equals("l")) {
            System.out.println("What do you wish to do?\n(B)uy\n(S)ell\n(L)eave");
            option = scan.nextLine().toLowerCase();
            if (!option.equals("l")) {
                if (option.equals("b")) {
                    buy();
                } else if (option.equals("s")) {
                    sell();
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

    public void sell() {
        System.out.print("What do you wish to sell?");
        Dictionary<Integer, Item> allItems = p1.getBag();
        boolean hasSell = false;
        Dictionary<Integer, Item> itemsOwned = new Hashtable<>();
        int count = 1;
        for (int i = 0; i < allItems.size(); i++) {
            if (!(allItems.get(i).getOwned() <= 0)) {
                //print the amount owned and how much to sell for
                itemsOwned.put(count, allItems.get(i));
                count++;
                hasSell = true;
            }
        }
        if (hasSell){
            for(int i = 1; i <= itemsOwned.size(); i++){
                System.out.println(i+") " + itemsOwned.get(i));
            }
            System.out.println("What would you like to sell?");
            int choice = Utility.tryInput(scan.nextLine(),itemsOwned.size());
            boolean confirm = false;
            while (!confirm) {
                System.out.println("How many would you like to sell? (0 - " + itemsOwned.get(choice).getOwned() + ")" );
                int sellCount = Utility.tryInput(scan.nextLine(),itemsOwned.get(choice).getOwned());
                System.out.println("Are you sure you want to sell " + sellCount + " " + itemsOwned.get(choice).getName() + " for " + (itemsOwned.get(choice).getValue() * sellCount) + " coins?");
            }

        } else {
            System.out.println("You don't got things to sell");
        }


    }
}