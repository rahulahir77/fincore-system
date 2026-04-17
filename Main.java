import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank();

        while (true) {
            System.out.println("\n1. Signup\n2. Login\n3. Exit");
            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Username: ");
                String u = sc.next();
                System.out.print("Password: ");
                String p = sc.next();
                bank.signup(u, p);

            } else if (choice == 2) {
                System.out.print("Username: ");
                String u = sc.next();
                System.out.print("Password: ");
                String p = sc.next();

                Account user = bank.login(u, p);

                if (user != null) {
                    while (true) {
                        System.out.println("\n1.Deposit 2.Withdraw 3.Balance 4.History 5.Logout");
                        int ch = sc.nextInt();

                        if (ch == 1) {
                            System.out.print("Amount: ");
                            bank.deposit(user, sc.nextDouble());
                        } 
                        else if (ch == 2) {
                            System.out.print("Amount: ");
                            bank.withdraw(user, sc.nextDouble());
                        } 
                        else if (ch == 3) {
                            System.out.println("Balance: " + user.balance);
                        } 
                        else if (ch == 4) {
                            FileManager.showTransactions(user.username);
                        } 
                        else break;
                    }
                } else {
                    System.out.println("Invalid login!");
                }

            } else break;
        }
    }
}