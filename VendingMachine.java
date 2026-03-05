public class VendingMachine {
    //beverage
    private Beverage[] beverageArray = new Beverage[10];
    private int beverageIndex = 0;

    //card
    private Card[] cardArray = new Card[10];
    private int cardIndex = 0;

    public VendingMachine() {

    }

    public void addBeverage(String name, double price) {
        Beverage beverage = new Beverage();
        beverage.setName(name);
        beverage.setPrice(price);
        beverageArray[beverageIndex++] = beverage;
    }

    public double getPrice(String beverageName) {
        for (Beverage beverage : beverageArray) {
            if (beverage != null && beverage.getName().equals(beverageName)) {
                return beverage.getPrice();
            }
        }
        return -1.0;
    }

    public void rechargeCard(int cardId, double credit) {
        for (Card card : cardArray){
            if (card != null && card.getId() == cardId){
                card.setCredit(credit);
            }
        }
    }

    public double getCredit(int cardId) {
        for (Card card : cardArray){
            if (card != null && card.getId() == cardId){
                return card.getCredit();
            }
        }
        return -1.0;
    }

    public void refillColumn(int column, String beverageName, int cans) {

    }

    public int availableCans(String beverageName) {
        return 0;
    }

    public int sell(String beverageName, int cardId) {
        return 0;
    }
}
