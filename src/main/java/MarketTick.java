public class MarketTick {
    private String symbol;
    private Double price;
    private int quantity;
    private String side;

    public MarketTick(String symbol, Double price, int quantity, String side) {
        this.symbol = symbol;
        this.price = price;
        this.quantity = quantity;
        this.side = side;
    }

    public String getSymbol() { return symbol; }
    public Double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public String getSide() { return side; }

}
