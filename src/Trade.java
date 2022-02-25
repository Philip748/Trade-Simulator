import java.util.Objects;

/**
 An object containing information about a trade such as amount of gems and goods that will be exchanged
 */
public class Trade {

    /** The amount of gems requested */
    int gems;
    /** The amount of goods that will be exchanged */
    int amount;
    /** The type of good which is up for offer */
    Goods goods;

    /** Creates a trade with a specified amount of gems, goods, and the type of good */
    public Trade(int gems, int amount, Goods goods) {
        this.gems = gems;
        this.amount = amount;
        this.goods = goods;
    }

    /**
     * Returns the amount of gems
     *
     * @return the amount of gems
     */
    public int getGems() {
        return gems;
    }

    /**
     * Returns the amount of the good
     *
     * @return the amount of the good
     */
    public int getAmount() {
        return amount;
    }

    /**
     * Returns the type of good
     *
     * @return the type of good
     */
    public Goods getGoods() {
        return goods;
    }

    /**
     * Checks if the passed object is equal in every way then returns either true or false
     *
     * @param o The passed object
     * @return the true or false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trade trade = (Trade) o;
        return gems == trade.gems &&
                amount == trade.amount &&
                goods == trade.goods;
    }

    /**
     * Computes a hash code based on gems, amount and goods
     */
    @Override
    public int hashCode() {
        return Objects.hash(gems, amount, goods);
    }

    /**
     * Returns a string representing this Trade
     */
    @Override
    public String toString() {
        String s = gems + " Gems for " + amount + " " + goods;
        return s;
    }

    /**
     * Checks if the trader supports this trade, if not throws error, if the trades does support this trade it will be executed
     * with the citizen before adding another random trade to the trader
     *
     * @param citizen The citizen participating in this trade
     * @param trader The trader participating in this trade
     */
    public void execute(Trader trader, Citizen citizen){
        if (!(trader.getTrades().contains(this))){
            throw new IllegalArgumentException("Trade not supported");
        }
        else{
            if (citizen.executeTrade(this)){
                trader.addRandomTrade();
            }
        }
    }
}
