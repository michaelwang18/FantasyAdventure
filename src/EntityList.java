public class EntityList {

    private EntityList(){};

    public static Entity direBoar(){
        int[] drops = {1,2,3,3};
        return new Monster("Dire Boar",70,30,25,50,drops,1);
    } //example

    public static Entity getGPMonster(){
        Entity[] list = {direBoar()};
        return list[(int) (Math.random()*list.length)];
    }
    public static Entity getSDMonster(){
        Entity[] list = {direBoar()};
        return list[(int) (Math.random()*list.length)];
    }
    public static Entity getBTMonster(){
        Entity[] list = {direBoar()};
        return list[(int) (Math.random()*list.length)];
    }




}
