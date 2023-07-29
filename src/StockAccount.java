public class StockAccount {
    private String customerName;
    private double cash;
    private List<CompanyShares> companyShares;

    public StockAccount(String customerName, double cash) {
        this.customerName = customerName;
        this.cash = cash;
        this.companyShares = new ArrayList<>();
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getCash() {
        return cash;
    }

    public List<CompanyShares> getCompanyShares() {
        return companyShares;
    }

    public void buy(String symbol, int numberOfShares, double price) {
        CompanyShares companyShare = getCompanyShare(symbol);
        if (companyShare == null) {
            companyShare = new CompanyShare(symbol, numberOfShares, price);
            companyShares.add(companyShare);
        } else {
            companyShare.setNumberOfShares(companyShare.getNumberOfShares() + numberOfShares);
        }
    }

    public void sell(String symbol, int numberOfShares, double price) {
        CompanyShares companyShare = getCompanyShare(symbol);
        if (companyShare == null) {
            throw new Exception("Company shares not found");
        } else if (companyShare.getNumberOfShares() < numberOfShares) {
            throw new Exception("Not enough shares");
        } else {
            companyShare.setNumberOfShares(companyShare.getNumberOfShares() - numberOfShares);
        }
    }

    private CompanyShares getCompanyShare(String symbol) {
        for (CompanyShares companyShare : companyShares) {
            if (companyShare.getSymbol().equals(symbol)) {
                return companyShare;
            }
        }
        return null;
    }
}

class CompanyShares {

    private String symbol;
    private int numberOfShares;
    private double price;

    public CompanyShares(String symbol, int numberOfShares, double price) {
        this.symbol = symbol;
        this.numberOfShares = numberOfShares;
        this.price = price;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getNumberOfShares() {
        return numberOfShares;
    }

    public double getPrice() {
        return price;
    }

    public void setNumberOfShares(int numberOfShares) {
        this.numberOfShares = numberOfShares;
    }
}
