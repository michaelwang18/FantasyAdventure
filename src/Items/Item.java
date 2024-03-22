public class Item {
    private String name;
    private String symbol;

    private int value;

    public Item(String name, String symbol, int value) {
        this.name = name;
        this.symbol = symbol;
        this.value = value;
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

}
