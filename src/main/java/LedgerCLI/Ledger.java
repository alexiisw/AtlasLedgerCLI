package LedgerCLI;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;

public class Ledger {
    public static ArrayList<Transaction> loadTransactions() {
        ArrayList<Transaction> ledger = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("transactions.csv"));

            String transactionInfo;
            reader.readLine(); // will skip the first line in the note

            while ((transactionInfo = reader.readLine()) != null) {
                String[] info = transactionInfo.split("\\|");// going to split the lines by "|"
                LocalDate date = LocalDate.parse(info[0]);
                LocalTime time = LocalTime.parse(info[1]);
                String description = info[2];
                String vendor = info[3];
                double amount = Double.parseDouble(info[4]);

                Transaction transaction = new Transaction(date, time, description,vendor, amount);
                ledger.add(transaction);
            }
            reader.close(); // outside the while/for/if loop

        } catch (IOException e) {
            System.out.println("Transaction file not found.");
        }
        ledger.sort(Comparator.comparing(Transaction::getDate) // cleaner version of transaction1.getDate().compareTo(transaction2.getDate())
            .thenComparing(Transaction::getTime) //in case 2 transactions occur on the same date; since both records dates are equal, Java asks what's the next thing I should compare?
            .reversed()); // sorts newest transaction first

        return ledger;
    }
    public static void storeTransaction(Transaction transaction) {

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("transactions.csv", true));

            //structures input how I want
            writer.write(transaction.getDate() + "|" + // \n will start and store input on the new line
                            transaction.getTime().format(Transaction.timeFormatter) + "|" +
                            transaction.getDescription() + "|" +
                            transaction.getVendor() + "|" +
                            String.format("%.2f", transaction.getAmount()));

            writer.newLine();
            writer.close();

        } catch (IOException e) {
            System.out.println("Error saving transaction.");
        }
    }
}

