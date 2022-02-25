public class Main {

    public static void main(String[] args) {
        Citizen citizen = new Citizen(10);
        Trader trader = new Trader();
        Trade activeTrade = (Trade) trader.getTrades().toArray()[0];
        System.out.println(activeTrade.toString());

        System.out.println(citizen.gems);
        activeTrade.execute(trader, citizen);
        System.out.println(citizen.gems);

        for (Goods good : citizen.inventory.keySet()){
            System.out.println(good + "(" + citizen.inventory.get(good) + ") ");
        }

    }

}
