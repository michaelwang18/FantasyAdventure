public class Main {
    public static void main(String[] args) {



        Game game = new Game();
        game.start();



        System.out.println(Utility.countDisplay(3,5));
        Inventory test = new Inventory();
        Player player =  new Player("Bobby",150,35,20,40,1);
        player.getBag().add(2,3);
        player.getBag().add(5,1);
        Shop testshop = new Shop(player);
       // testshop.sell();
        Apothecary testpot = new Apothecary(player);
        testpot.speech();





        Battle test1 = new Battle(new Player("Bobby",150,35,20,40,1),Monster.direBoar());
        test1.start();



        Object[] storeOptions = {};
        Object[] battleOptions = {new Battle(player,EntityList.getGPMonster()),new Battle(player,EntityList.getSDMonster()),new Battle(player,EntityList.getBTMonster())};
        Object[] options = {new Dialogue("TownHunt","Where would you like to hunt!\n1) Great 1 \n2) Scorching Desert\n3) Bleak Tundras",battleOptions),
                new Dialogue("Shop","What store would you like to visit?\n1) General Store\n2) Apothecary\n3) Blacksmith",storeOptions)}; //Add Fishing when richards done
        Dialogue dude = new Dialogue("TownStart","Your in town, what would you like to do? " +
                "\n1) Go Hunt" +
                "\n2) Visit Stores" +
                "\n3) Go Fish",options);

        //dude.start();



    }
}