
import java.util.*;

public class Bank {
    List<Account> users = FileManager.loadUsers();

    public void signup(String user, String pass) throws Exception {
        users.add(new Account(user, pass, 0));
        FileManager.saveUsers(users);
        System.out.println("Account Created!");
    }

    public Account login(String user, String pass) {
        for (Account u : users) {
            if (u.username.equals(user) && u.password.equals(pass)) {
                return u;
            }
        }
        return null;
    }

    public void deposit(Account u, double amt) throws Exception {
        u.balance += amt;
        FileManager.saveUsers(users);
        FileManager.saveTransaction(new Transaction(u.username, "DEPOSIT", amt));
    }

    public void withdraw(Account u, double amt) throws Exception {
        if (u.balance >= amt) {
            u.balance -= amt;
            FileManager.saveUsers(users);
            FileManager.saveTransaction(new Transaction(u.username, "WITHDRAW", amt));
        } else {
            System.out.println("Insufficient balance!");
        }
    }
}