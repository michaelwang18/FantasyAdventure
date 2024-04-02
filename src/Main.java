public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Inventory test = new Inventory();
        Player player =  new Player("Bobby",150,35,20,40,1);
        Battle test1 = new Battle(new Player("Bobby",150,35,20,40,1),new Entity("Gobby Boi",200,40,15,30));
        test1.start();



        Object[] storeOptions = {};
        Object[] battleOptions = {new Battle(player,EntityList.getGPMonster()),new Battle(player,EntityList.getSDMonster()),new Battle(player,EntityList.getBTMonster())};
        Object[] options = {new Dialogue("TownHunt","Where would you like to hunt!\n1) Great Plains \n2) Scorching Desert\n3) Bleak Tundras",battleOptions),
                new Dialogue("Shop","What store would you like to visit?\n1) General Store\n2) Apothecary\n3) Blacksmith",storeOptions)}; //Add Fishing when richards done
        Dialogue dude = new Dialogue("TownStart","Your in town, what would you like to do? " +
                "\n1) Go Hunt" +
                "\n2) Visit Stores" +
                "\n3) Go Fish",options);

        dude.start();



    }
}