public class EntityList {

    private EntityList(){};

    public static Entity direBoar(){
        int[] drops = {6,6,7,8};
        return new Monster("Dire Boar",70,30,25,50,drops,30);
    } //example

    public static Entity getGPMonster(){
        Entity[] list = {direBoar()};
        return list[(int) (Math.random()*list.length)];
    }
    public static Entity getSDMonster(){ //THESE ARE EXAMPLES
        Entity[] list = {direBoar()};
        return list[(int) (Math.random()*list.length)];
    }
    public static Entity getBTMonster(){
        Entity[] list = {direBoar()};
        return list[(int) (Math.random()*list.length)];
    }




}
