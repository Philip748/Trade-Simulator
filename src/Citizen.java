import java.util.HashMap;
import java.util.Map;

/**
 * An object representing a citizen with gems and an inventory of goods
 */
public class Citizen {

    /** The amount of gems held by this citizen */
    int gems;
    /** A Map of all the goods in the citizens inventory with the quantity */
    Map<Goods, Integer> inventory = new HashMap();

    /** Constructs a citizen with a specified amount of gems */
    public Citizen(int gems) {
        this.gems = gems;
    }

    /**
     * Returns The amount of gems held by this citizen
     *
     * @return The amount of gems held by this citizen
     */
    public int getGems() {
        return gems;
    }

    /**
     * Returns The amount of the specified good in the citizens inventory
     *
     * @param goods the good to get the quantity of
     * @return The amount of the specified good in the citizens inventory
     */
    public int getAmount(Goods goods) {
        for (Goods good : inventory.keySet()) {
            if (inventory.containsKey(good)) {
                return inventory.get(goods);
            }
        }
        return 0;
    }

    /**
     * Checks if the citezen has enough gems to complete the trade. If not false is returned. If they do, the gems are removed
     * from the citizen and the goods added to the citizens inventory as directed by the trade before returning true.
     *
     * @param trade the trade that the citizen is participating in
     * @return true of false whether the trade was completed or not
     */
    public boolean executeTrade (Trade trade){
        if (gems < trade.getGems()){
            return false;
        }
        else{
            gems = gems - trade.getGems();
            if (inventory.containsKey(trade.goods)){
                int x = trade.amount + inventory.get(trade.goods);
                inventory.put(trade.goods, x);
            }
            else{
                inventory.put(trade.goods, trade.amount);
            }
            return true;
        }
    }
}
