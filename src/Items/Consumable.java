public class Consumable extends Item {

    private boolean used;

    public Consumable(String name, String symbol, int value) {
        super(name, symbol, value);
        used = false;
    }

    public void useConsumable() {
        used = true;
        System.out.println("Used consumable");
    }
}
