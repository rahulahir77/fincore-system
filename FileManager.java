import java.io.*;
import java.util.*;

public class FileManager {

    public static void saveUsers(List<Account> users) throws Exception {
        PrintWriter writer = new PrintWriter("users.txt");
        for (Account u : users) {
            writer.println(u.username + "," + u.password + "," + u.balance);
        }
        writer.close();
    }

    public static List<Account> loadUsers() {
        List<Account> users = new ArrayList<>();
        try {
            Scanner sc = new Scanner(new File("users.txt"));
            while (sc.hasNextLine()) {
                String[] data = sc.nextLine().split(",");
                users.add(new Account(data[0], data[1], Double.parseDouble(data[2])));
            }
        } catch (Exception e) {}
        return users;
    }

    public static void saveTransaction(Transaction t) throws Exception {
        FileWriter fw = new FileWriter("transactions.txt", true);
        fw.write(t.username + "," + t.type + "," + t.amount + "\n");
        fw.close();
    }

    public static void showTransactions(String username) {
        try {
            Scanner sc = new Scanner(new File("transactions.txt"));
            while (sc.hasNextLine()) {
                String[] data = sc.nextLine().split(",");
                if (data[0].equals(username)) {
                    System.out.println(data[1] + " : " + data[2]);
                }
            }
        } catch (Exception e) {}
    }
}