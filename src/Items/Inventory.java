import java.io.File;
import java.io.IOException;
import java.util.*;

public class Inventory {
    private Dictionary<Integer, Item> allItems = new Hashtable<Integer, Item>();
    private ArrayList<Consumable> Handbag = new ArrayList<>();

    public Inventory(){

        try {
            int count = 0;
            File myFile = new File("src/items/itemList.csv");
            Scanner fileScanner = new Scanner(myFile);
            //fileScanner.nextLine(); //Skips first line
            while (fileScanner.hasNext()) {
                String data = fileScanner.nextLine();
                count++;
                String[] splitData = data.split(",");
                String name = splitData[0];
                int value = Integer.parseInt(splitData[2]);
                String symbol = splitData[1];
                Item item;
                if (splitData.length > 3){
                    int attack = Integer.parseInt(splitData[3]);
                    int defense = Integer.parseInt(splitData[4]);
                    int health = Integer.parseInt(splitData[5]);
                    int speed = Integer.parseInt(splitData[6]);
                    if (splitData.length > 7){
                        item = new Weapon(name,symbol,value,attack,defense,health,speed);
                    } else {
                        item = new Equipment(name,symbol,value,attack,defense,health,speed);
                    }
                } else {
                     item = new Material(name, symbol,value);
                }

                allItems.put(count,item);
                //System.out.println(item.getSymbol() + " " + item.getName() + ": " + item.getValue());
            }
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }


    }


    public int getAmount(int id){
        return getItem(id).getOwned();
    }
    public void add(int id, int amount){
        allItems.get(id).setOwned(getAmount(id) + amount);
        System.out.println("You obtained " + amount + " " + getItem(id).getName() + "(s)");
    }

    public void addPotions(Consumable potion) {
        Handbag.add(potion);
    }
    
    public Dictionary<Integer, Item> getAllItems() {
        return allItems;
    }

    public Item getItem(int idx){
        return allItems.get(idx);
    }

    public ArrayList<Consumable> getHandbag() {return Handbag;}

    public void viewOwned(String select){
        if (select.toLowerCase().equals("equipment")){
            for (int i = 1; i <= allItems.size(); i++){
                Item item = allItems.get(i);
                System.out.println("Equipment\n-----------------\n");
                if (allItems.get(i).getOwned() > 0){
                    System.out.println(item);
                }

            }
        }
        
    }




}
