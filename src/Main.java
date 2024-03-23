public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Inventory test = new Inventory();
        Battle test1 = new Battle(new Player("Bobby",1,1,1,1,1),new Entity("rawr",1,1,1,1));
        test1.start();




        String[] InfoOptions = {"You can fish by talking to the Fisherman and he'll teach you the ropes", "You hunt by going into the woods and finding beasts to slay", "Talk to the old smithy, though hasn't been in the best mood these days"};
        Object[] options = {new Dialogue("AA","You can do many things, which would you like to know more about? \n1) Fishing\n2) Hunting\n3) Crafting",InfoOptions), new Shop()};
        Dialogue dude = new Dialogue("A","Welcome to Adventure GAME thingy, what would you like to do? " +
                "\n1) How do I play the game?" +
                "\n2) I'd like to sell and buy goods",options);

        dude.start();



    }
}