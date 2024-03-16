import java.io.File;
import java.io.IOException;
import java.util.*;

public class ItemDictionary {
    Dictionary<Integer, Item> allItems;

    public ItemDictionary(){
        allItems = new Hashtable<>();
        try {
            int count = 1;
            File myFile = new File("src//itemList.csv");
            Scanner fileScanner = new Scanner(myFile);
            while (fileScanner.hasNext()) {
                String data = fileScanner.nextLine();
                String[] splitData = data.split(",");
                String name = splitData[0];
                int value = Integer.parseInt(splitData[2]);
                String symbol = splitData[1];
                Item item;
                if (splitData.length > 3){
                    int attack = Integer.parseInt(splitData[3]);
                    int defense = Integer.parseInt(splitData[4]);
                    int health = Integer.parseInt(splitData[5]);

                     item = new Equipment(name,symbol,value,attack,defense,health);
                } else {
                     item = new Material(name, symbol,value);
                }

                allItems.put(1,item);
                //System.out.println(item.getSymbol() + " " + item.getName() + ": " + item.getValue());
            }
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }


    }

    public Dictionary<Integer, Item> getAllItems() {
        return allItems;
    }
}
