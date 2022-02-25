import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 An object representing a trader with at least one supported trade
 */
public class Trader {

    /** The List of supported trades */
    ArrayList<Trade> trades = new ArrayList<>();

    /** Constructs a trader with one random trade */
    public Trader(){
        addRandomTrade();
    }

    /**
     * Returns the list of trades.
     *
     * @return the list of trades
     */
    public ArrayList<Trade> getTrades() {
        return trades;
    }

    /**
     * Adds a trade with random parameters onto the trades ArrayList
     */
    public void addRandomTrade(){
        Random rand = new Random();
        int gems = rand.nextInt(4)+1;
        int amount = rand.nextInt(4)+1;
        int pick = rand.nextInt(Goods.values().length);
        Goods good = Goods.values()[pick];

        Trade newTrade = new Trade(gems, amount, good);
        trades.add(newTrade);
    }

}
