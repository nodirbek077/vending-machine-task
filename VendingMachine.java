public class VendingMachine {
    //beverage
    private Beverage[] beverageArray = new Beverage[10];
    private int beverageIndex = 0;

    //card
    private Card[] cardArray = new Card[10];
    private int cardIndex = 0;

    //row
    private Row[] rowArray = new Row[4];

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

    public Card getCardById(Integer cardId) {
        for (Card card : cardArray) {
            if (card != null && card.getId().equals(cardId)) {
                return card;
            }
        }
        return null;
    }

    public void rechargeCard(Integer cardId, double credit) {
        Card card = getCardById(cardId);
        if (card == null) {
            card = new Card();
            card.setId(cardId);
            card.setCredit(credit);
            cardArray[cardIndex++] = card;
        } else {
            double balance = card.getCredit() + credit;
            card.setCredit(balance);
        }
    }

    public double getCredit(int cardId) {
        for (Card card : cardArray) {
            if (card != null && card.getId().equals(cardId)) {
                return card.getCredit();
            }
        }
        return -1.0;
    }

    public void refillRow(int rowCount, String beverageName, int cans) {
        Row row = new Row();
        row.setRowCount(rowCount);
        row.setBeverageName(beverageName);
        row.setCans(cans);
        rowArray[rowCount - 1] = row;
    }

    public int availableCans(String beverageName) {
        int count = 0;
        for (Row row : rowArray) {
            if (row != null && row.getBeverageName().equals(beverageName)) {
                count += row.getCans();
            }
        }

        return count;
    }

    public int sell(String beverageName, int cardId) {

        Beverage beverage = getBeverageByName(beverageName);
        Card card = getCardById(cardId);
        Row row = getRowByBeverageName(beverageName);
        if (beverage == null
                || card == null
                || row == null
                || card.getCredit() < beverage.getPrice()) {
            return -1;
        }

        card.setCredit(card.getCredit() - beverage.getPrice());
        row.setCans(row.getCans() - 1);
        return row.getRowCount();
    }

    public Beverage getBeverageByName(String beveragename) {
        for (Beverage beverage : beverageArray) {
            if (beverage != null && beverage.getName().equals(beveragename)) {
                return beverage;
            }
        }
        return null;
    }

    public Row getRowByBeverageName(String beverageName) {
        for (Row row : rowArray) {
            if (row != null && row.getBeverageName().equals(beverageName)
                    && row.getCans() > 0) {
                return row;
            }
        }
        return null;
    }
}
