import java.util.ArrayList;
import java.util.Scanner;
public class Shop {
    Scanner scan = new Scanner(System.in);
    ArrayList<String> materials = new ArrayList<>();
    ArrayList<String> consumables = new ArrayList<>();

    ArrayList<String> inventory = new ArrayList<>();

    public Shop() {
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

    public void buy() {
        System.out.print("We have two sections of items. Which section do you wish to enter?\n(C)onsumable\n(M)aterials");
        String option = scan.nextLine().toLowerCase();

        if (option.equals("c")) {
            for (int i = 0; i  < consumables.size(); i++) {
                System.out.println((i + 1) + ". " + consumables.get(i));
            }
            System.out.print("What do you wish to buy? They're tasty and they do their job. What else could you ask for.(Choose by entering the number in front of the item) :");
            int choice = scan.nextInt();
            choice--;
            scan.nextLine();
        } else if (option.equals("m")) {
            for (int i = 0; i < consumables.size(); i++) {
                System.out.println((i + 1) + ". " + consumables.get(i));
            }
            System.out.print("What do you wish to buy? Only the best available at my store.(Choose by entering the number in front of the item) :");
            int choice = scan.nextInt();
            choice--;
            scan.nextLine();
        }
        System.out.println("This isn't even one of the options. You sure you should be traveling the road? I think it's time to head back home.");
    }

    public void sell() {
        System.out.print("What do you wish to sell?");
        if (inventory.size() == 0) {
            System.out.println("You don't even have anything to sell. What you trying to pull?!");
        } else {
            for (int i = 0; i < inventory.size(); i++) {
                System.out.println((i + 1) + ". " + inventory.get(i));
            }
            System.out.println("What you selling.(Enter an number to choose what to sell)");
            int choice = scan.nextInt();
            choice--;
            scan.nextLine();
        }
    }
}