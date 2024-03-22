import java.util.Dictionary;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        ItemDictionary test = new ItemDictionary();



        String[] InfoOptions = {"You can fish by talking to the Fisherman and he'll teach you the ropes", "You hunt by going into the woods and finding beasts to slay", "Talk to the old smithy, though hasn't been in the best mood these days"};
        Object[] options = {new Dialogue("You can do many things, which would you like to know more about? \n1) Fishing\n2) Hunting\n3) Crafting",InfoOptions), new Shop()};
        Dialogue dude = new Dialogue("Welcome to Adventure GAME thingy, what would you like to do? " +
                "\n1) How do I play the game?" +
                "\n2) I'd like to sell and buy goods",options);

        dude.start();



    }
}