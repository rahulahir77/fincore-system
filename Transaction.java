public class Transaction {
    String username;
    String type;
    double amount;

    public Transaction(String username, String type, double amount) {
        this.username = username;
        this.type = type;
        this.amount = amount;
    }
}