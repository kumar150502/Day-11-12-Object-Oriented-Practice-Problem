import java.util.Scanner;
public class StockAccountManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Stock[] stocks = new Stock[n];
        for (int i = 0; i < n; i++) {
            String name = scanner.next();
            int number_of_shares = scanner.nextInt();
            int share_price = scanner.nextInt();
            stocks[i] = new Stock(name, number_of_shares, share_price);
        }
        int total_value = 0;
        for (Stock stock : stocks) {
            int value = stock.get_value();
            System.out.println("The value of " + stock.getName() + " is " + value);
            total_value += value;
        }
        System.out.println("The total value of the portfolio is " + total_value);
    }
}
class Stock {
    private String name;
    private int number_of_shares;
    private int share_price;
    public Stock(String name, int number_of_shares, int share_price) {
        this.name = name;
        this.number_of_shares = number_of_shares;
        this.share_price = share_price;
    }
    public int get_value() {
        return this.number_of_shares * this.share_price;
    }
}