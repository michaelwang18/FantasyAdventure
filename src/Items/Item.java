public class Item {
    private String name;
    private String symbol;
    private int owned;

    private int value;

    public Item(String name, String symbol, int value) {
        this.name = name;
        this.symbol = symbol;
        this.value = value;
        owned = 0;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getValue() {
        return value;
    }

    public int getOwned() {
        return owned;
    }

    public void setOwned(int owned) {
        this.owned = owned;
    }

    @Override
    public String toString() {
        return symbol+ " " + name + " Value: " + value;
    }



}
